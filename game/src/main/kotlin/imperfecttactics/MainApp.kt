package imperfecttactics

import com.almasb.fxgl.app.GameApplication
import com.almasb.fxgl.entity.Entities
import com.almasb.fxgl.settings.GameSettings
import javafx.scene.paint.Color

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
        gameMap.addBuilding(0, 0)

        createMap(gameMap)
    }

    private val GameMapXOffset = 200.0
    private val GameMapYOffset = 60.0

    private fun createMap(gameMap: GameMap) {
        gameMap.tiles.forEach { column ->
            column.forEach { tile ->
                Entities.builder().apply {
                    at(tile.coord.x.toDouble() + GameMapXOffset, tile.coord.y.toDouble() + GameMapYOffset)
                    viewFromNode(Hexagon(45.0, Color.BLACK))
                }.buildAndAttach()

                Entities.builder().apply {
                    at(tile.coord.x.toDouble() + GameMapXOffset, tile.coord.y.toDouble() + GameMapYOffset)
                    viewFromNode(Hexagon(36.0, Color.RED))
                }.buildAndAttach()
            }
        }

        gameMap.buildings.forEach {
            building ->
            Entities.builder().apply {
                at(building.coord.x.toDouble() + GameMapXOffset - 25, building.coord.y.toDouble() + GameMapYOffset-41)
                viewFromTexture("city-black.png")
            }.buildAndAttach()

        }
    }

    companion object {
        fun main(args: Array<String>) {
            launch(MainApp::class.java, *args)
        }
    }
}