function zeros() {
	var a = 0;
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

var z = zeros();

z;