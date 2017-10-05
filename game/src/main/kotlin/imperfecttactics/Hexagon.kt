package imperfecttactics

import javafx.scene.paint.Paint
import javafx.scene.shape.Polygon

class Hexagon(radius: Double, fill: Paint) : Polygon(*generateHexagon(radius)) {

    init {
        this.fill = fill
    }

    companion object {
        fun generateHexagon(radius: Double): DoubleArray {
            val points = DoubleArray(12)
            for (i in 0 until 6) {
                val angleDeg = 60 * i
                val angleRad = Math.PI / 180 * angleDeg
                points[i * 2] = Math.cos(angleRad) * radius
                points[i * 2 + 1] = Math.sin(angleRad) * radius
            }
            return points
        }
    }
}