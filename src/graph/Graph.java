package graph;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class Graph {
    private int V;   // No. of vertices

    private LinkedList<Integer>[] adj; //Adjacency Lists

    // Constructor
    Graph(int v) {
        this.V = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
    public void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the de-queued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> iterator = adj[s].listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    // A function used by DFS
    private void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    public void DFS(int v) {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    public void iterativeDFS(int v){
        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (! stack.isEmpty()){
            int value = stack.pop();
            // Stack may contain same vertex twice. So
            // we need to print the popped item only
            // if it is not visited.
            if(visited[value] == false) {
                System.out.print(value + " ");
                visited[value] = true;
            }
            Iterator<Integer> iterator = adj[value].iterator();
            while(iterator.hasNext()){
                int adj = iterator.next();
                if(visited[adj] == false) {
                    stack.push(adj);
                }
            }
        }
    }


    public int findMotherVertice() {

        boolean[] visited = new boolean[V];

        int v = -1;

        //last visit start vertex
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                DFSUtil(i, visited);
                v = i;
                System.out.println();
            }
        }

        System.out.println("Last visit started index, " + v);

        //reset boolean array
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        //start dfc traversal from v
        DFSUtil(v, visited);

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                return -1;
            }
        }

        return v;
    }


    // The function to find transitive
    // closure. It uses
    // recursive DFSUtil()
    public void transitiveClosure() {

        // To store transitive closure
        int[][] tc = new int[V][V];

        // Call the recursive helper
        // function to print DFS
        // traversal starting from all
        // vertices one by one
        for (int i = 0; i < V; i++) {
            dfsUtilForTransitiveCloser(i, i, tc);
        }

        for (int i = 0; i < V; i++) {
            System.out.println(Arrays.toString(tc[i]));
        }
    }

    private void dfsUtilForTransitiveCloser(int s, int v, int[][] tc) {
        tc[s][v] = 1;
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (tc[s][n] == 0) {
                dfsUtilForTransitiveCloser(s, n, tc);
            }
        }

    }



    // A recursive function to print DFS starting from v.
    // It returns true if degree of v after processing is less
    // than k else false
    // It also updates degree of adjacent if degree of v
    // is less than k. And if degree of a processed adjacent
    // becomes less than k, then it reduces of degree of v also,
    boolean DFSUtil(int v, boolean[] visited, int[] vDegree, int k)
    {

        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        for (int i : adj[v])
        {

            // degree of v is less than k, then degree of adjacent
            // must be reduced
            if (vDegree[v] < k)
                vDegree[i]--;

            // If adjacent is not processed, process it
            if (!visited[i])
            {

                // If degree of adjacent after processing becomes
                // less than k, then reduce degree of v also.
                if (DFSUtil(i, visited, vDegree, k))
                    vDegree[v]--;
            }
        }

        // Return true if degree of v is less than k
        return (vDegree[v] < k);
    }

    // Prints k cores of an undirected graph
    void printKCores(int k)
    {

        // INITIALIZATION
        // Mark all the vertices as not visited and not
        // processed.
        boolean[] visited = new boolean[V];
        boolean[] processed = new boolean[V];
        Arrays.fill(visited, false);
        Arrays.fill(processed, false);

        int mindeg = Integer.MAX_VALUE;
        int startvertex = 0;

        // Store degrees of all vertices
        int[] vDegree = new int[V];
        for (int i = 0; i < V; i++)
        {
            vDegree[i] = adj[i].size();

            if (vDegree[i] < mindeg)
            {
                mindeg = vDegree[i];
                startvertex = i;
            }
        }
        DFSUtil(startvertex, visited, vDegree, k);

        // DFS traversal to update degrees of all
        // vertices.
        for (int i = 0; i < V; i++)
            if (!visited[i])
                DFSUtil(i, visited, vDegree, k);

        // PRINTING K CORES
        System.out.println("K-Cores : ");
        for (int v = 0; v < V; v++)
        {

            // Only considering those vertices which have degree
            // >= K after BFS
            if (vDegree[v] >= k)
            {
                System.out.printf("\n[%d]", v);

                // Traverse adjacency list of v and print only
                // those adjacent which have vDegree >= k after
                // BFS.
                for (int i : adj[v])
                    if (vDegree[i] >= k)
                        System.out.printf(" -> %d", i);
            }
        }
    }



    // A recursive method to count
    // all paths from 'u' to 'd'.
    int countPathsUtil(int u, int d, int pathCount) {

        // If current vertex is same as
        // destination, then increment count
        if (u == d) {
            pathCount++;
        } else {
            // Recur for all the vertices
            // adjacent to this vertex
            Iterator<Integer> i = adj[u].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                pathCount = countPathsUtil(n, d, pathCount);
            }
        }
        return pathCount;
    }

    // Returns count of
    // paths from 's' to 'd'
    public int countPaths(int s, int d) {

        // Call the recursive method
        // to count all paths
        int pathCount = 0;
        pathCount = countPathsUtil(s, d, pathCount);
        return pathCount;
    }







}

