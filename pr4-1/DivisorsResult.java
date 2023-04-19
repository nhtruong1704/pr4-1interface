/*import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DivisorsTask implements Result {
    private List<Integer> numbers;

    // Constructor overloads
    public DivisorsTask(String input, String separator) {
        this.numbers = Arrays.stream(input.split(separator))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public DivisorsTask(int[] inputArray) {
        this.numbers = Arrays.stream(inputArray)
                .boxed()
                .collect(Collectors.toList());
    }

    public DivisorsTask(List<Integer> inputList) {
        this.numbers = inputList;
    }

    @Override
    public String getResult() {
        StringBuilder result = new StringBuilder();

        for (Integer number : numbers) {
            result.append("Divisors of ").append(number).append(": ");
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    result.append(i).append(" ");
                }
            }
            result.append("\n");
        }

        return result.toString();
    }
}
*/


import java.util.ArrayList;
import java.util.List;

public class DivisorsResult implements Result {
    private int m;
    private int n;
    private String separator;
    private int[] numbersArray;
    private List<Integer> numbersList;

    public DivisorsResult(int m, int n, String separator) {
        this.m = m;
        this.n = n;
        this.separator = separator;
        parseInputString(null);
    }

    public DivisorsResult(int[] numbersArray) {
        this.numbersArray = numbersArray;
        parseInputArray(null);
    }

    public DivisorsResult(List<Integer> numbersList) {
        this.numbersList = numbersList;
        parseInputList(null);
    }

    private void parseInputString(String inputString) {
        if (inputString == null) {
            return;
        }
        String[] parts = inputString.split(separator);
        m = Integer.parseInt(parts[0]);
        n = Integer.parseInt(parts[1]);
    }

    private void parseInputArray(int[] numbersArray) {
        if (numbersArray == null) {
            return;
        }
        this.numbersArray = numbersArray;
    }

    private void parseInputList(List<Integer> numbersList) {
        if (numbersList == null) {
            return;
        }
        this.numbersList = numbersList;
    }

    private List<Integer> getDivisors(int number) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    private String joinDivisors(List<Integer> divisors) {
        StringBuilder sb = new StringBuilder();
        for (Integer divisor : divisors) {
            sb.append(divisor).append(" ");
        }
        return sb.toString().trim();
    }

    @Override
    public String getResult() {
        StringBuilder sb = new StringBuilder();
        if (numbersArray != null) {
            for (int number : numbersArray) {
                List<Integer> divisors = getDivisors(number);
                sb.append(joinDivisors(divisors)).append("\n");
            }
        } else if (numbersList != null) {
            for (int number : numbersList) {
                List<Integer> divisors = getDivisors(number);
                sb.append(joinDivisors(divisors)).append("\n");
            }
        } else {
            for (int number = m; number <= n; number++) {
                List<Integer> divisors = getDivisors(number);
                sb.append(joinDivisors(divisors)).append("\n");
            }
        }
        return sb.toString().trim();
    }
}
