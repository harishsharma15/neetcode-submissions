class Solution {
    public int[] productExceptSelf(int[] nums) {
        // calculate prefix products
        int[] prefixProducts = new int[nums.length];
        int currentPrefixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            currentPrefixProduct = currentPrefixProduct * nums[i];
            prefixProducts[i] = currentPrefixProduct;
        }

        // calculate suffix products
        int[] suffixProducts = new int[nums.length];
        int currentSuffixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            currentSuffixProduct = currentSuffixProduct * nums[i];
            suffixProducts[i] = currentSuffixProduct;
        }

        // prepare the output array
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                output[i] = suffixProducts[i + 1];
                continue;
            }
            if (i == nums.length - 1) {
                output[i] = prefixProducts[i - 1];
                continue;
            }
            output[i] = prefixProducts[i - 1] * suffixProducts[i + 1];
        }
        return output;
    }
}  
