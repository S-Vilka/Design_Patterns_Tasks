package builder;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String processor;
    private int ram;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;
    private List<String> accessories = new ArrayList<>();

    public void setProcessor(String processor) { this.processor = processor; }
    public void setRam(int ram) { this.ram = ram; }
    public void setHardDrive(String hardDrive) { this.hardDrive = hardDrive; }
    public void setGraphicsCard(String graphicsCard) { this.graphicsCard = graphicsCard; }
    public void setOperatingSystem(String operatingSystem) { this.operatingSystem = operatingSystem; }

    public void addAccessory(String accessory) {
        accessories.add(accessory);
    }

    public List<String> getAccessories() {
        return accessories;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Computer Configuration:\n")
                .append("Processor: ").append(processor).append("\n")
                .append("RAM: ").append(ram).append(" GB\n")
                .append("Hard Drive: ").append(hardDrive).append("\n")
                .append("Graphics Card: ").append(graphicsCard).append("\n")
                .append("Operating System: ").append(operatingSystem).append("\n");

        if (!accessories.isEmpty()) {
            sb.append("Accessories:\n");
            for (String accessory : accessories) {
                sb.append("- ").append(accessory).append("\n");
            }
        }

        return sb.toString();
    }
}