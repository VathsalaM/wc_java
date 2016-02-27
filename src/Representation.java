/**
 * Created by vathsala on 25/02/16.
 */
public class Representation {

    public String represent(String errorMessage, Integer lineCount, Integer wordCount, Integer charCount, String fileName) {
        if (errorMessage != "")
            return errorMessage + " : " + fileName + "\n";
        return ((lineCount != 0) ? lineCount + "\t" : "\t") + ((wordCount != 0) ? wordCount + "\t" : "\t") + ((charCount != 0) ? charCount + "\t" : "\t") + fileName + "\n";
    }

    public String represent(String[] errorMessage, Integer[] lineCount, Integer[] wordCount, Integer[] charCount, String[] files) {
        String str = "";
        for (Integer i = 0; i < (files.length == 2 ? 1 : files.length); i++) {
            str += represent(errorMessage[i], lineCount[i], wordCount[i], charCount[i], files[i]);
        }
        return str;
    }
}
