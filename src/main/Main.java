package main;

import java.util.*;

public class Main {

    public static void main(String[] args){

        System.out.println("---------------------------------\n      HANGMAN - The Return\n---------------------------------");
        System.out.println(" ");
        System.out.println("What language do you want? English or german?");

        Scanner scanner = new Scanner(System.in);
        String lang = scanner.nextLine();

        Hangman hgm = new Hangman(lang);

        if(lang.equals("english")){

            System.out.println("Have fun!\nOnly ever enter one letter! If you enter more, the game will not register the second one.\nIf you know the word before having all the letters, then enter a '!' to enter the whole word.\nEnter a '-' to exit.");

            hgm.addWord("Cheeseburger");
            hgm.addWord("Beekeeper");
            hgm.addWord("Jukebox");
            hgm.addWord("Unworthy");
            hgm.addWord("Knapsack");
            hgm.addWord("Kiwifruit");
            hgm.addWord("Vaporize");
            hgm.addWord("Yachtsman");
            hgm.addWord("Wristwatch");
            hgm.addWord("Zigzagging");
            hgm.addWord("Pneumonia");
            hgm.addWord("Tournament");
            hgm.addWord("Swimming");
            hgm.addWord("Coconut");
            hgm.addWord("Columbia");
            hgm.addWord("Hangman");
            hgm.addWord("Microsoft");
            hgm.addWord("Management");
            hgm.addWord("Weather");
            hgm.addWord("Colourful");
            hgm.addWord("Broadway");
            hgm.addWord("Keyboard");
            hgm.addWord("Strengths");
            hgm.addWord("Psychotomimetic");
            hgm.addWord("Connecticut");
            hgm.addWord("Electrodynamo");
            hgm.addWord("Caramell");
            hgm.addWord("Jazz");
            hgm.addWord("Philadelphia");
            hgm.addWord("Indianapolis");
            hgm.addWord("electroluminescences");
            hgm.addWord("uncharacteristically");

        } else if(lang.equals("german")){

            System.out.println("Viel Spa??!\nBitte immer nur einen Buchstaben eingeben! Wenn mehr als einer engegeben werden, merkt es das Spiel nicht.\nWenn du das Wort schon wei??t bevor alle Buchstaben erraten wurden, gib ein '!' ein. Gib ein '-' ein um das Spiel zu schlie??en.");

            hgm.addWord("K??seplatte");
            hgm.addWord("Schifffahrtsgesellschaft");
            hgm.addWord("Schreibblockade");
            hgm.addWord("Autobahn");
            hgm.addWord("Schokolade");
            hgm.addWord("Programmieren");
            hgm.addWord("Wettervorhersage");
            hgm.addWord("Markdown");
            hgm.addWord("Avengers");
            hgm.addWord("Wasserflasche");
            hgm.addWord("Churchill");
            hgm.addWord("Zircuszelt");
            hgm.addWord("Regenbogen");
            hgm.addWord("Kokosnusspalme");
            hgm.addWord("Datenbanken");
            hgm.addWord("H??hlenmensch");
            hgm.addWord("Microsoft");
            hgm.addWord("Wildwasserrafting");
            hgm.addWord("Bruttosozialprodukt");
            hgm.addWord("??l??berschussmesser");
            hgm.addWord("W??hlmaus");
            hgm.addWord("M??slisch??ssel");
            hgm.addWord("Kaffeevollautomat");
            hgm.addWord("DeutscheBahn");
            hgm.addWord("Leberk??swecken");
            hgm.addWord("Tunfischfilet");
            hgm.addWord("Karamellbonbon");
            hgm.addWord("Schreibwarengesch??ft");
            hgm.addWord("Leuchtturmw??rter");
            hgm.addWord("Schulausflug");
            hgm.addWord("Kugelschreibermiene");
            hgm.addWord("Rollmops");
        }
        Hangman.game();
    }
}
