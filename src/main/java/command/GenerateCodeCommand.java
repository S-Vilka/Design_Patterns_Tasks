package command;

public class GenerateCodeCommand implements Command {
    private PixelGrid grid;

    public GenerateCodeCommand(PixelGrid grid) {
        this.grid = grid;
    }

    public void execute() {
        boolean[][] g = grid.getGrid();
        System.out.println("int[][] pixelArt = {");
        for (int y = 0; y < 8; y++) {
            System.out.print("    {");
            for (int x = 0; x < 8; x++) {
                System.out.print(g[y][x] ? "1" : "0");
                if (x < 7) System.out.print(", ");
            }
            System.out.println("},");
        }
        System.out.println("};");
    }
}