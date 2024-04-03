
class UserInput {
    fun userChoice(min: Int, max: Int): Int {
        var choice: Int? = null
        while (choice == null) {
            val input = readLine()
            if (input != null && input.matches(Regex("\\d+"))) {
                choice = input.toInt()
                if (choice !in min..max) {
                    println("Выберите корректный пункт.")
                    choice = null
                }
            } else {
                println("Введите цифру.")
            }
        }
        return choice
    }

    fun selectItemFromList(items: Array<String>): Int {
        println("Выберите один из пунктов:")
        items.forEachIndexed { index, item ->
            println("${index + 1}. $item")
        }

        var choice: Int? = null
        while (choice == null) {
            val input = readLine()
            if (input != null && input.matches(Regex("\\d+"))) {
                choice = input.toInt()
                if (choice !in 1..items.size) {
                    println("Выберите корректный пункт.")
                    choice = null
                }
            } else {
                println("Введите цифру.")
            }
        }
        return choice
    }
}