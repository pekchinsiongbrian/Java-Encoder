import java.util.regex.Pattern;

public class Utils {
    public static final String CLOSING_MESSAGE = "Thank you. Exiting program...";
    public static final String INVALID_INPUT = "Invalid input detected.";
    public static final String DICTIONARY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
    private static final Pattern VALID_CHARS_PATTERN = Pattern.compile("^[A-Z\\d()*+,-./\\s]+");

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printError(String message) {
        System.err.println(message);
    }

    /**
     * Only (uppercase) alphanumeric characters and selected symbols are present in the reference table.
     * Takes in a string and checks for characters that are not found in the reference table.
     *
     * @param toExamine the user's string to be examined for illegal characters
     * @return  true if the string contains illegal characters, false if there are no illegal characters
     */
    public static boolean containsIllegalChars(String toExamine) {
        return !VALID_CHARS_PATTERN.matcher(toExamine).matches();
    }
}
