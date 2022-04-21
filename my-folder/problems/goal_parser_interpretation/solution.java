class Solution {
    public String interpret(String command) {
        StringBuilder out = new StringBuilder() ;
        
        for(int i = 0 ; i < command.length() ; i++){
            
            if(command.charAt(i) == '(' && command.charAt(i + 1) ==')'){
                out.append("o");
                i++;
            } 
            
             else if(command.charAt(i) == '(') continue ;
            
             else if(command.charAt(i) == ')') continue ;
            else out.append(command.charAt(i));
        }
        
        return out.toString() ;
    }
}