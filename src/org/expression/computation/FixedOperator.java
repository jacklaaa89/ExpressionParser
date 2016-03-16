package org.expression.computation;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.expression.Type;
import org.expression.parser.Context;

/**
 * An operation type where the operator is postfixed to the type.
 * An example of this is increment/decrement operations.
 * @author Jack Timblin
 */
public class FixedOperator extends Operator {
    
    private final int[] COMPATIBLE_EXPRESSIONS = {
        FixedOperator.EXPRESSION_ALL, 
        FixedOperator.EXPRESSION_MATRIX,
        FixedOperator.EXPRESSION_SCALAR,
        FixedOperator.EXPRESSION_VECTOR
    };
    
    private final int[] ALL = {
        FixedOperator.EXPRESSION_MATRIX,
        FixedOperator.EXPRESSION_SCALAR,
        FixedOperator.EXPRESSION_VECTOR
    };
    
    public static final int PREFIX = 0;
    public static final int POSTFIX  = 1;
    
    private int fixPoint;
    
    /**
     * A collection of system reserved postfix operators, i.e. these
     * operations cannot be changed and are integral to other fundamental
     * parts of the language.
     */
    private final String[] SYSTEM_RESERVED = {/**"++", "--"**/};
    
    /**
     * Initializes a new postfix operator.
     * @param sign the sign for this operation.
     * @param fixPoint the position this operator is fixed, either before or after.
     */
    public FixedOperator(String sign, int fixPoint) {
        super(sign);
        boolean isIn = Arrays.asList(SYSTEM_RESERVED).contains(sign);
        if(isIn) {
            throw new RuntimeException("'" + sign + "' is reserved and cannot be modified.");
        }
        boolean valid = IntStream.of(new int[]{PREFIX, POSTFIX}).anyMatch(x -> x == fixPoint);
        if(!valid) {
            throw new RuntimeException("invalid fix point position defined.");
        }
        this.fixPoint = fixPoint;
    }
    
    @Override
    public Operator addEvaluator(int expression, Evaluator e) {
        boolean contains = IntStream.of(COMPATIBLE_EXPRESSIONS).anyMatch(x -> x == expression);
        if(!contains) {
            throw new RuntimeException("Invalid Expression type provided.");
        }
        int[] expr = (expression == EXPRESSION_ALL) ? ALL : new int[] {expression};
        for(int ex : expr) {
            super.addEvaluator(ex, e);
        }
        return this;
    }
    
    @Override
    public Operator addEvaluator(int[] exprs, Evaluator e) {
        for(int expression : exprs) {
            boolean contains = IntStream.of(COMPATIBLE_EXPRESSIONS).anyMatch(x -> x == expression);
            if(!contains) {
                throw new RuntimeException("Invalid Expression type provided.");
            }
        }
        boolean containsAll = IntStream.of(exprs).anyMatch(x -> x == EXPRESSION_ALL);
        if(containsAll) {
            exprs = ALL; //force to all.
        }
        return super.addEvaluator(exprs, e);
    }
    
    @Override
    public Context evaluate(Context left, Context right) {
        //right will always be null in this case.
        if(right != null) {
            throw new RuntimeException("post/prefix operations cannot have a right side context.");
        }
        
        //check the left is not empty.
        if(left == null || left.isEmptyContext()) {
            throw new RuntimeException("Cannot peform operations on an empty context.");
        }
        
        Type v;
        
        int evalType = (left.isArray())
                ? EXPRESSION_VECTOR
                : ((left.isMatrix()) ? EXPRESSION_MATRIX : EXPRESSION_SCALAR);
        
        Evaluator e = this.getEvaluator(evalType);
        
        if(e == null) {
            e = this.getDefaultOperator();
            if(e == null) {
                throw new RuntimeException("Could not evaluate the '" + this.getOper() + "' operator");
            }
        }
        
        v = e.eval((Arithmetic)left.getValue(), null); //always null on the right.
        
        return new Context(v, left.getLineNo(), left.getCharPositionInLine(), left.getExpression());
        
    }
    
    public int getFixPoint() {
        return this.fixPoint;
    }
    
}
