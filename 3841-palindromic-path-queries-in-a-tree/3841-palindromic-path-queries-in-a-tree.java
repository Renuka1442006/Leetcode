
import java.util.*;

class Solution {
    List<Integer>[] tree;

    int n, timer, LOG;
    int[] tin, tout, depth, parent, iter;
    int[][] up;
    int[] bit;
    char[] chars;

    public List<Boolean> palindromePath(int n, int[][] edges,
                                        String s, String[] queries) {
        this.n = n;
        chars = s.toCharArray();

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        parent = new int[n];
        iter = new int[n];
        up = new int[LOG][n];
        bit = new int[n + 2];

        Arrays.fill(parent, -1);

        // Iterative DFS: avoids stack overflow on a long tree.
        int[] stack = new int[n];
        int top = 0;
        stack[0] = 0;
        parent[0] = 0;
        timer = 0;

        tin[0] = ++timer;
        setAncestors(0, 0);

        while (top >= 0) {
            int u = stack[top];

            if (iter[u] < tree[u].size()) {
                int v = tree[u].get(iter[u]++);

                if (v == parent[u]) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                tin[v] = ++timer;
                setAncestors(v, u);

                stack[++top] = v;
            } else {
                tout[u] = timer;
                top--;
            }
        }

        // Each node's character affects its entire subtree.
        for (int u = 0; u < n; u++) {
            int mask = 1 << (chars[u] - 'a');
            rangeUpdate(tin[u], tout[u], mask);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                int oldMask = 1 << (chars[u] - 'a');
                int newMask = 1 << (c - 'a');

                rangeUpdate(tin[u], tout[u], oldMask ^ newMask);
                chars[u] = c;

            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int lca = getLCA(u, v);

                int maskU = pointQuery(tin[u]);
                int maskV = pointQuery(tin[v]);
                int maskLCA = 1 << (chars[lca] - 'a');

                int pathMask = maskU ^ maskV ^ maskLCA;

                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return ans;
    }

    void setAncestors(int u, int p) {
        up[0][u] = p;

        for (int j = 1; j < LOG; j++) {
            up[j][u] = up[j - 1][up[j - 1][u]];
        }
    }

    // XOR-update an entire Euler Tour interval.
    void rangeUpdate(int l, int r, int mask) {
        addBIT(l, mask);
        addBIT(r + 1, mask);
    }

    void addBIT(int i, int mask) {
        while (i <= n + 1) {
            bit[i] ^= mask;
            i += i & -i;
        }
    }

    // Get the XOR of all updates covering this position.
    int pointQuery(int i) {
        int mask = 0;

        while (i > 0) {
            mask ^= bit[i];
            i -= i & -i;
        }

        return mask;
    }

    int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }
}
