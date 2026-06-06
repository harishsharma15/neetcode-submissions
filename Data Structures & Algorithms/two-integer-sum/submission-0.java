class Solution {
    public int[] twoSum(int[] nums, int target) {
        int first = 0;
        int second = 0;
        Map<Integer, Integer> compliments = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (compliments.containsKey(nums[i])) {
                first = compliments.get(nums[i]);
                second = i;
            } else {
                compliments.put(target - nums[i], i);
            }
        }
        return new int[]{first, second};   
    }
}
