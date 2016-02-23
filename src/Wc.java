import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

class Wc {
	
	public static void main(String[] args)throws IOException{
		Library lib = new Library();
		lib.argumentSeperator(args);
		try{
			ArrayList<Integer> lineCount = lib.lineCounter();
			System.out.println("line count : "+lineCount);
			ArrayList<Integer> count = lib.charCounter();
			System.out.println("char count : "+count);
			ArrayList<Integer> wordCount = lib.wordCounter();
			System.out.println("word count : "+wordCount);
		}
		catch( FileNotFoundException fe){
			System.out.println("wc: One.java: open: No such file or directory");
		}
	}
}