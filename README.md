# MiniJava

## Potrebne instalacije

1. Java 8 JDK
2. JavaCC

## Cilj

Kreiranje kompilatora za pojednostavljenu verziju jezika Java poznatu kao 
MiniJava. Primer izvornog koda napisanog u jeziku MiniJava:

```java
package poglavlje02;

// Main class for testing the TestFac class
class Factorial {
    public static void main(String[] a) {
        System.out.println(new TestFac().ComputeFac(10));
    }
}

/* Class that implements
 * factorial numbers calculating
 */
class TestFac {

    public int ComputeFac(int num){
        int num_aux ;
        if (num < 1)
            num_aux = 1 ;
        else
            num_aux = num * (this.ComputeFac(num-1)) ;
        return num_aux ;
    }

}
```

Gramatika jezika je data narednom kontekstno-slobodnom gramatikom:

```
Goal                ::= MainClass ( ClassDeclaration )* <EOF>

MainClass           ::= "class" Identifier "{" 
                            "public" "static" "void" "main" "(" 
                                "String" "[" "]" Identifier ")" "{" 
                                    Statement 
                                "}" 
                            "}"

ClassDeclaration    ::= "class" Identifier ( "extends" Identifier )? "{" 
                            ( VarDeclaration )* 
                            ( MethodDeclaration )* 
                        "}"

VarDeclaration      ::= Type Identifier ";"

MethodDeclaration   ::= "public" Type Identifier "(" 
                            ( Type Identifier ( "," Type Identifier )* )? ")"
                            "{" 
                                ( VarDeclaration )* 
                                ( Statement )* 
                                "return" Expression ";" 
                            "}"

Type                ::= "int" "[" "]"
                      | "boolean"
                      | "int"
                      | Identifier

Statement           ::= "{" ( Statement )* "}"
                      | "if" "(" Expression ")" Statement "else" Statement
                      | "while" "(" Expression ")" Statement
                      | "System.out.println" "(" Expression ")" ";"
                      | Identifier "=" Expression ";"
                      | Identifier "[" Expression "]" "=" Expression ";"

Expression          ::= Expression ( "&&" | "<" | "+" | "-" | "*" ) Expression
                      | Expression "[" Expression "]"
                      | Expression "." "length"
                      | Expression "." Identifier "(" 
                            ( Expression ( "," Expression )* )? 
                        ")"
                      | <INTEGER_LITERAL>
                      | "true"
                      | "false"
                      | Identifier
                      | "this"
                      | "new" "int" "[" Expression "]"
                      | "new" Identifier "(" ")"
                      | "!" Expression
                      | "(" Expression ")"

Identifier          ::= <IDENTIFIER>
``` 