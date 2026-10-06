package com.ifsc.app;

public class Event {

    Integer id;
    Float values[] = new Float[3];

    public Event(Integer id, Float[] values) {
        this.id = id;
        this.values = values;
    }
}
