/*
HashMap
Time complexity : \mathcal{O}(N)O(N) where N is a number of characters in the input string. \mathcal{O}(N)O(N) time is needed to compute hashmap count "letter -> its frequency in the input string". Then we deal with a data structure out which contains 10 elements only and all operations are done in a constant time.

Space complexity : \mathcal{O}(1)O(1). count contains constant number of elements since input string contains only lowercase English letters, and out contains not more than 10 elements.

*/

class Solution {
  public String originalDigits(String s) {
    // building hashmap letter -> its frequency
    char[] count = new char[26 + (int)'a'];
    for(char letter: s.toCharArray()) {
      count[letter]++;
    }

    // building hashmap digit -> its frequency
    int[] out = new int[10];
    // letter "z" is present only in "zero"
    out[0] = count['z'];
    // letter "w" is present only in "two"
    out[2] = count['w'];
    // letter "u" is present only in "four"
    out[4] = count['u'];
    // letter "x" is present only in "six"
    out[6] = count['x'];
    // letter "g" is present only in "eight"
    out[8] = count['g'];
    // letter "h" is present only in "three" and "eight"
    out[3] = count['h'] - out[8];
    // letter "f" is present only in "five" and "four"
    out[5] = count['f'] - out[4];
    // letter "s" is present only in "seven" and "six"
    out[7] = count['s'] - out[6];
    // letter "i" is present in "nine", "five", "six", and "eight"
    out[9] = count['i'] - out[5] - out[6] - out[8];
    // letter "n" is present in "one", "nine", and "seven"
    out[1] = count['n'] - out[7] - 2 * out[9];

    // building output string
    StringBuilder output = new StringBuilder();
    for(int i = 0; i < 10; i++)
      for (int j = 0; j < out[i]; j++)
        output.append(i);
    return output.toString();
  }
}