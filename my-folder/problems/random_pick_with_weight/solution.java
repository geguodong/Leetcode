class Solution {
        private Random random = new Random();
        private int[] preSum;
        private int n;
        public Solution(int[] w) {
            this.n = w.length;
            // 前缀数组，下标0就是原数组w[0]
            preSum = new int[n];
            // 下标0就是原数组w[0]
            preSum[0] = w[0];
            for (int i = 1; i < n; i++) {
                preSum[i] = preSum[i-1] + w[i];
            }
        }

        public int pickIndex() {
            // 保证取到[1, preSum[n-1]]的闭区间
            int target = random.nextInt(preSum[n-1]) + 1;
            // right可以从n-1开始，也可以从n开始，对结果的正确性没有影响
            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 如果找到了，直接去当前的下标
                if (preSum[mid] == target) {
                    left =mid;
                    break;
                } else if (preSum[mid] > target) {
                    // 向左找，因为当前mid的值大于target，可能是"第一个大于target"的值，所以不能丢弃mid
                    // 如果mid的值不再需要了(最终不会取到现在的mid)，那么就可以right=mid-1；
                    right = mid;
                } else {
                    // 向右找，因为当前的mid的值比target小，永远不会取到了。所以left=mid+1;
                    left = mid + 1;
                }
            }
            // left代表的含义：
            // 当目标元素 target 不存在数组 nums 中时，搜索左侧边界的二分搜索的返回值可以做以下几种解读：
            // 1、返回的这个值是 nums 中大于等于 target 的最小元素索引。
            // 2、返回的这个值是 target 应该插入在 nums 中的索引位置。
            // 3、返回的这个值是 nums 中小于 target 的元素个数。
            return left;
        }
    }
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */