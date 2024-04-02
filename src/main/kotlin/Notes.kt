import java.io.File

public fun selectNoteInArchive(archive: File) { // Выбор заметок
    var exit = false
    while (!exit) {
        println("Список заметок в архиве '${archive.nameWithoutExtension}':")
        val noteFiles = archive.listFiles()

        val noteNames = noteFiles?.map { it.nameWithoutExtension }?.toTypedArray() ?: arrayOf()
        val menuItems = noteNames + "Создать заметку" + "Назад"
        val choice = selectItemFromList(menuItems)

        when {
            choice in 1..noteNames.size -> showNoteContent(noteFiles!![choice - 1])
            choice == noteNames.size + 1 -> createNoteInArchive(archive)
            choice == noteNames.size + 2 -> exit = true // Назад
        }
    }
    selectArchive()
}

public fun createNoteInArchive(archive: File) {   // Создание заметки в архиве
    println("Введите название новой заметки:")
    var noteName = readLine()?.trim()

    while (noteName.isNullOrBlank()) {
        println("Имя заметки не может быть пустым ")
        noteName = readLine()?.trim()
    }

    println("Введите содержание заметки:")
    var noteContent = readLine()?.trim()

    while (noteContent.isNullOrEmpty()) {
        println("Содержание заметки не может быть пустым ")
        noteContent = readLine()?.trim()
    }

    val newNoteFile = File(archive, "$noteName.txt")
    if (!newNoteFile.exists()) {
        newNoteFile.writeText(noteContent)
        println("Заметка '$noteName' успешно создана в архиве '${archive.nameWithoutExtension}'.")
    } else {
        println("Заметка с именем '$noteName' уже существует в архиве '${archive.nameWithoutExtension}'.")
    }
}

public fun showNoteContent(noteFile: File) {  // Вывод содержимого заметки
    println("Текст заметки '${noteFile.nameWithoutExtension}':")
    println(noteFile.readText())

    println("Нажмите Enter, чтобы вернуться назад.")
    readLine()
}