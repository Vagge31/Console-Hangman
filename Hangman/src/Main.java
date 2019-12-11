//MAIN LOGIC HERE

import java.io.IOException;
import java.util.*;

public class Main {
	static String[] secretWords = {"integer", "string", "loop", "program", "computer", "variable"};
	static Random rand = new Random();
	static String secretWord = secretWords[rand.nextInt(secretWords.length)];
	static char[] secretWordArr = secretWord.toCharArray();

	public static void main(String[] args) throws InterruptedException, IOException{
		String title = "Hangman Game!";
		String lines = "-------------\n\n";
		String hanger = "#######\n#\n#\n#\n#\n#\n#\n#\n\n\n";
		char[] dashes = new char[secretWord.length()];
		List<Character> guessedLetters = new ArrayList<Character>();
		int lives = 9;

		for(int i = 0; i < secretWord.length(); i++) {
			dashes[i] = '_';		
		}
		
		Win screen = new Win(secretWordArr,title, lines,hanger, dashes, guessedLetters);
		screen.clearScreen();
		screen.setScreen();

		while(true) {
			Scanner obj = new Scanner(System.in);
			System.out.print("Enter a guess: ");
			char guess = obj.next().charAt(0);

			if(secretWord.indexOf(guess) != -1) {
				 int indx = secretWord.indexOf(guess);
				for(int i = 0; i < secretWord.length(); i++){
					char c = secretWord.charAt(i);
					if(c == letterTimesAppear(secretWordArr) && guess == c){
						dashes[i] = c;
					}
				}
				dashes[indx] = guess;
				screen.clearScreen();
				screen.setScreen();
			}else if(secretWord.indexOf(guess) == -1) {
				guessedLetters.add(guess);
				System.out.println(guessedLetters);
				lives--;
				screen.clearScreen();
				screen.setScreen();
				}

			if(screen.checkWin() == true){
				System.out.println("You win!");
				break;
			}
			switch(lives){
				case 8:
				screen.lives8();
				screen.clearScreen();
				screen.setScreen();
				break;

				case 7:
				screen.lives7();
				screen.clearScreen();
				screen.setScreen();
				break;
				
				case 6:
				screen.lives6();
				screen.clearScreen();
				screen.setScreen();
				break;

				case 5:
				screen.lives5();
				screen.clearScreen();
				screen.setScreen();
				break;

				case 4:
				screen.lives4();
				screen.clearScreen();
				screen.setScreen();
				break;

				case 3:
				screen.lives3();
				screen.clearScreen();
				screen.setScreen();
				break;

				case 2:
				screen.lives2();
				screen.clearScreen();
				screen.setScreen();
				break;

				case 1:
				screen.lives1();
				screen.clearScreen();
				screen.setScreen();
				break;
			}
			if(lives <= 0){
				System.out.println("You lose!");
				break;
			}
			}			
	}
	static char letterTimesAppear(char[] str){
		char ch = ' ';
		Arrays.sort(str);

		for(int i = 0; i < str.length -1; i++){
			if(str[i] == str[i+1]){
				ch = str[i];
			}
		}
		return ch;
	}
}
