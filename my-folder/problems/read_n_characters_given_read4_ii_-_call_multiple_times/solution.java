/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
	 // we will store characters from read4 in this array
    private char[] temp = new char[4];
    
    // pointer in temporary array
    private int tempIndex = 0;
    
    // characters read
    private int charsToRead = 0;
    

    public int read(char[] buf, int n) {
        // total characters push so far in buf array
        int total = 0;
        while(total < n){
           // read characters and store in temp along with count in charsToRead
            if(tempIndex == charsToRead){
                // reset if we have read 4 characters already
                tempIndex = 0;
                
                // get count
                charsToRead = read4(temp);
                
                if(charsToRead == 0){
                    break;
                } 
            }
            
            buf[total++] = temp[tempIndex++];
        }
        
        return total;
    }

}