/*import java.util.Arrays;
import java.util.Scanner;

public class DivisorsTaskDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the numbers separated by commas:");
        String input = scanner.nextLine();
        DivisorsTask task1 = new DivisorsTask(input, ",");
        System.out.println(task1.getResult());

        System.out.println("Enter the numbers separated by spaces:");
        input = scanner.nextLine();
        DivisorsTask task2 = new DivisorsTask(input, " ");
        System.out.println(task2.getResult());

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] inputArray = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            inputArray[i] = scanner.nextInt();
        }
        DivisorsTask task3 = new DivisorsTask(inputArray);
        System.out.println(task3.getResult());
    }
}
*/

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DivisorsServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started.");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                String className = (String) in.readObject();
                Class<?> clazz = Class.forName(className);
                DivisorsResult result = null;
                if (clazz == DivisorsResult.class) {
                    int m = (int) in.readObject();
                    int n = (int) in.readObject();
                    String separator = (String) in.readObject();
                    result = new DivisorsResult(m, n, separator);
                } else if (clazz == int[].class) {
                    int[] numbersArray = (int[]) in.readObject();
                    result = new DivisorsResult(numbersArray);
                } else if (clazz == java.util.List.class) {
                    java.util.List<Integer> numbersList = (java.util.List<Integer>) in.readObject();
                    result = new DivisorsResult(numbersList);
                }
                out.writeObject(result.getResult());
                System.out.println("Result sent.");
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
