package main;

import java.util.*;

public class Hangman {

    static String language = "";

    public Hangman(String language){
        Hangman.language = language;
    }

    //listing word to guess
    static List<String> list = new ArrayList<>();

    //creating a list for the letters already guessed
    static List<Character> alreadyGuessed = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static boolean gameIsRunning = true;

    public static void game() {

        Hangman obj = new Hangman(language);

        //the actual game:
        while (gameIsRunning){

            //getting a random word
            String word = (obj.getRandomElement(list));

            word = word.toUpperCase();
            char[] wordArray = word.toCharArray();

            //replacing every letter with an underscore
            String replacedWord = word.replaceAll("[A-Z,ÄÖÜ]", "_");
            char[] word1Array = replacedWord.toCharArray();

            String updatedWord = replacedWord;

            boolean wordIsGuessed = false;
            int tries = 10;

            //while the word must still be guessed
            while (!wordIsGuessed | tries != 0){
                if (language.equals("english")){
                    System.out.println(" ");
                    System.out.println("You have " + tries + " tries left.");
                    System.out.println("You already guessed these letters: " + alreadyGuessed);
                    System.out.println("Your word: " + updatedWord);
                    System.out.println(" ");
                    System.out.println("Enter a single character: ");
                } else if (language.equals("german")){
                    System.out.println(" ");
                    System.out.println("Do hast noch " + tries + " Versuche.");
                    System.out.println("Diese Buchstaben hast du bereits geraten: " + alreadyGuessed);
                    System.out.println("Dein Wort: " + updatedWord);
                    System.out.println(" ");
                    System.out.println("Gib einen Buchstaben ein: ");
                }

                //getting a letter from user input
                char inputChar = scanner.nextLine().charAt(0);

                //converting it to upper case
                inputChar = toUpperCase(inputChar);
                String inputString = String.valueOf(inputChar);

                boolean isChar = Character.isLetter(inputChar);

                //making sure users only enter letters
                if (isChar | inputChar == '!'){
                    if (inputChar == '-'){

                        gameIsRunning = false;
                        wordIsGuessed = true;

                    } else if (word.contains(inputString)){ //compare the guessed letter with the letters in the word

                        for (int i = 0; i<word.length();i++) {
                            //loop over to word that is now an array to find the guessed letter in it

                            if (wordArray[i] == inputChar) {
                                word1Array[i] = inputChar;

                                if (!alreadyGuessed.contains(inputChar)){
                                    //adding the letter to the list of guessed letters
                                    alreadyGuessed.add(inputChar);

                                } else {
                                    System.out.println(" ");
                                }
                                //converting the char array into a string to display
                                updatedWord = toStringButBetter(word1Array);
                            }
                        }
                        if (isTheWordGuessed(word1Array)){
                            System.out.println(" ");
                            if (language.equals("english")){
                                System.out.println("You won! Congratulations!");
                                System.out.println("The word was "+word);
                            } else if (language.equals("german")){
                                System.out.println("Du hast gewonnen! Gratulation!");
                                System.out.println("Dein Wort war: "+word);
                            }
                            System.out.println(" ");
                            //clearing the ArrayList of guessed chars and leave
                            alreadyGuessed.clear();
                            break;
                        }
                        if (tries == 0){
                            //checking if the guesses are used up
                            if (language.equals("english")){
                                System.out.println("You ran out of guesses...");
                                System.out.println("The word was "+word);
                            } else if (language.equals("german")){
                                System.out.println("Du hast keine Versuche mehr...");
                                System.out.println("Dein Wort war "+word);
                            }
                            System.out.println(" ");
                            //clear the list for the next run  and leave
                            alreadyGuessed.clear();
                            break;
                        }
                    } else if (inputString.equals("!")){
                        //is the player enters !  they can guess
                        System.out.println(" ");
                        if (language.equals("english")){
                            System.out.println("You know the word? Please enter: ");
                        } else if (language.equals("german")){
                            System.out.println("Du weißt das Wort? Bitte gib ein: ");
                        }
                        String inputWhole = scanner.nextLine();
                        inputWhole = inputWhole.toUpperCase();

                        //comparing the entered word with the word to guess
                        if (inputWhole.equals(word)){
                            System.out.println(" ");
                            if (language.equals("english")){
                                System.out.println("You won! Congratulations!");
                                System.out.println("The word was "+word);
                            } else if (language.equals("german")){
                                System.out.println("Du hast gewonnen! Gratulation!");
                                System.out.println("Dein Wort war "+word);
                            }
                            System.out.println(" ");
                            //clearing again and the leaving
                            alreadyGuessed.clear();
                            break;

                        } else {
                            if (language.equals("english")){
                                System.out.println("Sorry, that was not the word...");
                            } else if (language.equals("german")){
                                System.out.println("Sorry, das war nicht das Wort...");
                            }
                            System.out.println(" ");
                            tries--;
                        }
                    } else {
                        if (language.equals("english")){
                            System.out.println("Wrong guess...");
                        } else if (language.equals("german")){
                            System.out.println("Falsch geraten...");
                        }
                        System.out.println(" ");
                        tries--;

                        if (tries == 0){
                            if (language.equals("english")){
                                System.out.println("You ran out of guesses...");
                            } else if (language.equals("german")){
                                System.out.println("Du hast keine Versuche mehr...");
                            }
                            System.out.println(" ");
                            //clear the list for the next run
                            alreadyGuessed.clear();
                            break;
                        }
                        //checking if the guessed letter was already guessed
                        if (!alreadyGuessed.contains(inputChar)){
                            //adding it to the list
                            alreadyGuessed.add(inputChar);

                        } else {
                            //to balance out the initial subtraction
                            tries++;
                        }
                    }
                } else{
                    //in case the user entered a number or similar
                    if (language.equals("english")){
                        System.out.println("Please enter either a letter or a '!'");
                    } else if (language.equals("german")){
                        System.out.println("Bitte gib entweder Buchstaben oder ein '!' ein.");
                    }
                }

            }
            //asking if you want to play another game, regardless of win or loss
            if (language.equals("english")){
                System.out.println("Do you want to play another round? Y/N");
            } else if (language.equals("german")){
                System.out.println("Willst du noch eine Runde spielen? Y/N");
            }
            System.out.println(" ");

            String anotherGame = scanner.nextLine();
            anotherGame = anotherGame.toUpperCase();

            //evaluate answer
            if (anotherGame.equals("N")){
                gameIsRunning = false;
                if (language.equals("english")){
                    System.out.println("Shutting down...");
                } else if (language.equals("german")){
                    System.out.println("Fahre runter...");
                }
                System.out.println(" ");
                System.exit(0);

            } else if (anotherGame.equals("Y")){
                gameIsRunning = true;
                if (language.equals("english")){
                    System.out.println("Starting new game...");
                } else if (language.equals("german")){
                    System.out.println("Starte neues Spiel...");
                }
                System.out.println(" ");
            } else{
                //exiting if the answer is anything else than Y or N
                System.out.println("Whoops...");
                System.exit(0);
            }
        }
    }

    //adding words to the list
    public void addWord(String word){
        list.add(word);
    }

    //Method to get a random element
    public String getRandomElement(List<String> list){
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    //method to make sure if the word is guessed by looking for _
    public static boolean isTheWordGuessed(char[] array){
        for (char c : array) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    //a better version of toString() so the output won't display [letter, _, _, letter, _, _, etc]
    public static String toStringButBetter (char[] arr){
        //buffer for temporal storage
        String buffer = "";

        for (char c : arr) {
            //adding every letter in an array to the string
            buffer += c;
        }
        return buffer;  //return the string
    }

    //method to convert a char into a upper case char
    public static char toUpperCase(char ch){
        ch = Character.toUpperCase(ch);
        return ch;
    }
}