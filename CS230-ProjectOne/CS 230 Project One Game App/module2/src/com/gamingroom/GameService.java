package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;

    /*
     * Holds the next team identifier
     */
    private static long nextTeamId = 1;

    // Create private variable to track the existence of GameService
    private static GameService service = null;

    // Default constructor
    private GameService() {
    }

    /**
     * Check for an existing instance of GameService
     * @return the singleton instance of GameService
     */
	public static GameService getInstance() {

        // If GameService does not exist, create a new instance in heap memory
	    if (service == null) {
	        service = new GameService();
	        System.out.println("New Game Service created.");
        } else {
            // If it already exists, just notify
            System.out.println("Game Service already instantiated.");
        }

        // Return the new or existing single instance
        return service;
    }

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// A local game instance
		Game game = null;

        // Iterator instance to iterate through games list
        Iterator<Game> gamesIterator = games.iterator();

        // Iterate over the list of games
        while (gamesIterator.hasNext()) {

            // Set local Game variable to the next item in the list
            Game gameInstance = gamesIterator.next();

            // Check if the game name already exists
            if (gameInstance.getName().equalsIgnoreCase(name)) {
                // If the game name already exists, return the existing game instance
                return gameInstance;
            }
        }

		// If the game name doesn't exist, create a new game instance and add it to the list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// Return the new or existing game instance
		return game;
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id the unique identifier of the game to search for
	 * @return the requested game instance
	 */
	public Game getGame(long id) {

		// A local game instance
		Game game = null;

        // Iterator instance to iterate through games list
        Iterator <Game> gamesIterator = games.iterator();

        // Iterate over the list of games
        while (gamesIterator.hasNext()) {

            // Set local Game variable to the next item in the list
            Game gameInstance = gamesIterator.next();

            // Check if the game id already exists
            if (gameInstance.getId() == id) {
                // If the game id already exists, return the existing game instance
                return gameInstance;
            }
        }

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name the unique name of the game to search for
	 * @return the requested game instance
	 */
	public Game getGame(String name) {

		// A local game instance
		Game game = null;

        // Iterator instance to iterate through games list
        Iterator<Game> gamesIterator = games.iterator();

        // Iterate over the list of games
        while (gamesIterator.hasNext()) {

            // Set local Game variable to the next item in the list
            Game gameInstance = gamesIterator.next();

            // Check if the game name already exists
            if (gameInstance.getName().equalsIgnoreCase(name)) {
                // If the game name already exists, return the existing game instance
                game = gameInstance;
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

    /**
     * Returns the player whose turn is next
     *
     * @return the player whose turn is next
     */
    public long getNextPlayerId() {
	    return nextPlayerId;
    }

    /**
     * Returns the team whose turn is next
     *
     * @return the team whose turn is next
     */
    public long getNextTeamId() {
        return nextTeamId;
    }
}
