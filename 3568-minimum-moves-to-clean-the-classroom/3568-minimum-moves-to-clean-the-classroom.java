class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] id = new int[m][n];
        for (int[] row : id) {
            java.util.Arrays.fill(row, -1);
        }

        int sr = -1, sc = -1, count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    id[i][j] = count++;
                }
            }
        }

        int fullMask = (1 << count) - 1;

        int[][][] best = new int[m][n][1 << count];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(best[i][j], -1);
            }
        }

        java.util.ArrayDeque<int[]> queue = new java.util.ArrayDeque<>();

        queue.offer(new int[]{sr, sc, 0, energy});
        best[sr][sc][0] = energy;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();

                int r = cur[0];
                int c = cur[1];
                int mask = cur[2];
                int en = cur[3];

                if (mask == fullMask) {
                    return moves;
                }

                if (en == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    int newEnergy = en - 1;
                    int newMask = mask;

                    if (classroom[nr].charAt(nc) == 'L') {
                        newMask |= (1 << id[nr][nc]);
                    }

                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    if (best[nr][nc][newMask] >= newEnergy) {
                        continue;
                    }

                    best[nr][nc][newMask] = newEnergy;
                    queue.offer(new int[]{
                        nr, nc, newMask, newEnergy
                    });
                }
            }

            moves++;
        }

        return -1;
    }
}