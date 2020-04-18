package com.kirikomp.Game;

import java.util.Random;

public class Game {

    private Random randomStep = new Random();
    private Random randomHealing = new Random();
    private boolean end = true;
    private boolean winT1 = false;
    private boolean winT2 = false;

    private GameFrame gameFrame;

    public Game(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public void start() {

        gameFrame.clearMessages();
        int round = gameFrame.getRounds();

        Hero[] team1 = new Hero[gameFrame.getTeam1().size()];
        team1 = gameFrame.getTeam1().toArray(team1);

        Hero[] team2 = new Hero[gameFrame.getTeam2().size()];
        team2 = gameFrame.getTeam2().toArray(team2);
        while (end) {
//            for (int j = 0; j < round; j++) {
            for (int i = 0; i < team1.length; i++) {
                if (randomStep.nextInt(2) == 0) {
                    if (team1[i] instanceof Doctor) {
                        team1[i].healing(team1[randomHealing.nextInt(2)]);
                    } else {
                        team1[i].hit(team2[i]);
                    }
                } else {
                    if (team2[i] instanceof Doctor) {
                        team2[i].healing(team2[randomHealing.nextInt(2)]);
                    } else {
                        team2[i].hit(team1[i]);
                    }
                }
            }
            for (int i = 0; i < team1.length; i++) {
                if (team1[i].isAlive) winT1 = true;
                System.out.println(team1[i].isAlive);
                System.out.println(winT1);
                if (team2[i].isAlive) winT2 = true;
                System.out.println("-------------");
                System.out.println(team2[i].isAlive);
                System.out.println(winT2);
            }
            if (winT1 != winT2) end = false;
            winT1 = false;
            winT2 = false;
        }

        gameFrame.addMessage("----------- Победитель -------------");
        if (winT1) {
            gameFrame.addMessage("Команда 1");
        } else {
            gameFrame.addMessage("Команда 2");
        }
        gameFrame.addMessage("----------- Результаты-------------");
        gameFrame.addMessage("Первая команда:");
        for (Hero t1 : team1) {
            t1.info();
            gameFrame.addMessage(t1.getInfo());
        }
        gameFrame.addMessage("Вторая команда:");
        for (Hero t2 : team2) {
            t2.info();
            gameFrame.addMessage(t2.getInfo());
        }
    }

}