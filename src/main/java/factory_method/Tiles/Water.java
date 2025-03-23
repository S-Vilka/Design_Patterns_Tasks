package factory_method.Tiles;

import factory_method.Tile;

public class Water implements Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getType() {
        return "water";
    }

    @Override
    public void action() {
        System.out.println("This is water");
    }
}
