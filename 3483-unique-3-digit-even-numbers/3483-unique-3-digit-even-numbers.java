class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];

        for (int digit : digits) {
            count[digit]++;
        }

        int answer = 0;

        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 8; k += 2) {

                    int[] used = new int[10];

                    used[i]++;
                    used[j]++;
                    used[k]++;

                    boolean possible = true;

                    for (int d = 0; d <= 9; d++) {
                        if (used[d] > count[d]) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}