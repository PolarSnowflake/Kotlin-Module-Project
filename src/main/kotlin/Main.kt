import java.io.File

fun main() {
    val archivesDirectory = File("archives")
    if (!archivesDirectory.exists()) {
        archivesDirectory.mkdirs()
    }

    println("Добро пожаловать!")

    var exit = false
    while (!exit) {
        printMainMenu()
        val choice = UserChoice(1, 4)

        when (choice) {
            1 -> createArchive()
            2 -> selectArchive()
            3 -> {
                println("До свидания!")
                exit = true
            }
        }
    }
}

fun printMainMenu() {
    println("Главное меню:")
    println("1. Создать архив")
    println("2. Выбрать архив")
    println("3. Выход из приложения")
}