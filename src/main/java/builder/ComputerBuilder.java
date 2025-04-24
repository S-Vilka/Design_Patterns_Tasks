package builder;

public interface ComputerBuilder {
    void buildProcessor();
    void buildRAM();
    void buildHardDrive();
    void buildGraphicsCard();
    void buildOperatingSystem();
    void buildAccessories(); // Новый метод
    Computer getComputer();
}
