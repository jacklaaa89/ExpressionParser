package org.expression;

import java.util.HashMap;

/**
 * A encapsulation of an operator to use in the grammar.
 * Order of Operations is hard-coded into the grammar, but
 * all of the operations for an operator are performed using the evaluators defined 
 * in this class, making for easy operation overriding.
 * @author Jack Timblin
 */
public class Operator {
    
    /**
     * The sign to match in the grammar.
     */
    private String sign = null;
    
    /**
     * The evaluators which are assigned to this operator.
     */
    private HashMap<Integer, Evaluator> evaluators = new HashMap();
    
    /**
     * The default evaluator if one is not set for a particular context.
     */
    private Evaluator defaultEvaluator = (Evaluator) (Arithmetic left, Arithmetic right) -> {
        String l = left.getClass().getSimpleName();
        String r = right.getClass().getSimpleName();
        throw new ArithmeticException("unsupported operation for ("+l+" "+sign+" "+r+").");
    };
    
    /***** EXPRESSION_CONSTANTS *****/
    
    /**
     * A vector - vector expression.
     */
    public final static int EXPRESSION_VECTOR = 0;
    
    /**
     * A vector - scalar expression.
     */
    public final static int EXPRESSION_VECTOR_SCALAR = 1;
    
    /**
     * A matrix - matrix expression.
     */
    public final static int EXPRESSION_MATRIX = 2;
    
    /**
     * A matrix - vector expression.
     */
    public final static int EXPRESSION_MATRIX_VECTOR = 3;
    
    /**
     * A matrix - scalar expression.
     */
    public final static int EXPRESSION_MATRIX_SCALAR = 4;
    
    /**
     * A scalar - scalar expression.
     */
    public final static int EXPRESSION_SCALAR = 5; 
    
    /**
     * A vector - matrix expression.
     */
    public final static int EXPRESSION_VECTOR_MATRIX = 6;
    
    /**
     * Matches all viable expressions. <br/><br/>i.e:
     * <br/>
     * {@link Operator#EXPRESSION_VECTOR_MATRIX} <br/>
     * {@link Operator#EXPRESSION_MATRIX_VECTOR} <br/>
     * {@link Operator#EXPRESSION_VECTOR} <br/>
     * {@link Operator#EXPRESSION_MATRIX} <br/>
     * {@link Operator#EXPRESSION_SCALAR} <br/>
     * {@link Operator#EXPRESSION_VECTOR_SCALAR} <br/>
     * {@link Operator#EXPRESSION_MATRIX_SCALAR} <br/>
     */
    public final static int EXPRESSION_ALL = 10;
    
    /**
     * Matches all expressions where a matrix is to the left of the expression. <br/><br/>i.e:
     * <br/>
     * {@link Operator#EXPRESSION_MATRIX_VECTOR} <br/>
     * {@link Operator#EXPRESSION_MATRIX} <br/>
     * {@link Operator#EXPRESSION_MATRIX_SCALAR} <br/>
     */
    public final static int EXPRESSION_MATRICES = 7;
    
    /**
     * Matches all expressions where a vector is to the left of the expression. <br/><br/>i.e:
     * <br/>
     * {@link Operator#EXPRESSION_VECTOR_MATRIX} <br/>
     * {@link Operator#EXPRESSION_VECTOR} <br/>
     * {@link Operator#EXPRESSION_VECTOR_SCALAR} <br/>
     */
    public final static int EXPRESSION_VECTORS = 8;
    
    /**
     * Matches all expressions where the left and right are the same type. <br/><br/>i.e:
     * <br/>
     * {@link Operator#EXPRESSION_VECTOR} <br/>
     * {@link Operator#EXPRESSION_MATRIX} <br/>
     * {@link Operator#EXPRESSION_SCALAR} <br/>
     */
    public final static int EXPRESSION_SYMMETRIC = 9;
    
