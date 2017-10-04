package imperfecttactics

class GameMap(cols: Int, rows: Int, tileRadius: Int) {

    private val tiles = Array(cols, { x -> Array(rows, { y -> GameTile(Coord(tileRadius + x * (tileRadius * 2), tileRadius * (1 + x % 2) + y * (tileRadius * 2))) }) })

    fun tileAt(x: Int, y: Int): GameTile {
        return tiles[x][y]
    }

}