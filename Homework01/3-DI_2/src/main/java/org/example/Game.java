package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : Game
 * @Description :
 * @Author : ZJ
 * @Date: 2025-11-12 16:39
 */

public class Game {
    public Thinkable getPlayer() {
        return player;
    }

    public void setPlayer(Thinkable player) {
        this.player = player;
    }

    Thinkable player;
    public void play() {
        player.thinking();
        System.out.println("Game Over");
    }
    public Game(Thinkable player) {
        this.player = player;
    }
//    @Autowired
//    Thinkable player1;
}
