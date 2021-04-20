fun main() {
        val lruImplementation = LRUCacheImplementation(2)
        lruImplementation[1] = 10
        lruImplementation[2] = 20
        //The latest will be considered as the recently used one. And the earlier value will be considered as the least use and
        //will be evicted.
        println(lruImplementation[1])
        println(lruImplementation[2])
        lruImplementation[3] = 30
        println(lruImplementation[2])
        println(lruImplementation[1])
}
