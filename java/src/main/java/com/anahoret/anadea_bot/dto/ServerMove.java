package com.anahoret.anadea_bot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
public class ServerMove {

    private HashMap<String, Integer> jumps;
    private int[][] changes;

    @Override
    public String toString() {
        return "ServerMove{" +
                "jumps=" + jumps +
                ", changes=" + Arrays.deepToString(changes) +
                '}';
    }

}
