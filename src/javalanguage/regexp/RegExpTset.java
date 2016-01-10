package javalanguage.regexp;

public class RegExpTset {

	//this code copyed from <<Mastering Regular Expressions, 3rd Edition>>
	public static void main(String[] args) {
		
		String myText = "this is my 1st test string";
		String myRegex = "\\d+\\w+"; // This provides for \d+\w+
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(myRegex);
		java.util.regex.Matcher m = p.matcher(myText);

		if (m.find()) {
			String matchedText = m.group();
			int matchedFrom = m.start();
			int matchedTo = m.end();
			System.out.println("matched [" + matchedText + "] " + "from "
					+ matchedFrom + " to " + matchedTo + ".");
		} else {
			System.out.println("didn't match");
		}

	}

}