class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> notDis = new HashSet<>();
        for (List<String> path : paths) {
            notDis.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!notDis.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return null;
    }
}