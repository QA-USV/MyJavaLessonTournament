package ru.netology.MyJavaLessonTournament;

import java.util.*;

public class Game {

    public ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        if (players.contains(player)) {
            throw new AlreadyExistsException(
                    "Player with name " + player + " is already registered."
            );
        }
        players.add(player);
    }

    public ArrayList<Player> findAllPlayers() {
        return players;
    }

    public int round(String playerName1, String playerName2) {
        Player playerInRedCorner = null;
        Player playerInBlueCorner = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                playerInRedCorner = player;
            }
            if (player.getName().equals(playerName2)) {
                playerInBlueCorner = player;
            }
        }
        if (playerInRedCorner == null) {
            throw new RuntimeException(
                    "Not enough players for a fight."
            );
        }
        if (playerInBlueCorner == null) {
            throw new RuntimeException(
                    "Not enough players for a fight."
            );
        }
        if (playerInRedCorner.getStrength() > playerInBlueCorner.getStrength()) {
            return 1;
        }
        if (playerInRedCorner.getStrength() < playerInBlueCorner.getStrength()) {
            return 2;
        }
        return 0;
    }
}