package state;

public class NoviceLevel extends State {

    public NoviceLevel(GameCharacter character) {
        super(character);
        this.getCharacter().newGame();
    }

    @Override
    public void action() {
        GameCharacter character = this.getCharacter();
        character.printStatus("Novice");

        String[] actions = {"Train", "Upgrade to next level", "Exit", "Check status"};
        switch (character.readUserChoice(actions)) {
            case 1:
                character.train();
                break;

            case 2:
                if (character.getExp() >= 30) {
                    character.setState(new IntermediateLevel(character));
                } else {
                    System.out.println("You are not ready yet! 30+ exp required to upgrade.");
                }
                break;

            case 3:
                System.out.println("Exiting the game...");
                System.exit(0);
                break;

            case 4:
                character.printStatus("Novice");
                break;

            default:
                System.out.println("Invalid option. Try again.");
                break;
        }
    }
}