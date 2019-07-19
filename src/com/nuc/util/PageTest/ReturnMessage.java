package com.nuc.util.PageTest;

/**
 * ClassName: ReturnMessage
 * Function:  TODO
 * Date:      2019/7/18 21:09
 * author     Dell
 * version    V1.0
 */
public class ReturnMessage {
    private String code;
    private String msg;
    private int count;
    private Object data;
    public ReturnMessage(String code, String msg, int count,
                         Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
    public ReturnMessage(String msg, Object data) {
        super();
        this.msg = msg;
        this.data = data;
    }
    public ReturnMessage() {
        super();
    }

    public ReturnMessage(String code, String msg, int count) {
        super();
        this.code = code;
        this.msg = msg;
        this.count = count;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "ReturnMessage [code=" + code + ", msg=" + msg + ", count="
                + count + ", data=" + data + "]";
    }
}

