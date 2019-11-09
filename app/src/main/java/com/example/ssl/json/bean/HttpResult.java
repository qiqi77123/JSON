package com.example.ssl.json.bean;

/**
 * Created by ssl on 2019/11/9.
 */

public class HttpResult {
    private int code;
    private String message;
    private String data;

    @Override
    public String toString() {
        return "HttpResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpResult(String message, String data, int code) {

        this.message = message;
        this.data = data;
        this.code = code;
    }
}
