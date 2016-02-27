import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vathsala on 25/02/16.
 */
public class CountersTest {

    String file1 = "I am using this string to test the counters\n" + "This is just a sample String";
    String file2 = "    hello         friends ... we       are here to learn   .    java";

    @Test
    public void wordCount1() {
        Counters c = new Counters();
        int count = c.wordCount(file1);
        Assert.assertEquals(15, count);
    }

    @Test
    public void lineCount1() {
        Counters c = new Counters();
        int count = c.lineCount(file1);
        Assert.assertEquals(2, count);
    }

    @Test
    public void charCount1() {
        Counters c = new Counters();
        int count = c.charCount(file1);
        Assert.assertEquals(73, count);
    }

    @Test
    public void wordCount2() {
        Counters c = new Counters();
        int count = c.wordCount(file2);
        Assert.assertEquals(10, count);
    }

    @Test
    public void lineCount() {
        Counters c = new Counters();
        int count = c.lineCount(file2);
        Assert.assertEquals(1, count);
    }

    @Test
    public void charCount2() {
        Counters c = new Counters();
        int count = c.charCount(file2);
        Assert.assertEquals(69, count);
    }
}
