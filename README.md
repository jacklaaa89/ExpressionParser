ExpressionParser
==========

### Introduction

ExpressionParser parses and evaluates mathematical and boolean expressions. It utilizes a lexer and parser generated using the Antlr parser generator.

##### Simple Usage

In its simplest terms, all you have to do is provide the `Expression` class which an expression to evaluate and then call `eval()` to obtain the result. For example:

````java
Expression e = new Expression("[1,2,3] + [4,5,6];");
Context result = e.eval();

System.out.println(result); //prints [5, 7, 9]
````

### Types

ExpressionParser has support for Scalars, Vectors & Matrices and operations can be changed based on the type of variables that are being operated on. Vector & Matrix values can be defined as Scalar values, variables or expressions which evaluate to a Scalar value.

#### Scalars

Scalar values are any real number or an expression or variable which can be evaluated to a real number.

#### Vectors

Vectors are defined using braces where the values are delimited using a comma. Values can be defined from either expressions, variables, functions and real numbers. ('e' can used for exponential notation i.e 45e2 == 4500)

eg. `[1,2,3,(2 + 2)]` would obviously be evaluated as a Vector with the values 1,2,3,4.

#### Matrices

Matrices share a similar syntax to Vectors which the only difference being a semi colon to distinguish the end of a row.

eg. `[1,2,3; 4,5,6; 7,8,9]` would be evaluated as a 3 x 3 matrix.

#### Matrix & Vector Operations

Operations performed on Matrices and Vectors require that the dimensions of the left and right sizes of the operation agree.

##### Matrix & Vector Array Access
Matrix & Vector values (including any function or variable which evaluates to a Matrix or Vector) can have its values accessed using using array access notation.

So, for example `[1, 2, 3][0]` will return the Scalar value `1.0` (Vector and Matrix indices always start from 0).

When working with a Matrix you can provide two values to access a specific row/column index or a single value to return the row vector at index _n_.

Again, for example `[1, 2, 3; 4, 5, 6][0]` would return the row vector `[1, 2, 3]` and `[1, 2, 3; 4, 5, 6][0,1]` would return the Scalar value `2.0`.

As stated above, accessing values using this notation can also be achieved from function results and evaluated variables, so, for example, `SIZE([1,2,3; 4,5,6])[0,1]`, `SIZE(A)[0,1]` and `A[0]` are all valid. 

### Variables

Variables can be referenced in expressions and then added to the `Expression` class before evaluating the result. Variables can be of any `Type` (i.e a Scalar, Vector or Matrix) and be referenced by number of letters which are not used by any other keyword or function definition.

for example:

````java
Expression e = new Expression();

Vector x = new Vector(new double[]{ 1,2,3 });
Scalar y = new Scalar(10d);

e.addVariable("x", x).addVariable("y", y);

e.setExpression("x * y;");
Context result = e.eval();

System.out.println(result); //prints [10, 20, 30]
````

### Syntax

The syntax conventions copy that of other traditional programming languages so it should be quite familiar to use. An expression script can contain one or more expressions terminated with a ';' (semi-colon).

##### Assigning Variables.

Variables can be assigned during expression evaluation using the 'var' keyword. Variables can be assigned from any valid expression, i.e a function return, evaluated expression or from another variable. For example:

````java
Matrix A = new Matrix(
    new double[][]{
        { 100,  2, 3 },
        {  -2, 34, 2 }
    }
);

Expression e = new Expression("var b = A; SIZE(b)[0] == 2;");
e.addVariable("A", A);

System.out.println(e.eval()); //prints 1.0 (boolean TRUE)
````

##### Result Value

The last evaluated expression in the script will be returned as the result of the evaluation, but all expressions in the script will be evaluated. So for example:

````java
Expression e = new Expression("var a = [1, 2, 3]; 1 + 1; a;");
System.out.println(e.eval()); //prints [1, 2, 3]
````

You can print out results from other expressions using the `print` keyword which prints the result to the output listener.

###### Output Listener

When the `print` keyword is used, the output listeners print method is triggered. By default it just prints the result of the evaluated expression to the console. This functionality can be overrided using the `setOutputListener` method in the `Expression` class. 

