package imperfecttactics

import com.almasb.fxgl.app.FXGL
import com.almasb.fxgl.app.GameApplication
import com.almasb.fxgl.entity.Entities
import com.almasb.fxgl.entity.RenderLayer
import com.almasb.fxgl.settings.GameSettings
import javafx.scene.paint.Color
import javafx.scene.shape.SVGPath

class MainApp : GameApplication() {

    private val gameMapLayer = GameLayer(0, "map")
    private val gameMapSelectionLayer = GameLayer(0, "mapSelection")
    private val actorLayer = GameLayer(0, "actors")

    class GameLayer(private val zIndex:Int, private val name:String) : RenderLayer {
        override fun index() = zIndex
        override fun name() = this.name
    }

    override fun initSettings(settings: GameSettings) {
        settings.apply {
            isIntroEnabled = false
            isMenuEnabled = false
            isProfilingEnabled = false
            isCloseConfirmation = false
            width = 800
            height = 600
            title = "Imperfect Tactics"
            version = "0.0.0"
        }
    }

    override fun initGame() {
        val gameMap = GameMap(6, 6, 40)

        gameMap.addPlayerBuilding(0, 0)
        gameMap.addEnemyBuilding(5, 5)

        gameMap.addPlayerTank(1, 0)

        createMap(gameMap)
    }

    private fun createMap(gameMap: GameMap) {
        gameMap.tiles.forEach { column ->
            column.forEach { tile ->
                Entities.builder().apply {
                    renderLayer(gameMapLayer)
                    at(tile.coord.x.toDouble() + GameMapXOffset, tile.coord.y.toDouble() + GameMapYOffset)
                    viewFromNode(Hexagon(45.0, Color.BLACK))
                }.buildAndAttach()

                Entities.builder().apply {
                    renderLayer(gameMapLayer)
                    at(tile.coord.x.toDouble() + GameMapXOffset, tile.coord.y.toDouble() + GameMapYOffset)
                    viewFromNode(Hexagon(36.0, Color.GREY))
                }.buildAndAttach()
            }
        }

        gameMap.playerBuildings.forEach { building ->
            Entities.builder().apply {
                at(building.coord.x.toDouble() + GameMapXOffset - 25, building.coord.y.toDouble() + GameMapYOffset - 41)
                renderLayer(actorLayer)
                viewFromNode(SVGPath().apply {
                    content = FXGL.getAssetLoader().getStream("/assets/svgs/city-white.svg").use {
                        it.bufferedReader().lines().reduce("", { acc, line -> acc + line })
                    }
                    fill = Color.WHITE
                })
            }.buildAndAttach()
        }

        gameMap.enemyBuildings.forEach { building ->
            Entities.builder().apply {
                renderLayer(actorLayer)
                at(building.coord.x.toDouble() + GameMapXOffset - 25, building.coord.y.toDouble() + GameMapYOffset - 41)
                viewFromNode(SVGPath().apply {
                    content = FXGL.getAssetLoader().getStream("/assets/svgs/city-black.svg").use {
                        it.bufferedReader().lines().reduce("", { acc, line -> acc + line })
                    }
                    fill = Color.BLACK
                })
            }.buildAndAttach()
        }

        gameMap.playerTanks.forEach { tank ->
            Entities.builder().apply {
                renderLayer(actorLayer)
                at(tank.coord.x.toDouble() + GameMapXOffset - 25, tank.coord.y.toDouble() + GameMapYOffset - 41)
                viewFromTexture("tank-white.png")
            }.buildAndAttach()
        }
    }

    companion object {

        private val GameMapXOffset = 200.0
        private val GameMapYOffset = 60.0

        fun main(args: Array<String>) {
            launch(MainApp::class.java, *args)
        }
    }
}