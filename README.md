# Hangman
Silahviing/Hangman

## Introduction

> This simple Hangman game is helping me learn java and object-oriented programming. Though I don't know how to work with different classen yet...

## Code Samples

> This is a little sample. It shows that I want to get a random word and make it upper case, that i want to save the letters the player inputs to an array and that the word should only be visible as _. This sample is located in the main function

            String word = (obj.getRandomElement(list));
            word = word.toUpperCase();
            char[] wordArray = word.toCharArray();

            //replacing every letter with an underscore
            String word1 = word.replaceAll("[A-Z,ÄÖÜß]", "_");
            char[] word1Array = word1.toCharArray();

            String word3 = word1;

            boolean wordIsGuessed = false;
            int tries = 10;

> This a the getRandomElement() function:


        public String getRandomElement(List<String> list){
            Random rand = new Random();
            return list.get(rand.nextInt(list.size()));
        }
