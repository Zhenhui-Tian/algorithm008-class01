class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int count = 0;
        if(i < Math.min(s.length,g.length)) {
            while(s[i]>= g[i]) {
            count++;
            i++;
            }
        }

        return count;
    }
}
