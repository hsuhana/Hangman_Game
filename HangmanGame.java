/**Application Purpose: The purpose of this application is to develop a simple code for 
 * a game Hangman with a collaboration of crossword to make it more interesting. 
 * The code includes several strings, functions, 
 *Author: Yuvraj Jindal, Fang Ting HSU, Gurleen Kaur, Lovekaranjeet Singh
 * Time: 11:00am
 * Date: 26 July 2023
 */

 //import the libraries 
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//A class with name Hangman Game is declared
public class HangmanGame 
{
    //An array of strings storing the Words with variable name "WORDS"
    private static final String[] WORDS = {"cost", "tasty", "pleat", "usa", "ease", "far", "steps", "eyes"};

    //An array of strings storing the Words hint with variable name "WORDS_HINT"
    private static final String[]WORDS_HINT = {"Expense","Delicious","Crease in a Skirt","Country Between Canada and Mexico (abbr.)", "Lack of Difficulty", "Opposite of 'Near'", "Staircase Parts", "Body Parts that Blink and Wink"};


    private String word;                     //string with name word
    private StringBuilder guessedWord;      //string Builder with name guessWord
    private int attemptsLeft;              //integer with name attemptsLeft
    private StringBuilder guessedLetters; //string Builder with name guessedLetters

    //another function for HangmanGame (construtor?)
    
    public void HangmanGame() 
    {
        word = getRandomWord(); //for getting the randome word
        guessedWord = new StringBuilder("_".repeat(word.length())); //prints underscore or dashes for the length of the word
        attemptsLeft = 7; //attempts allowed are seven only
        guessedLetters = new StringBuilder(); //new string builder for guessed letters
               
    }
    
    //getter for getting random word
    private String getRandomWord() 
    {
        int randomIndex = (int) (Math.random() * WORDS.length); //getting the random word from the string WORDS
        word = WORDS[randomIndex]; //checks for the word using index
        
        String hint; //defines a string with name hint
        
        int index = Arrays.asList(WORDS).indexOf(word); //for getting the Word
        hint = (String)Array.get(WORDS_HINT,index); //for getting the hint associated with that word
        System.out.println("Your Hint is : " + hint); //prints the hint with appropriate message
        
        return word; //return the word
    }

    //function for printinf Hangman step by step for wrong guesses
    private void printHangman() 
    {
        //string holding the Hangman Structure
        String[] hangman = 
        {
                "  +---+\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=========",

                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "=========",

                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                "  |   |\n" +
                "      |\n" +
                "      |\n" +
                "=========",

                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|   |\n" +
                "      |\n" +
                "      |\n" +
                "=========",

                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\ |\n" +
                "      |\n" +
                "      |\n" +
                "=========",

                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " /    |\n" +
                "      |\n" +
                "=========",

                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " / \\  |\n" +
                "      |\n" +
                "========="
        };

        //prints the attempts left after each guess
        System.out.println(hangman[7 - attemptsLeft]);
    }

    //Prints the appropriate message for input by the user

    //for the word dashes
    private void printGuessedWord() 
    {
        System.out.println("Word is: " + guessedWord); //space for the word with appropriate message
    }

    //for attempts left
    private void printAttemptsLeft() 
    {
        System.out.println("Attempts Left for guessing correct word: " + attemptsLeft); //prints the attempts left
    }

    //for guessed letters
    private void printGuessedLetters() 
    {
        System.out.println("Your Guessed Letters are: " + guessedLetters);  //prints the guessed letters
    }

    //boolean variable
    private boolean isGameWon() 
    {
        return !guessedWord.toString().contains("_");  //returns guessed word to string
    }

