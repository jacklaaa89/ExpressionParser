ExpressionParser
==========

### Introduction

ExpressionParser parses and evaluates mathematical and boolean expressions. It utilizes a lexer and parser generated using the Antlr parser generator.

##### Simple Usage

In its simplest terms, all you have to do is provide the `Expression` class which an expression to evaluate and then call `eval()` to obtain the result. For example:

````java
Expression e = new Expression("[1,2,3] + [4,5,6]");
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

#### Matrix & Vector 

Operations performed on Matrices and Vectors require that the dimensions of the left and right sizes of the operation agree.

### Variables

Variables can be referenced in expressions and then added to the `Expression` class before evaluating the result. Variables can be of any `Type` (i.e a Scalar, Vector or Matrix) and be referenced by number of letters which are not used by any other keyword or function definition.

for example:

````java
Expression e = new Expression();

Vector x = new Vector(new double[]{ 1,2,3 });
Scalar y = new Scalar(10d);

e.addVariable("x", x).addVariable("y", y);

e.setExpression("x * y");
Context result = e.eval();

System.out.println(result); //prints [10, 20, 30]
````

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

#### Adding/Overriding an Operator

In addition to using the core operations, you can also add or override any exisiting operator the ExpressionParser uses.

When implementing an operator, you need to provide it with the symbol which the parser will use to match the operation and also the operation types that will take place, dependant on the left and right types that are provided in the operation.

##### Operation Types

There are different operation types which can occur in each operation. For example, even though `2 + 2` and `[1,2,3,4] + [1,2,3,4]` use the same operator '+', they will be evaluated differently based on the left and right types that are provided.

The operation types that can occur are:

- EXPRESSION_SCALAR - A Scalar - Scalar operation 
- EXPRESSION_VECTOR - A Vector - Vector operation
- EXPRESSION_MATRIX - A Matrix - Matrix operation
- EXPRESSION_SCALAR_VECTOR - A Scalar - Vector operation
- EXPRESSION_SCALAR_MATRIX - A Scalar - Matrix operation
- EXPRESSION_VECTOR_SCALAR - A Vector - Scalar operation
- EXPRESSION_MATRIX_SCALAR - A Matrix - Scalar operation
- EXPRESSION_MATRIX_VECTOR - A Matrix - Vector operation
- EXPRESSION_VECTOR_MATRIX - A Vector - Matrix operation

When creating a new operator you can define 1 or all of the operation types based on what your operator will support. There are also some other expression types defined in the `Operator` class to make your life easier in defining operations. These are:

- EXPRESSION_ALL - This matches all types of operation stated above.
- EXPRESSION_MATRICES - This matches all operations where a Matrix is at the left of the expression.
- EXPRESSION_VECTORS - This matches all operations where a Vector is at the left of the expression.
- EXPRESSION_SYMMETRIC - This matches operations where the type of the left and right sides are the same.
- EXPRESSION_SCALARS - This matches operations where a Scalar is at the left of the expression.

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
e.setExpression("-2 + 2");
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

- TRANSPOSE(expression) - Generates the `A^T` transpose matrix from matrix A.
- IDENTITY(n) - Generates a _n_ by _n_ identity matrix.
- ROW(expression1, expression2, index?) - Inserts _expression_2_ into _expression_1_ as a new row at _index_ (or at the end if _index_ is omitted).
- SQUARE(expression) - Determines if a Matrix is square. 
- DIAGONALLY_DOMINANT(expression) - Determines if a Matrix is diagonally dominant.
- DET(expression) - Determines the determinant of the evaluated matrix.
- RANK(expression) - Detemines the rank of the evaluated matrix.

###### Functions which accept only Scalar values.

- SQRT(expression) - Calculates the square root of an evaluated expression.

###### Linear equations

ExpressionParser also has the capability to solve systems of linear equations using typical matrix manipulation methods. All of these functions need a coefficient matrix _A_ and a set of right hand side values _b_ in order to solve `Ax = b`. The functions include:

- GAUSSIAN(_expression_for_A_, _expression_for_b_) - solves the system of linear equations using gaussian elimination.
- LU(_expression_for_A_, _expression_for_b_) - solves the system of linear equations using LU Factorization.

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
e.setExpression("GAUSSIAN(A,b)");

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

### TODO

There is some functionality that is in the works of being implemented. These are:

- [ ] Update the grammar to allow for array access. i.e `SIZE(A)[0]` where `A` is a 4x4 Matrix would return the Scalar value `4.0`. 