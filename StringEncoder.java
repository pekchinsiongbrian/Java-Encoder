public class StringEncoder {
    private String offsetChar;
    public StringEncoder(String offsetChar) {
        this.offsetChar = offsetChar;
    }

    /**
     * Encodes user's plaintext and returns it. First character of the encoded message is the offset character.
     * Any character not in the reference table will be mapped back to the same character.
     * Entire reference table will be shifted by [index] elements down, where index corresponds to the
     * offset character's index.
     *
     * @param plainText the user's plaintext to be encoded
     * @return  the encoded text
     */
    public String encode(String plainText) {
        int shiftKey = Utils.DICTIONARY.indexOf(offsetChar);

        StringBuilder encodedString = new StringBuilder(offsetChar);
        for (int i = 0; i < plainText.length(); i++) {
            int charPosition = Utils.DICTIONARY.indexOf(plainText.charAt(i));
            if (charPosition == -1) {
                encodedString.append(plainText.charAt(i)); // there was no encoding done for such a char
                continue;
            }

            int keyVal = (charPosition - shiftKey) % 44;
            if (keyVal < 0) {
                keyVal = Utils.DICTIONARY.length() + keyVal;
            }
            char replaceVal = Utils.DICTIONARY.charAt(keyVal);
            encodedString.append(replaceVal);
        }
        return encodedString.toString();
    }
}