For Example:

````java
Expression e = new Expression();

e.setOutputListener(
	new OutputListener() {
		@Override
		public void print(Context context, int lineNo, String expression, int charPositionInLine) {
			System.out.format("%s = %s\n", expression, context);
		}
	}
);

//using print on the final statement also triggers the listener as well as returning this result.
e.setExpression("var x = 1; var y = 2; print x; print y; print x + y;"); 
//prints:
//x = 1.0
//y = 2.0
//x + y = 3.0
````

##### Commenting

Expressions also support commenting in the form of `/* comment */` and `//comment` which are ignored by the parser.

### Operations

The core operations that are included are as follows: (Also be aware that these are in the order that the operator takes precedence in the operation.)

- Exponents (Powers) '^'
- Division '/'
- Multiplication '*'
- Addition '+'
- Subtraction '-'
- Modulo '%'
- Bitwise '>>' & '<<'
- Dot '.'

As stated above, the ExpressionParser also supports logical operators, which are:

- Equals '=='
- Not Equals '!='
- Greater Than '>'
- Less Than '<'
- Greater Than Or Equal '>='
- Less Than Or Equal '<='
- And '&&'
- Or '||'

> The result from using logical operators will either be `1` or `0`, i.e boolean TRUE or FALSE.

#### Adding/Overriding an Operator

In addition to using the core operations, you can also add or override any exisiting operator the ExpressionParser uses.

When implementing an operator, you need to provide it with the symbol which the parser will use to match the operation and also the operation types that will take place, dependant on the left and right types that are provided in the operation.

##### Operation Types

There are different operation types which can occur in each operation. For example, even though `2 + 2` and `[1,2,3,4] + [1,2,3,4]` use the same operator '+', they will be evaluated differently based on the left and right types that are provided.

The operation types that can occur are:

Expression Type | Description
--------------- | -----------
**EXPRESSION_SCALAR** | A Scalar - Scalar operation 
**EXPRESSION_VECTOR** | A Vector - Vector operation
**EXPRESSION_MATRIX** | A Matrix - Matrix operation
**EXPRESSION_SCALAR_VECTOR** | A Scalar - Vector operation
**EXPRESSION_SCALAR_MATRIX** | A Scalar - Matrix operation
**EXPRESSION_VECTOR_SCALAR** | A Vector - Scalar operation
**EXPRESSION_MATRIX_SCALAR** | A Matrix - Scalar operation
**EXPRESSION_MATRIX_VECTOR** | A Matrix - Vector operation
**EXPRESSION_VECTOR_MATRIX** | A Vector - Matrix operation

When creating a new operator you can define 1 or all of the operation types based on what your operator will support. There are also some other expression types defined in the `Operator` class to make your life easier in defining operations. These are:

Expression Type | Description
--------------- | -----------
**EXPRESSION_ALL** | This matches all types of operation stated above.
**EXPRESSION_MATRICES** | This matches all operations where a Matrix is at the left of the expression.
**EXPRESSION_VECTORS** | This matches all operations where a Vector is at the left of the expression.
**EXPRESSION_SYMMETRIC** | This matches operations where the type of the left and right sides are the same.
**EXPRESSION_SCALARS** | This matches operations where a Scalar is at the left of the expression.

##### Implementation

So, for example, to add a new operator which overrides the default implementation of the '+' (plus) operation we can do:

````java
Expression e = new Expression();

e.addOperator(
	new Operator("+")
	.addEvaluator(
		//Can provide an int[] of expression types or EXPRESSION_ALL, MATRICES, VECTORS or SYMMETRIC.
		Operator.EXPRESSION_SCALAR,
		new Evaluator() {
			@Override
			public Type eval(Arithmetic left, Arithmetic right) {
				//only take absolute values (sign is disregarded.)
				//the Arithmetic interface provides access to a lot of pre-defined arithmetic methods.
				return left.absolute().plus(right.absolute());
			}
		}
	)
);

//Our '+' operator now only supports Scalar - Scalar expressions.
e.setExpression("-2 + 2;");
Context result = e.eval();

System.out.println(result); //prints 4
````

### Functions

