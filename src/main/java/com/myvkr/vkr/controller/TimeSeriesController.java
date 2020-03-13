package com.myvkr.vkr.controller;

import com.myvkr.vkr.model.Image;
import com.myvkr.vkr.model.TimeSeries;
import com.myvkr.vkr.rep.TimeSeriesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
public class TimeSeriesController {
    private final TimeSeriesRep timeSeriesRep;

    @Autowired
    public TimeSeriesController(TimeSeriesRep timeSeriesRep) {
        this.timeSeriesRep = timeSeriesRep;
    }

    @GetMapping
    public List<TimeSeries> main(){
        return timeSeriesRep.findAll();
    }


}
