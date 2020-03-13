package com.myvkr.vkr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String main(Model model){
        // если авторизован возвращать такую-то страницу, если нет то другую
        HashMap<Object, Object> data = new HashMap<>();
        data.put("id",null);
        model.addAttribute("frontendData", data );
        return "index";
    }
}
