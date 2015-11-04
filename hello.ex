function helloWorld(a) {
    if(!(a instanceof Scalar)) {
        return [1,2,3];
    }
    [4,5,6]; //the last evaluated statement is returned.
}