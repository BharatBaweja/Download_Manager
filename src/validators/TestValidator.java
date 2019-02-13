import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;


// Java program to validate an url in Java
class URLValidator
{
	public static final String URL_REGEX =
			"^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
			"(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
			"([).!';/?:,][[:blank:]])?$";
	Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	public boolean urlValidator(String url) {
		if (url == null) {
			return false;
		}
		Matcher matcher = URL_PATTERN.matcher(url);
		return matcher.matches();
	}


}
    class TestValidator{
	public static void main(String args[])
	{
		URLValidator url1 = new URLValidator();
		String url = "https:/www.github.c/";
		boolean urlVal = url1.urlValidator(url);
		// Validate an url
		if (urlVal) {
			System.out.print("The URL " + url + " is valid");
		}
		else {
			System.out.print("The URL " + url + " isn't valid");
		}
		CheckIfDirectoryExists chkDirect = new CheckIfDirectoryExists();
		boolean chk = chkDirect.CheckIfDirectoryExists("sdiuugvig");
		if (chk) {
			System.out.println("The path  is valid");
		}
		else {
			System.out.println("The path  isn't valid");
		}
	}
}