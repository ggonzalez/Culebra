module auth;

authUser()
{
	println("Gimme your password!");
}

isLogged()
: hooks("*.main", "*.is*", -"auth.*")
{
	println("Checking whether the user is still logged in");
	authUser();
}
