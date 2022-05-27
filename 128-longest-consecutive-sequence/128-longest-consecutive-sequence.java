class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
         int max = 1;
        Arrays.sort(nums);

        int now = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i] == nums[i + 1] - 1) {
                now++;
            } else {
                now = 1;
            }

            max = Math.max(max, now);
        }

        return max;
    }
}