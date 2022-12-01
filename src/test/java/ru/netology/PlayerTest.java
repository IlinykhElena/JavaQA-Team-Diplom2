package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    GameStore store = new GameStore();
    Player player = new Player("Petya");
    Game game1 = store.publishGame("Game1", "Genre1");
    Game game2 = store.publishGame("Game2", "Genre2");
    Game game3 = store.publishGame("Game3", "Genre1");
    Game game4 = store.publishGame("Game4", "Genre3");

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
    @Test
    public void shouldPlayNotInstallGame() {

        assertThrows(RuntimeException.class, () -> {
            player.play(game1, 1);
        });
    }

    @Test
    public void reinstallingGameNotResetNull() {
        player.installGame(game1);
        player.play(game1, 3);

        int expected = 3;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

}