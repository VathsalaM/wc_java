import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by vathsala on 25/02/16.
 */
public class FileReaders {
    public String readFile(String file) {
        String str = "";
        String line = "";
        try {
            File fileName = new File(file);
            FileReader a = new FileReader(fileName);
            BufferedReader x = new BufferedReader(a);
            while ((line = x.readLine()) != null) {
                str += line + "\n";
            }
        } catch (IOException ie) {
            return "This file doesn't exist";
        }
        return str.substring(0, str.length() - 1);
    }
}
