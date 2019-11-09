package com.example.ssl.json.bean;

/**
 * Created by ssl on 2019/11/9.
 */

public class Menu {
    private String img;
    private String title;
    private String content;

    @Override
    public String toString() {
        return "Menu{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Menu(String img, String title, String content) {

        this.img = img;
        this.title = title;
        this.content = content;
    }
}
