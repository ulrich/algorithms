package net.reservoircode.sort;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 */
public class RemoveDuplicateInSortedArray {

    public int remove(int[] nums) {
        int k = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[nums.length - 1]) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    nums[i + 1] = nums[j];
                    k++;
                    break;
                }
            }
        }
        return k;
    }
}