ExpressionParser also has a collection of functions that are available which can manipulate or generate values. The core functions available are:

###### Functions which accept Scalars, Vectors & Matrices as parameters.

Function Name | Description
------------- | -----------
**LOG(**_expression_**)** | Computes the Natural Logarithm for an evaluated expression.
**LOG10(**_expression_**)** | Computes the Base 10 Logarithm for an evaluated expression.
**RANDOM(**_args?_**)** | Generates a random Scalar, Vector or Matrix value.
**SIN(**_expression_**)** | Calculates the Sine from an evaluated expression.
**COS(**_expression_**)** | Calculates the Cosine from an evaluated expression.
**TAN(**_expression_**)** | Calculates the Tangent from an evaluated expression.
**ASIN(**_expression_**)** | Calculates the inverse Sine from an evaluated expression.
**ACOS(**_expression_**)** | Calculates the inverse Cosine from an evaluated expression.
**ATAN(**_expression_**)** | Calculates the inverse Tangent from an evaluated expression.
**SINH(**_expression_**)** | Calculates the hyperbolic Sine from an evaluated expression.
**COSH(**_expression_**)** | Calculates the hyperbolic Cosine from an evaluated expression.
**TANH(**_expression_**)** | Calculates the hyperbolic Tangent from an evaluated expression.
**RAD(**_expression_**)** | Converts an evaluated value to radians.
**DEG(**_expression_**)** | Converts an evaluated value to degrees.
**ABS(**_expression_**)** | Converts an evaluated value to its absolute value (sign is disregarded).
**ROUND(**_expression_, _precision_**)** | Rounds an evaluated value to the requested precision.
**FLOOR(**_expression_**)** | Rounds an evaluated value towards negative infinity.
**CEILING(**_expression_**)** | Rounds an evaluated value towards positive infinity.

###### Functions which accept Vectors & Matrices as parameters.

Function Name | Description
------------- | -----------
**MAX(**_expression_**)** | Returns the largest value from a struture.
**MIN(**_expression_**)** | Returns the smallest value from a structure.
**SUM(**_expression_**)** | Calculates the sum of all values in a structure.
**COLUMN(**_expression1_, _expression2_, _index?_**)** | Inserts _expression2_ as a new column if _expression1_ is a Matrix or all the values from _expression2_ into _expression1_ if _expression1_ is a Vector at the specified _index_ (or the end if _index_ is omitted).
**SLICE(**_expression_, _start_, _end_**)** | Extracts a slice from _expression_ using the start and end indices (start & end must be Vectors when slicing a Matrix and Scalars when slicing a Vector).
**SIZE(**_expression_**)** | Calculates the dimensions of a Structure.

###### Functions which accept only Matrix values.

Function Name | Description
------------- | -----------
**TRANSPOSE(**_expression_**)** | Generates the `A^T` transpose matrix from matrix A.
**IDENTITY(**_n_**)** | Generates a _n_ by _n_ identity matrix.
**ROW(**_expression1_, _expression2_, _index?_) | Inserts _expression2_ into _expression1_ as a new row at _index_ (or at the end if _index_ is omitted).
**SQUARE(**_expression_**)** | Determines if a Matrix is square. 
**DIAGONALLY_DOMINANT(**_expression_**)** | Determines if a Matrix is diagonally dominant.
**DET(**_expression_**)** | Determines the determinant of the evaluated matrix.
**RANK(**_expression_**)** | Detemines the rank of the evaluated matrix.

###### Functions which accept only Scalar values.

Function Name | Description
------------- | -----------
**SQRT(**_expression_**)** | Calculates the square root of an evaluated expression.

###### Linear equations

ExpressionParser also has the capability to solve systems of linear equations using typical matrix manipulation methods. All of these functions need a coefficient matrix _A_ and a set of right hand side values _b_ in order to solve `Ax = b`. The functions include:

Function Name | Description
------------- | -----------
**GAUSSIAN(**_A_, _b_**)** | solves the system of linear equations using gaussian elimination.
**LU(**_A_, _b_**)** | solves the system of linear equations using LU Factorization.
**QR(**_A_, _b_**)** | solves the system of linear equations using QR Factorization.

For example:

