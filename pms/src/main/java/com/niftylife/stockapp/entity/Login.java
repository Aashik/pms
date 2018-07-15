package com.niftylife.stockapp.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.zip.DataFormatException;

@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long login_id;
    @Column(name="login_time",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date login_time;
    private String login_token;
    private boolean login_token_status;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Login() {
    }

    public Login(Long login_id, Date login_time, String login_token,boolean login_token_status) {
        this.login_id = login_id;
        this.login_time = login_time;
        this.login_token = login_token;
        this.login_token_status = login_token_status;
    }

    public Long getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Long login_id) {
        this.login_id = login_id;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public String getLogin_token() {
        return login_token;
    }

    public void setLogin_token(String login_token) {
        this.login_token = login_token;
    }

    public boolean isLogin_token_status() {
        return login_token_status;
    }

    public void setLogin_token_status(boolean login_token_status) {
        this.login_token_status = login_token_status;
    }
}
