class LRUCacheImplementation(private val limit: Int) {
    private var counter: Int
    private val head: Node = Node(0, 0)
    private val tail: Node = Node(0, 0)
    private val map: HashMap<Int, Node?> = HashMap()


    init {
        //initial values
        head.next = tail
        tail.prev = head
        head.prev = null //pointing at nothing
        tail.next = null //pointing at nothing
        counter = 0
    }

    private fun deleteNode(node: Node?) {
        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev
    }

    private fun addToHead(node: Node?) {
        node?.next = head.next
        node?.next?.prev = node
        node?.prev = head
        head.next = node
    }

    operator fun get(key: Int): Int {
        if (map[key] != null) {
            val node = map[key]
            deleteNode(node)
            addToHead(node)
            assert(node != null)
            return node!!.value
        }
        return -1
    }

    operator fun set(key: Int, value: Int) {
        if (map[key] != null) {
            val node = map[key]
            node!!.value = value
            deleteNode(node)
            addToHead(node)
        } else {
            val node = Node(key, value)
            map[key] = node
            if (counter < limit) {
                counter++
            } else {
                map.remove(tail.prev!!.key)
                deleteNode(tail.prev)
            }
            addToHead(node)
        }
    }

}