class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String res = "";
        
        int minlen = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {

                String str = s.substring(i, j);

                int count = 0;

                for (int m = 0; m < str.length(); m++) {
                    char ch = str.charAt(m);

                    if (ch == '1') {
                        count++;
                    }
                }

                if (count == k) {
                    int len = str.length();

                    if (len < minlen) {
                        minlen = len;
                        res = str;
                    }
                    else if (len == minlen && str.compareTo(res) < 0) {
                        res = str;
                    }
                }
            }
        }

        return res;
    }
}