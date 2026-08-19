import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }
        int answer = (n - map.size()) * 2;
        for (Set<Integer> reserved : map.values()) {

            boolean left = true;
            for (int i = 2; i <= 5; i++) {
                if (reserved.contains(i)) {
                    left = false;
                    break;
                }
            }

            boolean middle = true;
            for (int i = 4; i <= 7; i++) {
                if (reserved.contains(i)) {
                    middle = false;
                    break;
                }
            }

            boolean right = true;
            for (int i = 6; i <= 9; i++) {
                if (reserved.contains(i)) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                answer += 2;
            }
            else if (left || middle || right) {
                answer += 1;
            }
        }

        return answer;
    }
}