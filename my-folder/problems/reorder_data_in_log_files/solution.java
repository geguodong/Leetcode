/*

Time Complexity: \mathcal{O}(M \cdot N \cdot \log N)O(M⋅N⋅logN)

First of all, the time complexity of the Arrays.sort() is \mathcal{O}(N \cdot \log N)O(N⋅logN), as stated in the API specification, which is to say that the compare() function would be invoked \mathcal{O}(N \cdot \log N)O(N⋅logN) times.

For each invocation of the compare() function, it could take up to \mathcal{O}(M)O(M) time, since we compare the contents of the logs.

Therefore, the overall time complexity of the algorithm is \mathcal{O}(M \cdot N \cdot \log N)O(M⋅N⋅logN).

Space Complexity: \mathcal{O}(M \cdot \log N)O(M⋅logN)

For each invocation of the compare() function, we would need up to \mathcal{O}(M)O(M) space to hold the parsed logs.

In addition, since the implementation of Arrays.sort() is based on quicksort algorithm whose space complexity is \mathcal{O}(\log n)O(logn), assuming that the space for each element is \mathcal{O}(1)O(1)). Since each log could be of \mathcal{O}(M)O(M) space, we would need \mathcal{O}(M \cdot \log N)O(M⋅logN) space to hold the intermediate values for sorting.

In total, the overall space complexity of the algorithm is \mathcal{O}(M + M \cdot \log N) = \mathcal{O}(M \cdot \log N)O(M+M⋅logN)=O(M⋅logN).

*/

class Solution {
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // split each log into two parts: <identifier, content>
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // case 1). both logs are letter-logs
                if (!isDigit1 && !isDigit2) {
                    // first compare the content
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0)
                        return cmp;
                    // logs of same content, compare the identifiers
                    return split1[0].compareTo(split2[0]);
                }

                // case 2). one of logs is digit-log
                if (!isDigit1 && isDigit2)
                    // the letter-log comes before digit-logs
                    return -1;
                else if (isDigit1 && !isDigit2)
                    return 1;
                else
                    // case 3). both logs are digit-log
                    return 0;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}