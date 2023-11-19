import java.lang.Integer.max

fun main() {
    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

    var globalMax = nums[0]
    var localMax = nums[0]
    for (i in 1 until nums.size) {
        localMax = max(localMax + nums[i], nums[i])
        globalMax = max(globalMax, localMax)
    }

    println(globalMax)
    println(maxSubArraySum(0, nums.size - 1, nums))
}

fun maxSubArraySum(l: Int, r: Int, nums: IntArray): Int {
    if (l == r) return nums[l]

    val mid = l + (r - l) / 2
    val leftSum = maxSubArraySum(l, mid, nums)
    val rightSum = maxSubArraySum(mid + 1, r, nums)
    val overallSum = overallSum(l, r, mid, nums)

    return max(max(leftSum, rightSum), overallSum)
}

fun overallSum(l: Int, r: Int, mid: Int, nums: IntArray): Int {

    var sum = 0
    var maxLeftSum = Int.MIN_VALUE
    for (i in l..mid) {
        sum += nums[i]
        if (sum > maxLeftSum) {
            maxLeftSum = sum
        }
    }

    sum = 0
    var maxRightSum = Int.MIN_VALUE
    for (i in mid + 1..r) {
        sum += nums[i]
        if (sum > maxLeftSum) {
            maxRightSum = sum
        }
    }

    return maxLeftSum + maxRightSum
}

