package poglavlje06;

import poglavlje06.syntaxtree.Program;
import poglavlje06.parsetree.MiniJavaParser;
import poglavlje06.parsetree.ParseException;
import poglavlje06.visitor.BuildSymbolTableTypeVisitor;
import poglavlje06.visitor.PrettyPrintVisitor;
import poglavlje06.visitor.TypeCheckDFVisitor;

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

            if (!testFile.isPresent()) {
                System.out.println("Could not find the test file");
                System.exit(1);
            }

            // Initializing the static parser
            new MiniJavaParser(new FileInputStream(testFile.get().toFile()));
            // Parsing the file
            Program p = MiniJavaParser.Parse();

            // Printing the parsed information
            p.accept(new PrettyPrintVisitor());

            System.out.print("\n\n");

            // Building a symbol table
            BuildSymbolTableTypeVisitor buildSymbolTableTypeVisitor = new BuildSymbolTableTypeVisitor();
            p.accept(buildSymbolTableTypeVisitor);
            buildSymbolTableTypeVisitor.getErrReport().printErrorReport();

            System.out.print("\n\n");

            // Typechecking
            TypeCheckDFVisitor typeCheckDFVisitor = new TypeCheckDFVisitor(buildSymbolTableTypeVisitor.getSymbolTable());
            p.accept(typeCheckDFVisitor);
            typeCheckDFVisitor.getErrorReport().printErrorReport();
        }
        catch (ParseException e) {
            System.out.println("Parser Error : \n" + e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
