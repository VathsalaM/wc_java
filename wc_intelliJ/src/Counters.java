/**
 * Created by vathsala on 25/02/16.
 */
public class Counters {
    public int wordCount(String file) {
        file = file.replaceAll("\t", " ");
        file = file.replaceAll("\n", " ");
        file = file.trim().replaceAll(" +", " ");
        String[] str = file.split(" ");
        return str.length;
    }

    public int lineCount(String file) {
        return file.split("\n").length - 1;
    }

    public int charCount(String file) {
        return file.split("").length - 1;
    }
}
