
var	test {
	value
	} List();

main()
{
	var teta;
	
	test = "hola";
	test = "que";
	test = "tal";
	test = "estas?";
	
	@test as testIter {
		print(test + " ");
	}
	println("");
	
	teta = 23423423423424;
	
	@teta as tetaIter{
		println("----> " + teta);
	}
}