package factory_method.Tiles;

import factory_method.Tile;

public class Forest implements Tile {

    @Override
    public String getType() {
        return "forest";
    }

    @Override
    public void action() {
        System.out.println("This is a forest.");
    }
}