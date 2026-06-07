class Solution {
    private static final String WORD_DELIMITER = "_";
    private static final String CHAR_DELIMITER = "#";

    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            StringBuilder sb = new StringBuilder();
            int[] codePointsArray = str.codePoints().toArray();

            if (codePointsArray == null || codePointsArray.length == 0) {
                stringBuilder.append(CHAR_DELIMITER + WORD_DELIMITER);
                continue;
            }

            for (int codePoint : codePointsArray) {
                sb.append(String.valueOf(codePoint)).append(CHAR_DELIMITER);
            }
            String codePointsString = sb.toString();
            stringBuilder.append(codePointsString).append(WORD_DELIMITER);
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        if (str == null || str.isBlank() || str.isEmpty()) {
            return List.of();
        }
        String[] encodedStrings = str.split(WORD_DELIMITER);
        List<String> decodedStrings = new ArrayList<>();
        for (String encodedString : encodedStrings) {
            String[] codePoints = encodedString.split(CHAR_DELIMITER);
            if (codePoints == null || codePoints.length == 0) {
                decodedStrings.add("");
                continue;
            }
            StringBuilder cpStringBuilder = new StringBuilder();
            for (String codePoint : codePoints) {
                cpStringBuilder.appendCodePoint(Integer.valueOf(codePoint));
            }
            decodedStrings.add(cpStringBuilder.toString());
        }
        return decodedStrings;
    }
}
