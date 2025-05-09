package command;

public class MoveCursorUpCommand implements Command {
    private PixelGrid grid;

    public MoveCursorUpCommand(PixelGrid grid) {
        this.grid = grid;
    }

    public void execute() {
        grid.moveUp();
    }
}