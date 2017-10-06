import imperfecttactics.Coord
import imperfecttactics.GameMap
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class GameMapTest {

    @Test
    fun singleTileMapCanBeCreated() {
        val map = GameMap(1, 1, 10)
        val hexHeight = Math.sqrt(3.0) / 2.0 * 20.0

        assertThat(map.tileAt(0, 0).coord, `is`(Coord(10, (hexHeight/2.0).toInt())))
    }

    @Test
    fun singleColumnTileMapCanBeCreated() {
        val map = GameMap(1, 2, 10)
        val hexHeight = Math.sqrt(3.0) / 2.0 * 20.0

        assertThat(map.tileAt(0, 0).coord, `is`(Coord(10, (hexHeight/2.0).toInt())))
        assertThat(map.tileAt(0, 1).coord, `is`(Coord(10, (hexHeight/2.0+hexHeight).toInt())))
    }

    @Test
    fun multipleColumnTileMapCanBeCreated() {
        val map = GameMap(2, 2, 10)
        val hexHeight = Math.sqrt(3.0) / 2.0 * 20.0

        assertThat(map.tileAt(0, 0).coord, `is`(Coord(10, (hexHeight/2.0).toInt())))
        assertThat(map.tileAt(0, 1).coord, `is`(Coord(10, (hexHeight/2.0 + hexHeight).toInt())))
        assertThat(map.tileAt(1, 0).coord, `is`(Coord(25, (hexHeight).toInt())))
        assertThat(map.tileAt(1, 1).coord, `is`(Coord(25, (hexHeight * 2.0).toInt())))
    }

    @Test
    fun aMapCanContainAPlayerBuilding() {
        val map = GameMap(1, 1, 10)
        val hexHeight = Math.sqrt(3.0) / 2.0 * 20.0

        map.addPlayerBuilding(0, 0)

        assertThat(map.playerBuildings.first().coord, `is`(Coord(10, (hexHeight/2.0).toInt())))
    }

    @Test
    fun aMapCanContainAPlayerTank() {
        val map = GameMap(3, 3, 10)
        val hexHeight = Math.sqrt(3.0) / 2.0 * 20.0

        map.addPlayerTank(1, 1)

        assertThat(map.playerTanks.first().coord, `is`(Coord(25, (hexHeight*2.0).toInt())))
    }

    @Test
    fun aMapCanContainAnEnemyBuilding() {
        val map = GameMap(1, 1, 10)
        val hexHeight = Math.sqrt(3.0) / 2.0 * 20.0

        map.addEnemyBuilding(0, 0)

        assertThat(map.enemyBuildings.first().coord, `is`(Coord(10, (hexHeight/2.0).toInt())))
    }


}
