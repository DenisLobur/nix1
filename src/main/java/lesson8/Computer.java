package lesson8;

import lesson4.WeekDays;

import java.util.UUID;

public class Computer {
    private int ram;
    private int cores;
    private String name;
    private UUID number;
    private OperatingSystem operatingSystem;

    public Computer(int ram, int cores, String name, OperatingSystem operatingSystem) {
        this.ram = ram;
        this.cores = cores;
        this.name = name;
        this.operatingSystem = operatingSystem;
        this.number = UUID.randomUUID();
    }

    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] transposedMatrix = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public String calculateWorkingMood(WeekDays weekDay) {
        return switch (weekDay) {
            case MON, TUE, WED, THU, FRI -> "In mood for work";
            default -> "In mood for rest";
        };
    }

    public boolean canRunGames() {
        return this.ram >= 18 && this.cores >= 8;
    }

    public boolean supportsXcode() {
        return this.operatingSystem == OperatingSystem.MacOS;
    }

    public static ComputerBuilder builder() {
        return new ComputerBuilder();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ram=" + ram +
                ", cores=" + cores +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", operatingSystem=" + operatingSystem +
                '}';
    }

    enum OperatingSystem {
        Windows,
        Linux,
        MacOS
    }

    public static class ComputerBuilder {
        private int ram;
        private int cores;
        private String name;
        private UUID number;
        private OperatingSystem operatingSystem;

        public ComputerBuilder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder cores(int cores) {
            this.cores = cores;
            return this;
        }

        public ComputerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ComputerBuilder number() {
            this.number = UUID.randomUUID();
            return this;
        }

        public ComputerBuilder operatingSystem(OperatingSystem operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Computer build() {
            return new Computer(ram, cores, name, operatingSystem);
        }
    }
}
