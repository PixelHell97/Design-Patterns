package design_patterns

interface Shape {
    fun draw()
}


class Triangle : Shape {
    override fun draw() {
        println("Drawing Triangle")
    }
}

class Square : Shape {
    override fun draw() {
        println("Drawing Square")
    }
}

class Pentagon : Shape {
    override fun draw() {
        println("Drawing Pentagon")
    }
}

//  Factory class
object ShapeFactory {
    fun getShape(numberOfRips: Int): Shape? {
        return when (numberOfRips) {
            3 -> Triangle()
            4 -> Square()
            5 -> Pentagon()
            else -> null
        }
    }
}

fun main() {
    val circle: Shape? = ShapeFactory.getShape(3)
    circle?.draw()

    val rectangle: Shape? = ShapeFactory.getShape(4)
    rectangle?.draw()

    val square: Shape? = ShapeFactory.getShape(5)
    square?.draw()
}