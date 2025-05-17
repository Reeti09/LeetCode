import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int steps = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.add(1);
        visited[n - 1][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == n * n) return steps;

                for (int mov = 1; mov <= 6; mov++) {
                    int next = curr + mov;
                    if (next > n * n) break;

                    int[] pos = findCoordinates(next, n);
                    int r = pos[0];
                    int c = pos[1];

                    if (visited[r][c]) continue;
                    visited[r][c] = true;

                    if (board[r][c] == -1) {
                        q.add(next);
                    } else {
                        q.add(board[r][c]);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    public int[] findCoordinates(int curr, int n) {
        int r = n - 1 - (curr - 1) / n;
        int c = (curr - 1) % n;
        if ((n - r) % 2 == 0) {
            c = n - 1 - c;
        }
        return new int[]{r, c};
    }
}
