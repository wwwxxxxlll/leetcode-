class Solution {
    class Union {
        int[] parent;
        int[] size;

        public int findroot(int x) {
            return x == parent[x] ? x : findroot(parent[x]);
        }
        // 路径压缩
        // public int findroot(int x){
        // if(parent[x] != x){
        // parent[x] = findroot(parent[x]);
        // }
        // return parent[x];
        // }

        public void connect(int x, int y) {
            int rx = findroot(x);
            int ry = findroot(y);
            if (rx == ry) {
                return;
            } else {
                if (size[rx] >= size[ry]) {
                    parent[ry] = rx;
                    size[rx] += size[ry];
                } else {
                    parent[rx] = ry;
                    size[ry] += size[rx];
                }
            }
        }

        public Union(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        Union u = new Union(n + 1);
        List<Boolean> ans = new ArrayList<>();
        for (int i = threshold + 1; i <= n; ++i) {
            for (int j = i; j <= n; j += i) {
                u.connect(i, j);
            }
        }
        for (int[] query : queries) {
            if (u.findroot(query[0]) == u.findroot(query[1]))
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}