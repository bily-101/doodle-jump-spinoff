import com.anysolo.toyGraphics.*
import kotlin.random.Random

data class Area(val x: Int, val y: Int, val width: Int, val height: Int) {
    fun isInsideThis(a2: Area): Boolean =
        a2.y >= y - height && a2.y < y + height &&
        a2.x > x - a2.width && a2.x < x + width
}


class Game() {
    private val wnd = Window(400,600)
    val keyboard = Keyboard(wnd)
    var doodle = Doodle(wnd.width/2, wnd.height /2.0)
    var slabs = Slabs(wnd.width/2 - 10,wnd.height-30,50,10)



    private fun calculations(){ // Necessary calculations for the game to work
        doodle.doodleCalculations()
        slabs.slabCalculation()
       // println("Calc works!!")
        processCollisions()
    }
    private fun keyboard(){
        do {
            val key = keyboard.getPressedKey()

            if (key != null) {
                if(key.code == KeyCodes.LEFT)
                    doodle.x-=5

                if(key.code == KeyCodes.RIGHT)
                    doodle.x +=5
            }
        } while (key != null)
    }

    fun draw(){ // Function to draw the game
        val g = Graphics(wnd)
        g.clear()
        doodle.drawDoodle(g)

        slabs.drawSlabs(g)

       // println("Draw works!!")
    }

     fun processCollisions() {
         for(b in slabs.slabs){
            if (Area(b.x,b.y,b.width,b.height).isInsideThis(doodle.getArea())) {
                doodle.applyGravity = false

                if(b.fill)
                    slabs.pointsToWin+=0
                else
                    slabs.pointsToWin+=1
                b.fill=true
            }
         }

    }
    fun preGameLogic(){

        slabs.slabs.add(slabs.slab)

        repeat(3){
            slabs.slabs.add(Object(Random.nextInt(0, wnd.width),Random.nextInt(wnd.height/2+150, wnd.height),slabs.width,slabs.height,false))
        }

        repeat(5){
            slabs.slabs.add(Object(Random.nextInt(0, wnd.width),Random.nextInt(wnd.height/2, wnd.height),slabs.width,slabs.height,false))
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
    game.preGameLogic()
    game.run()
}