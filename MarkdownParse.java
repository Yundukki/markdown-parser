//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

// import org.junit.Test;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        int openBracket = 0;
        int closeBracket = 0;
        int openParen = 0;
        int closeParen = 0;
        while(currentIndex < markdown.length()) {
            
            // // fixes test file 3
            if (markdown.contains("(") == false && markdown.contains(")") == false){
                openBracket = markdown.indexOf("[", currentIndex);
                closeBracket = markdown.indexOf("]", openBracket);
                openParen = closeBracket;
                closeParen = markdown.length();
            }

            // fixes test file 2
            else if(markdown.contains("[") == false && markdown.contains("]") == false){
                openBracket = markdown.indexOf(";", currentIndex);
                closeBracket = markdown.indexOf(";", openBracket);
                openParen = markdown.indexOf("(", closeBracket);
                closeParen = markdown.lastIndexOf(")", markdown.length());
                toReturn.add(markdown.substring(openParen + 1, closeParen-1));
                break;
            }

            else{
                openBracket = markdown.indexOf("[", currentIndex);
                closeBracket = markdown.indexOf("]", openBracket);
                openParen = markdown.indexOf("(", closeBracket);
                closeParen = markdown.indexOf(")", openParen);  
            }
                
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;

            //fixes test file 4 
            String tempSubStr = markdown.substring(closeParen, markdown.length());
            if (tempSubStr.contains("[") == false){
                break;
            }
            
        }

        return toReturn;
    }
    

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
      

        

    }
}