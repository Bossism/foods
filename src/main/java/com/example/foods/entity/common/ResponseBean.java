package com.example.foods.entity.common;

import java.util.HashMap;

public class ResponseBean extends HashMap<String, Object> {

    public ResponseBean code(int code) {
        this.put("code", code);
        return this;
    }

    public ResponseBean data(Object data) {
        this.put("data", data);
        return this;
    }

    public ResponseBean message(String message) {
        this.put("message", message);
        return this;
    }

}
