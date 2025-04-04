package state;

public class IntermediateLevel extends State {

    public IntermediateLevel(GameCharacter character) {
        super(character);
    }

    @Override
    public void action() {
        GameCharacter character = this.getCharacter();
        character.printStatus("Intermediate");

        String[] actions = {"Train", "Meditate", "Upgrade to next level", "Exit", "Check status"};
        switch (character.readUserChoice(actions)) {
            case 1:
                character.train();
                break;

            case 2:
                character.meditate();
                break;

            case 3:
                if (character.getExp() >= 60) {
                    character.setState(new ExpertLevel(character));
                } else {
                    System.out.println("You are not ready yet! 60+ exp required to upgrade.");
                }
                break;

            case 4:
                System.out.println("Exiting the game...");
                System.exit(0);
                break;

            case 5:
                character.printStatus("Intermediate");
                break;

            default:
                System.out.println("Invalid option. Try again.");
                break;
        }
    }
}