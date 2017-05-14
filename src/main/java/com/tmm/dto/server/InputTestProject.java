package com.tmm.dto.server;

/**
 * Created by Captain Wang on 17/4/23.
 */
public class InputTestProject {

    private String title;

    private String comment;

    public InputTestProject() {
    }

    public InputTestProject(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "InputTestProject{" +
                "title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
