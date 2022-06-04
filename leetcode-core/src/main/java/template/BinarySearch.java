package template;

/**
 * 二分查找
 * <p>
 * 时间复杂度 O(logn)
 * <p>
 * Solution34
 */
public class BinarySearch {
    private int binarySearchLeftBound(boolean[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int binarySearchRightBound(boolean[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ------------------^
            if (checkMid(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(boolean[] nums, int mid) {
        return nums[mid];
    }

    public static void main(String[] args) {
        boolean[] bool1 = {false, false, false, true, true, true};
        // 3
        System.out.println(new BinarySearch().binarySearchLeftBound(bool1));
        // 2
        System.out.println(new BinarySearch().binarySearchRightBound(bool1));


        boolean[] bool2 = {true, true, true, true, true, true};
        // 0
        System.out.println(new BinarySearch().binarySearchLeftBound(bool2));
        // -1（越界）
        System.out.println(new BinarySearch().binarySearchRightBound(bool2));


        boolean[] bool3 = {false, false, false, false, false, false};
        // 6（越界）
        System.out.println(new BinarySearch().binarySearchLeftBound(bool3));
        // 5
        System.out.println(new BinarySearch().binarySearchRightBound(bool3));
    }
}
