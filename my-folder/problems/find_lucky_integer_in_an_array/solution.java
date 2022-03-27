class Solution {
    public int findLucky(int[] arr) {

        // Use a HashMap to count how many times each num
        // appears in arr.
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int largestLuckyNumber = -1;
        // Iterate over the key/ value pairs of the dictionary.
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            // If this is a lucky number
            if (entry.getKey().equals(entry.getValue())) {
                // Keep the largest out of this lucky number and our current largest.
                largestLuckyNumber = Math.max(largestLuckyNumber, entry.getKey());
            }
        }

        return largestLuckyNumber;
    }
}