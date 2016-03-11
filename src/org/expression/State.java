package org.expression;

import java.util.HashMap;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.expression.computation.Function;
import org.expression.computation.Operator;
import org.expression.computation.Procedure;
import org.expression.output.OutputListener;
import org.expression.parser.ErrorHandler;

/**
* Container class for the parse tree and parser instances and other variables for 
* the current expression.
* @author Jack Timblin
*/
public class State {
    /**
     * The parser used to generate the parse tree.
     */
    public Parser parser;

    /**
     * The generated AST.
     */
    public ParseTree tree;

    /**
     * The lexer used to generate the parse tree.
     */
    public Lexer lexer;

    /**
     * The error handler attached to the lexer and parser.
     */
    public ErrorHandler handler;

    /**
     * The variables in the current scope.
     */
    public HashMap<String, Type> variables;

    /**
     * The functions in the current scope.
     */
    public HashMap<String, Function> functions;

    /**
     * The operators in the current scope.
     */
    public HashMap<String, Operator> operators;

    /**
     * The procedures in the current scope.
     */
    public HashMap<String, Procedure> procedures = new HashMap<>();

    /**
     * The defined output listener which is triggered on certain parse events.
     */
    public OutputListener listener;
    
    /**
     * The current expression string for the current state.
     */
    public String expression;

    /**
     * Copies a new state object from an existing state.
     * @param state the state object to copy from.
     * @return the new state object copied from {@code state}
     */
    public static State from(State state) {
        State s = new State();
        s.functions = state.functions;
        s.handler = state.handler;
        s.lexer = state.lexer;
        s.listener = state.listener;
        s.operators = state.operators;
        s.parser = state.parser;
        s.procedures = state.procedures;
        s.tree = state.tree;
        s.variables = state.variables;
        s.expression = state.expression;
        return s;
    }

}
