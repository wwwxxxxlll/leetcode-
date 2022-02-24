class Solution {//看到logn首先考虑二分，由于连续的长度应当为常数，因此只需向两侧扩展
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        vector<int> res;
        if(!n){
            res.push_back(-1);
            res.push_back(-1);
            return res;
        }
        if(n == 1 && target == nums[0]){
            res.push_back(0);
            res.push_back(0);
            return res;
        }
        else{
            if(n != 1){
                int l = 0, r = n - 1, mid;
                while(l<=r){
                    mid = (l+r)>>1;
                    if(nums[mid] == target){
                        int l1 = mid - 1,r1 = mid + 1;
                        while(l1 >= l && nums[l1] == nums[mid]){
                            l1--;
                        }
                        while(r1 <= r && nums[r1] == nums[mid]){
                            r1++;
                        }
                        res.push_back(l1+1);
                        res.push_back(r1-1);
                        return res;
                    }else{
                        if(nums[mid]<target){
                            l = mid + 1;
                        }
                        else{
                            r = mid - 1;
                        }
                    }
                }
            }
                
        }   
        res.push_back(-1);
        res.push_back(-1);
        return res;

    }
};