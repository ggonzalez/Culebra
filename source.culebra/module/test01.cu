module prueba;

pruebaFunc(var test)
{
	println("test        " + ( test ))
	
	@test{
		println("printing inside pruebaFunc " + test);
	}
	test.field1 = "oxtiasputas";
	
	return test;
}