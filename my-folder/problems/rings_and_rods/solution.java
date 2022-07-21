// O(N) O(N)
class Solution {
	public int countPoints(String rings) {
		HashSet<Character>[]rods=new HashSet[10];
		int count=0;
		for(int i=0;i<=9;i++) rods[i]=new HashSet<Character>();
		for(int i=0;i<rings.length();i+=2){
			char c=rings.charAt(i);
			int j=rings.charAt(i+1)-'0';
			rods[j].add(c);
		}
        for(HashSet<Character> rod : rods) {
            if (rod.size() == 3) {
                count++;
            }
        }
		return count;
	}
}