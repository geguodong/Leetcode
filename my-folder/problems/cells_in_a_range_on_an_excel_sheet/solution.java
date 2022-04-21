class Solution {
    public List<String> cellsInRange(String s) {
        List<String> cells = new ArrayList<>();
        char startColumn = s.charAt(0);
        char endColumn = s.charAt(3);
        int startRow = s.charAt(1) - '0';
        int endRow = s.charAt(4) - '0';


        while (startColumn <= endColumn) {
            for (int i = startRow; i <= endRow; i++) {
                cells.add(new StringBuilder().append(startColumn).append(i).toString());
            }
            startColumn += 1;
        }
        return cells;
    }
}