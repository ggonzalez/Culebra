var testTCP {
	day,
	month,
	numMonth,
	hour,
	year
} Socket.TCP(host = "192.168.0.77", port = "13")

main()
{
	@testTCP (server){
			@testTCP {
				println (testTCP.day);
			}
	}
}
