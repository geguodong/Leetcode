/*
Map
Time Complexity: \mathcal{O}(|T| + |S| \cdot \log{|T|})O(∣T∣+∣S∣⋅log∣T∣).

First of all, we build a hashmap out of the target string, which would take \mathcal{O}(|T|)O(∣T∣) time complexity. But if we redesign the API to better fit the scenario of the follow-up question, we should put the construction of the hashmap in the constructor of the class, which should be done only once. The cost of this construction would be amortized by the following calls of string matches.

As the second part of the algorithm, we scan through the source string, and lookup the corresponding indices in the hashmap. The lookup operation in hashmap is constant. However, to find the suitable index would take either \mathcal{O}(|T|)O(∣T∣) with the linear search or \mathcal{O}(\log{|T|})O(log∣T∣) with the binary search. To summarize, this part would be bounded by \mathcal{O}(|S| \cdot \log{|T|})O(∣S∣⋅log∣T∣).

As one can see, the second part heavily depends on the distribution of the characters in the target string. If the characters are distributed evenly, the entries in the hashmap would have a shorter list of indices, which in return would shorten the search time. But in general, one could consider the approach with hashmap should be faster than the two-pointers approach, although their time complexities say otherwise.

Space Complexity: \mathcal{O}(|T|)O(∣T∣)

We built a hashmap that consists of the indices for each character in the target string. Hence, the size of values (indices) in hashmap would be |T|∣T∣. In the worst case, we might have as many keys as the values, i.e. each character corresponds to a unique index. In total, the space complexity of the hashmap would be \mathcal{O}(|T|)O(∣T∣).

*/

// Two pointer
// O(T)
// O(1)
class Solution {

    public boolean isSubsequence(String s, String t) {
        Integer leftBound = s.length(), rightBound = t.length();
        Integer pLeft = 0, pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            // move both pointers or just the right pointer
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft += 1;
            }
            pRight += 1;
        }
        return pLeft == leftBound;
    }
}