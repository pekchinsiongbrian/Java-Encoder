public class StringDecoder {
    public StringDecoder() {
    }

    /**
     * First character of offset will be taken and matched backwards to obtain the original plaintext.
     *
     * @param encodedText the user's encoded text to be decoded
     * @return  the plaintext after decoding
     */
    public String decode(String encodedText) {
        char offsetChar = encodedText.charAt(0);
        int shiftKey = Utils.DICTIONARY.indexOf(offsetChar);
        String toDecode = encodedText.substring(1);

        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < toDecode.length(); i++) {
            int charPosition = Utils.DICTIONARY.indexOf(toDecode.charAt(i));
            if (charPosition == -1) {
                plainText.append(toDecode.charAt(i)); // there was no encoding done for such a char
                continue;
            }

            int keyVal = (shiftKey + charPosition) % 44;
            char replaceVal = Utils.DICTIONARY.charAt(keyVal);
            plainText.append(replaceVal);
        }
        return plainText.toString();
    }
}
