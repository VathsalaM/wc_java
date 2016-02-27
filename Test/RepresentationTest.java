import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vathsala on 25/02/16.
 */
public class RepresentationTest {

    Representation r = new Representation();

    @Test
    public void represent_only_error_if_there_is_an_error_message() {
        String errorMessage = "This file doesn't exist";
        String expected = "This file doesn't exist : Sample.txt\n";
        String actual = r.represent(errorMessage, 0, 0, 0, "Sample.txt");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void represent_line_word_and_char_count_if_all_the_counts_exist() {
        String expected = "10\t20\t30\tSample.txt\n";
        String actual = r.represent("", 10, 20, 30, "Sample.txt");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void represent_specific_count_if_only_a_specific_count_exist() {
        String expected = "20\t30\tSample.txt\n";
        String actual = r.represent("", 0, 20, 30, "Sample.txt");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void represent_multiple_data() {
        String expected = "10\t20\t30\tSample.txt\n" + "32\t40\t50\tMyThings.txt\n";
        Integer[] lineCount = {10, 20};
        Integer[] charCount = {30, 50};
        Integer[] wordCount = {20, 40};
        String[] files = {"Sample.txt", "MyThings.txt"};
        String[] errorMessage = {"", ""};
        String actual = r.represent(errorMessage, lineCount, charCount, wordCount, files);
    }

    @Test
    public void represent_multiple_data_including_error_messages() {
        String expected = "10\t20\t30\tSample.txt\n" + "This file doesn't exist : Fail.txt\n" + "32\t40\t50\tMyThings.txt\n";
        Integer[] lineCount = {10, 0, 20};
        Integer[] charCount = {30, 0, 50};
        Integer[] wordCount = {20, 0, 40};
        String[] files = {"Sample.txt", "Fail.txt", "MyThings.txt"};
        String err = "This file doesn't exist : Fail.txt";
        String[] errorMessage = {"", err, ""};
        String actual = r.represent(errorMessage, lineCount, charCount, wordCount, files);
    }
}
