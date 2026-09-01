class Solution {
    public boolean validTree(int n, int[][] edges) {
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

        if(hasCycle(graph,vis,0,-1)) {
            return false;
        }

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                return false;
            }
        }
        
        return true;
    }

    private boolean hasCycle(ArrayList<Integer> graph[], boolean[] vis, int curr, int parent) {

        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            int edge = graph[curr].get(i);

            if(vis[edge] && edge != parent) {
                return true;
            }

            if(!vis[edge]) {
                if(hasCycle(graph,vis,edge,curr)) {
                    return true;
                }
            }
        }
        return false;
    }
}
