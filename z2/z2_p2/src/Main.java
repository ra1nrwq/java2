import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите задание:");
            System.out.println("1. Анализ текста");
            System.out.println("2. Игра 'Городки'");
            System.out.println("0. Выход");
            System.out.print("Введите номер задания: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Очищаем буфер после ввода числа
            System.out.println();

            switch (choice) {
                case 1:
                    textAnalyzer();
                    break;
                case 2:
                    cityGame();
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

    // Анализ текста
    public static void textAnalyzer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        countWords(text);
        findLongestWord(text);
        countCharacters(text);
        printReverseText(text);
    }

    // Подсчитывает количество слов в тексте
    public static void countWords(String text) {
        String[] words = text.trim().split("\\s+");
        System.out.println("Количество слов: " + words.length);
    }

    // Находит и выводит самое длинное слово
    public static void findLongestWord(String text) {
        String[] words = text.trim().split("\\s+");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println("Самое длинное слово: " + longestWord);
    }

    // Подсчитывает количество каждого символа в тексте
    public static void countCharacters(String text) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char ch : text.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        System.out.println("Количество каждого символа:");
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    // Выводит текст в обратном порядке
    public static void printReverseText(String text) {
        StringBuilder reversedText = new StringBuilder(text);
        System.out.println("Текст в обратном порядке: " + reversedText.reverse().toString());
    }

    // Игра "Городки"
    public static void cityGame() {
        Scanner scanner = new Scanner(System.in);
        String previousCity = null;
        boolean playerOneTurn = true;

        while (true) {
            System.out.print((playerOneTurn ? "Игрок 1" : "Игрок 2") + ", введите название города: ");
            String city = scanner.nextLine().trim();

            if (previousCity != null) {
                char lastChar = previousCity.charAt(previousCity.length() - 1);
                if (city.charAt(0) != lastChar) {
                    System.out.println("Ошибка! Название города должно начинаться с буквы '" + lastChar + "'. Попробуйте снова.");
                    continue;
                }
            }

            previousCity = city;
            playerOneTurn = !playerOneTurn;
        }
    }
}
