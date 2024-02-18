package com.example.tmp.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Result {
    private int code;
    private String msg;
    private String result;


    public void setSuccess(String msg, String result) {

        this.code = 200;
        this.msg = msg;
        this.result = result;
    }

    public void setInfo(String msg, String result) {
        this.code = 300;

        this.msg =  msg;

        this.result = result;
    }
}
