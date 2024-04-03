import java.io.File
fun main() {
    val menu = Menu()
    val userInput = UserInput()
    val archive = Archives()


    val archivesDirectory = File("archives")
    if (!archivesDirectory.exists()) {
        archivesDirectory.mkdirs()
    }

    println("Добро пожаловать!")

    var exit = false
    while (!exit) {
        menu.printMenu()
        val choice = userInput.userChoice(1, 4)

        when (choice) {
            1 -> archive.createArchive()
            2 -> archive.selectArchive()
            3 -> {
                println("До свидания!")
                exit = true
            }
        }
    }
}