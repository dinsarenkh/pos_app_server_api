package com.dinsaren.bbuappserver.payload.res;

import com.dinsaren.bbuappserver.constants.Constants;

public class MessageRes {
    private String code;
    private String message;
    private Object data;

    public MessageRes() {
    }

    public MessageRes(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    public void setGetDateMessageSuccess(Object data) {
        this.code = "SUC-00";
        this.message = Constants.MESSAGE_CREATE;
        this.data = data;
    }

    public void setCreateMessageSuccess() {
        this.code = "SUC-01";
        this.message = Constants.MESSAGE_CREATE;
        this.data = null;
    }

    public void setUpdateMessageSuccess() {
        this.code = "SUC-02";
        this.message = Constants.MESSAGE_UPDATE;
        this.data = null;
    }

    public void setDeleteMessageSuccess() {
        this.code = "SUC-03";
        this.message = Constants.MESSAGE_DELETE;
        this.data = null;
    }

    public void setServerError() {
        this.code = "ERR-00";
        this.message = Constants.MESSAGE_SERVER_ERROR;
        this.data = null;
    }

}
