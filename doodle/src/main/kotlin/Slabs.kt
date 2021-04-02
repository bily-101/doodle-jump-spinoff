import com.anysolo.toyGraphics.Graphics
import com.anysolo.toyGraphics.Pal16

data class Object(var x: Int, var y: Int, var width: Int, var height: Int, var fill: Boolean)

class Slabs(var x: Int, var y: Int, var width: Int, var height: Int) {
    val slab = Object(x,y,width,height,false)
    val slab2 = Object(x+30,y-50,width,height,false)
    var pointsToWin = 0
    val slabs = mutableListOf<Object>()
    var win = false



    fun getArea() = Area(x, y, width, height)
    fun slabCalculation() {
        if(pointsToWin==9){
            win = true
        }
    }

    fun drawSlabs(g: Graphics) {

        if(win){
            g.color = Pal16.green
            g.setFontSize(20)
            g.drawText(200,200,"You win")
        }
        for (b in slabs) {
            g.drawRect(b.x, b.y, b.width, b.height, fill = b.fill)
        }

    }
}