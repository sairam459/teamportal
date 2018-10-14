package com.src.teamportal.application.model;

public class Message {

    public String getFrom() {
        return from;
    }

    public Message(String from, String text) {
        this.from = from;
        this.text = text;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String from;
    private String text;
}
