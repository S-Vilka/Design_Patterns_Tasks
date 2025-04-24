package builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomComputerBuilder implements ComputerBuilder {

    private final Computer computer;
    private final Scanner scanner;

    public CustomComputerBuilder(Scanner scanner) {
        this.computer = new Computer();
        this.scanner = scanner;
    }

    @Override
    public void buildProcessor() {
        System.out.print("Enter processor: ");
        computer.setProcessor(scanner.nextLine());
    }

    @Override
    public void buildRAM() {
        System.out.print("Enter RAM size GB: ");
        computer.setRam(Integer.parseInt(scanner.nextLine()));
    }

    @Override
    public void buildHardDrive() {
        System.out.print("Enter hard drive: ");
        computer.setHardDrive(scanner.nextLine());
    }

    @Override
    public void buildGraphicsCard() {
        System.out.print("Enter graphics card: ");
        computer.setGraphicsCard(scanner.nextLine());
    }

    @Override
    public void buildOperatingSystem() {
        System.out.print("Enter operating system: ");
        computer.setOperatingSystem(scanner.nextLine());
    }

    @Override
    public void buildAccessories() {
        System.out.print("Enter accessories (add , after each): ");
        String[] accessories = scanner.nextLine().split(",");
        for (String accessory : accessories) {
            computer.addAccessory(accessory.trim());
        }
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}