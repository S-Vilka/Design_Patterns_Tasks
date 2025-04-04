package state;

public class ExpertLevel extends State {

    public ExpertLevel(GameCharacter character) {
        super(character);
    }

    @Override
    public void action() {
        GameCharacter character = this.getCharacter();
        character.printStatus("Expert");

        String[] actions = {"Train", "Meditate", "Fight", "Upgrade to next level", "Exit", "Check status"};
        switch (character.readUserChoice(actions)) {
            case 1:
                character.train();
                break;

            case 2:
                character.meditate();
                break;

            case 3:
                character.fight();
                break;

            case 4:
                if (character.getExp() >= 90) {
                    character.setState(new MasterLevel(character));
                } else {
                    System.out.println("You are not ready yet! 90+ exp required to upgrade.");
                }
                break;

            case 5:
                System.out.println("Exiting the game...");
                System.exit(0);
                break;

            case 6:
                character.printStatus("Expert");
                break;

            default:
                System.out.println("Invalid option. Try again.");
                break;
        }
    }
}