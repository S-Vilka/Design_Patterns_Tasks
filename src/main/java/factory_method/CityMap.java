package factory_method;

import factory_method.Tiles.Building;
import factory_method.Tiles.Forest;
import factory_method.Tiles.Road;

import java.util.Random;

public class CityMap extends Map {
    private Random rand = new Random();

    @Override
    public Tile createTile() {
        int choice = rand.nextInt(3);
        switch (choice) {
            case 0: return new Road();
            case 1: return new Forest();
            case 2: return new Building();
            default: return new Road();
        }
    }
}