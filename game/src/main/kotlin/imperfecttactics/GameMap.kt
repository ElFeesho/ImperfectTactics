package imperfecttactics

class GameMap(cols: Int, rows: Int, private val tileRadius: Int) {

    private val tileWidth = tileRadius*2
    private val tileHeight = Math.sqrt(3.0)/2.0 * tileWidth
    private val tileStride = tileRadius + tileRadius/2

    val enemyBuildings: MutableList<GameTile> = mutableListOf()
    val playerBuildings: MutableList<GameTile> = mutableListOf()

    val tiles = Array(cols, { column ->
        Array(rows, {
            row ->
            val coord = cartesianToCoord(column, row)
            GameTile(coord)
        })
    })

    private fun cartesianToCoord(x: Int, y: Int): Coord {
        val hexagonX = tileRadius + x * tileStride
        val hexagonY = (tileHeight / 2.0 + tileHeight * y + (x % 2 * (tileHeight / 2.0))).toInt()
        return Coord(hexagonX, hexagonY)
    }

    fun tileAt(x: Int, y: Int): GameTile {
        return tiles[x][y]
    }

    fun addPlayerBuilding(x: Int, y: Int) {
        playerBuildings.add(GameTile(cartesianToCoord(x, y)))
    }

    fun addEnemyBuilding(x: Int, y: Int) {
        enemyBuildings.add(GameTile(cartesianToCoord(x, y)))
    }
}