class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        for (int num : nums) {
            if (num == 0) {
                totalProduct = 0;
                break;
            }
            totalProduct *= num;
        }

        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (totalProduct == 0) {
                if (nums[i] == 0) {
                    int temp = 1;
                    for (int k = 0; k < nums.length; k++) {
                        if (k == i) {
                            continue;
                        }
                        temp = temp * nums[k];
                    }
                    output[i] = temp;
                } else {
                    output[i] = 0;
                }
            } else {
                output[i] = totalProduct / nums[i];
            }
        }
        return output;
    }
}  
