class Solution {
    public List generatePossibleNextMoves(String currentState) {

        List<String> res = new ArrayList<String>();

        if(currentState.length() < 2) return res;

        char[] current = currentState.toCharArray();

        for(int i = 0; i < current.length - 1; i++)
        {
            if(current[i] != '-' && current[i+1] != '-')
            {
                StringBuilder str = new StringBuilder("");
                current[i] = '-';
                current[i + 1] = '-';

                res.add(str.append(current).toString());

                current[i] = '+';
                current[i + 1] = '+';
            }
        }
        return res;
    }
}

