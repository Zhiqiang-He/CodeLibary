package com.james.codelib.guava.patterns.observer;

/**
 * Created by james on 9/21/14.
 */
public class NotifyMessage {
    private int id;
    private String context;

    @Override
    public String toString() {
        return "NotifyMessage{" +
                "id=" + id +
                ", context='" + context + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
