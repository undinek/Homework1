/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.it.mavenproject1.domain;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Undine
 */
public class Advertisement {

    private static int count = 0;
    private long id;
    private boolean isFilled;
    String title, message, author;

    public Advertisement() {
        isFilled = false;
        id = ++count;
    }

    public Advertisement(String title, String message, String author) {
        this.title = title;
        this.message = message;
        this.author = author;
        isFilled = false;
        id = ++count;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
