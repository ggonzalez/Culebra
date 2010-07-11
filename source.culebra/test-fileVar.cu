var file {
	field1,
	field2
} File(file="C:\\test.txt")

var file2 (delim="\t", re_delim="\t+") {
	field1 ~ "cell.1",
	field2 ~ "cell.2"
} File(file="C:\\test2.txt")

main()
{
	file.field1 = "cell66";
	file.field2 = "cell67";
	file.field1 = "cell01";
	file.field2 = "cell02";
	file.flush()
	file.field1 = "cell11";
	file.field2 = "cell12";
	file.flush()
	file.field1 = "cell21";
	file.field2 = "cell22";
	file.flush()

	@file {
		println("TEST file:" + file.field1 + " " + file.field2 + "!");
	}
	
	file2.field1 = "cell66";
	file2.field2 = "cell67";
	file2.field1 = "cell01";
	file2.field2 = "cell02";
	file2.flush()
	file2.field1 = "cell11";
	file2.field2 = "cell12";
	file2.flush()
	file2.field1 = "cell21";
	file2.field2 = "cell22";
	file2.flush()
	file2 = "cell31 cell32"
	
	@file2 {
		println("TEST file2:" + file2.field1 + " " + file2.field2 + "!");
	}
}