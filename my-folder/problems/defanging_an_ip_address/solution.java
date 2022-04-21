class Solution {
    public String defangIPaddr(String address) {
        StringBuilder out = new StringBuilder();
        
        for(int i = 0 ; i < address.length() ; i++){
            if(address.charAt(i) == '.'){
                out.append("[.]") ;
            }
            else out.append(address.charAt(i)) ;
        }
        
        return out.toString() ;
    }
}