class Solution {
    public String toGoatLatin(String sentence) {
        
        String [] strArray = sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        String a="a" , ma = "ma";  int count=0;
        for (String s:strArray){
            char c=s.charAt(0);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u' || c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
                sb.append(s+ma).append(a.repeat(++count )).append(" ");   
            
            else sb.append(s.substring(1)+s.charAt(0)+"ma").append("a".repeat(++count)).append(" ");
          
        }
        
        return sb.toString().trim();
    }
}