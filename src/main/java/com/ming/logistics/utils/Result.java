package com.ming.logistics.utils;

public class Result {

    private Integer code;

    private String msg;

    private Object data;


    public static Result success(){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }

    public static Result success(Object data){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(500);
        result.setMsg("失败");
        return result;
    }
    public static Result error(Object data){
        Result result = new Result();
        result.setCode(500);
        result.setMsg("失败");
        result.setData(data);
        return result;
    }

    public static Result toResult(boolean success){
        Result result = new Result();
        return success ? result.success():result.error();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
