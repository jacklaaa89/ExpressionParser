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

Vectors are defined using braces where the values are delimited using a comma.

eg. `[1,2,3,(2 + 2)]` would obviously be evaluated as a Vector with the values 1,2,3,4.

#### Matrices

Matrices share a similar syntax to Vectors which the only difference being a semi colon to distinguish the end of a row.

eg. `[1,2,3; 4,5,6; 7,8,9]` would be evaluated as a 3 x 3 matrix.

#### Matrix & Vector Operations

Operations performed on Matrices and Vectors require that the dimensions of the left and right sizes of the operation agree.

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