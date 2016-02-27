import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/***
 * Created by vathsala on 25/02/16.
 */
public class Wc {
    private String[] args;
    private ArrayList<String> files;
    private Set commands;
    private ArrayList<String> errorMessages;
    private ArrayList<Integer> lineCount;
    private ArrayList<Integer> wordCount;
    private ArrayList<Integer> charCount;

    public Wc(String[] args) {
        this.args = args;
        this.files = new ArrayList<String>();
        this.commands = new HashSet();
        this.errorMessages = new ArrayList<String>();
        this.lineCount = new ArrayList<Integer>();
        this.wordCount = new ArrayList<Integer>();
        this.charCount = new ArrayList<Integer>();
    }

    public void argumentSeparator() {

        for (int i = 0; i < this.args.length; i++) {
            if (this.args[i].split("[^.]").length > 0 || this.files.size() > 0) {
                files.add(this.args[i]);
                continue;
            }
            if (this.args[i].split("[^-]").length > 0) {
                String[] cmds = this.args[i].substring(1, this.args[i].length()).split("");
                for (String cmd : cmds) {
                    commands.add(cmd);
                }
            }
        }
    }

    public void count(String fileContent, int line, int word, int ch) {
        errorMessages.add(fileContent);
        lineCount.add(line);
        wordCount.add(word);
        charCount.add(ch);
    }

    public int[] lwcCounter(String line, String word, String ch, String fileContent) {
        Counters c = new Counters();
        int lCount = (line == "l") ? c.lineCount(fileContent) : 0;
        int wCount = (word == "w") ? c.wordCount(fileContent) : 0;
        int cCount = (ch == "c") ? c.charCount(fileContent) : 0;
        return new int[]{lCount, wCount, cCount};
    }

    public void calculate() {
        argumentSeparator();
        int line = 0;
        int ch = 0;
        int word = 0;
        System.out.println("commands = " + commands);
        if (commands.size() <= 0) {
            for (int i = 0; i < files.size(); i++) {
                String fileContent = new FileReaders().readFile(files.get(i));
                if (fileContent == "This file doesn't exist") {
                    count(fileContent, 0, 0, 0);
                    continue;
                }
                int[] lwcCounts = lwcCounter("l", "w", "c", fileContent);
                count("", lwcCounts[0], lwcCounts[1], lwcCounts[2]);
                line += lwcCounts[0];
                ch += lwcCounts[1];
                word += lwcCounts[2];
            }
        }
        String l = (commands.contains("l")) ? "l" : "";
        String w = (commands.contains("w")) ? "w" : "";
        String c = (commands.contains("c")) ? "c" : "";
        for (int i = 0; i < files.size(); i++) {
            String fileContent = new FileReaders().readFile(files.get(i));
            if (fileContent == "This file doesn't exist") {
                count(fileContent, 0, 0, 0);
                continue;
            }
            int[] lwcCounts = lwcCounter(l, w, c, fileContent);
            count("", lwcCounts[0], lwcCounts[1], lwcCounts[2]);
            line += lwcCounts[0];
            ch += lwcCounts[1];
            word += lwcCounts[2];
        }
        count("", line, word, ch);
        files.add("Total");

    }

    public void represent() {
        Representation r = new Representation();
        String[] newStr = new String[]{};
        Integer[] newInt = new Integer[]{};
        String text = r.represent(errorMessages.toArray(newStr), lineCount.toArray(newInt),
                wordCount.toArray(newInt), charCount.toArray(newInt), files.toArray(newStr));
        System.out.println(text);
    }
}