package org.wayne.btdown.common.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;


public class ErrorMessage implements Serializable {

    private int code;
    private String message;
    private String status;
    private Map<String,String>[] details;

    public ErrorMessage(){
    }

    public ErrorMessage(int code,String message,String status){
        this.code=code;
        this.message = message;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String>[] getDetails() {
        return details;
    }

    public void setDetails(Map<String, String>[] details) {
        this.details = details;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorMessage{");
        sb.append("code=").append(code);
        sb.append(", message='").append(message).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", details=").append(Arrays.toString(details));
        sb.append('}');
        return sb.toString();
    }
}
