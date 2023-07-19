package ru.netology.HomeWork_Map.Javaqa.Services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testFirstWin() {
        Player one = new Player(1, "Nick", 100);
        Player two = new Player(2, "Rick", 10);
        Game game = new Game();

        game.register(one);
        game.register(two);
        int expected = 1;
        int actual = game.round("Nick", "Rick");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondWin() {
        Player one = new Player(1, "Nick", 10);
        Player two = new Player(2, "Rick", 100);
        Game game = new Game();

        game.register(one);
        game.register(two);
        int expected = 2;
        int actual = game.round("Nick", "Rick");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDraw() {
        Player one = new Player(1, "Nick", 100);
        Player two = new Player(2, "Rick", 100);
        Game game = new Game();

        game.register(one);
        game.register(two);
        int expected = 0;
        int actual = game.round("Nick", "Rick");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThrowFirst() {
        Player one = new Player(1, "Nick", 100);
        Player two = new Player(2, "Rick", 100);
        Game game = new Game();

        game.register(one);
        game.register(two);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Mick", "Rick"));
    }

    @Test
    public void testThrowSecond() {
        Player one = new Player(1, "Nick", 100);
        Player two = new Player(2, "Rick", 100);
        Game game = new Game();

        game.register(one);
        game.register(two);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Nick", "Kick"));
    }

    @Test
    public void testGamerNotregistred() {
        Player one = new Player(1, "Nick", 100);
        Player two = new Player(2, "Rick", 100);
        Game game = new Game();

        game.register(one);
        game.register(two);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Mick", "Kick"));
    }
}
