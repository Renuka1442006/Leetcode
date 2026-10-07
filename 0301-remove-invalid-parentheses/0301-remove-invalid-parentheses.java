
    //check all the options and generate the all possible strings and add them into the set
    //after check the maximum length of the valid string and add only that string into the answer list
    //also apply the logic to check whether the strings are valid or not
    //set used to because we need only the valid unique strings.
 
class Solution {

    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                left++;
            } 
            else if (ch == ')') {

                if (left > 0)
                    left--;
                else
                    right++;
            }
        }
        solve(s, 0, left, right, 0, "");

        return new ArrayList<>(set);
    }

    void solve(String s, int i, int left, int right,int balance, String str) {

        if (balance < 0)
            return;
        if (i == s.length()) {

            if (left == 0 && right == 0 && balance == 0) {
                set.add(str);
            }

            return;
        }

        char ch = s.charAt(i);
        if (ch == '(') {

            if (left > 0) {
                solve(s, i + 1, left - 1, right,
                      balance, str);
            }
            solve(s, i + 1, left, right,
                  balance + 1, str + ch);
        }

        else if (ch == ')') {

            if (right > 0) {
                solve(s, i + 1, left, right - 1,
                      balance, str);
            }

            if (balance > 0) {
                solve(s, i + 1, left, right,balance - 1, str + ch);
            }
        }

        else {
            solve(s, i + 1, left, right, balance, str + ch);
        }
    }
}
 