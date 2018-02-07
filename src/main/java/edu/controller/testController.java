package edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Controller
public class testController {
    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/getAllClassesName")
    @ResponseBody
    public List getAllClassesName(){
        ArrayList<String> result = new ArrayList<>();
        result.addAll(getPackageClasses("edu.dao.Impl"));
        result.addAll(getPackageClasses("edu.service.Impl"));
        return result;
    }

    @RequestMapping("/getClassMethod/{className}")
    @ResponseBody
    public List getClassMethod(@PathVariable("className") String className) throws ClassNotFoundException {
        Class aClass = Class.forName(className);
        Method method[] = aClass.getMethods();
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < method.length; ++i){
            if(method[i].getName().equals("wait"))
                break;
            result.add(method[i].getName());
        }

        return result;

    }

    @RequestMapping("/getMethodParameter/{class}/{method}")
    @ResponseBody
    public List getMethodParameter(@PathVariable("class")String className, @PathVariable("method")String method) throws ClassNotFoundException {
        Class aClass = Class.forName(className);
        Method methods[] = aClass.getMethods();
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < methods.length; ++i){
            if(methods[i].getName().equals(method)){
                Class<?> para[] = methods[i].getParameterTypes();
                for(int j = 0; j < para.length; ++j){
                    result.add(para[j].toString().split(" ")[1]);
                }
                break;
            }
        }
        return result;
    }

    @RequestMapping("/excuteTest")
    @ResponseBody
    public List test(@RequestParam("className") String className, @RequestParam("methodName") String methodName, @RequestParam(value = "parameter", required = false) String parameter, @RequestParam(value = "type", required = false) String type) {
        try {
            Class test = Class.forName(className);
            Object o = test.newInstance();

            Class[] args = null;
            if (type != null) {
                String[] types = type.split(",");
                args = new Class[types.length];
                for (int i = 0; i < types.length; ++i) {
                    args[i] = Class.forName(types[i]);
                }
            }

            Method testMethod = test.getMethod(methodName, args);
            Object[] args2 = null;
            if (parameter != null) {
                String[] parameters = parameter.split(",");
                args2 = new Object[parameters.length];
                for (int i = 0; i < parameters.length; ++i) {
                    Constructor constructor = args[i].getDeclaredConstructor(String.class);
                    constructor.setAccessible(true);
                    args2[i] = constructor.newInstance(parameters[i]);
                }
            }
            return (List) testMethod.invoke(o, args2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        }

    }

    private List getPackageClasses(String packageName){
        ArrayList<String> result = new ArrayList<>();
        Set<String> classNames = getClassName(packageName, false);
        if (classNames != null) {
            for (String className : classNames) {
                result.add(className);
            }
        }
        return result;
    }

    /**
     * 获取某包下所有类
     * @param packageName 包名
     * @param isRecursion 是否遍历子包
     * @return 类的完整名称
     */
    public static Set<String> getClassName(String packageName, boolean isRecursion) {
        Set<String> classNames = null;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String packagePath = packageName.replace(".", "/");

        URL url = loader.getResource(packagePath);
        if (url != null) {
            String protocol = url.getProtocol();
            if (protocol.equals("file")) {
                classNames = getClassNameFromDir(url.getPath(), packageName, isRecursion);
            } else if (protocol.equals("jar")) {
                JarFile jarFile = null;
                try{
                    jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
                } catch(Exception e){
                    e.printStackTrace();
                }

                if(jarFile != null){
                    getClassNameFromJar(jarFile.entries(), packageName, isRecursion);
                }
            }
        } else {
            /*从所有的jar包中查找包名*/
            classNames = getClassNameFromJars(((URLClassLoader)loader).getURLs(), packageName, isRecursion);
        }

        return classNames;
    }

    /**
     * 从项目文件获取某包下所有类
     * @param filePath 文件路径
     * @param packageName 类名集合
     * @param isRecursion 是否遍历子包
     * @return 类的完整名称
     */
    private static Set<String> getClassNameFromDir(String filePath, String packageName, boolean isRecursion) {
        Set<String> className = new HashSet<String>();
        File file = new File(filePath);
        File[] files = file.listFiles();
        for (File childFile : files) {
            if (childFile.isDirectory()) {
                if (isRecursion) {
                    className.addAll(getClassNameFromDir(childFile.getPath(), packageName+"."+childFile.getName(), isRecursion));
                }
            } else {
                String fileName = childFile.getName();
                if (fileName.endsWith(".class") && !fileName.contains("$")) {
                    className.add(packageName+ "." + fileName.replace(".class", ""));
                }
            }
        }

        return className;
    }


    /**
     * @param jarEntries
     * @param packageName
     * @param isRecursion
     * @return
     */
    private static Set<String> getClassNameFromJar(Enumeration<JarEntry> jarEntries, String packageName, boolean isRecursion){
        Set<String> classNames = new HashSet<String>();

        while (jarEntries.hasMoreElements()) {
            JarEntry jarEntry = jarEntries.nextElement();
            if(!jarEntry.isDirectory()){
                /*
                 * 这里是为了方便，先把"/" 转成 "." 再判断 ".class" 的做法可能会有bug
                 * (FIXME: 先把"/" 转成 "." 再判断 ".class" 的做法可能会有bug)
                 */
                String entryName = jarEntry.getName().replace("/", ".");
                if (entryName.endsWith(".class") && !entryName.contains("$") && entryName.startsWith(packageName)) {
                    entryName = entryName.replace(".class", "");
                    if(isRecursion){
                        classNames.add(entryName);
                    } else if(!entryName.replace(packageName+".", "").contains(".")){
                        classNames.add(entryName);
                    }
                }
            }
        }

        return classNames;
    }

    /**
     * 从所有jar中搜索该包，并获取该包下所有类
     * @param urls URL集合
     * @param packageName 包路径
     * @param isRecursion 是否遍历子包
     * @return 类的完整名称
     */
    private static Set<String> getClassNameFromJars(URL[] urls, String packageName, boolean isRecursion) {
        Set<String> classNames = new HashSet<String>();

        for (int i = 0; i < urls.length; i++) {
            String classPath = urls[i].getPath();

            //不必搜索classes文件夹
            if (classPath.endsWith("classes/")) {continue;}

            JarFile jarFile = null;
            try {
                jarFile = new JarFile(classPath.substring(classPath.indexOf("/")));
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (jarFile != null) {
                classNames.addAll(getClassNameFromJar(jarFile.entries(), packageName, isRecursion));
            }
        }

        return classNames;
    }
}
