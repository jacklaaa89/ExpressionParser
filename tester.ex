/* Attempt LU Factorization to solve for Ax = b */

//define A & b.
var A = [
	100, 2, 3; 
	4, 5, 6; 
	7, 8, 9
];
var b = [12, -10, 6];

/* perform the computation. */
var x = LU(A,b);

//check that the result is valid.
SUM(A[0] * x) == b[0]; //the last expression is returned.
