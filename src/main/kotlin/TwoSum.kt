fun main() {
    println(twoSum(intArrayOf(2, 7, 11, 15), 9))
    println(twoSum(intArrayOf(3, 2, 4), 6))
    println(twoSum(intArrayOf(3, 3), 6))
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        if (map[nums[i]] == null) {
            val m = target - nums[i]
            map[m] = i
        } else {
            return intArrayOf(map[nums[i]]!!, i)
        }
    }

    return intArrayOf()
}