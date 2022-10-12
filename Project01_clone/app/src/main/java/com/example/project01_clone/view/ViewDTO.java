package com.example.project01_clone.view;

public class ViewDTO {
     private String v_img_title, v_tv_title, v_tv_title_main, v_tv_title_sub;
     private int v_img_content;

    public ViewDTO(String v_img_title, String v_tv_title, String v_tv_title_main, String v_tv_title_sub, int v_img_content) {
        this.v_img_title = v_img_title;
        this.v_tv_title = v_tv_title;
        this.v_tv_title_main = v_tv_title_main;
        this.v_tv_title_sub = v_tv_title_sub;
        this.v_img_content = v_img_content;
    }

    public String getV_img_title() {
        return v_img_title;
    }

    public void setV_img_title(String v_img_title) {
        this.v_img_title = v_img_title;
    }

    public String getV_tv_title() {
        return v_tv_title;
    }

    public void setV_tv_title(String v_tv_title) {
        this.v_tv_title = v_tv_title;
    }

    public String getV_tv_title_main() {
        return v_tv_title_main;
    }

    public void setV_tv_title_main(String v_tv_title_main) {
        this.v_tv_title_main = v_tv_title_main;
    }

    public String getV_tv_title_sub() {
        return v_tv_title_sub;
    }

    public void setV_tv_title_sub(String v_tv_title_sub) {
        this.v_tv_title_sub = v_tv_title_sub;
    }

    public int getV_img_content() {
        return v_img_content;
    }

    public void setV_img_content(int v_img_content) {
        this.v_img_content = v_img_content;
    }
}
