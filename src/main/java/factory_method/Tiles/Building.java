package factory_method.Tiles;

import factory_method.Tile;

public class Building implements Tile {

    @Override
    public String getType() {
        return "building";
    }

    @Override
    public void action() {
        System.out.println("This is a building.");
    }
}