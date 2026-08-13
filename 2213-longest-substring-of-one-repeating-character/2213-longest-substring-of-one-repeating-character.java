class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int leftLen;
        int rightLen;
        int maxLen;
        int len;

        Node() {}

        Node(char ch) {
            leftChar = ch;
            rightChar = ch;
            leftLen = 1;
            rightLen = 1;
            maxLen = 1;
            len = 1;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(
            String str,
            String queryCharacters,
            int[] queryIndices) {

        s = str.toCharArray();

        int n = s.length;
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            s[index] = ch;

            update(1, 0, n - 1, index, ch);

            ans[i] = tree[1].maxLen;
        }

        return ans;
    }

    // Build segment tree
    private void build(int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(s[l]);
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // Update one position
    private void update(int node, int l, int r, int index, char ch) {

        if (l == r) {
            tree[node] = new Node(ch);
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, r, index, ch);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // Merge two segments
    private Node merge(Node left, Node right) {

        Node res = new Node();

        res.len = left.len + right.len;

        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

        // Prefix
        res.leftLen = left.leftLen;

        if (left.leftLen == left.len &&
            left.rightChar == right.leftChar) {

            res.leftLen = left.len + right.leftLen;
        }

        // Suffix
        res.rightLen = right.rightLen;

        if (right.rightLen == right.len &&
            left.rightChar == right.leftChar) {

            res.rightLen = right.len + left.rightLen;
        }

        // Maximum inside either child
        res.maxLen = Math.max(left.maxLen, right.maxLen);

        // Maximum crossing the boundary
        if (left.rightChar == right.leftChar) {
            res.maxLen = Math.max(
                res.maxLen,
                left.rightLen + right.leftLen
            );
        }

        return res;
    }
}