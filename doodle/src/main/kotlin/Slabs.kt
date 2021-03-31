import com.anysolo.toyGraphics.Graphics

class Slabs(var x: Int, var y: Int) {
    fun getArea() = Area(x, y, 50, 10)
    fun positioning() {

    }

    fun drawSlabs(g: Graphics) {
        g.drawRect(x,y,50,10)
    }
}