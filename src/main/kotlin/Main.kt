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



    println("Задача 4.")
    println("Введите первый массив чисел через пробел: ")
    // Читаем ввод, разбиваем на части по пробелам, преобразуем каждую часть в число
    val array1 = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    // Просим пользователя ввести второй массив
    println("Введите второй массив чисел через пробел:")
    val array2 = (readLine() ?: "").split(" ").map { it.toInt() }.toIntArray()

    // Создаем список для результата
    val result = mutableListOf<Int>()
    // Создаем копию второго массива для работы
    val tempArray2 = array2.toMutableList()

    // Перебираем элементы первого массива
    for (element in array1) {
        // Если элемент есть во втором массиве
        if (tempArray2.contains(element)) {
            // Добавляем в результат
            result.add(element)
            // Удаляем из временного массива
            tempArray2.remove(element)
        }
    }

    // Сортируем результат
    result.sort()

    // Выводим итог
    println("\nПервый массив: ${array1.joinToString()}")
    println("Второй массив: ${array2.joinToString()}")
    println("Пересечение массивов: ${result.joinToString()}")
}
}