
/**Application Purpose: The purpose of this application to play the Hangman Game as it contains the main method for
 * calling the function/ class HangmanGame.
 * Author: Yuvraj Jindal, Fang Ting HSU, Gurleen Kaur, Lovekaranjeet Singh
 * Time: 2:00pm
 * Date: 28 July 2023
 */

//A class with name Game is declared
public class Game 
{
    //The main method which is used to run the entire code
    public static void main(String[] args) 
    {
        //A new object with name game is defined
        HangmanGame game = new HangmanGame();
        
        //prints a friendly welcome message at the start of the game
        System.out.println();
        System.out.println("This a Game with a mashup of Hangman And Crossowrd Game");
        System.out.println("You will be liking this game if you play it at leaset once");
        System.out.println("!Starting.......");
        System.out.print("!!!!Welcome to the Game!!!!");
        
        //plays the game
        game.play();

    }
    //This is the end of the code
}