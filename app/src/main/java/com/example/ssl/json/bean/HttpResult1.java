package com.example.ssl.json.bean;

import java.util.List;

/**
 * Created by ssl on 2019/11/9.
 */

public class HttpResult1 {
    private int code;
    private String message;

    @Override
    public String toString() {
        return "HttpResult1{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Menu> getData() {
        return data;
    }

    public void setData(List<Menu> data) {
        this.data = data;
    }

    public HttpResult1(int code, List<Menu> data, String message) {

        this.code = code;
        this.data = data;
        this.message = message;
    }

    private List<Menu> data;
}
