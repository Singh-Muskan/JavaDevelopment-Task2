package com.hangman;

import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        String[] words = {"APPLE", "BANANA", "ORANGE", "MANGO", "STRAWBERRY"};
        String wordToGuess = words[(int) (Math.random() * words.length)];

        int maxAttempts = 6;
        int remainingAttempts = maxAttempts;
        StringBuilder guessedWord = new StringBuilder("_".repeat(wordToGuess.length()));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the fruit name.");

        while (remainingAttempts > 0 && guessedWord.toString().contains("_")) {
            System.out.println("Word: " + guessedWord);
            System.out.println("Attempts left: " + remainingAttempts);
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toUpperCase().charAt(0);

            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord.setCharAt(i, guess);
                    found = true;
                }
            }

            if (!found) {
                remainingAttempts--;
                System.out.println("Incorrect guess!");
            }
        }

        if (guessedWord.toString().equals(wordToGuess)) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you're out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }
}
