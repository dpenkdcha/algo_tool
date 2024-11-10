package moduel2.week1;

import java.util.*;
import java.io.*;

public class tree_height {
  class FastScanner {
    StringTokenizer tok = new StringTokenizer("");
    BufferedReader in;

    FastScanner() {
      in = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
      while (!tok.hasMoreElements())
        tok = new StringTokenizer(in.readLine());
      return tok.nextToken();
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }
  }

  public class TreeHeight {
    int n;
    int parent[];

    void read() throws IOException {
      FastScanner in = new FastScanner();
      n = in.nextInt();
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = in.nextInt();
      }
    }
  }

  static int computeHeight(int root, List<List<Integer>> adj) {
    Map<Integer, Boolean> visited = new HashMap<>();
    Queue<int[]> q = new LinkedList<>();
    int maxHeight = 0;

    // Start BFS from the root node
    q.add(new int[] { root, 1 });

    while (!q.isEmpty()) {
      int node = q.peek()[0];
      int level = q.peek()[1];
      q.poll();

      visited.put(node, true);
      maxHeight = Math.max(maxHeight, level);

      System.out.println("node " + node + " level " + level + " adj " + adj.get(node));

      // Traverse all children of the
      // current node
      for (int child : adj.get(node)) {
        if (!visited.getOrDefault(child, false)) {
          q.add(new int[] { child, level + 1 });
        }
      }
    }
    return maxHeight;
  }

  static int buildTree(int[] parent, int n,
      List<List<Integer>> adj) {
    int root = -1;

    // Iterate through all nodes to establish
    // connections
    for (int i = 0; i < n; i++) {
      if (parent[i] == -1)
        root = i;
      else {
        adj.get(i).add(parent[i]);
        adj.get(parent[i]).add(i);
      }

      for (int x = 0; x < n; x++) {
        System.out.println(adj.get(x));
      }
    }
    return root;
  }

  static public void main(String[] args) throws IOException {
    new Thread(null, new Runnable() {
      public void run() {
        try {
          new tree_height().run();
        } catch (IOException e) {
        }
      }
    }, "1", 1 << 26).start();
  }

  public void run() throws IOException {
    TreeHeight tree = new TreeHeight();
    tree.read();

    int n = tree.parent.length;
    List<List<Integer>> adj = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    int root = buildTree(tree.parent, n, adj);

    System.out.println(computeHeight(root, adj));
  }
}
