//SCREEN CLASS
import java.io.IOException;
import java.util.*;

public class Win {
	char[] secretWord;
	String title;
	String lines;
	String hanger;
	char[] dashes;
	List<Character> guessedLetters = new ArrayList<Character>();
	
	public Win(char[] secretWord,String title, String lines, String hanger,char[] dashes, List<Character> guessedLetters) {
		this.secretWord = secretWord;
		this.title = title;
		this.lines = lines;
		this.hanger = hanger;
		this.dashes = dashes;
		this.guessedLetters = guessedLetters;
	}	
	public void setScreen() {
		System.out.println(this.title);
		System.out.println(this.lines);
		System.out.println(this.hanger);
		System.out.println("Current word: " + new String(this.dashes));
		System.out.println("Letters guessed: " + this.guessedLetters);
	}
	public void clearScreen() throws InterruptedException, IOException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
	public boolean checkWin(){
		if(Arrays.equals(dashes, this.secretWord) || new String(this.dashes).contains("_") == false){
			return true;
		}else{
			return false;
		}	
	}
	public void lives8(){
		this.hanger = "#######\n#     |\n#\n#\n#\n#\n#\n#\n\n\n";
	}
	public void lives7(){
		this.hanger = "#######\n#     |\n#    ( )\n#\n#\n#\n#\n#\n\n\n";
	}
	public void lives6(){
		this.hanger = "#######\n#     |\n#    ( )\n#     |\n#\n#\n#\n#\n\n\n";
	}
	public void lives5(){
		this.hanger = "#######\n#     |\n#    ( )\n#     |\n#     |\n#\n#\n#\n\n\n";
	}
	public void lives4(){
		this.hanger = "#######\n#     |\n#    ( )\n#  ---|\n#     |\n#\n#\n#\n\n\n";
	}
	public void lives3(){
		this.hanger = "#######\n#     |\n#    ( )\n#  ---|---\n#     |\n#\n#\n#\n\n\n";
	}
	public void lives2(){
		this.hanger = "#######\n#     |\n#    ( )\n#  ---|---\n#     |\n#    |\n#\n#\n\n\n";
	}
	public void lives1(){
		this.hanger = "#######\n#     |\n#    ( )\n#  ---|---\n#     |\n#    | |\n#\n#\n\n\n";
	}
}
