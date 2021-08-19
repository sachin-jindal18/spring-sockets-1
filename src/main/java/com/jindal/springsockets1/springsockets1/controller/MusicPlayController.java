package com.jindal.springsockets1.springsockets1.controller;

import com.jindal.springsockets1.springsockets1.models.PlayMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MusicPlayController {

    @MessageMapping("/play")
    @SendTo("/instruments/play")
    public PlayMessage playInstrument(PlayMessage playMessage) {
        System.out.println("Playing = " + playMessage);
        return playMessage;
    }
}
