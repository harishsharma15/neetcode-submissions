class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c: sArr) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        for (char c: tArr) {
            charMap.put(c, charMap.getOrDefault(c, 0) - 1);
        }
        return !charMap.values().stream().anyMatch(it -> it != 0);   
    }
}
