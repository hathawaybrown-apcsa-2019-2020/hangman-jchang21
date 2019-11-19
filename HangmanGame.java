/**
 * this class represents a game of hangman
 * a secret word is stored
 * players guess letters in that word and are told whether or not they are correct
 *
 * @jessicachang
 * @version 2019-11-19
 */
public class HangmanGame
{
    private String gameStatus; // progress of game
    private String guessedLetters; // letters already guessed
    private String secretWord;

   /**
    * Constructor for objects of class HangmanGame
    */
    
    public HangmanGame(String word)
    {
        this.secretWord = word;
        this.gameStatus = "";
        for (int i = 0; i < word.length(); i++) // for each character in the word
        {
            if (Character.isLetter(word.charAt(i))) //checks if it is a letter
            {
                gameStatus += "-"; // adds a dash for every letter
            }
            else
            {
                gameStatus += word.charAt(i); // if it is not a letter, it adds punctuation or a space
            }
        }
        this.guessedLetters = "";
        secretWord = secretWord.toLowerCase(); // convert everything to lowercase
        }

    /**
     * Accessor method for class Hangman
     * @returns   already guessed letters
     */
        public String getTried()
    {
        return guessedLetters;
    }
    
    /**
     * Accessor method for class Hangman
     * @returns   the status of the game
     */
     public String getGuessed()
    {
        return gameStatus;
    }
    
    /**
     * Method for class Hangman
     * @param     a guessed letter
     * @return    a value that represents the accuracy of the guess
     */
    public int tryLetter(char letter)
     {
        int c = 0; // c is the value that will be returned
        for (int i = 0; i < secretWord.length(); i++)
        {
            int a = guessedLetters.indexOf(letter); // a is the position of the letter in the already guessed letters
            int b = secretWord.indexOf(letter); // b is the position of the guessed letter in the secret word
            if (a != -1) // if the letter is already guessed
            {
                c = 0; // c = 0 means the letter is already tried
            }
            else if (b == -1) // if the letter is out of bounds/not found in the secret word
            {
                c = -1; // c = -1 means the letter is not found in the word
            }
            else // the letter must be in the secret word
            {
                for (int k = 0; k < secretWord.length(); k++) // for every letter in the secret word
                {
                    if (secretWord.charAt(k) == letter) // if the character at k position is the same as the guessed letter
                    {
                         gameStatus = gameStatus.substring(0,k) + letter + gameStatus.substring(k+1);
                         // gameStatus is adjusted to reveal the "hidden letter"
                    }
                }
                c = 1; // c = 1 means the letter is found in the word
            }
        }
        guessedLetters = guessedLetters + " " + letter; // the letter is added to the list of already tried letters
        return c;
    }
}
