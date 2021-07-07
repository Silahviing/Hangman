package main;

import java.util.*;

public class Hangman {
    public static void main(String[] args) {

        //listing word to guess
        List<String> list = new ArrayList<>();

        list.add("Käseplatte");
        list.add("Schifffahrtsgesellschaft");
        list.add("Schreibblockade");
        list.add("Autobahn");
        list.add("Schokolade");
        list.add("Programmieren");
        list.add("Wettervorhersage");
        list.add("Markdown");
        list.add("Avengers");
        list.add("Wasserflasche");
        list.add("Churchill");
        list.add("Zircuszelt");
        list.add("Regenbogen");
        list.add("Kokosnusspalme");
        list.add("Datenbanken");
        list.add("Höhlenmensch");
        list.add("Microsoft");
        list.add("Wildwasserrafting");
        list.add("Bruttosozialprodukt");
        list.add("Ölüberschussmesser");
        list.add("Wühlmaus");
        list.add("Müslischüssel");
        list.add("Kaffeevollautomat");
        list.add("DeutscheBahn");
        list.add("Leberkäswecken");
        list.add("Tunfischfilet");
        list.add("Karamellbonbon");

        Hangman obj = new Hangman();

        //creating a list for the letters already guessed
        List<Character> alreadyGuessed = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean gameIsRunning = true;

        //the actual game:
        while (gameIsRunning){
            System.out.println("---------------------------------\n      HANGMAN - The Return\n---------------------------------");
            System.out.println(" ");
            System.out.println("Have fun!\nOnly ever enter one letter! If you enter more, the game will not register the second one.\nIf you know the word before having all the letters, then enter a '!' to enter the whole word.");

            //getting random word
            String word = (obj.getRandomElement(list));
            word = word.toUpperCase();
            char[] wordArray = word.toCharArray();

            //replacing every letter with an underscore
            String word1 = word.replaceAll("[A-Z,ÄÖÜß]", "_");
            char[] word1Array = word1.toCharArray();

            String word3 = word1;

            boolean wordIsGuessed = false;
            int tries = 10;

            //while the word must still be guessed
            while (!wordIsGuessed | tries != 0){
                System.out.println(" ");
                System.out.println("You have " + tries + " tries left.");
                System.out.println("You already guessed these letters: " + alreadyGuessed);
                System.out.println("Your word: " + word3);
                System.out.println(" ");
                System.out.println("Enter a single character: ");

                //getting a letter from user input
                char input = scanner.nextLine().charAt(0);

                //converting it to upper case
                input = toUpperCase(input);
                String input2 = String.valueOf(input);

                if (input == '-'){

                    //forgot why this is here...
                    gameIsRunning = false;
                    wordIsGuessed = true;

                } else if (word.contains(input2)){
                    //guess a letter and use the letter converted into str

                    for (int i = 0; i<word.length();i++) {
                        //loop over to word that is now an array to see if the guessed letter is in it

                        if (wordArray[i] == input) {
                            word1Array[i] = input;

                            if (!alreadyGuessed.contains(input)){
                                //adding the letter to the list of guessed letters
                                alreadyGuessed.add(input);

                            } else {
                                System.out.println(" ");
                            }
                            //converting the char array into a string to display
                            word3 = toStringAberInBesser(word1Array);
                        }
                    }
                    if (isTheWordGuessed(word1Array)){
                        // letting you know you won if the word is guessed
                        wordIsGuessed = true;
                        System.out.println(" ");
                        System.out.println("You won! Congratulations!");
                        System.out.println("The word was "+word);
                        System.out.println(" ");
                        alreadyGuessed.clear();
                        //leave
                        break;
                    }
                    if (tries == 0){
                        System.out.println("You ran out of guesses...");
                        System.out.println("The word was "+word);
                        System.out.println(" ");
                        //clear the list for the next run
                        alreadyGuessed.clear();
                        break;
                    }
                } else if (input2.equals("!")){
                    //is the player enters !  they can guess
                    System.out.println(" ");
                    System.out.println("You know the word? Please enter: ");
                    String inputWhole = scanner.nextLine();
                    inputWhole = inputWhole.toUpperCase();

                    if (inputWhole.equals(word)){
                        // letting you know you won if the word is guessed
                        wordIsGuessed = true;
                        System.out.println(" ");
                        System.out.println("You won! Congratulations!");
                        System.out.println("The word was "+word);
                        System.out.println(" ");
                        alreadyGuessed.clear();
                        break;

                    } else {
                        System.out.println("Sorry, that was not the word...");
                        System.out.println(" ");
                        tries--;
                    }
                } else {
                    System.out.println("Wrong guess...");
                    System.out.println(" ");

                    //subtracting tries
                    tries--;

                    if (tries == 0){
                        System.out.println("You ran out of guesses...");
                        System.out.println(" ");
                        //clear the list for the next run
                        alreadyGuessed.clear();
                        break;
                    }
                    if (!alreadyGuessed.contains(input)){
                        //adding it to the list
                        alreadyGuessed.add(input);

                    } else {
                        tries++;
                    }
            }
            }
            //asking if you want to play another game, regardless of win or lose
            System.out.println("Do you want to play another round? Y/N");
            System.out.println(" ");

            String anotherGame = scanner.nextLine();
            anotherGame = anotherGame.toUpperCase();

            if (anotherGame.equals("N")){
                gameIsRunning = false;
                System.out.println("Shutting down...");
                System.out.println(" ");
                System.exit(0);

            } else if (anotherGame.equals("Y")){
                gameIsRunning = true;
                System.out.println("Starting new game...");
                System.out.println(" ");
            } else{
                System.out.println("Whoops...");
                System.exit(0);
            }
        }
    }
    //Method to get a random element
    public String getRandomElement(List<String> list){
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
    //method to make sure if the word is guessed by looking for _
    public static boolean isTheWordGuessed(char[] array){
        for(int i =0; i < array.length; i++){
            if(array[i] == '_') {return false;}
        }
        return true;
    }
    //a better version of toString() so the output won't display [letter, _, _, letter, _, _, usw]
    public static String toStringAberInBesser (char[] arr){
        //buffer for temporal storage
        String buffer = "";

        for (int i = 0; i<arr.length;i++){
            //adding every letter in an array to the string
            buffer += arr[i];
        }
        return buffer;  //return the string
    }
    //method to convert a char into a upper case char
    public static char toUpperCase(char ch){
        ch = Character.toUpperCase(ch);
        return ch;
    }
}
