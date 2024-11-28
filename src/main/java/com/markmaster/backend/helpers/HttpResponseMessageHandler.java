package com.markmaster.backend.helpers;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Scope("singleton")
@Component
public class HttpResponseMessageHandler {

    public ResponseEntity<Map<String, Object>> updateHttpResponse(String message, HttpStatus status) {
        return updateHttpResponse(message, status, null);
    }

    public ResponseEntity<Map<String, Object>> updateHttpResponse(String message, HttpStatus status, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("message", message);
        response.put("data", data);

        return new ResponseEntity<>(response, status);
    }
}
