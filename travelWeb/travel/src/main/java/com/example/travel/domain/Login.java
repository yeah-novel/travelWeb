package com.example.travel.domain;

public class Login {
    private Long id;
    private String userPhone;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", userPhone='" + userPhone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
