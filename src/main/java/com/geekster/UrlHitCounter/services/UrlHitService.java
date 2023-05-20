package com.geekster.UrlHitCounter.services;

import com.geekster.UrlHitCounter.models.UrlCounter;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UrlHitService {

    static private HashMap<String,Integer> map = new HashMap<>();
    static private int count = 0;
    UrlCounter urlCounter;

    public String countIncrement() {
        count++;
        return "count : "+count;
    }

    public UrlCounter urlHitByName(String name) throws JSONException {

        int count = map.getOrDefault(name,0);
        if(map.containsKey(name)){
            count++;

            map.put(name,count);
        }else{
            map.put(name,0);
        }


        urlCounter = new UrlCounter(name,count);
        return urlCounter;
    }
}
