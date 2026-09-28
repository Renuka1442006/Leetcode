class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        if (m > n) {
            return ans;
        }
        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a']++;
        }

        // First window of size m
        for (int i = 0; i < m; i++) {
            sFreq[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(pFreq, sFreq)) {
            ans.add(0);
        }

        // Slide the window
        for (int right = m; right < n; right++) {

            // Add new character
            sFreq[s.charAt(right) - 'a']++;

            // Remove old character
            int left = right - m;
            sFreq[s.charAt(left) - 'a']--;

            // Check current window
            if (Arrays.equals(pFreq, sFreq)) {
                ans.add(left + 1);
            }
        }

        return ans;
    }
}