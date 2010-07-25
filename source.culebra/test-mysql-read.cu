var testMySQL {
	field1,
	field2,
	field3,
	field4
} DB.MySQL(server = "localhost", user = "culebra", pass = "cul3br4", db = "culebra")

main()
{
	testMySQL.field1 = "34";
	testMySQL.field2 = "34";
	testMySQL.field3 = 3333;
	testMySQL.field4 = 33333343;
	testMySQL.flush()
	
	@testMySQL () as testIter  {
		/*println (testMySQL);*/
		if (testIter.field1 == "hola")
			println ("putaaaa");

	}
	/*
	{ ret = genValues(); } * 3;
	@ret as retIter {
		println(retIter);
	}
	*/
}
