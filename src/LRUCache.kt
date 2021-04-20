fun main() {
        val lruImplementation = LRUCacheImplementation(2)
        lruImplementation[1] = 10
        lruImplementation[2] = 20
        println(lruImplementation[1])
        println(lruImplementation[2])
        lruImplementation[3] = 30
        println(lruImplementation[3])
        println(lruImplementation[1])
    }
