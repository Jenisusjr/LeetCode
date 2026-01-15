class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = longestConsecutive(hBars);
        int maxV = longestConsecutive(vBars);

        int side = Math.min(maxH + 1, maxV + 1);
        return side * side;
    }

    private int longestConsecutive(int[] bars) {
        Arrays.sort(bars);
        int max = 1, curr = 1;

        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                curr++;
                max = Math.max(max, curr);
            } else {
                curr = 1;
            }
        }
        return max;
    }
}
