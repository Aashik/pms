package com.niftylife.stockapp.entity;

public class LoginResponse {

    private String status;
    private String message;
    private int response_code;
    private String access_token;
    private int user_id;

    public LoginResponse() {
    }

    public LoginResponse(String status, String message, int response_code, String access_token, int user_id) {
        this.status = status;
        this.message = message;
        this.response_code = response_code;
        this.access_token = access_token;
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
