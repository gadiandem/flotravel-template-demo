package com.flocash.flotravel.demo.dto.flocash.response;

import java.io.Serializable;

public class Redirect implements Serializable {
    private Object params;

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }
}
