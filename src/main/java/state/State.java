package state;

public abstract class State {

    private GameCharacter character;

    public State(GameCharacter character) {this.character = character;}

    public GameCharacter getCharacter(){return character;}

    abstract void action();
}
