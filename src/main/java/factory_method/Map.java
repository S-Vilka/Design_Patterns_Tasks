package factory_method;

public abstract class Map {

    protected final int rows = 5;
    protected final int cols = 10;
    protected Tile[][] mapTiles;

    public abstract Tile createTile();

    public void generateMap() {
        mapTiles = new Tile[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mapTiles[i][j] = createTile();
            }
        }
    }

    public void display() {
        if (mapTiles == null) {
            System.out.println("Map has not been generated yet.");
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mapTiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Tile getTileAt(int row, int col) {
        if (mapTiles == null || row < 0 || row >= rows || col < 0 || col >= cols) {
            return null;
        }
        return mapTiles[row][col];
    }
}