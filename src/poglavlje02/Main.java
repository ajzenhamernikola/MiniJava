package poglavlje02;

import poglavlje02.parser.MiniJavaParser;
import poglavlje02.parser.ParseException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class Main {

    public static void main(String [] args) {
        try {
            Optional<Path> testFile =
                    Files.walk(Paths.get(System.getProperty("user.dir")))
                    .filter(Files::isRegularFile)
                    .filter(f -> f.getFileName().toString().contains("TestFac.java"))
                    .findFirst();

            assert testFile.isPresent();

            new MiniJavaParser(new FileInputStream(testFile.get().toFile())).Goal();
            System.out.println("Lexical analysis successfull");
        }
        catch (ParseException e) {
            System.out.println("Lexer Error : \n"+ e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

