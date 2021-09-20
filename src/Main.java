import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Main {

    static long[] method(String str) {
        int i;
        String[] splitArray = str.split(" ");
        long[] array = new long[splitArray.length];
        for(i=0;i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }

    public static void main(String...args) throws IOException {
        File inputFile = new File("src/test.in");
        FileReader fr = new FileReader(inputFile);
        BufferedReader br = new BufferedReader(fr);
        int t = Integer.parseInt(br.readLine()); //number of test cases
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            boolean isZerosInArray = false; // some element = 0
            String allTestCaseNumbers = br.readLine();
            long[] array = method(allTestCaseNumbers);
            for (int i = 0; i < n; i++) {
                if (array[i] == 0) {
                    isZerosInArray = true;
                    break;
                }
            }
            if (isZerosInArray) {
                System.out.println("yes");
                continue;
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
