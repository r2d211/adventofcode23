import adventofcode23.App

fun main() {
    val input: List<String> = object {}.javaClass.getResource("/day2").readText().split("\n")
    val colors = setOf("red", "blue","green")
    input.fold(0) { acc, s ->
        val maxMap = mutableMapOf("red" to 0, "blue" to 0,"green" to 0)
        val games = s.split(":")
        val showOfHands = games[1].split(";")
        for(shown in showOfHands){
            val hands = shown.split(",")
            for (record in hands){
                for(color in colors){
                    if(record.contains(color)){
                        //println(color)
                        maxMap[color] = kotlin.math.max(Integer.parseInt(record.substring(1,3).trim()), maxMap[color]!!)
                    }
                }
            }
        }
        //println(if(broken) 0 else  gameId)
        acc + (maxMap.values.fold(1){a, i -> a * i})
    }.let(::println)


}