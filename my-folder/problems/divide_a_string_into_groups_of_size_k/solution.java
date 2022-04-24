class Solution {
    public String[] divideString(String s, int k, char fill) {
        if(s.length()%k !=0){
           int x=k-(s.length()%k);
            s=s+(Character.toString(fill).repeat(x));
        }
        String []arr=new String[s.length()/k];
        int i=0;
        int j=0;
        int l=k;
        while(i<arr.length){
            arr[i]=s.substring(j,l);
            i++;
            j=j+k;
            l=l+k;
        }
        return arr;
    }
}