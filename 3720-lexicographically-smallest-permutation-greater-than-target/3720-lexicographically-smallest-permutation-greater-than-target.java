class Solution {

    private String buildAnswer(String target, int pos, int[] freq, boolean used) {

        for (int i = pos; i >= 0; i--) {

            if (used || i < pos) {
                freq[target.charAt(i) - 'a']++;
            }

            used = true;

            int current = target.charAt(i) - 'a';

            for (int c = current + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    ans.append(target, 0, i);
                    ans.append((char) ('a' + c));

                    freq[c]--;

                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            ans.append((char) ('a' + x));
                            freq[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }

    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = 0; i < n; i++) {

            int idx = target.charAt(i) - 'a';

            if (freq[idx] == 0) {
                return buildAnswer(target, i, freq, false);
            }

            freq[idx]--;
        }

        return buildAnswer(target, n - 1, freq, true);
    }
}