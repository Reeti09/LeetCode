public class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int rotations = check(A[0], A, B);
        if (rotations != -1 || A[0] == B[0]) {
            return rotations;
        } else {
            return check(B[0], A, B);
        }
    }

    private int check(int target, int[] A, int[] B) {
        int rotateA = 0, rotateB = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] != target && B[i] != target) {
                return -1;  // Not possible to make all values equal to target
            } else if (A[i] != target) {
                rotateA++;
            } else if (B[i] != target) {
                rotateB++;
            }
        }

        return Math.min(rotateA, rotateB);
    }
}
