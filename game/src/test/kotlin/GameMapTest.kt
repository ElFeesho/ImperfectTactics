import imperfecttactics.Coord
import imperfecttactics.GameMap
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class GameMapTest {

    @Test
    fun singleTileMapCanBeCreated() {
        val map = GameMap(1, 1, 10)

        assertThat(map.tileAt(0, 0).coord, `is`(Coord(10, 10)))
    }

    @Test
    fun singleColumnTileMapCanBeCreated() {
        val map = GameMap(1, 2, 10)

        assertThat(map.tileAt(0, 0).coord, `is`(Coord(10, 10)))
        assertThat(map.tileAt(0, 1).coord, `is`(Coord(10, 30)))
    }

    @Test
    fun multipleColumnTileMapCanBeCreated() {
        val map = GameMap(2, 2, 10)

        assertThat(map.tileAt(0, 0).coord, `is`(Coord(10, 10)))
        assertThat(map.tileAt(0, 1).coord, `is`(Coord(10, 30)))
        assertThat(map.tileAt(1, 0).coord, `is`(Coord(30, 20)))
        assertThat(map.tileAt(1, 1).coord, `is`(Coord(30, 40)))
    }


}
