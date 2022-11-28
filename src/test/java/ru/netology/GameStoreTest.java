package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

//    @BeforeEach
//    void setUp() {
//        GameStore store = new GameStore();
//    }

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddSeveralGames() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Minecraft", "Симулятор");

        assertTrue(store.containsGame(game));
        assertTrue(store.containsGame(game1));
    }

    @Test
    public void shouldBeEmpty() {

        GameStore store = new GameStore();
        assertFalse(store.containsGame(null));
    }

    @Test
    public void shouldContainsGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        assertFalse(store.containsGame(game));
    }

    @Test
    public void shouldGetMostPlayerIfAllPlayersAreDifferent() {

        GameStore store = new GameStore();
        store.addPlayTime("Paul", 5);
        store.addPlayTime("Nina", 7);
        store.addPlayTime("Chris", 9);
        store.addPlayTime("Irina", 15);

        assertEquals("Irina", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerIfPlayersRepeat() {

        GameStore store = new GameStore();
        store.addPlayTime("Paul", 5);
        store.addPlayTime("Nina", 7);
        store.addPlayTime("Paul", 19);
        store.addPlayTime("Irina", 15);

        assertEquals("Paul", store.getMostPlayer());
    }

    @Test
    public void shouldNotGetMostPlayer() {

        GameStore store = new GameStore();
        assertEquals(null, store.getMostPlayer());
    }

    @Test
    public void shouldGetSumPlayedTime() {

        GameStore store = new GameStore();
        store.addPlayTime("Nina", 5);
        store.addPlayTime("Anna", 10);
        store.addPlayTime("Paul", 15);

        assertEquals(30, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetSumOfOnyOneTime() {

        GameStore store = new GameStore();
        store.addPlayTime("Anna", 8);

        assertEquals(8, store.getSumPlayedTime());
    }

    @Test
    public void shouldNotGetSum() {

        GameStore store = new GameStore();
        assertEquals(0, store.getSumPlayedTime());
    }
}
