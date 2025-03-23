package factory_method.Tiles;

import factory_method.Tile;

public class Forest implements Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getType() {
        return "forest";
    }

    @Override
    public void action() {
        System.out.println("This is forest");
    }
}
