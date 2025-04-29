package factory_method;

import factory_method.Tiles.Forest;
import factory_method.Tiles.Swamp;
import factory_method.Tiles.Water;

import java.util.Random;

public class WildernessMap extends Map {
    private Random rand = new Random();

    @Override
    public Tile createTile() {
        int choice = rand.nextInt(3);
        switch (choice) {
            case 0: return new Swamp();
            case 1: return new Water();
            case 2: return new Forest();
            default: return new Forest();
        }
    }
}