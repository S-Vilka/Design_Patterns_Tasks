package builder;

public class ComputerDirector {

    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void constructComputer() {
        builder.buildProcessor();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildGraphicsCard();
        builder.buildOperatingSystem();
        builder.buildAccessories();
    }

    public Computer getComputer() {
        return builder.getComputer();
    }
}