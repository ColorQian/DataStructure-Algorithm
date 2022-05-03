package com.jianzhi.master2;

import java.util.Map;
import java.util.TreeMap;

public class Question58 {

    TreeMap<Integer, Integer> events;
    public Question58() {
        events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> event = events.floorEntry(start);

        if (event != null && start < event.getValue())
            return false;

        event = events.ceilingEntry(start);
        if (event != null && end > event.getKey())
            return false;

        events.put(start, end);

        return true;
    }
}