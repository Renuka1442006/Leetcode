class Solution {

    String s;
    int index;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        index = 0;

        Set<String> result = parseExpression();

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }

    Set<String> parseExpression() {

        Set<String> result = new HashSet<>();

        while (index < s.length() && s.charAt(index) != '}') {

            Set<String> current = parseTerm();

            result.addAll(current);

            if (index < s.length() && s.charAt(index) == ',') {
                index++;
            }
        }

        if (index < s.length() && s.charAt(index) == '}') {
            index++;
        }

        return result;
    }

    // Handles concatenation: ab, a{b,c}, {a,b}{c,d}
    Set<String> parseTerm() {

        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != ','
                && s.charAt(index) != '}') {

            Set<String> current = parseFactor();

            Set<String> next = new HashSet<>();

            for (String a : result) {
                for (String b : current) {
                    next.add(a + b);
                }
            }

            result = next;
        }

        return result;
    }

    // Handles either a single letter or {expression}
    Set<String> parseFactor() {

        Set<String> result = new HashSet<>();

        if (s.charAt(index) == '{') {

            index++;

            result = parseExpression();

        } else {

            result.add(String.valueOf(s.charAt(index)));

            index++;
        }

        return result;
    }
}