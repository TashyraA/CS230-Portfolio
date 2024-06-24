package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

    /**
     * A list of the active games
     */
    private static List<Game> games = new ArrayList<Game>();

    /*
     * Holds the next game identifier
     */
    private static long nextGameId = 1;

    /*
     * The singleton instance of GameService
     */
    private static GameService instance;

    /**
     * Private constructor to prevent instantiation
     * 
     * The Singleton pattern ensures that only one instance of this class
     * is created. This is crucial for managing game instances consistently
     * across the application, preventing issues such as duplicate game 
     * management and inconsistent states.
     */
    private GameService() {
    }

    /**
     * Returns the singleton instance of GameService
     * 
     * This static method returns the single instance of GameService,
     * creating it if necessary. This ensures that all parts of the 
     * application use the same instance, providing a global point of 
     * access to the game management functionality.
     * 
     * @return the singleton instance of GameService
     */
    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    /**
     * Construct a new game instance
     * 
     * @param name the unique name of the game
     * @return the game instance (new or existing)
     */
    public Game addGame(String name) {

        // a local game instance
        Game game = null;

        // Use iterator to look for existing game with same name
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existingGame = iterator.next();
            if (existingGame.getName().equals(name)) {
                game = existingGame;
                break;
            }
        }

        // if not found, make a new game instance and add to list of games
        if (game == null) {
            game = new Game(nextGameId++, name);
            games.add(game);
        }

        // return the new/existing game instance to the caller
        return game;
    }

    /**
     * Returns the game instance at the specified index.
     * <p>
     * Scope is package/local for testing purposes.
     * </p>
     * @param index index position in the list to return
     * @return requested game instance
     */
    Game getGame(int index) {
        return games.get(index);
    }
    
    /**
     * Returns the game instance with the specified id.
     * 
     * @param id unique identifier of game to search for
     * @return requested game instance
     */
    public Game getGame(long id) {

        // a local game instance
        Game game = null;

        // Use iterator to look for existing game with same id
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existingGame = iterator.next();
            if (existingGame.getId() == id) {
                game = existingGame;
                break;
            }
        }

        return game;
    }

    /**
     * Returns the game instance with the specified name.
     * 
     * @param name unique name of game to search for
     * @return requested game instance
     */
    public Game getGame(String name) {

        // a local game instance
        Game game = null;

        // Use iterator to look for existing game with same name
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existingGame = iterator.next();
            if (existingGame.getName().equals(name)) {
                game = existingGame;
                break;
            }
        }

        return game;
    }

    /**
     * Returns the number of games currently active
     * 
     * @return the number of games currently active
     */
    public int getGameCount() {
        return games.size();
    }
}
