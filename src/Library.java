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

	public BufferedReader readFile(String file)throws FileNotFoundException, IOException{
		File fileName = new File(file);
		FileReader a = new FileReader(fileName);
		BufferedReader x = new BufferedReader(a);
		return x;
	}

	public int countLines(String file)throws FileNotFoundException, IOException{
		int count = 0;
		String file_text = "";
		String line = "";
		BufferedReader x = readFile(file);
		while( (line = x.readLine()) != null ) {
			file_text+=line;
			count++;
        }
		return count-1;
	}
}