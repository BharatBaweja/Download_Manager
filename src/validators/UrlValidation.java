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
	public static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	public static boolean urlValidator(String url) {
		if (url == null) {
			return false;
		}
		Matcher matcher = URL_PATTERN.matcher(url);
		return matcher.matches();
	}
}
	class DirectoryExists
	 {       
        File dir = new File("C:\\Users\\Dell\\Desktop\\Download_Manager\\src\\validators");
        // Tests whether the directory exists.
        boolean exists = dir.exists();
        System.out.println("Directory " + dir.getPath() + " exists: " + exists);    
    }
    class TestValidator{
	public static void main(String[] args)
	{
		String url = "https://www.github.com/";

		// Validate an url
		if (urlValidator(url)) {
			System.out.print("The URL " + url + " is valid");
		}
		else {
			System.out.print("The URL " + url + " isn't valid");
		}

	}
}