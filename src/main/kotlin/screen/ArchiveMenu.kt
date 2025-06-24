package screen

import manager.ArchiveManager
import manager.MenuItem
import manager.MenuManager
import model.Archive

fun showArchiveMenu() {
    val menuItems = mutableListOf<MenuItem>()
    menuItems.add(MenuItem("Создать архив") {
        createArchive()
        showArchiveMenu()
    })
    ArchiveManager.archives.forEachIndexed { index, archive ->
        menuItems.add(MenuItem(archive.name) {
            showNoteMenu(archive)
            showArchiveMenu()
        })
    }
    menuItems.add(MenuItem("Выход") {
        println("Выход из программы.")
    })

    MenuManager("Список архивов:", menuItems).show()
}

fun createArchive() {
    print("Введите имя архива: ")
    val name = readln().trim()
    if (name.isEmpty()) {
        println("Имя архива не может быть пустым.")
        return
    }
    ArchiveManager.archives.add(Archive(name))
    println("Архив '$name' создан.")
}
