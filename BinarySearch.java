/**
 * BinarySearch
 */
public class BinarySearch {

    // Binary Search
    public int bSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // Upper bound & Lower bound Binary search
    public static int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int first = 0, last = 0, flag1 = 0;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target)
                flag1 = 1;
            if (nums[mid] >= target) {
                first = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (flag1 == 0)
            return new int[] { -1, -1 };
        return new int[] { first, last };
    }

    // Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int position = 0;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid]) {
                position = mid + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return position;
    }

    // Search in Rotated Sorted Array
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target)
                return mid;

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // Search In sorted Array 2
    public boolean search2(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target)
                return true;

            if (nums[low] == nums[mid]) {
                low++;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    // 153. Minimum in Rotated Sorted Array.
    // Rotation Count.
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + ((high - low) / 2);

            if (nums[low] < nums[high] || low == high) {
                return nums[low];
            }

            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }

    // 540. Single Element in a Sorted Array
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) / 2);
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
        }
        return nums[left];
    }

    // 162. Find Peak Element
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high = nums.length - 1;

        if (nums[0] > nums[1] || n == 1)
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n;

        while (low < high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // 69. Sqrt(x)
    public int mySqrt(int x) {
        int low = 0, high = x;
        while (low < high) {
            int mid = low + ((high - low) / 2);
            int val = mid * mid;
            if (val <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 6 };
        System.out.println(searchRange(arr, 3));
    }
}