import java.io.File

public fun selectArchive() {  // Выбор архива
    val archivesDirectory = File("archives")
    val archiveFiles = archivesDirectory.listFiles()

    val archiveNames = archiveFiles?.map { it.nameWithoutExtension }?.toTypedArray() ?: arrayOf()
    val menuItems = archiveNames + "Создать архив" + "Назад"
    val choice = selectItemFromList(menuItems)

    when (choice) {
        in 1..archiveNames.size -> selectNoteInArchive(archiveFiles!![choice - 1])
        archiveNames.size + 1 -> createArchive()
        archiveNames.size + 2 -> return // Назад
    }
}

public fun createArchive() { // Создание архива
    println("Введите название архива:")
    var archiveName = readLine()?.trim()

    while (archiveName.isNullOrBlank()) {
        println("Имя архива не может быть пустым ")
        archiveName = readLine()?.trim()
    }

    val archiveDirectory = File("archives", archiveName)
    if (!archiveDirectory.exists()) {
        archiveDirectory.mkdirs()
        println("Архив '$archiveName' успешно создан.")
    } else {
        println("Архив с именем '$archiveName' уже существует.")
    }
}