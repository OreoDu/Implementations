package Algorithms.UnionFind;

import java.io.*;

public class QuickFind {

    private int[] id;

    public QuickFind(int N) {
        id  = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    //change all entries whose id equals id[p] to id[q].
    public void union(int p,int q) {
        int pid = id[p];
        int qid = id[q];
        if (pid == qid) return;
        for (int i = 0; i<id.length; i++)
            if (id[i] == pid) id[i] = qid;
    }

    public void toPrint(){
        for(int i = 0; i < id.length; i++) System.out.println(i + ":" + id[i]);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(br.readLine());
            QuickFind uf = new QuickFind(N);
            String line = null;
            while (!((line = br.readLine()).isEmpty())) {
                int p = Integer.parseInt(line);
                int q = Integer.parseInt(br.readLine());
                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                    System.out.println(p + " " + q);
                }
            }
            uf.toPrint();
        }catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}