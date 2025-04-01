package singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance(); // getting single instance of logger

        logger.setFileName("simulation_log.txt"); // setting new name

        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");

        logger.close();
    }
}
