import com.anysolo.toyGraphics.*

data class Area(val x: Int, val y: Int, val width: Int, val height: Int) {
    fun isInsideThis(a2: Area): Boolean =
        a2.y >= y - height && a2.y < y + height &&
        a2.x > x - a2.width && a2.x < x + width
}


class Game() {
    private val wnd = Window(400,600)
    val keyboard = Keyboard(wnd)
    var doodle = Doodle(wnd.width/2, wnd.height /2.0)
    var slabs = Slabs(wnd.width/2 - 10,wnd.height-30)



    private fun calculations(){ // Necessary calculations for the game to work
        doodle.doodleCalculations()
        slabs.positioning()
       // println("Calc works!!")
        processCollisions()
    }
    private fun keyboard(){
        do {
            val key = keyboard.getPressedKey()

            if (key != null) {
                println(key)
                println("key: " + key.code)

                if(key.code == KeyCodes.LEFT)
                    doodle.x-=5

                if(key.code == KeyCodes.RIGHT)
                    doodle.x +=5
                println()
            }
        } while (key != null)
    }

    fun draw(){ // Function to draw the game
        val g = Graphics(wnd)
        g.clear()
        slabs.drawSlabs(g)
        doodle.drawDoodle(g)
       // println("Draw works!!")
    }

     fun processCollisions() {
        if (slabs.getArea().isInsideThis(doodle.getArea())) {
            doodle.applyGravity = false

        }
    }
    fun run() { // Running the game putting together calculations
                // function and draw function and adding more necessary functions.
        while(true) {
            keyboard()
            //println("Reached run function.... Starting run function")
            calculations()
            draw()
            sleep(10)
        }
    }
}


fun main() {
    val game = Game()
    game.run()
}