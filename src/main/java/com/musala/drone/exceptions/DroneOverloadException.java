package com.musala.drone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DroneOverloadException  extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DroneOverloadException(String message) {
        super(message);
    }
}
