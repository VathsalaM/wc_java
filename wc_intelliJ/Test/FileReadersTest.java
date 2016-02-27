import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vathsala on 25/02/16.
 */
public class FileReadersTest {

    String file = "The Java Tutorials are continuously updated to keep up with changes to the Java Platform and to incorporate feedback from our readers.\n\n" +
            "This release of the tutorial corresponds to the JDK 8u40 release.\n\n" +
            "This release includes a new lesson in the Deployment trail that describes how to use the Java packaging tools to generate self-contained applications. Self-contained applications are Java applications that are bundled with the JRE that is needed to run. These applications are installed on a user's local drive and launched in the same way as native applications. See Deploying Self-Contained Applications for more information.";

    @Test
    public void readFile() {
        FileReaders f = new FileReaders();
        Assert.assertEquals(file, f.readFile("Sample.txt"));
    }

    @Test
    public void readFile_error() {
        FileReaders f = new FileReaders();
        Assert.assertEquals("This file doesn't exist", f.readFile("MyThings.txt"));
    }
}