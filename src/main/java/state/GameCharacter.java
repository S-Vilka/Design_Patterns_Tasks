package state;

import java.util.Scanner;

public class GameCharacter {
    private static Scanner sc = new Scanner(System.in);
    private State state;
    private String name;
    private int exp = 0;
    private int HP = 50;

    public GameCharacter(){ state = new NoviceLevel(this); }

    public void play() {
        while (true) {
            if (state == null) {
                System.out.println("Game does not work properly");
                return;
            }
            state.action();
        }
    }

    public void setState(State state){this.state = state;}

    public void train() {
        exp += 10;
        System.out.println("Your exp increased by 10 points! Keep training! Curren exp: " + exp);
    }

    public void meditate() {
        HP += 10;
        System.out.println("After meditation, your health increased by 10 points! Current HP: " + HP);
    }

    public void fight() {
        HP -= 10;
        exp += 20;
        System.out.println("You've been into a fight. -10 HP, +20 exp HP: " + HP + "Exp: " + exp );
    }

    public int getExp(){return exp;}

    public int getHP(){return HP;}

    public int readUserChoice(String[] options){
        //Print options
        System.out.println("\nSelect action: ");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        // read user input
        return sc.nextInt();
    }

    public void newGame(){
        HP = 50;
        exp = 0;
        System.out.println("New game started...");
    }

    public void printStatus(String levelName) {
        System.out.println("\n--- Character Status ---");
        System.out.println("Level: " + levelName);
        System.out.println("HP: " + HP);
        System.out.println("EXP: " + exp);
    }


}
