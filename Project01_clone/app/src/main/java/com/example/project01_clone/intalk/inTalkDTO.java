package com.example.project01_clone.intalk;

public class inTalkDTO {
    private int img;
    private String name, stateMess;

    public inTalkDTO(int img, String name, String stateMess) {
        this.img = img;
        this.name = name;
        this.stateMess = stateMess;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateMess() {
        return stateMess;
    }

    public void setStateMess(String stateMess) {
        this.stateMess = stateMess;
    }
}
