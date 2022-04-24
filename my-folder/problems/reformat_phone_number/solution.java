class Solution {
    public String reformatNumber(String number) {
        StringBuffer output = new StringBuffer("");
        number = number.replace("-", "").replace(" ", "");
        int numberLength = number.length();
        int i = 0;
        if(numberLength>3) {
            while(numberLength>0 && numberLength!=2 && numberLength!=4) {
                output.append(number.substring(i, i+3)).append("-");
                numberLength-=3;
                i+=3;
            }
        }
        while(numberLength!=0) {
            output.append(number.substring(i, i+2)).append("-");
            numberLength-=2;
            i+=2;
        }
        return output.toString().substring(0, output.length()-1);
    }
}