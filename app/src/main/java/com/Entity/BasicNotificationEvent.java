package com.Entity;

/**
 * Created by liguoying on 2017/6/30.
 */

public class BasicNotificationEvent {
    private String title;
    private String content;
    private int smallIcon;

    public BasicNotificationEvent(String title, String content, int smallIcon) {
        this.title = title;
        this.content = content;
        this.smallIcon = smallIcon;
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

    public int getSmallIcon() {
        return smallIcon;
    }

    public void setSmallIcon(int smallIcon) {
        this.smallIcon = smallIcon;
    }
}
