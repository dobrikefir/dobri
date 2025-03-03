import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (от 1 до 10");

        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Результат " + result);
        } catch (Exception e) {
            System.out.println("Ошибка " + e.getMessage());
        } finally {
            scanner.close();
        }

    }

    static String calc(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода");

        }

        int a = parseNumber(parts[0]);
        int b = parseNumber(parts[2]);
        String operator = parts[1];

        switch (operator) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                if (b == 0) throw new ArithmeticException("Деление на ноль");
                return String.valueOf(a / b);
            default:
                throw new IllegalArgumentException("Недопустимая операция");
        }


    }
    static int parseNumber(String num) {
        int number = Integer.parseInt(num);
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }
        return number;
    }

}