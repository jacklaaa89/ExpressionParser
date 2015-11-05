function helloWorld(a) -> Vector {
    if(!(a instanceof Scalar)) {
        return [1,2,3];
    }
    var b = new Vector(3);
    b[0] = 4; b[1] = 5; b[2] = 6;
}