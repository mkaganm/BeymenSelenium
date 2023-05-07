package com.beymen.data;

import lombok.Data;

@Data
public class Variables {

    private static final ThreadLocal<Variables> instance = new ThreadLocal<>();

    public static Variables getInstance() {
        if (instance.get() == null) {
            setup();
        }
        return instance.get();
    }

    public static void setup() {
        instance.set(new Variables());
    }
}
