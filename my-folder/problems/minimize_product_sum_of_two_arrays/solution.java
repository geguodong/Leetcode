/*
Time complexity: O(n + k)O(n+k)

We need to traverse both the input arrays once. In each step during the iteration, we increment the count of the current number by 1 in \text{counter1}counter1 or \text{counter2}counter2; which just takes constant time. Thus each of these two traversals takes O(n)O(n) time.
Then, we traverse the two counter arrays \text{counter1}counter1 and \text{counter2}counter2, calculate the cumulative product sum, which takes O(k)O(k) time.
To sum up, the overall time complexity is O(n + k)O(n+k).
Space complexity: O(k)O(k)

Given the range of input values, we used two arrays \text{counter1}counter1, \text{counter2}counter2 of size kk to record the number of occurrences of each number in \text{nums1}nums1 and \text{nums2}nums2, which takes O(k)O(k) space.
In the second iteration, we just need to record the cumulative product sum of the elements.
To sum up, the overall space complexity is O(k)O(k).
*/

class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        // Initialize counter1 and counter2.
        int[] counter1 = new int[101], counter2 = new int[101];

        // Record the number of occurrence of elements in nums1 and nums2.
        for (int num : nums1)
            counter1[num]++;
        for (int num : nums2)
            counter2[num]++;
        
        // Initialize two pointers p1 = 1, p2 = 100.
        // Stands for counter1[1] and counter2[100], respectively.
        int p1 = 0, p2 = 100, ans = 0;
        int occ;
        
        // While the two pointers are in the valid range.
        while (p1 < 101 && p2 > 0) {
            // If counter1[p1] == 0, meaning there is no element equals p1 in counter1,
            // thus we shall increment p1 by 1.
            while (p1 < 101 && counter1[p1] == 0) 
                p1 += 1;

            // If counter2[p2] == 0, meaning there is no element equals p2 in counter2,
            // thus we shall decrement p2 by 1.
            while (p2 > 0 && counter2[p2] == 0)
                p2 -= 1;

            // If any of the pointer goes beyond the border, we have finished the 
            // iteration, break the loop.
            if (p1 == 101 || p2 == 0)
                break;

            // Otherwise, we can make at most min(counter1[p1], counter2[p2]) 
            // pairs {p1, p2} from nums1 and nums2, let's call it occ. 
            // Each pair has product of p1 * p2, thus the cumulative sum is 
            // incresed by occ * p1 * p2. Update counter1[p1] and counter2[p2].
            occ = Math.min(counter1[p1], counter2[p2]);
            ans += occ * p1 * p2;
            counter1[p1] -= occ;
            counter2[p2] -= occ;
        }

        // Once we finish the loop, return ans as the product sum.
        return ans;
    }
}