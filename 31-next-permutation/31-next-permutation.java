class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;

        int end = nums.length - 1;

        while (end > 0 && nums[end - 1] >= nums[end]) {
            end--;
        }
        end--;
        if (end >= 0) {
            int start = end + 1;
            while (start < nums.length && nums[start] > nums[end]) {
                start++;
            }
            start--;
            swap(nums, end, start);

        }

        reverse(nums, end + 1);

    }

    private static void reverse(int[] nums, int i) {
        int left = i, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }

    }

    private static void swap(int[] nums, int end, int start) {
        int tmp = nums[end];
        nums[end] = nums[start];
        nums[start] = tmp;
    }
}
