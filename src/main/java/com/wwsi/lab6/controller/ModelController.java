package com.wwsi.lab6.controller;

import com.wwsi.lab6.model.db.Photo;
import com.wwsi.lab6.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ModelController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @GetMapping("/gallery")
    public ModelAndView gallery(){
        ModelAndView model = new ModelAndView("gallery");
        List<Photo> list = apiService.getPhotosFromMongo();
        model.addObject("photos",list);
        return model;
    }
}
