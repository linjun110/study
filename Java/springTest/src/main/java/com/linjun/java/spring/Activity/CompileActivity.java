package com.linjun.java.spring.Activity;

import com.linjun.java.spring.ClientModel.CompileInput;
import com.linjun.java.spring.ClientModel.CompileOutput;
import com.linjun.java.spring.annotation.Operation;
import com.linjun.java.spring.annotation.Service;
import com.linjun.java.spring.utils.compiler.ExprBaseListener;
import com.linjun.java.spring.utils.compiler.ExprLexer;
import com.linjun.java.spring.utils.compiler.ExprListener;
import com.linjun.java.spring.utils.compiler.ExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.Tree;

import java.util.List;

@Service(value = "ShippingConfigPlatformService")
public class CompileActivity {

    @Operation(value = "Compile")
    public CompileOutput enact(CompileInput input){
        System.out.println("Service: ShippingConfigPlatformService, Operation: Compile, request: " + input.getName());

        ANTLRInputStream in = new ANTLRInputStream(input.getName());
        ExprLexer lexer = new ExprLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ExprParser.ExprContext context = parser.expr();
        List<ParseTree> tree = context.children;
        System.out.println(tree.get(0).getText());
        System.out.println(tree.get(1).getText());
        System.out.println(tree.get(2).getText());
        System.out.println(tree.get(2).getChild(0).getText());
        System.out.println(tree.get(2).getChild(1).getText());
        System.out.println(tree.get(2).getChild(2).getText());

        // Walk it and attach our listener
        /*
        ParseTreeWalker walker = new ParseTreeWalker();
        ExprBaseListener listener = new ExprBaseListener();
        walker.walk(listener, context);
        */

        CompileOutput output = new CompileOutput("OK");
        return output;
    }
}
