package builder;

public class OfficeComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Apple M4");
    }

    @Override
    public void buildRAM() {
        computer.setRam(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1 TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Graphics");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("MacOS Sequoia");
    }

    @Override
    public void buildAccessories() {
        computer.addAccessory("Magic Keyboard");
        computer.addAccessory("Magic Trackpad");
        computer.addAccessory("27-inch Retina Display");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}