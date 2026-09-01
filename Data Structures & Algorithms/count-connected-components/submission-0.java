class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<Integer> graph[] = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                dfs(graph,vis,i);
                count++;
            }
        }
        return count;
    }

    private void dfs(ArrayList<Integer> graph[], boolean[] vis, int curr) {
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            int edge = graph[curr].get(i);
            if(!vis[edge]) {
                dfs(graph,vis,edge);
            }
        }
    }
}
