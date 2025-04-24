package builder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        buildAndPrintComputer(new GamingComputerBuilder(), "^^^^ Gaming PC ^^^^");
        System.out.println();
        buildAndPrintComputer(new OfficeComputerBuilder(), "**** Office PC ****");
        System.out.println();

        System.out.println("==== Custom PC ====");
        ComputerBuilder customBuilder = new CustomComputerBuilder(scanner);
        ComputerDirector director = new ComputerDirector(customBuilder);
        director.constructComputer();
        Computer customPC = director.getComputer();

        System.out.println("\n==== Your Custom PC ====");
        System.out.println(customPC);

        scanner.close();
    }

    private static void buildAndPrintComputer(ComputerBuilder builder, String title) {
        ComputerDirector director = new ComputerDirector(builder);
        director.constructComputer();
        Computer computer = director.getComputer();

        System.out.println(title);
        System.out.println(computer);
    }
}