class Solution {
 public  String compare(String s1, String s2){
		String res="";
 		for(char s :s2.toCharArray()) {
 			if(s1.indexOf(s)!=-1) {
 				s1 =s1.substring(0, s1.indexOf(s)) + s1.substring(s1.indexOf(s) + 1); 
 				res =res + s;
 			}
 		}
 		return res;
	}
 public List<String> commonChars(String[] words){
     List<String> al =new ArrayList<>();

    String result =words[0];
    for(int i=0;i<words.length-1;i++) {
         result = compare(result, words[i+1]);
    }

    for(char c :result.toCharArray()) {
        al.add(Character.toString(c));
    }

     return al;
 }

}