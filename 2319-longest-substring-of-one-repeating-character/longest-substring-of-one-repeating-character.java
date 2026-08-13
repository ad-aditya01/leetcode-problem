// class Solution {
//     public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
//         char[] arr=s.toCharArray();
//         int n=queryIndices.length;
//         int[] ans=new int[n];

//         for(int q=0;q<n;q++){
//             int idx=queryIndices[q];
//             char ch=queryCharacters.charAt(q);

//             arr[idx]=ch;
            
//             int maxLen=1;
//             int currLen=1;
//             for(int i=1;i<arr.length;i++){
//                 if(arr[i]==arr[i-1]){
//                     currLen++;
//                 }else{
//                     currLen=1;
//                 }
//                 maxLen=Math.max(maxLen,currLen);
//             }
//             ans[q]=maxLen;
//         }
//         return ans;
        
//     }
// }  


class Solution {

    class Node {
        int len;
        int prefix;
        int suffix;
        int max;
        char leftChar;
        char rightChar;

        Node(int len, int prefix, int suffix, int max,
             char leftChar, char rightChar) {

            this.len = len;
            this.prefix = prefix;
            this.suffix = suffix;
            this.max = max;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s,
                                  String queryCharacters,
                                  int[] queryIndices) {

        int n = s.length();

        arr = s.toCharArray();
        tree = new Node[4 * n];

        // Build segment tree
        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int q = 0; q < queryIndices.length; q++) {

            int index = queryIndices[q];
            char ch = queryCharacters.charAt(q);

            // Update the string
            arr[index] = ch;

            // Update segment tree
            update(1, 0, n - 1, index, ch);

            // Root contains answer for whole string
            ans[q] = tree[1].max;
        }

        return ans;
    }

    // Build tree
    void build(int node, int left, int right) {

        if (left == right) {

            char ch = arr[left];

            tree[node] = new Node(
                1,      // len
                1,      // prefix
                1,      // suffix
                1,      // max
                ch,     // left character
                ch      // right character
            );

            return;
        }

        int mid = (left + right) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2],
                            tree[node * 2 + 1]);
    }

    // Update one index
    void update(int node, int left, int right,
                int index, char ch) {

        if (left == right) {

            tree[node] = new Node(
                1,
                1,
                1,
                1,
                ch,
                ch
            );

            return;
        }

        int mid = (left + right) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, right, index, ch);
        }

        tree[node] = merge(tree[node * 2],
                            tree[node * 2 + 1]);
    }

    // Merge two nodes
    Node merge(Node a, Node b) {

        int len = a.len + b.len;

        int prefix = a.prefix;
        int suffix = b.suffix;

        int max = Math.max(a.max, b.max);

        // Can combine suffix of left
        // with prefix of right
        if (a.rightChar == b.leftChar) {

            int combined = a.suffix + b.prefix;

            max = Math.max(max, combined);

            // Entire left segment has same character
            if (a.prefix == a.len) {
                prefix = a.len + b.prefix;
            }

            // Entire right segment has same character
            if (b.suffix == b.len) {
                suffix = b.len + a.suffix;
            }
        }

        return new Node(
            len,
            prefix,
            suffix,
            max,
            a.leftChar,
            b.rightChar
        );
    }
}