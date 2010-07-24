var testMySQL {
	field1,
	field2,
	field3,
	field4
} DB.MySQL(server = "localhost", user = "culebra", pass = "cul3br4", db = "culebra")


main()
{
	var ret;
	
	{
	testMySQL.field1 = "00";
	testMySQL.field2 = "0";
	testMySQL.field3 = 0;
	testMySQL.field4 = 0;
	testMySQL.flush()
	} * 10
	
	{ println("HELLO"); } * 3

}
