package design_patterns



class Pizza private constructor(pizzaBuilder: PizzaBuilder) {
    private val size: String
    private val cheese: Boolean
    private val pepperoni: Boolean
    private val mushrooms: Boolean
    private val sausage: Boolean

    init {
        size = pizzaBuilder.size
        cheese = pizzaBuilder.cheese
        pepperoni = pizzaBuilder.pepperoni
        mushrooms = pizzaBuilder.mushrooms
        sausage = pizzaBuilder.sausage
    }

    override fun toString(): String {
        return "Pizza(size='$size', cheese=$cheese, pepperoni=$pepperoni, mushrooms=$mushrooms, sausage=$sausage)"
    }

    class PizzaBuilder {
        var size: String = ""
            private set
        var cheese: Boolean = false
            private set
        var pepperoni: Boolean = false
            private set
        var mushrooms: Boolean = false
            private set
        var sausage: Boolean = false
            private set

        fun setSize(size: String): PizzaBuilder = apply { this.size = size }

        fun addCheese(): PizzaBuilder = apply { this.cheese = true }

        fun addPepperoni(): PizzaBuilder = apply { this.pepperoni = true }

        fun addMushrooms(): PizzaBuilder = apply { this.mushrooms = true }

        fun addSausage(): PizzaBuilder = apply { this.sausage = true }

        fun build(): Pizza {
            return Pizza(this)
        }
    }
}

fun main() {

    val pizza = Pizza.PizzaBuilder()
        .setSize("Large")
        .addCheese()
        //TODO (notice here when we remove one method the code still work)
        //.addPepperoni()
        .addMushrooms()
        .build()


    println(pizza.toString())
}