class Solution {
	public int countElements(int[] nums) {
		int minValue = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			minValue = Math.min(nums[i], minValue);
			maxValue = Math.max(nums[i], maxValue);
		}

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > minValue && nums[i] < maxValue) {
				count++;
			}
		}
		return count;
	}
}