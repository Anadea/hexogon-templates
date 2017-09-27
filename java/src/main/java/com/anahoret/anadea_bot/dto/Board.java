package com.anahoret.anadea_bot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
public class Board {

    private int size;
    private int[][] cells;

    @Override
    public String toString() {
        return "Board{" +
                "size=" + size +
                ", cells=" + Arrays.deepToString(cells) +
                '}';
    }
}
