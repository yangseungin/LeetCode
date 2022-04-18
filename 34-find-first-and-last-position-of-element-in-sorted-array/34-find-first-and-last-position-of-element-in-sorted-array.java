class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findLeft(nums, target);
        result[1] = findRight(nums, target);
        return result;
    }

    private  int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1, leftMost = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                leftMost = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return leftMost;
    }

    private  int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1, rightMost = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                rightMost = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return rightMost;
    }
}