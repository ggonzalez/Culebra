var test01 {
	value1, value2
} List();

main()
{
	test01.value1 = "prueba01";
	test01.value2 = "prueba02";
	test01.flush();
	test01.value1 = "prueba11";
	test01.value2 = "prueba12";
	test01.flush();
	test01.value1 = "prueba21";
	test01.value2 = "prueba22"
	
	println("Last value: " + test01.value1 + " " + test01.value2);
	test01.flush();
	
	@test01 as testIter {
		println("Values: " + testIter.value1 + " " + testIter.value2);
	}
	
	println("BYE");
}