package com.anahoret.anadea_bot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientMove {

    public ClientMove(int figure) {
        status = "ok";
        this.figure = figure;
    }

    private String status;
    private int figure;

}
