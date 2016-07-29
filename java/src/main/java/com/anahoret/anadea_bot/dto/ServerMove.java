package com.anahoret.anadea_bot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServerMove {

    private int figure;
    private int color;

    @Override
    public String toString() {
        return "ServerMove{" +
                "figure=" + figure +
                ", color=" + color +
                '}';
    }

}
