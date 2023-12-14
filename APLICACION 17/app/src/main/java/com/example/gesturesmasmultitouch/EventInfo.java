package com.example.gesturesmasmultitouch;

public class EventInfo {
    private int eventType;
    private float x;
    private float y;

    public EventInfo(int eventType, float x, float y) {
        this.eventType = eventType;
        this.x = x;
        this.y = y;
    }

    public int getEventType() {
        return eventType;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
