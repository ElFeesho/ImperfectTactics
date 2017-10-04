import org.hamcrest.core.Is.`is`
import org.junit.*
import org.junit.Assert.assertThat

class GameMapTest {

    @Test
    fun singleTileMapCanBeCreated() {
        val map = GameMap(1, 1, 10)
        assertThat(map.tileAt(0, 0).coord, `is`(Coord(10, 10)))
    }

    class GameMap(cols: Int, rows: Int, tileRadius: Int) {
        fun tileAt(x: Int, y: Int): GameTile {
            return GameTile(Coord(10, 10))
        }

    }

    data class GameTile(val coord: Coord)

    data class Coord(val x: Int, val y: Int)
}
