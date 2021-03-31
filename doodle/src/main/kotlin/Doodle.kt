import com.anysolo.toyGraphics.Graphics

class Doodle(var x: Int, var y: Double) { // Characters name
   // var doodlesImage = Image("/home/bily101/IdeaProjects/doodle-poodle/doodle/graphics/Doodler.webp")
   private var yVelocity = 0.0
    var applyGravity = true
    private var jump_force= -5

    fun getArea() = Area(x, y.toInt(), 10, 10)





    fun doodleCalculations(){
        y += yVelocity
        if(applyGravity) {
            yVelocity += .05 // 5 will be the game gravity instead of 9.8 like in real life.
        } else {
            yVelocity = 0.0
            yVelocity += jump_force
            applyGravity=true
        }
    }

    fun drawDoodle(g: Graphics) {
      //  g.drawImage(x,y,doodlesImage)
        g.drawRect(x,y.toInt(),10,10)
    }

}