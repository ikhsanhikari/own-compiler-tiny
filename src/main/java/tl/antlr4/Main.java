package tl.antlr4;

import java.util.Collections;
import java.util.Map;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

    public static void main(String[] args) {
        try {
            TLLexer lexer = new TLLexer(CharStreams.fromFileName("D:\\ikhsan\\sample.txt"));
            TLParser parser = new TLParser(new CommonTokenStream(lexer));
            parser.setBuildParseTree(true);
            ParseTree tree = parser.parse();

            Scope scope = new Scope();
            Map<String, Function> functions = Collections.emptyMap();
            EvalVisitor visitor = new EvalVisitor(scope, functions);
            visitor.visit(tree);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                System.err.println(e.getMessage());
            } else {
                e.printStackTrace();
            }
        }
    }
}
