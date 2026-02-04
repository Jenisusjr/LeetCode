class Solution {
    public boolean judgeSquareSum(int c) {
        long ss;
        long l = 0;
        long h = (long) Math.sqrt(c);
        
        while(l <= h) {
            ss = l * l + h * h;
            if(ss == c)
                return true;
            else if(ss > c)
                h--;
            else
                l++;
        }
        return false;
    }
}