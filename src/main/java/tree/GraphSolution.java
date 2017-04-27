package tree;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by david on 3/18/17.
 */
public class GraphSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        AdjacencyMatrix am = new AdjacencyMatrix(n);

        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                int edge = in.nextInt();
                if (edge == 1) am.addEdge(i, j);
            }
        }
        // your code goes here
    }

    private static Map<Integer, Integer> trianglesByNodes(AdjacencyMatrix am) {
        return null;
    }


}

class Triangle {
    int va;
    int vb;
    int vc;

    Triangle(int va, int vb, int vc) {
        this.va = va;
        this.vb = vb;
        this .vc = vc;
    }

    Set getVertices() {
        return new TreeSet<Integer>(Arrays.asList(va, vb, vc));
    }
}

class AdjacencyMatrix {
    int n;
    boolean[][] edges;
    AdjacencyMatrix(int n) {
        this.n = n;
        this.edges = new boolean[n][n];
    }

    void addEdge(int i, int j) {
        edges[i][j] = true;
    }
    void removeEdge(int i, int j) {
        edges[i][j] = false;
    }
    boolean hasEdge(int i, int j) {
        return edges[i][j];
    }
}