    /**
     * An array of all the viable expressions available.
     */
    private final int[] ALL = new int[] { 0, 1, 2, 3, 4, 5, 6 };
    
    /**
     * An array of all of the expressions where a matrix is to the left of the expression.
     */
    private final int[] MATRICES = new int[] { 2, 3, 4 };
    
    /**
     * An array of all of the expressions where a vector is to the left of the expression.
     */
    private final int[] VECTORS = new int[] { 0, 1, 6 };
    
    /**
     * An array of all of the expressions where the left and right are the same type.
     */
    private final int[] SYMMETRIC = new int[] { 0, 2, 5 };
    
    /**
     * Initializes a new Operator using the default evaluator for all expressions. 
     * @param sign the sign to match in the grammar.
     */
    public Operator(String sign) {
        this.sign = sign;
    }
    
    /**
     * Initializes a new Operator with a list of evaluators to use.
     * @param sign the sign to match in the grammar.
     * @param evaluators the evaluators to use.
     */
    public Operator(String sign, HashMap<Integer, Evaluator> evaluators) {
        this(sign);
        this.evaluators = evaluators;
    }
    
    /**
     * Initializes a new Operator with a list of evaluators to use
     * and a custom default evaluator.
     * @param sign the sign to match in the grammar.
     * @param evaluators the evaluators to use.
     * @param defaultEvaluator the default evaluator to use.
     */
    public Operator(String sign, HashMap<Integer, Evaluator> evaluators, 
            Evaluator defaultEvaluator) {
        this(sign, evaluators);
        this.defaultEvaluator = defaultEvaluator;
    }
    
    /**
     * Adds a new evaluator for this operation.
     * @param expression the type of expression this evaluator is for.
     * @param e the evaluator.
     * @return an instance of itself for method chaining.
     */
    public Operator addEvaluator(int expression, Evaluator e) {
        switch(expression) {
            case EXPRESSION_MATRICES:
            case EXPRESSION_VECTORS:
            case EXPRESSION_ALL:
            case EXPRESSION_SYMMETRIC:
                int[] v = (expression == EXPRESSION_ALL)
                        ? ALL
                        : ((expression == EXPRESSION_MATRICES)
                          ? MATRICES
                          : ((expression == EXPRESSION_VECTORS)
                            ? VECTORS
                            : SYMMETRIC
                          )
                        );
                for(int i = 0; i < v.length; i++) {
                    this.evaluators.put(v[i], e);
                }
                break;
            default:
                this.evaluators.put(expression, e);
                break;
        }
        this.evaluators.put(expression, e);
        return this;
    }
    
    /**
     * Adds a new evaluator for this operation.
     * @param expressions an array of expression types this evaluator is for.
     * @param e the evaluator.
     * @return an instance of itself for method chaining.
     */
    public Operator addEvaluator(int[] expressions, Evaluator e) {
        for(int i = 0; i < expressions.length; i++) {
            this.addEvaluator(expressions[i], e);
        }
        return this;
    }
    
    /**
     * Sets the default evaluator for this instance.
     * @param e the evaluator
     * @return an instance of itself for method chaining.
     */
    public Operator setDefaultEvaluator(Evaluator e) {
        if(e != null) {
            this.defaultEvaluator = e;
        }
        return this;
    }
    
    /**
     * gets the symbol which this operator matches in the grammar.
     * @return the symbol for this operation.
     */
    public final String getOper() {
        return this.sign;
    }
    
    /**
     * retrieves an evaluator for a particular expression type.
     * @param expression the expression type
     * @return the evaluator for the expression type or null if one is not set or found.
     */
    public Evaluator getEvaluator(int expression) {
        if(!this.evaluators.containsKey(expression)) {
            return null;
        }
        return this.evaluators.get(expression);
    }
    
