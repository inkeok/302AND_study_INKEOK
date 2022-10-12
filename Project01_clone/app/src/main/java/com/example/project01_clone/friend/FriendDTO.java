package com.example.project01_clone.friend;

public class FriendDTO {
    private int f_img;
    private String f_name, f_msg;

    public FriendDTO(int f_img, String f_name, String f_msg) {
        this.f_img = f_img;
        this.f_name = f_name;
        this.f_msg = f_msg;
    }

    public int getF_img() {
        return f_img;
    }

    public void setF_img(int f_img) {
        this.f_img = f_img;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getF_msg() {
        return f_msg;
    }

    public void setF_msg(String f_msg) {
        this.f_msg = f_msg;
    }
}
