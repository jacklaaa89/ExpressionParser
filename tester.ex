function zeros() {
	var a = [2,2];
	//var 'a' should be a Vector.
	if(!(a instanceof Vector)) {
		return 0;
	}
	var r = 0;
	if(SIZE(a) > 0) {
		var m = a[0];
		if(SIZE(a) > 1) {
			var n = a[1];
			r = new [m,n];
		} else {
			r = new [m];
		}		
	}
	r; //the last evaluated statement is returned.
}

function helloWorld(a) {
    if(!(a instanceof Scalar)) {
        return [1,2,3];
    }
    [4,5,6]; //the last evaluated statement is returned.
}

var a = helloWorld(1); //prints [4,5,6];
var b = helloWorld([1]); //prints [1,2,3];

print a;
b;