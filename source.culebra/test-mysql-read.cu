var testMySQL {
	field1,
	field2,
	field3,
	field4
} DB.MySQL(server = "localhost", user = "root", pass = "d.d.334", db = "culebra")

main()
{
	testMySQL.field1 = "hola";
	testMySQL.field2 = "hola";
	testMySQL.field3 = 3333;
	testMySQL.field4 = 34343333343;
	testMySQL.flush()
	
	@testMySQL () {
		/*println (testMySQL);*/
		if (testMySQL.field1 == "hola")
			println ("putaaaa");

	}
	/*
	{ ret = genValues(); } * 3;
	@ret {
		println(ret);
	}
	*/
}
