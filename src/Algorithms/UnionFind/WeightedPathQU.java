package Algorithms.UnionFind;

import java.io.*;

public class WeightedPathQU {
    private int[] id;
    private int[] size;

    public WeightedPathQU(int N) {
        id  = new int[N];
        for(int i = 0; i<N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int p) {
        int r = p;
        while(r!=id[r]) r = id[r];
        while(p!= id[p]){
            int tmp = id[p];
            id[p] = r;
            p = tmp;
        }
        return r;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int pr = root(p);
        int qr = root(q);
        if (pr == qr) return;
        if (size[pr]<size[qr]) {
            id[pr] = qr;
            size[qr] += size[pr];
        }
        else {
            id[qr] = pr;
            size[pr] += size[qr];
        }
    }

    public void toPrint(){
        for(int i = 0; i < id.length; i++) System.out.println(i + ":" + id[i]);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(br.readLine());
            WeightedPathQU uf = new WeightedPathQU(N);
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
