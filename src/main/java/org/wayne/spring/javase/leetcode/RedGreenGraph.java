package org.wayne.spring.javase.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RedGreenGraph {
     private static int UNCOLORED = 0;
     private static int RED = 1;
     private static int GREEN = 2;
     private int[] color;


    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n; i++) {
            if (color[i] == UNCOLORED) {
                color[i] = RED;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);

               while (!queue.isEmpty()) {
                   int v = queue.poll();
                   for (int w: graph[v]) {
                       int comp = (color[v] == RED) ? GREEN : RED;

                       if (color[w] == UNCOLORED) {
                           queue.offer(w);
                           color[w] = comp;

                       } else if (color[w] != comp) return false;
                   }
               }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        RedGreenGraph redGreenGraph = new RedGreenGraph();
        boolean result = redGreenGraph.isBipartite(graph);
        System.out.println(result);
    }
}
