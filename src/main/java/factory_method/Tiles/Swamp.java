package factory_method.Tiles;

import factory_method.Tile;

public class Swamp implements Tile {

    @Override
    public String getType() {
        return "swamp";
    }

    @Override
    public void action() {
        System.out.println("This is a swamp.");
    }
}