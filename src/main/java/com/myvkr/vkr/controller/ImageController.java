package com.myvkr.vkr.controller;

import com.myvkr.vkr.model.Image;
import com.myvkr.vkr.rep.ImageRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vkr")
public class ImageController {
    private final ImageRep imageRep;

    @Autowired
    public ImageController(ImageRep imageRep) {
        this.imageRep = imageRep;
    }

    @GetMapping
    public List<Image> main(){
        return imageRep.findAll();
    }

    @GetMapping("{id}")
    public Image getOne(@PathVariable("id") Image image) {
        return image;
    }

    @PostMapping
    public Image create(@RequestBody Image image) {
        return imageRep.save(image);
    }
}
