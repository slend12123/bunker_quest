package model;

import java.util.Random;

public class Game {
    private int health;
    private int food;
    private boolean alive;
    private String lastMessage;

    public Game() {
        this.health = 100;
        this.food = 3;
        this.alive = true;
        this.lastMessage = "Ты проснулся в холодном бункере. Что будешь делать?";
    }

    public void makeChoice(String action) throws InterruptedException {
        Random random = new Random();

        if (!alive) {
            lastMessage = "Ты уже мёртв. Начни заново.";
            return;
        }

        switch (action) {
            case "eat":
                if (food > 0) {
                    food--;
                    health = Math.min(100, health + 10);
                    lastMessage = "Ты поел. Силы немного вернулись.";
                } else {
                    health -= 20;
                    lastMessage = "Еды нет. Ты теряешь силы.";
                }
                break;

            case "explore":
                int event = random.nextInt(3);
                if (event == 0) {
                    food++;
                    lastMessage = "Ты нашёл немного консервов!";
                } else if (event == 1) {
                    health -= 30;
                    lastMessage = "Ты встретил мутанта! Он ранил тебя.";
                } else {
                    lastMessage = "Пусто... только тишина.";
                }
                break;

            case "sleep":
                if (health < 100) {
                    Thread.sleep(5000);
                    health += 5;
                    lastMessage = "Ты немного отдохнул.";
                    break;
                }
            default:
                lastMessage = "Ты выспался.";
                break;
        }

        if (health <= 0) {
            alive = false;
            lastMessage = "Ты умер в бункере...";
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public int getHealth() {
        return health;
    }

    public int getFood() {
        return food;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}