ExpressionParser
==========

### Introduction

ExpressionParser parses and evaluates mathematical and boolean expressions. It utilizes a lexer and parser generated using the Antlr parser generator.

### Syntax

ExpressionParser has support for Scalars, Vectors & Matrices and operations can be changed based on the type of variables that are being operated on. Vector & Matrix values can be defined as Scalar values, variables or expressions which evaluate to a Scalar value.

#### Vectors

Vectors are defined using braces where the values are delimited using a comma.

eg.

````
[1,2,3,4]
```` 

