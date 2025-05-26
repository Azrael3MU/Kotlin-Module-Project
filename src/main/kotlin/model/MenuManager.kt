package manager

import java.util.*

class MenuItem(val title: String, val action: () -> Unit)

class MenuManager(private val title: String, private val items: List<MenuItem>) {

    fun show() {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("\n$title")
            items.forEachIndexed { index, item -> println("$index. ${item.title}") }
            print("Введите номер пункта: ")
            val input = scanner.nextLine()
            val index = input.toIntOrNull()
            if (index == null) {
                println("Ошибка: введите цифру.")
                continue
            }
            if (index !in items.indices) {
                println("Ошибка: такого пункта нет.")
                continue
            }
            items[index].action()
            break
        }
    }
}
