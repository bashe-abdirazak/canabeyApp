package com.bashe.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(AccessDeniedException.class)
    @RequestMapping(value = "error/404")
    public String error404(HttpServletRequest request) {

        String originalUri = (String) request.getAttribute("javax.servlet.forward.request_uri");
        log.error("Requested URL not found : " + request.getMethod() + " " + originalUri);

        return "error/404";
    }
}