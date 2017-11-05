package com.wdm.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wdm.example.model.User;

@RestController
@RequestMapping("")
public class IndexController {

    @RequestMapping("/")
    public Map<String, Object> index() {
        Map<String, Object> result = new HashMap<>();
        injectData(result, new User(1, "name", "account", "passwd", "136****8888"));
        return result;
    }

    private void injectData(Map<String, Object> result, @Nonnull User user) {
        result.put("user", user);
    }
}
