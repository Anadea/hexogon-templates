package com.anahoret.anadea_bot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
public class Board {

    private int width;
    private int height;
    private int figures_count;
    private int[][] cells;

    @Override
    public String toString() {
        return "Board{" +
                "width=" + width +
                ", height=" + height +
                ", figures_count=" + figures_count +
                ", cells=" + Arrays.deepToString(cells) +
                '}';
    }
}
