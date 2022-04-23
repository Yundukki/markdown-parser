import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
//imports junit

public class MarkdownParseTest { //creates MarkdownParse test class
    @Test //calls a junit test
    public void addition() { //names the method of test
        assertEquals(2, 1 + 1); //asserts 2 and 1+1 are equal
    }

    @Test
    public void GetLink() throws IOException{
        assertEquals(List.of("https://something.com", "some-thing.html")
        ,MarkdownParse.getLinks(Files.readString(Path.of("test-file.md"))));
    }
        
    @Test
    public void GetLink2() throws IOException{
        assertEquals(List.of("https://www.youtube.com/")
        ,MarkdownParse.getLinks(Files.readString(Path.of("test-file-2.md"))));
    }

    @Test
    public void GetLink3() throws IOException{
        assertEquals(List.of("https://www.youtube.com/")
        ,MarkdownParse.getLinks(Files.readString(Path.of("test-file-3.md"))));
    }

    @Test
    public void GetLink4() throws IOException{
        assertEquals(List.of("https://www.youtube.com/")
        ,MarkdownParse.getLinks(Files.readString(Path.of("test-file-4.md"))));
    }
}
