class Solution {
    public String makeGood(String s) {
      if(s.length()==0 || s.length() == 1){  //edge test condition
          return s;
      }  
      Stack<Character> stack = new Stack<>(); 
      
    for(int i =0 ; i< s.length() ; i++){
        if(!stack.isEmpty() && Math.abs(stack.peek()-s.charAt(i)) == 32){ 
		//Ascii value of character , the difference between capital and small character is 32
                stack.pop();
        }else{
                stack.push(s.charAt(i));
        }                           
    }
      StringBuilder ans = new StringBuilder();
      while(!stack.isEmpty()){
             ans.append(stack.pop());
        }
        return ans.reverse().toString();
		// we return the ans into string using string builder.
    }
}