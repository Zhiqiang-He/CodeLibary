package com.james.codelib.guava.patterns.observer;

/**
 * Created by james on 9/21/14.
 */
public class ChildNotifyMessage extends NotifyMessage {
    public boolean isChild = true;
    @Override
    public String toString() {
        return "ChildNotifyMessage{" +
                "isChild=" + isChild +
                '}';
    }
}
