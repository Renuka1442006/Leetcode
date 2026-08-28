
class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int half = n / 2;

        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        String answer = null;

        for (int pivot = half - 1; pivot >= 0; pivot--) {

            int[] remaining = halfFreq.clone();

            boolean possible = true;

            for (int i = 0; i < pivot; i++) {
                int ch = target.charAt(i) - 'a';

                if (remaining[ch] == 0) {
                    possible = false;
                    break;
                }

                remaining[ch]--;
            }

            if (!possible) {
                continue;
            }

            int targetChar = target.charAt(pivot) - 'a';
            int next = -1;

            for (int c = targetChar + 1; c < 26; c++) {
                if (remaining[c] > 0) {
                    next = c;
                    break;
                }
            }

            if (next == -1) {
                continue;
            }

            StringBuilder left = new StringBuilder();

            for (int i = 0; i < pivot; i++) {
                left.append(target.charAt(i));
            }

            left.append((char) ('a' + next));
            remaining[next]--;

            for (int c = 0; c < 26; c++) {
                while (remaining[c] > 0) {
                    left.append((char) ('a' + c));
                    remaining[c]--;
                }
            }

            String candidate = buildPalindrome(
                left.toString(),
                middle,
                n
            );

            if (candidate.compareTo(target) > 0) {
                if (answer == null || candidate.compareTo(answer) < 0) {
                    answer = candidate;
                }
            }
        }

        int[] remaining = halfFreq.clone();
        boolean possible = true;

        for (int i = 0; i < half; i++) {
            int ch = target.charAt(i) - 'a';

            if (remaining[ch] == 0) {
                possible = false;
                break;
            }

            remaining[ch]--;
        }

        if (possible) {
            StringBuilder left = new StringBuilder();

            for (int i = 0; i < half; i++) {
                left.append(target.charAt(i));
            }

            String candidate = buildPalindrome(
                left.toString(),
                middle,
                n
            );

            if (candidate.compareTo(target) > 0) {
                if (answer == null || candidate.compareTo(answer) < 0) {
                    answer = candidate;
                }
            }
        }

        return answer == null ? "" : answer;
    }

    private String buildPalindrome(String left, char middle, int n) {
        StringBuilder result = new StringBuilder();

        result.append(left);

        if (n % 2 == 1) {
            result.append(middle);
        }

        for (int i = left.length() - 1; i >= 0; i--) {
            result.append(left.charAt(i));
        }

        return result.toString();
    }
}