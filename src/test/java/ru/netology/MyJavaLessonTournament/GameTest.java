package ru.netology.MyJavaLessonTournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class GameTest {
    ArrayList<Player> expected = new ArrayList<>();
//    ArrayList<Player> actual = new ArrayList<>();

    Game game = new Game();

    Player player1 = new Player(1, "Player1", 10);
    Player player2 = new Player(2, "Player2", 20);
    Player player3 = new Player(3, "Player3", 30);
    Player player4 = new Player(4, "Player4", 40);
    Player player5 = new Player(5, "Player5", 10);

    @Test
    public void shouldRegisterPlayer() {
        expected.add(player2);
        game.register(player2);

        ArrayList<Player> actual = new ArrayList<>(game.players);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAllPlayers() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        ArrayList<Player> expected = new ArrayList<>(game.players);
        ArrayList<Player> actual = new ArrayList<>(game.findAllPlayers());

        Assertions.assertArrayEquals(new ArrayList[]{expected}, new ArrayList[]{actual});
    }

    @Test
    public void shouldStartFightOne() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 1;
        int actual = game.round("Player2", "Player5");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldStartFightTwo() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 2;
        int actual = game.round("Player1", "Player4");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldStartFightThree() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 0;
        int actual = game.round("Player1", "Player5");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotStartFightWithUnregisteredPlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(RuntimeException.class, () -> game.round("Player1", "Player6"));
    }

    @Test
    public void shouldNotStartFightWithSinglePlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(RuntimeException.class, () -> game.round("Player1", ""));
    }
}