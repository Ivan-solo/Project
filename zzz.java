import java.util.Scanner;

    public class zzz {

        public static void main(String[] args) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите операцию в формате 'число оператор число': ");
                String inputStr = scanner.nextLine();
                int result = calculate(inputStr);
                System.out.println("Результат: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        public static int calculate(String input) {
            String[] operands = input.split(" ");

            if (operands.length != 3) {
                throw new IllegalArgumentException("Неверное количество аргументов. Введите два числа и оператор.");
            }

            int a = Integer.parseInt(operands[0]);
            String operator = operands[1];
            int b = Integer.parseInt(operands[2]);

            if (!operator.matches("[-+*/]")) {
                throw new IllegalArgumentException("Неподдерживаемый оператор. Используйте +, -, *, /.");
            }

            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("Введите числа от 1 до 10 включительно.");
            }

            int result;
            switch (operator) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестная арифметическая операция.");
            }
            return result;
        }
    }


