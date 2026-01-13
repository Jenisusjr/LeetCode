class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE, high = Double.MIN_VALUE;

        // Find search bounds
        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }

        // Binary search for y
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2.0;
            double area = 0;

            for (int[] s : squares) {
                double y = s[1], side = s[2];
                double top = y + side;

                if (mid <= y) {
                    area += side * side;
                } else if (mid >= top) {
                    area -= side * side;
                } else {
                    area += (top - mid) * side;
                    area -= (mid - y) * side;
                }
            }

            if (area > 0) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
