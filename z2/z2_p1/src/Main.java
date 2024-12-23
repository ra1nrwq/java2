import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите задание:");
            System.out.println("1. Приветствие пользователя");
            System.out.println("2. Проверка симметричности трехзначного числа");
            System.out.println("3. Операции с четным или нечетным числом");
            System.out.println("4. Определение периода суток");
            System.out.println("5. Вывод диапазона чисел");
            System.out.println("0. Выход");
            System.out.print("Введите номер задания: ");

            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    greetUser();
                    break;
                case 2:
                    checkSymmetricNumber();
                    break;
                case 3:
                    evenOddOperations();
                    break;
                case 4:
                    determineTimeOfDay();
                    break;
                case 5:
                    displayNumberRange();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
            System.out.println();
        }
    }

    // Задание 1: Приветствие пользователя
    public static void greetUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        System.out.println("Привет, " + name + "!");
    }

    // Задание 2: Проверка симметричности трехзначного числа
    public static void checkSymmetricNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите трехзначное число: ");
        int number = scanner.nextInt();

        if (number >= 100 && number <= 999) {
            int firstDigit = number / 100;
            int lastDigit = number % 10;

            if (firstDigit == lastDigit) {
                System.out.println("Число является симметричным.");
            } else {
                System.out.println("Число не является симметричным.");
            }
        } else {
            System.out.println("Ошибка: введите положительное трехзначное число.");
        }
    }

    // Задание 3: Операции с четным или нечетным числом
    public static void evenOddOperations() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.print("Введите дробное число: ");
            double decimal = scanner.nextDouble();
            System.out.println("Произведение: " + (number * decimal));
        } else {
            System.out.print("Введите другое целое число: ");
            int otherNumber = scanner.nextInt();
            System.out.println("Сумма: " + (number + otherNumber));
        }
    }

    // Задание 4: Определение периода суток
    public static void determineTimeOfDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите час (от 0 до 23): ");
        int hour = scanner.nextInt();

        if (hour < 0 || hour > 23) {
            System.out.println("Ошибка: введите значение от 0 до 23.");
        } else if (hour >= 6 && hour < 10) {
            System.out.println("Утро");
        } else if (hour >= 10 && hour <= 18) {
            System.out.println("День");
        } else if (hour > 18 && hour < 22) {
            System.out.println("Вечер");
        } else {
            System.out.println("Ночь");
        }
    }

    // Задание 5: Вывод диапазона чисел
    public static void displayNumberRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое положительное число x: ");
        int x = scanner.nextInt();

        if (x > 0) {
            for (int i = -x + 1; i < x; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            System.out.println("Ошибка: введите положительное число.");
        }
    }
}
