import java.util.*;

class Solution {

    static class Interval {
        int l, r, w, index;

        Interval(int l, int r, int w, int index) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.index = index;
        }
    }

    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Interval[] arr;
    int n;
    State[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();
        arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            int l = intervals.get(i).get(0);
            int r = intervals.get(i).get(1);
            int w = intervals.get(i).get(2);

            arr[i] = new Interval(l, r, w, i);
        }

        // Sort by starting point
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l) {
                return Integer.compare(a.l, b.l);
            }

            return Integer.compare(a.index, b.index);
        });

        dp = new State[n + 1][5];

        State answer = solve(0, 4);

        int[] result = new int[answer.indices.size()];

        for (int i = 0; i < answer.indices.size(); i++) {
            result[i] = answer.indices.get(i);
        }

        return result;
    }

    private State solve(int pos, int remaining) {

        if (pos == n || remaining == 0) {
            return new State(0, new ArrayList<>());
        }

        if (dp[pos][remaining] != null) {
            return dp[pos][remaining];
        }

        // Option 1: Do not select this interval
        State skip = solve(pos + 1, remaining);

        // Option 2: Select this interval
        int next = findNext(pos);

        State nextState = solve(next, remaining - 1);

        List<Integer> selected = new ArrayList<>();

        selected.add(arr[pos].index);
        selected.addAll(nextState.indices);

        Collections.sort(selected);

        State take = new State(
                arr[pos].w + nextState.score,
                selected
        );

        dp[pos][remaining] = better(skip, take);

        return dp[pos][remaining];
    }

    private int findNext(int pos) {

        int target = arr[pos].r;

        int low = pos + 1;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            /*
             * Intervals sharing a boundary overlap.
             *
             * Therefore:
             * next.l > current.r
             */
            if (arr[mid].l > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private State better(State a, State b) {

        // Higher score is better
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        // Same score -> lexicographically smaller indices
        if (isLexicographicallySmaller(a.indices, b.indices)) {
            return a;
        }

        return b;
    }

    private boolean isLexicographicallySmaller(
            List<Integer> a,
            List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}