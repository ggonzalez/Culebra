main()
{
	var la = 5;

	for (; la > 0; la = la - 1) {
		println("remaining loops " + la);
	}

	for (la = 0; la < 5; la = la + 1) {
		println("performed loops " + (la + 1));
	}
}