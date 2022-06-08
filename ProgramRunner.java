public class ProgramRunner {
    public ProgramRunner() {
    }

    public void run() {
        ProgramController pc = new ProgramController();
        String programMode = pc.getProgramMode();

        if (programMode.equalsIgnoreCase("e")) {
            String offsetChar = pc.getOffsetChar();

            StringEncoder encoder = new StringEncoder(offsetChar);

            String plainText = pc.getPlainText();

            String encodedString = encoder.encode(plainText);

            Utils.printMessage(encodedString);
            Utils.printMessage(Utils.CLOSING_MESSAGE);
        } else if (programMode.equalsIgnoreCase("d")) {
            String encodedText = pc.getEncodedText();

            StringDecoder decoder = new StringDecoder();

            String decodedString = decoder.decode(encodedText);

            Utils.printMessage(decodedString);
            Utils.printMessage(Utils.CLOSING_MESSAGE);
        } else {
            Utils.printMessage(Utils.CLOSING_MESSAGE);
        }
    }
}
