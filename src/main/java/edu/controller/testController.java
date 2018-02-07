package edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Controller
public class testController {
    @RequestMapping("/test")
    @ResponseBody
    public List test(@RequestParam("className") String className, @RequestParam("methodName") String methodName, @RequestParam(value = "parameter",required = false) String parameter){
        System.out.println("Success");
        System.out.println(className);
        System.out.println(methodName);
        System.out.println(parameter);
        try {
            Class test = Class.forName("edu.dao.Impl."+className);
            Object o = test.newInstance();
            Method testMethod = test.getMethod(methodName);
            String[] parameters = null;
            if(parameter != null)
                parameters = parameter.split(",");

            return (List)testMethod.invoke(o,parameters);
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
}
