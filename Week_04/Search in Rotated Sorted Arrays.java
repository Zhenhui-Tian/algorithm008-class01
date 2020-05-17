class Solution {
    public int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        int p = 0;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r =  mid;
            }
        }
        p = r;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r-l) / 2;
            int realmid=(mid+p)%nums.length;
            if(nums[realmid] == target) return realmid;
            if(nums[realmid] < target){
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        return -1;
    }
}
