import java.io.*;

class Mkdir {
	public static void main(String[] args) {
		String[] fileNames = {"build","test","lib","out","src","test"};
		for (int i=0;i<5 ;i++ ) {
			File fileName = new File("./"+fileNames[i]);
			fileName.mkdir();
		}
	}
}