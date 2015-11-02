function zeros(a) {
	//var 'a' should be a Vector.
	if(!(a instanceof Vector)) {
		throws exception("args must be a vector!"); //null is returned.
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

var z = zeros(2);

z;