package com.anahoret.anadea_bot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Game {

    private String id;
    private Board board;

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", board=" + board +
                '}';
    }
}
