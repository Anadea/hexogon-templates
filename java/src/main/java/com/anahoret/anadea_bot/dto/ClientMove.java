package com.anahoret.anadea_bot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientMove {

    public ClientMove(int[] move_from, int[] move_to) {
        status = "ok";
        this.move_from = move_from;
        this.move_to = move_to;
    }

    private String status;
    private int[] move_from;
    private int[] move_to;
}
