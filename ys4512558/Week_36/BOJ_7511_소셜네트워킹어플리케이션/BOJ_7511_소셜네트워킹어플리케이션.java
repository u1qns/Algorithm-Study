package BOJ7511;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ7511 {

    static int[] parents, rank;
    static BufferedReader br;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append("Scenario ")
              .append(i)
              .append(":\n");
            solution();
            sb.append("\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void solution() throws IOException {
        parents = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            union(u, v);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int p1 = find(u);
            int p2 = find(v);
            if (p1 == p2) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
    }

    private static int find(int v) {
        if(parents[v] == v) return v;
        return parents[v] = find(parents[v]);
    }

    private static boolean union(int v, int u) {
        int p1 = find(v);
        int p2 = find(u);
        if (p1 == p2) {
            return false;
        }

        if (rank[p1] < rank[p2]) {
            parents[p1] = p2;
            return true;
        }
        rank[p1] = rank[p1] == rank[p2] ? rank[p1] + 1 : rank[p1];
        parents[p2] = p1;
        return true;
    }
}
