package com.ciandt.nextgen.faculdade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Olá Mundo!";
    }

    @RequestMapping("/exemplo")
    @ResponseBody
    public String criaAluno() {
        return "Teste123";
    }
}
