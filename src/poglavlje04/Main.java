package poglavlje04;

import poglavlje04.parsetree.MiniJavaParser;
import poglavlje04.parsetree.ParseException;
import poglavlje04.syntaxtree.Program;

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
                            .filter(f -> f.getFileName().toString().contains("TestFac2.java"))
                            .findFirst();

            assert testFile.isPresent();

            Program p = new MiniJavaParser(new FileInputStream(testFile.get().toFile())).Parse();
            System.out.println("Abstract syntax tree successfully created");
        }
        catch (ParseException e) {
            System.out.println("Parser Error : \n"+ e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
