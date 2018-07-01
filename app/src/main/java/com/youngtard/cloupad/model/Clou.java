package com.youngtard.cloupad.model;

public class Clou {
    private String clouTitle;
    private String clouContent;

    public Clou(String clouTitle, String clouContent) {
        this.clouTitle = clouTitle;
        this.clouContent = clouContent;
    }

    public String getClouTitle() {
        return clouTitle;
    }

    public String getClouContent() {
        return clouContent;
    }
}
