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
    public ClientMove makeMove(@PathVariable("gameId") String gameId, @RequestParam("color") int color) {
        System.out.println("makeMove endpoint hit");
        System.out.println("gameId=" + gameId);
        System.out.println("color=" + color);

        return new ClientMove(new int[]{0,2}, new int[]{0,3});
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseStatusDto handleMove(@PathVariable("gameId") String gameId, @RequestBody ServerMove serverMove) {
        System.out.println("handleMove endpoint hit");
        System.out.println("gameId=" + gameId);
        System.out.println(serverMove);

        return new ResponseStatusDto("ok");
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseStatusDto finishGame(@PathVariable("gameId") String gameId) {
        System.out.println("finishGame endpoint hit");
        System.out.println("gameId=" + gameId);

        return new ResponseStatusDto("ok");
    }

}
