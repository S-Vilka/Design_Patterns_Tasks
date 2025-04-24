package builder;

public class GamingComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("AMD Ryzen 9");
    }

    @Override
    public void buildRAM() {
        computer.setRam(64);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("10 TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA GeForce RTX 5090");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Pro");
    }

    @Override
    public void buildAccessories() {
        computer.addAccessory("Logitech Mechanical RGB Keyboard");
        computer.addAccessory("Logitech Gaming Mouse");
        computer.addAccessory("Samsung 4K Monitor");
        computer.addAccessory("Logitech Headset");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}