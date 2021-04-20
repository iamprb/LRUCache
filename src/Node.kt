class Node(var key: Int, var value: Int) {
    @JvmField
    var prev: Node? = null
    @JvmField
    var next: Node? = null
}