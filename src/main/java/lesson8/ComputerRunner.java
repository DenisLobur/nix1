package lesson8;

public class ComputerRunner {

    public static void main(String[] args) {
        Computer computer = new Computer(16, 4, "Acer", Computer.OperatingSystem.Windows);
        System.out.println(computer);

        Computer computer1 = Computer.builder()
                .cores(8)
                .ram(32)
                .name("Lenovo")
                .operatingSystem(Computer.OperatingSystem.Linux)
                .number()
                .build();
        System.out.println(computer1);

        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
        int[][] transposed = computer.transpose(arr);
        System.out.println("original");
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

        System.out.println("transposed");
        for (int[] ints : transposed) {
            for (int j = 0; j < transposed[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
