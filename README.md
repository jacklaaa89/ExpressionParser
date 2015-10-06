ExpressionParser
==========

### Introduction

ExpressionParser parses and evaluates mathematical and boolean expressions. It utilizes a lexer and parser generated using the Antlr parser generator.

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

Operations performed on Matrices and Vectors require that the dimensions of the left and right sizes of the operation agree. Also when a Matrix/Vector is operated on with a Scalar value, then the Matrix is always evaluated to the left of the statement (with the Scalar on the right) as the position of the scalar does not matter in the outcome of such an operation. 

i.e  `([1,2,3,4] + 3) == (3 + [1,2,3,4]) = 1`

### Operations

The core operations that are included are as follows: (Also be aware that these are in the order that the operator takes precedence in the operation.)

- Exponents (Powers) '^'
- Division '/'
- Multiplication '*'
- Addition '+'
- Subtration '-'
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