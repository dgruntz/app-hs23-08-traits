package ch.mse.app.traits

object CompoundTypes {
    trait Component
    trait Point

    trait Container { // controls graphical objects (components)
        def add(c: Component, pos: Point) : Unit
    }

    trait TextEditor { // trait for a text editor
        def insert(ch: Char, pos: Int): Unit
        def coordinates(pos: Int) : Point
    }

    def insertComponent(obj: TextEditor & Container, c: Component, pos: Int): Unit = {
        val point = obj.coordinates(pos) // obj <: TextEditor
        obj.add(c, point)                // obj <: Container
    }

}
