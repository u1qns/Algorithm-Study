import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1063 {
    static int[][] map;
    static final int[]
            R = {0, 1}, L = {0, -1}, B = {-1, 0}, T = {1, 0},
            RT = {1, 1}, LT = {1, -1}, RB = {-1, 1}, LB = {-1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[8][8];
        String str1 = st.nextToken();
        int kingC = str1.charAt(0) - 'A';
        int kingR = str1.charAt(1) - '1';
        Position king = new Position(kingR, kingC);
        String str2 = st.nextToken();
        int stoneC = str2.charAt(0) - 'A';
        int stoneR = str2.charAt(1) - '1';
        Position stone = new Position(stoneR, stoneC);

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            int[] delta = null;
            switch (command) {
                case "R":
                    delta = R;
                    break;
                case "L":
                    delta = L;
                    break;
                case "B" :
                    delta = B;
                    break;
                case "T" :
                    delta = T;
                    break;
                case "RT":
                    delta = RT;
                    break;
                case "LT":
                    delta = LT;
                    break;
                case "RB" :
                    delta = RB;
                    break;
                case "LB" :
                    delta = LB;
                    break;
            }
            int nx = king.x + delta[0];
            int ny = king.y + delta[1];
            if (isOutRange(nx, ny)) continue;
            if (nx == stone.x && ny == stone.y) {
                int nx2 = stone.x + delta[0];
                int ny2 = stone.y + delta[1];
                if (isOutRange(nx2, ny2)) continue;
                stone.x = nx2;
                stone.y = ny2;
            }
            king.x = nx;
            king.y = ny;
        }
        System.out.println(king);
        System.out.println(stone);
    }

    private static boolean isOutRange(int x, int y) {
        if(x < 0 || y < 0 || x >= 8 || y >= 8) return true;
        return false;
    }
}

class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        char c = (char) ((this.y) + 'A');
        return String.valueOf(c) + (this.x + 1);
    }
}