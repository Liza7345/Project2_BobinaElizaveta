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
    println ("ведите количество строк: ")
    val rows = readLine()?.toIntOrNull()?:
    return println ("Error")
    println ("ведите количество столбцов: ")
    val cols = readLine()?.toIntOrNull()?:
    return println("Error")
    val arr = Array (rows){IntArray(cols)}
    println("Введите числа: ")
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            while (true) {
                val v = readLine()
                val num = v?.toIntOrNull()
                if (num != null && num in 100..999) {
                    arr[i][j] = num
                    break
                }
                else {
                    println("Error")
                }
            }
        }
    }
    for (row in arr) {
        for (num in row) {
            print ("$num\t")
        }
        println()
    }
    val a = countdigits (arr)
    println("В массиве используются $a различных символа.")
}