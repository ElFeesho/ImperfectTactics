package imperfecttactics

class GameMap(cols: Int, rows: Int, tileRadius: Int) {

    private val tileWidth = tileRadius*2
    private val tileHeight = Math.sqrt(3.0)/2.0 * tileWidth
    private val tileStride = tileRadius + tileRadius/2

    val tiles = Array(cols, { column ->
        Array(rows, {
            row ->
            val hexagonX = tileRadius + column * tileStride
            val hexagonY = (tileHeight / 2.0 + tileHeight * row + (column % 2 * (tileHeight/2.0))).toInt()
            GameTile(Coord(hexagonX, hexagonY))
        })
    })

    fun tileAt(x: Int, y: Int): GameTile {
        return tiles[x][y]
    }

}