package com.epam.springaidemo;

import org.springframework.ai.client.AiClient;
import org.springframework.ai.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai/songs")
public class SongsController {

    @Autowired
    private AiClient chatClient;

    @GetMapping("/song")
    public String getSong(@RequestBody String song) {
        return chatClient.generate(new Prompt(song)).getGeneration().getText();
    }
}
