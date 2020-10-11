package com.iflytek.vuedemo.result;

public class Result {
    private Integer code;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result SUCCESS(Object object){
        Result result = new Result();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }

    public static Result ERROR(Object object){
        Result result = new Result();
        result.setCode(500);
        result.setMessage(String.valueOf(object));
        result.setData(object);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
