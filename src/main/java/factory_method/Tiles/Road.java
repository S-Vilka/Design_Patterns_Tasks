package factory_method.Tiles;

import factory_method.Tile;

public class Road implements Tile {

    @Override
    public String getType() {
        return "road";
    }

    @Override
    public void action() {
        System.out.println("This is a road.");
    }
}