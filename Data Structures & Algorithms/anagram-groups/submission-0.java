class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringSortMap = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedString = String.copyValueOf(chars);
            List<String> stringList = stringSortMap.get(sortedString);
            if (stringList == null) {
                stringList = new ArrayList<>();
            }
            stringList.add(s);
            stringSortMap.put(sortedString, stringList);
        }
        return new ArrayList<>(stringSortMap.values());
    }
}
