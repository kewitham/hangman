package snippet;

import java.util.Scanner;
import java.util.Random;

public class Hangman {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String[] guesses = {"code", "java"};
		

		System.out.println ("Welcome to Hangman");

		boolean weArePlaying = true;
		while (weArePlaying) {
			char[] randomWordToGuess = guesses[random.nextInt (guesses.length)].toCharArray();
			int amountOfGuesses = randomWordToGuess.length;
			char[] playerGuess = new char[amountOfGuesses];

			for (int i=0; i < playerGuess.length; i++) {
				playerGuess [i] = '_';
			}

			boolean wordIsGuessed = false;
			int tries = 0;

			while (!wordIsGuessed && tries != amountOfGuesses){
				System.out.print ("Guesses: ");
				printArray(playerGuess);
				char input = scanner.nextLine().charAt(0);
				tries++;

				for(int i = 0; i<randomWordToGuess.length; i++){
					if(randomWordToGuess[i] == input){
						playerGuess[i] = input;
					}
				}

				if (isTheWordGuessed(playerGuess)){
					wordIsGuessed = true;
					System.out.println ("You win!");
				}
				}
			}

		
		System.out.println("Game over");
	}
	public static void printArray(char[] array){
		for (int i = 0; i < array.length; i++){
			System.out.println(array[i] + " ");
		}
		System.out.println();
	}

	public static boolean isTheWordGuessed(char[] array){
		for (int i=0; i < array.length; i++){
			if(array[i] == '_') return false;
		}
		return true;

	}
}
