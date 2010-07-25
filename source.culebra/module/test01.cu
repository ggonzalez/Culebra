module prueba;

pruebaFunc(var test)
{
	println("test        " + ( test ))
	
	@test as testIter{
		println("printing inside pruebaFunc " + test);
	}
	test.field1 = "oxtiasputas";
	
	return test;
}