package com.geekster.UrlHitCounter.controllers;

import com.geekster.UrlHitCounter.models.UrlCounter;
import com.geekster.UrlHitCounter.services.UrlHitService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/visitor-count-app")
public class UrlHitController {

    @Autowired
    UrlHitService urlHitService;

    @GetMapping(value = "count")
    public String urlHitted(){
        return urlHitService.countIncrement();
    }

    @GetMapping(value = "username/{name}")
    public UrlCounter urlHitByName(@PathVariable String name) throws JSONException {

        return urlHitService.urlHitByName(name);
    }

}
