/**
 * BinarySearch
 */
public class BinarySearch {

    //Binary Search
    public int bSearch(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(high+low)/2;
            if(target==nums[mid]) return mid;
            else if( target>nums[mid]) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }

    //Upper bound & Lower bound Binary search
}