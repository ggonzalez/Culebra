var regex {
	field1 ~ "^:[\w]+ ",
	field2 ~ " [\w\-]+ ",
	field3 ~ " [0-9]+$"
} List();

main()
{
	regex = ":antonia -todos-los-dias 34343";
	regex = ":pepe -todos-los-dias 333";
	regex = ":joakin -todos-los-dias 444444";

	@regex {
		print("REGEX FIELDS: ");
		print(regex.field1 + " ");
		print(regex.field2 + " ");
		println(regex.field3);
	}
}