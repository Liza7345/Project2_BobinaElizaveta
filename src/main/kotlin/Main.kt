import kotlin.random.Random
import java.util.LinkedHashMap
fun countdigits (arr: Array<IntArray>): Int {
    val digitset = mutableSetOf <Char> ()
    for (row in arr) {
        for (num in row) {
            digitset.addAll(num.toString().toCharArray().asList())
        }
    }
    return digitset.size
}
fun groupWords (Words: List<String>) : List<List<String>> {
    val groups:MutableMap<String, MutableList<String>> = LinkedHashMap()
    for ( word in Words) {
        val key = word.toCharArray().sorted().joinToString("")
        groups.getOrPut(key){mutableListOf()}.add(word)
    }
    return groups.values.map{it.toList()}
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
    val alphabet = listOf(
        'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й',
        'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф',
        'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я'
    )
    val perm = listOf(
        21, 13, 4, 20, 22, 1, 25, 12, 24, 14, 2, 28, 9, 23, 3,
        29, 6, 16, 15, 11, 26, 5, 30, 27, 8, 18, 10, 33, 31, 32, 19, 7, 17
    )
    val charToNum = alphabet.zip(perm).toMap()
    val numToChar = perm.zip(alphabet).toMap()

    print("Выберите режим (1 - шифровать, 2 - дешифровать): ")
    val mode = readln().trim()

    print("Введите текст: ")
    val text = readln().uppercase().replace('Ё', 'Ё')

    print("Введите ключевое слово: ")
    val key = readln().uppercase()

    val result = StringBuilder()
    var keyIndex = 0

    for (ch in text) {
        if (ch !in charToNum.keys) {
            result.append(ch)
            continue
        }

        val chNum = charToNum[ch]!!
        val keyCh = key[keyIndex % key.length]
        val shift = charToNum[keyCh]!!

        val newNum = if (mode == "1") {
            ((chNum + shift - 1) % 33) + 1
        } else {
            ((chNum - shift - 1 + 33 * 10) % 33) + 1
        }

        result.append(numToChar[newNum])
        keyIndex++
    }

    if (mode == "1") println("Зашифрованный текст: $result")
    else println("Дешифрованный текст: $result")




    println("Задача 4.")
    println("Введите первый массив чисел через пробел: ")

    val array1 = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    println("Введите второй массив чисел через пробел:")
    val array2 = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    val result4 = mutableListOf<Int>()
    val tempArray2 = array2.toMutableList()

    for (element in array1) {
        if (tempArray2.contains(element)) {
            result4.add(element)
            tempArray2.remove(element)
        }
    }

    result4.sort()

    println("\nПервый массив: ${array1.joinToString()}")
    println("Второй массив: ${array2.joinToString()}")
    println("Пересечение массивов: ${result4.joinToString()}")

    println("Задача 5.")
    println ("Введите слова через пробел: ")
    val line = readLine ()?.trim().orEmpty()
    if (line.isEmpty()) {
        println ("Ошибка")
        return
    }
    val Words = line.split(" ","\t")
        .map{it.trim()}
        .filter{it.isNotEmpty()}
        .distinct()
    val group = groupWords(Words)
    for (g in group) {
        println (g.joinToString(", "){"\"$it\""})
    }
}