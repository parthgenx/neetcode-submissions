class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int a = Integer.MIN_VALUE,b=Integer.MIN_VALUE,c=Integer.MIN_VALUE;
        
        for(int[] curr : triplets) {
            if(curr[0] > target[0] || curr[1] > target[1] || curr[2] > target[2]) {
                continue;
            }
            a = Math.max(a,curr[0]);
            b = Math.max(b,curr[1]);
            c = Math.max(c,curr[2]);
        }

        return a == target[0] && b == target[1] && c == target[2];
    }
}