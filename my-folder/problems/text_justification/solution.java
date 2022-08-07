// O(N)
// O(1)
// Need to care about at least and extra, and last line. 
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list=new ArrayList<>();
        int i=0;
      

        while(i< words.length) {
            int j = i + 1;
            int wc = words[i].length();// words length counter
            int gapBetweenWords = 0;
            while (j < words.length && (wc + gapBetweenWords + words[j].length() + 1) <= maxWidth) {
               /*
               In While loop, we are doing words[j].length()+1 to consider the space before the current word.
               And we are using gapBetweenWords variable to count the number of such spaces of previous words. 
               */
                wc += words[j].length();
                gapBetweenWords++;
                j++;
            }
            int vacancy = maxWidth - wc;// No. Of vacancy in the current line after taking the words.

            int atleast = gapBetweenWords == 0 ? 0 : vacancy / gapBetweenWords;
            //First We will try to accommodate all the vacancy with equal spaces between the words.
            //"atleast" will be the number of spaces we will add between two words.
            
            
            int extra = gapBetweenWords == 0 ? 0 : vacancy % gapBetweenWords;
            //After distributing the spaces equally if there are any additional vacancy left.
            //We will use mod to get that vacancy left("extra") and distribute one in between two words 

            if (j == words.length) {
                //If we have reached the last word of the string array then we will 
                //assign atleast to 1 which will be the space between two words and extra to 0.
				//Why I did this? Check the last line of question.
                atleast = 1;
                extra = 0;
            }

            StringBuilder sb = new StringBuilder();
            
            for (int k = i; k < j; k++) {//loop for the current line(i to j)
                    sb.append(words[k]);//Append words one by one
                    if (k == j - 1) break;// Last word no need to add spaces after that so break.

                for (int e = 0; e < atleast; e++) {
                    //Add "atleast" spaces between words
                    sb.append(" ");
                }
                if (extra > 0) {
                    //Add extra spaces if available between words
                    sb.append(" ");
                    extra--;
                }
            }
            while(sb.length()<maxWidth){
                //If after adding all words and all spaces , if still the character count 
                //in current line is less than maxWidth then add spaces.
                sb.append(" ");
            }
            list.add(sb.toString());
            i=j;//Moving i to j. So that we can proceed to the next line operation.
        }
        return list;
    }
}