````java
Expression e = new Expression();

//  x + 2y + 3z = 15
//-2x +  y + 2z = 20
// 5x - 2y +  z = 13

Matrix A = new Matrix(
    new double[][]{
        { 1,  2, 3},
        {-2,  1, 2},
        { 5, -2, 1}
    }
);
Vector b = new Vector(
    new double[] {
        15, 20, 13
    }
);

e.addVariable("A", A).addVariable("b", b);
e.setExpression("GAUSSIAN(A,b);");

System.out.println(e.eval()); //prints [-2.769234, -7.846158, 11.15385]
````

> parameters ending in a '?' mean they are optional and can be omitted.

#### Adding/Overriding a Function

You can also add or override any function to the ExpressionParser. When adding a new function, add you need to do is provide the name of the function, the minimum amount of arguments it expects and an implementation of its `eval()` method which is triggered when the method is found in the expression.

##### Implementation.

So, for example, we can add a new function which generates a new Scalar, Vector or Matrix (based on the amount of args) full of zero values called `zeros(args?)`.

````java
Expression e = new Expression();

e.addFunction(new Function("zeros", 0/* minimum args required is none. */){
	@Override
	public Type eval(List<Type> args) {
		//Where a Type object is the generic type for the Scalar, Vector & Matrix objects.
		if(args.isEmpty()) {
			//can be empty, as minimum required args is zero.
			return Scalar.ZERO; //returns a zero Scalar value.
		}
		try {
			Scalar m = (Scalar) args.get(0);
			if(args.size() > 1) {
				//we are generating a zero matrix.
				Scalar n = (Scalar) args.get(1);
				return Matrix.zeroes(m, n); //generates a new Matrix with zero values.
			}
			return Vector.zeroes(m); //generates a new Vector with zero values.
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("invalid parameter types.");
		}
	}
});

System.out.println(e.setExpression("ZEROS()").eval()); //prints 0 
System.out.println(e.setExpression("ZEROS(1)").eval()); //prints [0]
System.out.println(e.setExpression("ZEROS(3,3)").eval()); //prints [0,0,0; 0,0,0; 0,0,0] 
````

### Usage Examples

##### 1: Solving a system of linear equations using LU factorization and confirming that the generated `x` values are correct.

````java

/** 
 * The sum of the first row in 'A' multiplied with the computed values of 'x'
 * (in this case using LU Factorization) should equal the first value in 'b'. 
 **/
String expression = "SUM(A[0] * LU(A,b)) == b[0];"; 

//  x + 2y + 3z = 15
//-2x +  34y + 2z = 20
// 5x - 2y +  8z = 13
Matrix A = new Matrix(
    new double[][]{
        { 100,  2,  3 },
        {-2,  34, 2 },
        { 5, -2,  8 }
    }
);
Vector b = new Vector(
    new double[] {
        15, 20, 13
    }
);
Expression e = new Expression();
e.addVariable("A", A).addVariable("b", b).setExpression(expression);

System.out.println(e.eval()); //prints 1.0 (or equivilent to boolean TRUE)
```` 

##### 2: Vector addition from a source file.

````
/* This source file.ex performs vector addition. */
//File saved at path/to/source/file.ex

var x = [100, 45, 3e2]; //should be [100, 45, 300].
var y = [(12 * 12), 8, MAX(x)]; //should be [144, 8, 300].

//print x & y to standard output.
PRINT(x); PRINT(y);

/* calculate x + y */
x + y;
````

````java
File source = new File("/path/to/source/file.ex");

Expression e = new Expression(source);

System.out.println(e.eval()); //prints [244, 53, 600]
```` 

### TODO

There is some functionality that is in the works of being implemented. These are:

- [x] Update the grammar to allow for array access. i.e `SIZE(A)[0]` where `A` is a 4x4 Matrix would return the Scalar value `4.0`. 
- [ ] Add support for calculating the inverse matrix `A^-1` from matrix `A`.
- [x] Add support for storing variables which can be used on subsequent lines.
- [x] Add support for comments in expressions.
- [x] Expressions can be parsed from files as well as strings.
- [x] Ability to change where the `PRINT(expression)` prints its output.