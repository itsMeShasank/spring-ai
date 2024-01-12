package com.epam.springaidemo;

import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai/songs")
public class SongsController {

    @Autowired
    private ChatClient chatClient;

    @GetMapping("/song/{movie}")
    public String getSong(@PathVariable String movie) {
        String template = "does how many number of songs does "+movie+" have?";
        String aiResponse =  chatClient.generate(template);
        System.out.println(aiResponse);
        return aiResponse;
    }
}
