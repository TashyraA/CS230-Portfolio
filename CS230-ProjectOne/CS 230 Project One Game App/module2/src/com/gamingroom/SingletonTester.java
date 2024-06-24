package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

    public void testSingleton() {
        
        System.out.println("\nAbout to test the singleton...");
        
        // Obtain local reference to the singleton instance
        // This ensures we are working with the same instance of GameService,
        // maintaining consistency across the application.
        GameService service = GameService.getInstance();
        
        // A simple for loop to print the games
        for (int i = 0; i < service.getGameCount(); i++) {
            System.out.println(service.getGame(i));
        }
    }
}
