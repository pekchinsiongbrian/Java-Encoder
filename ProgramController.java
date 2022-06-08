import java.util.Scanner;

public class ProgramController {
    private String programMode;
    public ProgramController() {
    }

    /**
     * Takes in user's desired action via stdin and returns it as a string.
     *
     * @return  the user's desired action. "e" = to encode, "d" to decode, "q" to quit
     */
    public String getProgramMode() {
        String getProgModeMsg = "Type 'e' to encode a text, 'd' to decode a text, 'q' to quit program";
        Utils.printMessage(getProgModeMsg);

        Scanner sc = new Scanner(System.in);
        String programMode = sc.next();

        while (!programMode.equalsIgnoreCase("e")
                && !programMode.equalsIgnoreCase("d")
                && !programMode.equalsIgnoreCase("q")) {
            Utils.printError(Utils.INVALID_INPUT);
            Utils.printMessage(getProgModeMsg);
            programMode = sc.next().toLowerCase();
        }
        return programMode;
    }

    private void setProgramMode(String programMode) {
        this.programMode = programMode;
    }

    /**
     * When user chooses to encode a text, takes in user's desired offset character via stdin and returns it as a string.
     *
     * @return  the user's desired offset character
     */
    public String getOffsetChar() {
        String getOffsetCharMsg = "Please enter a single offset character";
        Utils.printMessage(getOffsetCharMsg);

        Scanner sc = new Scanner(System.in);
        String offsetChar = sc.next().toUpperCase();

        while (Utils.containsIllegalChars(offsetChar) || offsetChar.length() > 1) {
            Utils.printError(Utils.INVALID_INPUT);
            Utils.printMessage(getOffsetCharMsg);
            offsetChar = sc.next().toUpperCase();
        }
        return offsetChar;
    }

    /**
     * When user chooses to encode a text, takes in user's plaintext via stdin and returns it as a string.
     *
     * @return  the user's plaintext to be encoded
     */
    public String getPlainText() {
        String getPlainTextMsg = "Please enter the plaintext to encode";
        Utils.printMessage(getPlainTextMsg);

        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toUpperCase();
    }

    /**
     * When user chooses to decode a text, takes in user's encoded text via stdin and returns it as a string.
     *
     * @return  the user's encoded text to be decoded
     */
    public String getEncodedText() {
        String getEncodedTextMsg = "Please enter the encoded text to decode";
        Utils.printMessage(getEncodedTextMsg);

        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toUpperCase();
    }

    public void run() {

    }
}
