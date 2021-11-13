package com.musala.drone.exceptions;

public class LowBatteryException extends  RuntimeException{
    private static final long serialVersionUID = 1L;

    public LowBatteryException(String message) {
        super(message);
    }
}
