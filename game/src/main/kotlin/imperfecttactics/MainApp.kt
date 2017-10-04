package imperfecttactics

import com.almasb.fxgl.app.GameApplication
import com.almasb.fxgl.entity.Entities
import com.almasb.fxgl.settings.GameSettings
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.scene.shape.Polygon

class MainApp : GameApplication() {

    override fun initSettings(settings: GameSettings) {
        settings.apply {
            isIntroEnabled = false
            isMenuEnabled = false
            isProfilingEnabled = false
            isCloseConfirmation = false
            width = 800
            height = 600
        }
    }

    override fun initGame() {

        val gameMap = GameMap(6, 6, 40)

        gameMap.tiles.forEach { column ->
            column.forEach { tile ->
                Entities.builder().apply {
                    at(tile.coord.x.toDouble() + 200, tile.coord.y.toDouble() + 60)
                    viewFromNode(Hexagon(45.0, Color.BLACK))
                }.buildAndAttach()

                Entities.builder().apply {
                    at(tile.coord.x.toDouble() + 200, tile.coord.y.toDouble() + 60)
                    viewFromNode(Hexagon(36.0, Color.RED))
                }.buildAndAttach()
            }
        }
    }

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

    companion object {
        fun main(args: Array<String>) {
            launch(MainApp::class.java, *args)
        }
    }
}