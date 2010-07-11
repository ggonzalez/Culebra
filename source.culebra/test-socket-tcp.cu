var testTCP {
	day,
	month,
	numMonth,
	hour,
	year
} Socket.TCP(host = "192.168.0.77", port = "13")

main()
{
	@testTCP {
		println("--------------------------");
		println("day: " + testTCP.day);
		println("month: " + testTCP.month);
		println("numMonth: " + testTCP.numMonth);
		println("hour: " + testTCP.hour);
		println("year: " + testTCP.year);
	}
}