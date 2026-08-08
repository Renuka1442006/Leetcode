class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        /*
         * suf[i] = earliest index in word1 from which
         * word2[i ... m-1] can be matched EXACTLY.
         *
         * If it is impossible, suf[i] = n.
         */
        int[] suf = new int[m + 1];

        // n means "impossible"
        for (int i = 0; i <= m; i++) {
            suf[i] = n;
        }

        // Empty suffix can always be matched
        suf[m] = n;

        int p = n - 1;

        for (int i = m - 1; i >= 0; i--) {

            while (p >= 0 && word1.charAt(p) != word2.charAt(i)) {
                p--;
            }

            if (p >= 0) {
                suf[i] = p;
                p--;
            }
        }

        int[] ans = new int[m];

        int pos = 0;
        boolean usedMismatch = false;

        for (int i = 0; i < m; i++) {

            boolean found = false;

            while (pos < n) {

                // Case 1: Characters match
                if (word1.charAt(pos) == word2.charAt(i)) {

                    ans[i] = pos;
                    pos++;
                    found = true;
                    break;
                }

                /*
                 * Case 2: Characters don't match.
                 *
                 * We can use this position as our ONE mismatch,
                 * but only if the remaining word2 can be matched.
                 */
                if (!usedMismatch) {

                    boolean canMatchRemaining;

                    if (i == m - 1) {
                        // Last character -> nothing remains
                        canMatchRemaining = true;
                    } else {
                        /*
                         * suf[i + 1] must exist and must be
                         * after the current position.
                         */
                        canMatchRemaining =
                            suf[i + 1] != n &&
                            suf[i + 1] > pos;
                    }

                    if (canMatchRemaining) {

                        ans[i] = pos;
                        pos++;
                        usedMismatch = true;
                        found = true;
                        break;
                    }
                }

                // Current index cannot be used
                pos++;
            }

            // Couldn't find a valid index
            if (!found) {
                return new int[0];
            }
        }

        return ans;
    }
}