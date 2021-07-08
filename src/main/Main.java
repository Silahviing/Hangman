package main;

import java.util.*;

public class Main {
    public static void main(String[] args){

        Hangman hgm = new Hangman();

        System.out.println("---------------------------------\n      HANGMAN - The Return\n---------------------------------");
        System.out.println(" ");
        System.out.println("Have fun!\nOnly ever enter one letter! If you enter more, the game will not register the second one.\nIf you know the word before having all the letters, then enter a '!' to enter the whole word.");
        System.out.println("But first, choose a language: english? or german? (The interface stays english)");

        Scanner scanner = new Scanner(System.in);

        String language = scanner.nextLine();

        if(language.equals("english")){
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
            hgm.addWord("Swimmingpool");
            hgm.addWord("Coconutpalm");
            hgm.addWord("Columbia");
            hgm.addWord("Hangman");
            hgm.addWord("Microsoft");
            hgm.addWord("Management");
            hgm.addWord("Weatherstation");
            hgm.addWord("Colourful");
            hgm.addWord("Broadway");
            hgm.addWord("Müslischüssel");
            hgm.addWord("Strengths");
            hgm.addWord("Psychotomimetic");
            hgm.addWord("Connecticut");
            hgm.addWord("Electrodynamo");
            hgm.addWord("Caramellbonbon");
        } else if(language.equals("german")){
            hgm.addWord("Käseplatte");
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
            hgm.addWord("Höhlenmensch");
            hgm.addWord("Microsoft");
            hgm.addWord("Wildwasserrafting");
            hgm.addWord("Bruttosozialprodukt");
            hgm.addWord("Ölüberschussmesser");
            hgm.addWord("Wühlmaus");
            hgm.addWord("Müslischüssel");
            hgm.addWord("Kaffeevollautomat");
            hgm.addWord("DeutscheBahn");
            hgm.addWord("Leberkäswecken");
            hgm.addWord("Tunfischfilet");
            hgm.addWord("Karamellbonbon");
        }

        Hangman.game();
    }
}
