import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String...args) throws IOException {
        File inputFile = new File("src/testLittle.in");
        Scanner in = new Scanner(inputFile);
        int t = in.nextInt() ; //number of test cases
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = in.nextInt();
            long[] array = new long[n];
            boolean isZeros = false; // any element = 0
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
                if (array[i] == 0) isZeros = true;
            }
            if (isZeros) {
                System.out.println("yes");
                break;
            }

            boolean isSumEQZero = false;
            for (int firstElementNumber = 0; firstElementNumber < n - 1; firstElementNumber++) {
                long sum = array[firstElementNumber];
                for (int fENinSequence = firstElementNumber + 1; fENinSequence < n; fENinSequence++) {
                    sum += array[fENinSequence];
                    if (sum == 0) {
                        isSumEQZero = true;
                        break;
                    }
                }
                if (isSumEQZero) {
                    System.out.println("yes");
                    break;
                }
            }
            if (!isSumEQZero) System.out.println("no");
        }
    }
}
