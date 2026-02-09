class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        for(int[]row:prerequisites)adj.get(row[1]).add(row[0]);
        List<Integer>topo=new ArrayList<>();
        int[]visited=new int[numCourses];
        int[]pathVisited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(dfs(i,adj,visited,pathVisited,topo)){
                    return new int[0];
                }
            }
        }
        Collections.reverse(topo);
        int[]ans=new int[numCourses];
        for(int i=0;i<numCourses;i++)ans[i]=topo.get(i);
        return ans;
    }
    public boolean dfs(int i,List<List<Integer>>adj,int[]visited,int[]pathVisited,List<Integer>topo){
        visited[i]=1;
        pathVisited[i]=1;
        for(int cur:adj.get(i)){
            if(visited[cur]==0){
                if(dfs(cur,adj,visited,pathVisited,topo))return true;
            }else if(pathVisited[cur]==1)return true;
        }
        pathVisited[i]=0;//make 1->0 while going back for this path//backtracking
        topo.add(i);
        return false;
    }
}