import "source.culebra/module/test01.cu"

var oxtias {
field1,
field2,
field3
} List();

mainmoduleFunc()
{
	println("Hi from main module");
	println("Gonna print the Behavour Variable oxtias");
	@oxtias() as asdf{
		println("==> " + oxtias);
	}
}

main()
{
	var	test = 333;
	
	oxtias.field1 = "134";
	oxtias.field2 = "134";
	oxtias.field3 = "134";
	oxtias.flush();
	oxtias.field1 = "234";
	oxtias.field2 = "234";
	oxtias.field3 = "234";
	oxtias.flush();
	oxtias.field1 = "334";
	oxtias.field2 = "334";
	oxtias.field3 = "334";
	oxtias.flush();
	mainmoduleFunc();
	println ("Returned " + prueba.pruebaFunc(oxtias));
}