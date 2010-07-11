main()
{
	var tmp1 = 333333333333333333333333333333333333333333333, tmp2 = 333333333333333333333333333333333333333333333;
	var tmp3 = tmp1 + tmp2;
	var tmp4 = tmp1 * 2;
	var tmp5 = tmp4 / 2;

	if (tmp3 != 666666666666666666666666666666666666666666666)
		println("Wrong operation " + tmp1 + " + " + tmp2 + " != " + tmp3);
	else
		println("Operation Succeded: " + tmp1 + " + " + tmp2 + " == " + tmp3);

	if (tmp4 != 666666666666666666666666666666666666666666666)
		println("Wrong operation " + tmp1 + " * 2 != " + tmp3);
	else
		println("Operation Succeded: " + tmp1 + " * 2 == " + tmp3);
		
	print("tmp4++ " + (tmp4++));
	if (tmp4 == 666666666666666666666666666666666666666666667)
		println(" worked!");
	else
		println(" failed");
	
	print("tmp4-- " + (tmp4--));
	if (tmp4 == 666666666666666666666666666666666666666666666)
		println(" worked!");
	else
		println(" failed");

	if (tmp5 != 333333333333333333333333333333333333333333333)
		println("Wrong operation " + tmp3 + " / 2 != " + tmp5);
	else
		println("Operation Succeded: " + tmp3 + " / 2 == " + tmp5);
		
}