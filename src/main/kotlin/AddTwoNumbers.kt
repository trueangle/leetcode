class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val num1 = ListNode(9).apply {
        next = ListNode(9).apply {
            next = ListNode(9).apply {
                next = ListNode(9)
            }
        }
    }

    val num2 = ListNode(9).apply {
        next = ListNode(9)
    }

    printList(num1)
    println()
    printList(num2)
    println()
    printList(addTwoNumbers(num1, num2))
}

fun recursive(l1: ListNode?, l2: ListNode?, carry: Int): ListNode? {
    if (l1 == null && l2 == null) {
        return if (carry > 0) {
            ListNode(1)
        } else {
            null
        }
    }

    val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry
    val node = ListNode(sum % 10)

    node.next = recursive(l1?.next, l2?.next, sum / 10)

    return node
}

fun iterative(l1: ListNode?, l2: ListNode?): ListNode {
    var remainder = 0
    var nex1: ListNode? = l1
    var next2: ListNode? = l2
    val resultList = ListNode(0)
    var currNode: ListNode? = resultList

    while (nex1 != null || next2 != null || remainder != 0) {

        val value1 = nex1?.`val` ?: 0
        val value2 = next2?.`val` ?: 0

        var sum = value1 + value2 + remainder
        remainder = if (sum > 9) {
            sum %= 10
            1
        } else {
            0
        }

        val next = ListNode(sum)
        currNode?.next = next
        currNode = next

        nex1 = nex1?.next
        next2 = next2?.next
    }

    return resultList.next ?: ListNode(0)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? = recursive(l1, l2, 0)

fun printList(node: ListNode?) {
    print("${node?.`val`} ")
    if (node?.next == null) {
        return
    }
    printList(node?.next)
}

/*
fun sum(next1: ListNode, next2: ListNode, remainder: Int): ListNode {

}

*/
