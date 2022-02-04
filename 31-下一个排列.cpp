class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int i = nums.size() - 2;
        while( i>=0 && nums[i+1]<=nums[i])
            i--;
        if(i>=0){
            int j = nums.size() - 1;
            while(j>=0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums[i],nums[j]);
        }
        sort(nums.begin()+i+1,nums.end());
    }
};
// 对错误答案的修正：
// class Solution {
// public:
//     void nextPermutation(vector<int>& nums) {
//         int n = nums.size() - 1;
//         int i = 0, j = 1;
//         if(n <= 0)
//             return;
//         while(n-1>=0){
//             if(nums[n-1]<nums[n]){
//                 j = n;
//                 break;
//             }
//             n--;
//         }
//         i = n - 1;
//         int l;
//         if(i>=0){
//             for( l = nums.size() - 1; l>=j; l--){
//                 if(nums[i]<nums[l]){
//                     int temp = nums[i];
//                     nums[i] = nums[l];
//                     nums[l] = temp;
//                     break;
//                 }
//             } 
//         }
//         sort(nums.begin()+i+1,nums.end());
//     }
// };
// 错误解答：
// 问题在于不能处理完全降序序列，
// class Solution {
// public:
//     void nextPermutation(vector<int>& nums) {
//         int n = nums.size() - 1;
//         int i = 0, j = 1;
//         if(n <= 0)
//             return;
//         while(n-1){
//             if(nums[n-1]<nums[n]){
//                 i = n - 1;
//                 j = n;
//                 break;
//             }
//             n--;
//         }
//         int l;
//         if(i>=0){
//             for( l = nums.size() - 1; l>=j; l--){
//                 if(nums[i]<nums[l]){
//                     int temp = nums[i];
//                     nums[i] = nums[l];
//                     nums[l] = temp;
//                     break;
//                 }
//             } 
//             sort(nums.begin()+j,nums.end());
//         }
//     }
// };