package screen

import model.Note

fun showNoteView(note: Note) {
    println("\nПросмотр заметки '${note.name}':")
    println(note.content)
    println("Нажмите Enter для возврата.")
    readln()
}
