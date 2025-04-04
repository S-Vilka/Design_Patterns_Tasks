package state;

public class MasterLevel extends State {

    public MasterLevel(GameCharacter character) {
        super(character);
    }

    @Override
    public void action() {
        GameCharacter character = this.getCharacter();
        character.printStatus("Master");

        System.out.println("\n🏆 Congratulations!");
        System.out.println("You have reached the Master level and completed the game!");
        System.out.println("Thank you for playing!");

        // Exit the game
        System.exit(0);
    }
}