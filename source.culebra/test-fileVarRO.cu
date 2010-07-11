var file {
	field1,
	field2
} File(file="C:\\test.txt")

main()
{
	file@ {
		println("TEST:" + file.field1 + " " + file.field2);
	}
}