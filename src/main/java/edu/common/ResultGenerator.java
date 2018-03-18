package edu.common;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_CODE = "SUCCESS";
    private static final String DEFAULT_FAIL_CODE = "FAIL";
    public static Result genSuccessResult(){
        Result result = new Result();
        result.setResultCode(Constants.RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_CODE);
        return result;
    }
    public static Result genSuccessResult(Object data){
        Result result = new Result();
        result.setResultCode(Constants.RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_CODE);
        result.setData(data);
        return result;
    }
    public static Result genFailResult(String message){
        Result result = new Result();
        result.setResultCode(Constants.RESULT_CODE_FAIL);
        if(message == null || message.length() < 1){
            message = DEFAULT_FAIL_CODE;
        }
        result.setMessage(message);
        return result;
    }
}
