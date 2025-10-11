fun countdigits (arr: Array<IntArray>): Int {
    val digitset = mutableSetOf <Char> ()
    for (row in arr) {
        for (num in row) {
            digitset.addAll(num.toString().toCharArray().asList())
        }
    }
    return digitset.size
}
fun main(args: Array<String>) {
    println ("ведите строки: ")
    val rows = readLine()?.toIntOrNull()?:
    return println ("Error")

}