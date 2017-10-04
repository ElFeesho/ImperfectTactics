package imperfecttactics

import com.almasb.fxgl.app.GameApplication
import com.almasb.fxgl.entity.Entities
import com.almasb.fxgl.settings.GameSettings
import javafx.scene.paint.Color
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

        val gameMap = GameMap(16, 16, 23)

        gameMap.tiles.forEach { column ->
            column.forEach { tile ->
                Entities.builder().apply {
                    at(tile.coord.x.toDouble(), tile.coord.y.toDouble())
                    viewFromNode(Hexagon(20.0))
                }.buildAndAttach()

            }
        }
    }

    class Hexagon(radius: Double) : Polygon(*generateHexagon(radius)) {

        init {
            fill = Color.RED
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