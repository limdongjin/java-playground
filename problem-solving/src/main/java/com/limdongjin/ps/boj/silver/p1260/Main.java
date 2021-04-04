package com.limdongjin.ps.boj.silver.p1260;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        var st = new StringTokenizer(br.readLine());
        int vLen = Integer.parseInt(st.nextToken());
        int eLen = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());
        boolean[][]  adj = new boolean[vLen + 1][vLen + 1]; // first -> second
        boolean[] visited = new boolean[vLen+1];
        for (int i = 0; i < eLen; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1][v2] = true;
            adj[v2][v1] = true;
        }
        List<String> dfsPath = new LinkedList<>();
        List<String> bfsPath = new LinkedList<>();
        dfs(adj, startV, dfsPath, visited);
        for (int i = 1; i <= vLen; i++)
            visited[i] = false;
        bfs(adj, startV, bfsPath, visited);
        bw.write(String.join(" ", dfsPath));
        bw.write("\n");
        bw.write(String.join(" ", bfsPath));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(boolean[][] adj, int startV, List<String> bfsPath, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(startV);
        visited[startV] = true;
        while (!q.isEmpty()){
            var x = q.remove();
            bfsPath.add(x+"");
            for (int i = 1; i < adj.length; i++) {
                if(i != x && !visited[i] && adj[i][x]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(boolean[][] adj, int startV, List<String> path, boolean[] visited) {
        visited[startV] = true;
        path.add(startV + "");
        for (int i = 1; i < adj.length; i++) {
            if(i != startV && !visited[i] && adj[startV][i])
                dfs(adj, i, path, visited);
        }

    }
}
