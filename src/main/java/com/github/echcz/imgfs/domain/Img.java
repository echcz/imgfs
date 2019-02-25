package com.github.echcz.imgfs.domain;

import org.springframework.data.annotation.Id;

public class Img {
    @Id
    private String id;
    private String name;
    private String contentType;
    private byte[] content;

    public Img() {
    }

    public Img(String id, String name, String contentType, byte[] content) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
