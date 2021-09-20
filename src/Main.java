import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String...args) throws IOException {
        File inputFile = new File("src/testLittle.in");
        Scanner in = new Scanner(inputFile);
//        Scanner in = new Scanner(System.in);
        int t = in.nextInt() ; //number of test cases
//        System.out.println("t = " + t);
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = in.nextInt();
            //System.out.println("n = " + n);
            int[] array = new int[n];

            boolean isZeros = false; // any element = 0
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
                if (array[i] == 0) {
                    isZeros = true;
                    break;
                }
                //System.out.println("   i = " + i + " " + array[i]);
            }
            if (isZeros) {
                System.out.println("yes");
                break;
            }

            boolean isTrue = false;
            for (int firstElementNumber = 0; firstElementNumber < n - 1; firstElementNumber++) {

                int sum = array[firstElementNumber];
                //System.out.println(" sum = " + sum);
                for (int fENinSequence = firstElementNumber + 1; fENinSequence < n; fENinSequence++) {
                    sum += array[fENinSequence];
                    //System.out.println("--- sum = " + sum);
                    if (sum == 0) {
                        isTrue = true;
                        break;
                    }
                }
                if (isTrue) {
                    System.out.println("yes");
                    break;
                }
            }
            if (!isTrue) System.out.println("no");
        }
    }
}
