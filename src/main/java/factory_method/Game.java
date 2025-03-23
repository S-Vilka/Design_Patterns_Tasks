package factory_method;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose map type: 1 for CityMap, 2 for WildernessMap");
        String choice = sc.nextLine();

        Map map = createMap(choice);
        if (map != null) {
            map.generateMap();

            int playerRow = 0;
            int playerCol = 0;
            boolean running = true;

            while (running) {
                displayMapWithPlayer(map, playerRow, playerCol);

                Tile currentTile = map.getTileAt(playerRow, playerCol);
                System.out.println("You are on a " + currentTile.getType() + " tile.");
                currentTile.action();

                System.out.println("\nMove (WASD), or Q to quit:");
                String input = sc.nextLine().toLowerCase();

                switch (input) {
                    case "w":
                        if (playerRow > 0) playerRow--;
                        break;
                    case "s":
                        if (playerRow < map.getRows() - 1) playerRow++;
                        break;
                    case "a":
                        if (playerCol > 0) playerCol--;
                        break;
                    case "d":
                        if (playerCol < map.getCols() - 1) playerCol++;
                        break;
                    case "q":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input.");
                }
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static Map createMap(String type) {
        switch (type) {
            case "1":
                return new CityMap();
            case "2":
                return new WildernessMap();
            default:
                return null;
        }
    }

    public static void displayMapWithPlayer(Map map, int playerRow, int playerCol) {
        for (int i = 0; i < map.getRows(); i++) {
            for (int j = 0; j < map.getCols(); j++) {
                if (i == playerRow && j == playerCol) {
                    System.out.print("\u001B[31mP\u001B[0m ");
                } else {
                    System.out.print(map.getTileAt(i, j).getCharacter() + " ");
                }
            }
            System.out.println();
        }
    }

}