    //function for checking the input and if the input is false then attempts left will be decreased by 1
    private void guessLetter(char letter) 
    {
        guessedLetters.append(letter).append(" ");
        boolean correctGuess = false;  //boolean for correctguess

        //for loop for the words
        for (int i = 0; i < word.length(); i++) 
        {
            if (word.charAt(i) == letter) 
            {
                guessedWord.setCharAt(i, letter);
                correctGuess = true;  //guess is true attempts left remains same 
            }
        }

        //if the guess is incorrect
        if (!correctGuess) 
        {
            attemptsLeft--;  //decrease attempts left by 1
        }
    }

//another function to check the letter guessed
private boolean isLetterGuessed(char letter) 
{
    return guessedLetters.toString().contains(Character.toString(letter));  //returns the guessed letter
}

//function for checking whether the input is valid or not
private char getValidLetterInput(Scanner scanner) 
{
    while (true) 
    {
        System.out.print("Enter a letter which you think will be correct: "); //appropriate message before entering the letter
        
        //try statement
        try 
        {
            String input = scanner.nextLine().toLowerCase(); //asks user to enter a letter
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) 
            {
                char letter = input.charAt(0);

                //if letter guessed is correct
                if (!isLetterGuessed(letter)) 
                {
                    return letter; //return the letter if it is valid
                }

                //if letter is entered again
                 else 
                {
                    System.out.println("You have already guessed this letter. Try a different letter!");  //else prints the message
                }

            } 

            //else if the user enter more than 1 letters at a time
            else if (input.length() >=2) 
            {
                System.out.println("Please enter single letter at a time");  //prints the message to enter single letter
            }

            //if letter entered is not an alphabet
            else 
            {
                System.out.println("Please enter a valid letter!");  //prints letter is invalid
            }
        } 

        //catch statement
        catch (Exception e) 
        {
            System.out.println("Please enter a valid letter!" + e.getMessage());  //prints appropriate message
            scanner.nextLine(); // Clear the invalid input from the scanner buffer
        }
    }
}


//play function
public void play() 
{
    Scanner scanner = new Scanner(System.in);  //initialize the scanner
    boolean playAgain = true;  //boolean for playingagain checker
    int count = 0; //integer count set to value 0

    while (playAgain)
    {
        System.out.println();  //leaves a line

        //if user wishes to play again prints the below message
        if (count == 1)
        {
            System.out.println("!!!!Welcome to the Game Again!!!!");  //prints at starting
        }
        
        System.out.println("Welcome to Hangman!");
        System.out.println("!All the Best!");
        HangmanGame();  //play the game

        while (attemptsLeft > 0 && !isGameWon()) 
        {
            printHangman(); //prints hangman
            printGuessedWord();  //guessedword
            printAttemptsLeft();  //attempts left
            printGuessedLetters();  //guessed letters

            char letter = getValidLetterInput(scanner);  //for valid input
            guessLetter(letter); 
        } 

        //After winning the Game
        if (isGameWon()) 
        {
            System.out.println(); //leaves a line
            System.out.println("You Guessed the correct Word i.e. " + word); //appropriate message with showing the word
            System.out.println("Congratulations! You won the Game!"); //appreciating message after winning the game
        } 
        
        //After losing the Game 
        else 
        {
            System.out.println();  //leaves a line
            System.out.println("Bad Luck! Better Next Time"); //Prints the motivating Message
            System.out.println("Game over! The word was: " + word); //prints the correct word
        }

        System.out.println();  //leaves a line
        System.out.print("Do you want to play again? (yes/no): "); //asks the user if they want to play again
        String playAgainInput = scanner.nextLine().toLowerCase(); //gets the input and change to lowecase
        playAgain = playAgainInput.equals("yes") || playAgainInput.equals("y"); //reads the input if yes then play again
        count = 1;
    }

    //if user enters "No" then prints the below message 
    System.out.println(); //leaves a line
    System.out.println("This Game is brought to you by:");  //credits for the game creators 
    System.out.println("Yuvraj Jindal");
    System.out.println("Fang Ting HSU");
    System.out.println("Gurleen Kaur");
    System.out.println("Lovekaranjeet Singh");
    System.out.println(); //leaves a line
    System.out.println("Thanks for playing Hangman! Goodbye!");  //thank you message
    System.out.println("!We will be waiting for you to play again!"); //eagerly waiting to play again message
}

//This is the End of The code
 
}