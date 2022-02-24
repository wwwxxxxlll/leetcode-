class Solution {
    public double getkth(int[] nums1, int[] nums2, int k){
        int i1 = 0, i2 = 0;
        int l1 = nums1.length, l2 = nums2.length;
        int pivot1, pivot2;
        int newindex1, newindex2;
        while(true){
            if(i1 == l1){
                return nums2[i2 + k - 1];
            }
            if(i2 == l2){
                return nums1[i1 + k - 1];
            }
            if(k == 1)
                return Math.min(nums1[i1],nums2[i2]);
            newindex1 = Math.min(l1 - 1, i1 + k/2 - 1);
            newindex2 = Math.min(l2 - 1, i2 + k/2 - 1);
            pivot1 = nums1[newindex1];
            pivot2 = nums2[newindex2];
            if(pivot1 < pivot2){
                k -= newindex1 - i1 + 1;
                i1 = newindex1 + 1;
            }
            else{
                k -= newindex2 - i2 + 1;
                i2 = newindex2 + 1;
            }
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int n = l1+l2;
        if(n%2 == 1){
            return getkth(nums1,nums2,(n+1)/2);
        }
        else{
            return (getkth(nums1,nums2,n/2)+getkth(nums1,nums2,n/2+1))/2.0;
        }
    }
}