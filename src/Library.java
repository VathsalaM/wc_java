import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;


class Library {
	private	ArrayList<String> files = new ArrayList<String>(); 
	private	ArrayList<String> commands = new ArrayList<String>(); 

	public void argumentSeperator(String[] args){
		for (int i=0;i<args.length ;i++ ) {
			if(args[i].split("[^-]").length>0){
				commands.add(args[i]);
				continue;
			}
			if(args[i].split("[^.]").length>0){
				files.add(args[i]);
			}
		}
	}

	public ArrayList<Integer> lineCounter()throws FileNotFoundException, IOException{
		ArrayList<Integer> lineCounts = new ArrayList<Integer>(); 
		for(int i=0;i<this.files.size();i++){
			int count = countLines(this.files.get(i));
			lineCounts.add(count);
		}
		return lineCounts;
	}

	public FileReader readFile(String file)throws FileNotFoundException, IOException{
		File fileName = new File(file);
		FileReader a = new FileReader(fileName);
		return a;
	}

	public int countLines(String file)throws FileNotFoundException, IOException{
		int count = 0;
		String line = "";
		FileReader a = readFile(file);
		BufferedReader x = new BufferedReader(a);
		while( (line = x.readLine()) != null ) {
			count++;
        }
		return count-1;
	}

	public ArrayList<Integer> charCounter()throws FileNotFoundException, IOException{
		ArrayList<Integer> lineCounts = new ArrayList<Integer>(); 
		for(int i=0;i<this.files.size();i++){
			int count = countChars(this.files.get(i));
			lineCounts.add(count);
		}
		return lineCounts;
	}

	public int countChars(String file)throws FileNotFoundException,IOException{
		FileReader a = readFile(file);
		int i = 0;
		int x = 0;
		int buff_offset = 0;
		int length = 100;
		char[] cbuf = new char[400];
		do{
			i = a.read(cbuf,buff_offset,length);
			x+=i;

		}while(i>=0);
		return x+1;
	}

	public ArrayList<Integer> wordCounter()throws FileNotFoundException, IOException{
		ArrayList<Integer> lineCounts = new ArrayList<Integer>(); 
		for(int i=0;i<this.files.size();i++){
			int count = wordCount(this.files.get(i));
			lineCounts.add(count);
		}
		return lineCounts;
	}

	public int wordCount(String file)throws FileNotFoundException, IOException{
		int count = 0;
		String line = "";
		FileReader a = readFile(file);
		BufferedReader x = new BufferedReader(a);
		while( (line = x.readLine()) != null ) {
			String[] str = line.split(" ");
			count+=str.length;
        }
		return count-1;
	}

}