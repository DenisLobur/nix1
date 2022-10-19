package lesson4;

import java.util.Random;

public class LoopsRunner {
    private static final WeekDays today = WeekDays.values()[new Random().nextInt(0, 7)];

    public static void main(String[] args) {
        System.out.println("Even numbers:");
        evenNumbers();
        System.out.println("Random day of the week:");
        daysOfWeek();
    }

    private static void evenNumbers() {
        int[] arr = {-9, -8, -7, -6, -5, -4, -3, -2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : arr) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    private static void daysOfWeek() {
        switch (today) {
            case MON -> System.out.println("Сьогодні Понеділок. Працюємо сумлінно");
            case TUE -> System.out.println("Сьогодні Вівторок. Працюємо");
            case WED -> System.out.println("Сьогодні Середа. Знов працюємо");
            case THU -> System.out.println("Сьогодні Четвер. Ще трохи працюємо");
            case FRI -> System.out.println("Сьогодні П'ятниця. Вже майже не працюємо");
            case SAT, SUN -> System.out.println("Сьогодні яскравий сонячний день. Працювати заборонено!");
            default -> System.out.println("Помилка. Такого дня не існує");
        }
    }


}
