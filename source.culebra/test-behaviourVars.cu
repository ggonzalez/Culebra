var testBehaviour {
	param1, param2
	param3
} List();

main()
{
	var	la = 0;
	
	testBehaviour.param1 = 111;
	testBehaviour.param2 = 133333331;
	testBehaviour.param3 = "oxtias";
	
	println("parameter one " + testBehaviour.param1);
	println("parameter one " + testBehaviour.param2);
	println("parameter one " + testBehaviour.param3);
	testBehaviour.flush();
	
	testBehaviour.param1 = 222;
	testBehaviour.param2 = 23424;
	testBehaviour.param3 = "oxtiasputas";
	
	println("parameter one " + testBehaviour.param1);
	println("parameter one " + testBehaviour.param2);
	println("parameter one " + testBehaviour.param3);
	testBehaviour.flush();

	@testBehaviour as testIter {
		println("Iterator round: " + (la++));
		println("PUM " + testIter.param1);
		println("PUM " + testIter.param2);
		println("PUM " + testIter.param3);
	}
	
}