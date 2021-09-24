import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Main {

    public static void main(String...args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("src/testLittle.in")));
        int numberOfTestCases = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            int numberOfIntsInTestCase = Integer.parseInt(br.readLine());
            long[] array = parseStringToArrayOfInts(br.readLine());

            if(isZerosInArray(array)) {
                System.out.println("yes");
                continue;
            }

            if (isSumEqualsZero(numberOfIntsInTestCase, array)) System.out.println("yes");
            else System.out.println("no");
        }
    }

    static boolean isZerosInArray(long[] array) {
        for (long i : array ) {
            if (i == 0) return true;
        }
        return false;
    }

    static long[] parseStringToArrayOfInts(String str) {
        String[] splitArray = str.split(" ");
        long[] array = new long[splitArray.length];
        for(int i=0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }

    static boolean isSumEqualsZero(int numberOfInts, long[] array) {
        for (int firstElementNumber = 0; firstElementNumber < numberOfInts - 1; firstElementNumber++) {
            long sum = array[firstElementNumber];
            for (int fENinSequence = firstElementNumber + 1; fENinSequence < numberOfInts; fENinSequence++) {
                sum += array[fENinSequence];
                if (sum == 0) return true;
            }
        }
        return false;
    }

}
