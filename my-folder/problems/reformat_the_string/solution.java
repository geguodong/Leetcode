class Solution {
   public String reformat(String s) {
      if(s==null || s.length()<=1){
          return s;
      }
        List<Integer> l1=new ArrayList<>();
        List<Character> l2=new ArrayList<>();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                l1.add(Character.getNumericValue(ch));
            }else{
                l2.add(ch);
            }
        }
        if(Math.abs(l1.size()-l2.size())>=2)
            return "";
        StringBuilder sb=new StringBuilder();
        boolean flag=l1.size()>=l2.size()?true:false;
        for(int i=0;i<s.length();i++){
            if(flag){
                if(l1.size()>0){
                    sb.append(l1.remove(0));
                }
            }else{
                if(l2.size()>0)
                sb.append(l2.remove(0));
            }
            flag=!flag;
        }
        return sb.toString();
        
    }
}