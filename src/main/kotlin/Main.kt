import kotlin.random.Random
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
    println()


    println("Задача 2.")
    val size = 5
    val matrix = Array(size) { IntArray(size) }

    for (i in 0 until size) {
        for (j in i until size) {
            val randomValue = Random.nextInt(0, 10)
            matrix[i][j] = randomValue
            matrix[j][i] = randomValue
        }
    }

    println("Сгенерированная симметричная матрица:")
    for (i in 0 until size) {
        for (j in 0 until size) {
            print("${matrix[i][j]} ")
        }
        println()
    }

    println("\nМатрица симметрична относительно главной диагонали")
    println()


    println("Задача 3.")
    val al = listOf("А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И",
        "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т",
        "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ь", "Ы", "Ъ",
        "Э", "Ю", "Я")
    val chisl = listOf(21, 13, 4, 20, 22, 1, 25, 12, 24, 14, 2, 28, 9, 23, 3, 29, 6, 16, 15, 11, 26, 5, 30, 27, 8, 18, 10, 33, 31, 32, 19, 7, 17)
    val Chartonum = al.zip(chisl).toMap()
    val Numtochar= chisl.zip(al).toMap()
    print ("Vvedite 1 dla rashif and 2 dla shifr: ")
    val n = readln().trim()
    print ("Vvedite key: ")
    val key = readln().uppercase()
    print ("Vvedite text: ")
    val text = readln().uppercase()
    val res = StringBuilder()
    var k = 0
    for (i in text) {
        val ch = Chartonum[i]
        val keych = key[k%key.length]
        val s = Chartonum[keych]
        val newNum = if (n=="2"){
            ((ch+s-1)%33+1)
        }
        else {
            ((ch-s-1+33*10)%33+1)
        }
        res.append(Numtochar[newNum])
        k++
    }
    if (n=="1") println("rashif text: $res")
    else println ("zashif text: $res")



    println("Задача 4.")
    println("Введите первый массив чисел через пробел: ")

    val array1 = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    println("Введите второй массив чисел через пробел:")
    val array2 = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    val result = mutableListOf<Int>()
    val tempArray2 = array2.toMutableList()

    for (element in array1) {
        if (tempArray2.contains(element)) {
            result.add(element)
            tempArray2.remove(element)
        }
    }

    result.sort()

    println("\nПервый массив: ${array1.joinToString()}")
    println("Второй массив: ${array2.joinToString()}")
    println("Пересечение массивов: ${result.joinToString()}")
}
