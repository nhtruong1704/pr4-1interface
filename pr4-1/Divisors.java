import java.util.Scanner;

public class Divisors implements Result {
    private int[] numbers;
    private int m;
    private int n;

    public Divisors(int[] numbers) {
        this.numbers = numbers;
    }

    public Divisors(int m, int n) {
        this.m = m;
        this.n = n;
    }

    //Initialize a Divisors object
    public Divisors() {

    }

    //Override the method from the Result interface.
    @Override
    public String getResult() {
        StringBuilder result = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Enter a list of numbers");
            System.out.println("2. Enter an array of numbers");
            System.out.println("3. Enter a range of numbers");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    System.out.print("Enter the list of numbers separated by spaces: ");
                    scanner.nextLine(); // Consume the new line character left over from nextInt()
                    String input1 = scanner.nextLine();
                    String[] numbers = input1.split(" ");
                    int[] intNumbers = new int[numbers.length];

                    for (int i = 0; i < numbers.length; i++) {
                        intNumbers[i] = Integer.parseInt(numbers[i]);
                    }

                    this.numbers = intNumbers;
                    break;

                case 2:
                    System.out.print("Enter the length of the array: ");
                    int length = scanner.nextInt();
                    int[] intArray = new int[length];
                    System.out.print("Enter the numbers separated by spaces: ");
                    for (int i = 0; i < length; i++) {
                        intArray[i] = scanner.nextInt();
                    }

                    this.numbers = intArray;
                    break;

                case 3:
                    System.out.print("Enter the value of m: ");
                    int m = scanner.nextInt();
                    System.out.print("Enter the value of n: ");
                    int n = scanner.nextInt();

                    this.m = m;
                    this.n = n;
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

            if (numbers != null) {
                for (int num : numbers) {
                    result.append("Divisors of ").append(num).append(": ");
                    for (int i = 1; i <= num; i++) {
                        if (num % i == 0) {
                            result.append(i).append(" ");
                        }
                    }
                    result.append("\n");
                }
            } else {
                for (int i = m; i <= n; i++) {
                    result.append("Divisors of ").append(i).append(": ");
                    for (int j = 1; j <= i; j++) {
                        if (i % j == 0) {
                            result.append(j).append(" ");
                        }
                    }
                    result.append("\n");
                }
            }
            System.out.println(result.toString());
            result.setLength(0);
        }
    }

    public static void main(String[] args) {
        Divisors divisors = new Divisors();
        divisors.getResult();
    }
}

//Для каждого натурального числа в промежутке от m до n вывести все делители.
// Числа следует вводить следующим образом: строка с некоторым разделителем; массив; список чисел (реализовать все три способа ввода).
