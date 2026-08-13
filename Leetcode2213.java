class Leetcode2213 {
    static class Node {
        char leftChar, rightChar;
        int maxLen, prefLen, suffLen;

        Node(char c) {
            this.leftChar = c;
            this.rightChar = c;
            this.maxLen = 1;
            this.prefLen = 1;
            this.suffLen = 1;
        }

        Node() {}
    }

    private Node[] tree;
    private char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;
        this.chars = s.toCharArray();
        this.tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char c = queryCharacters.charAt(i);
            chars[idx] = c;
            update(1, 0, n - 1, idx, c);
            result[i] = tree[1].maxLen;
        }

        return result;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(chars[start]);
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1], mid - start + 1, end - mid);
    }

    private void update(int node, int start, int end, int idx, char val) {
        if (start == end) {
            tree[node] = new Node(val);
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1], mid - start + 1, end - mid);
    }

    private Node merge(Node left, Node right, int leftLen, int rightLen) {
        Node res = new Node();
        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;
        res.maxLen = Math.max(left.maxLen, right.maxLen);
        res.prefLen = left.prefLen;
        res.suffLen = right.suffLen;

        if (left.rightChar == right.leftChar) {
            res.maxLen = Math.max(res.maxLen, left.suffLen + right.prefLen);

            if (left.prefLen == leftLen) {
                res.prefLen = left.prefLen + right.prefLen;
            }
            if (right.suffLen == rightLen) {
                res.suffLen = right.suffLen + left.suffLen;
            }
        }

        return res;
    }
}