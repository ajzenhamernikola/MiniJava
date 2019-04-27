package poglavlje03;

import poglavlje03.parser.MiniJavaParser;
import poglavlje03.parser.ParseException;

import java.io.FileInputStream;
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

            new MiniJavaParser(new FileInputStream(testFile.get().toFile())).Parse();
            System.out.println("Parsing successful");
        }
        catch (ParseException e) {
            System.out.println("Lexer Error : \n"+ e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