    /**
     * Determines the current context of the expression and attempts to evaluate using
     * the attached Evaluator
     * @param left the left context.
     * @param right the right context
     * @return the computed context for this expression.
     */
    protected final Context evaluate(Context left, Context right) {
        
        Type v = null;
        
        //check the dimensions of the arrays and determineif they agree.
        if((left.isArray() && right.isArray()) || (left.isMatrix() && right.isMatrix())) {
            Arithmetic l = (Arithmetic) left.getValue(); Arithmetic r = (Arithmetic) right.getValue();
            if(!l.sizeOf(r)) {
                throw new ArithmeticException("dimensions do not agree");
            }
        }
        
        //if we have two vectors.
        if(left.isArray() && right.isArray()) {
            if(this.evaluators.containsKey(EXPRESSION_VECTOR)) {
                Evaluator e = this.evaluators.get(EXPRESSION_VECTOR);
                v = e.eval((Arithmetic)left.getValue(), (Arithmetic)right.getValue());
            }
        }
        
        //if we have two matrices.
        if(left.isMatrix() && right.isMatrix()) {
            if(this.evaluators.containsKey(EXPRESSION_MATRIX)) {
                Evaluator e = this.evaluators.get(EXPRESSION_MATRIX);
                v = e.eval((Arithmetic)left.getValue(), (Arithmetic)right.getValue());
            }
        }
        
        //if we have two scalar values.
        if(left.isScalar() && right.isScalar()) {
            if(this.evaluators.containsKey(EXPRESSION_SCALAR)) {
                Evaluator e = this.evaluators.get(EXPRESSION_SCALAR);
                v = e.eval((Arithmetic)left.getValue(), (Arithmetic)right.getValue());
            }
        }
        
        //if the left is a matrix and the right is a vector.
        if(left.isMatrix() && right.isArray()) {
            if(this.evaluators.containsKey(EXPRESSION_MATRIX_VECTOR)) {
                Evaluator e = this.evaluators.get(EXPRESSION_MATRIX_VECTOR);
                v = e.eval((Arithmetic)left.getValue(), (Arithmetic)right.getValue());
            }
        }
        
        //if the left is a vector and the right is a matrix.
        if(right.isMatrix() && left.isArray()) {
            if(this.evaluators.containsKey(EXPRESSION_VECTOR_MATRIX)) {
                Evaluator e = this.evaluators.get(EXPRESSION_VECTOR_MATRIX);
                v = e.eval((Arithmetic)left.getValue(), (Arithmetic)right.getValue());
            }
        }
        
        //if the left or right is a vector and the opposite is an scalar.
        if((left.isArray() && right.isScalar()) || (right.isArray() && left.isScalar())) {
            Arithmetic n = (left.isArray()) ? (Arithmetic) right.getValue() : (Arithmetic) left.getValue();
            Arithmetic ve = (left.isArray()) ? (Arithmetic) left.getValue() : (Arithmetic) right.getValue();
            if(this.evaluators.containsKey(EXPRESSION_VECTOR_SCALAR)) {
                Evaluator e = this.evaluators.get(EXPRESSION_VECTOR_SCALAR);
                v = e.eval(ve, n);
            }
        }
        
        //if the left or right is a matrix and the opposite is an scalar.
        if((left.isMatrix() && right.isScalar()) || (right.isMatrix() && left.isScalar())) {
            Arithmetic n = (left.isMatrix()) ? (Arithmetic) right.getValue() : (Arithmetic) left.getValue();
            Arithmetic ve = (left.isMatrix()) ? (Arithmetic) left.getValue() : (Arithmetic) right.getValue();
            if(this.evaluators.containsKey(EXPRESSION_MATRIX_SCALAR)) {
                Evaluator e = this.evaluators.get(EXPRESSION_MATRIX_SCALAR);
                v = e.eval(ve, n);
            }
        }
        
        //if we could not define the context, call the default evaluator.
        if(v == null) {
           v = this.defaultEvaluator.eval((Arithmetic)left.getValue(), (Arithmetic) right.getValue());
        }
        
        return new Context(v);
    }
    
}
