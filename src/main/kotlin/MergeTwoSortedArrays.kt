fun main() {
    merge(intArrayOf(4, 0, 0, 0, 0, 0), 1, intArrayOf(1, 2, 3, 5, 6), 5).map { println(it) }
}

/**

1 2 3 0 0 0 [2,5,6] i = 2, j = 2
1 2 3 0 0 0 [2,5,6] i = 2, j = 1
1 2 2 0 0 0 [3,5,6] i = 2, j = 0

9,10 0 0 [1, 8] i = 1, j = 1
9, 8, 0 0 [1, 10] i = 0, j = 0
1, 8 0 0 [9, 10]

[4,0,0,0,0,0] [1,2,3,5,6] i = 0, j = 4
[4,0,0,0,0,0] [1,2,3,5,6] i = 0, j = 3
[3,0,0,0,0,0] [1,2,4,5,6] i = 0, j = 2






 */

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {
    var i = m - 1
    var j = n - 1
    var k = m + n - 1

    while (j >= 0) {
        nums1[k--] = if (i < 0 || nums1[i] < nums2[j]) {
            nums2[j--]
        } else {
            nums1[i--]
        }
    }

    return nums1
}

/*
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


 */