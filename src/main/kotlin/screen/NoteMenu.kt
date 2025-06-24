package screen

import manager.MenuItem
import manager.MenuManager
import model.Archive
import model.Note

fun showNoteMenu(archive: Archive) {
    val menuItems = mutableListOf<MenuItem>()
    menuItems.add(MenuItem("Создать заметку") {
        createNote(archive)
        showNoteMenu(archive)
    })
    archive.notes.forEachIndexed { _, note ->
        menuItems.add(MenuItem(note.name) {
            showNoteView(note)
            showNoteMenu(archive)
        })
    }
    menuItems.add(MenuItem("Назад") { })

    MenuManager("Заметки архива '${archive.name}':", menuItems).show()
}

fun createNote(archive: Archive) {
    print("Введите имя заметки: ")
    val name = readln().trim()
    if (name.isEmpty()) {
        println("Имя заметки не может быть пустым.")
        return
    }

    print("Введите текст заметки: ")
    val content = readln().trim()
    if (content.isEmpty()) {
        println("Текст заметки не может быть пустым.")
        return
    }

    archive.notes.add(Note(name, content))
    println("Заметка '$name' создана.")
}
