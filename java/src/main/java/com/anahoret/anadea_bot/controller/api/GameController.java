package com.anahoret.anadea_bot.controller.api;

import com.anahoret.anadea_bot.dto.ClientMove;
import com.anahoret.anadea_bot.dto.Game;
import com.anahoret.anadea_bot.dto.ResponseStatusDto;
import com.anahoret.anadea_bot.dto.ServerMove;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/games")
public class GameController {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseStatusDto startGame(@RequestBody Game game) {
        System.out.println("startGame endpoint hit");
        System.out.println(game);

        return new ResponseStatusDto("ok");
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.GET)
    @ResponseBody
    public ClientMove makeMove(@PathVariable("gameId") int gameId, @RequestParam("color") int color) {
        System.out.println("makeMove endpoint hit");
        System.out.println("gameId=" + gameId);
        System.out.println("color=" + color);

        return new ClientMove(0);
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseStatusDto handleMove(@PathVariable("gameId") int gameId, @RequestBody ServerMove serverMove) {
        System.out.println("handleMove endpoint hit");
        System.out.println("gameId=" + gameId);
        System.out.println(serverMove);

        return new ResponseStatusDto("ok");
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseStatusDto finishGame(@PathVariable("gameId") int gameId) {
        System.out.println("finishGame endpoint hit");
        System.out.println("gameId=" + gameId);

        return new ResponseStatusDto("ok");
    }

}
