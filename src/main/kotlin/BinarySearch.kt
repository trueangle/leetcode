fun main() {
    val nums = intArrayOf(-1, 0, 3, 5, 9, 12)
    println(binarySearch(0, nums.size - 1, nums, 2))
}

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 */
fun binarySearch(l: Int, r: Int, nums: IntArray, target: Int): Int {
    if (l > r) return -1
    val middle = l + ((r - l) / 2)
    if (nums[middle] == target) return middle

    return if (nums[middle] < target) {
        binarySearch(middle + 1, r, nums, target)
    } else {
        binarySearch(l, middle - 1, nums, target)
    }
}

/**
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
val badVersion = 4
fun search(l: Int, r: Int): Int {
    val middle = l + ((r - l) / 2)

    if (l >= r) return l

    return if (isBadVersion(middle)) {
        search(l, middle)
    } else {
        search(middle + 1, r)
    }
}

fun isBadVersion(version: Int): Boolean = version >= badVersion

/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
fun searchInsert(nums: IntArray, target: Int): Int {
    return searchWithIndex(0, nums.size - 1, nums, target)
}

fun searchWithIndex(l: Int, r: Int, nums: IntArray, target: Int): Int {
    if (l > r) return l
    val middle = l + ((r - l) / 2)
    if (nums[middle] == target) return middle

    return if (nums[middle] < target) {
        searchWithIndex(middle + 1, r, nums, target)
    } else {
        searchWithIndex(l, middle - 1, nums, target)
    }
}