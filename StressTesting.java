import java.util.Random;

public class Stress_testing {
    private static Random random = new Random();

    static int[] Algorithm1(int param[]) {
        //Slower algorithm here
        return param;
    }

    static int[] Algorithm2(int param[]) {
        //Faster Algorithm here
        return param;
    }

    public static void main(String[] args) {
        long totalChange = 0;
        long totalIterations = 0;
        while (true) {
            System.out.println("\n---------------------------------------------------------------------------------------");
            int n = (int) (Math.random() * 20);

            //Generate random input test values
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                int tmp = (int) (Math.random() * 1000);
                arr1[i] = tmp;
                arr2[i] = tmp;
            }

            //Print generated input
            for (int j : arr1) System.out.print(j + " ");
            System.out.println("");

            //Running Algorithm 1
            long t1 = System.nanoTime();
            int[] res1 = Algorithm1(arr1);
            long t2 = System.nanoTime();
            long timeTaken1 = (t2 - t1) / 1000;

            //Running Algorithm 2
            long t3 = System.nanoTime();
            int[] res2 = Algorithm2(arr2);
            long t4 = System.nanoTime();
            long timeTaken2 = (t4 - t3) / 1000;

            //Checking if result is same
            boolean same = true;
            for (int i = 0; i < n; i++) {
                if (arr1[i] != arr2[i]) {
                    same = false;
                    break;
                }
            }

            //Printing final output
            if (!same) {
                System.out.println("BREAK");
                System.out.println("res1 (faster) : ");
                for (int j : arr1) System.out.print(j + " ");

                System.out.println("");
                System.out.println("res2 (slower) : ");
                for (int j : arr2) System.out.print(j + " ");
                break;
            } else {
                System.out.println("OK");
                System.out.println("result : ");
                for (int j : arr1) System.out.print(j + " ");
                System.out.println("");
                System.out.println("Algo 1 time : " + timeTaken1 + "µs");
                System.out.println("Algo 2 time : " + timeTaken2 + "µs");
                System.out.println((timeTaken2 - timeTaken1) * 100 / timeTaken2 + "% faster");

                totalChange += (timeTaken2 - timeTaken1) * 100 / timeTaken2;
                totalIterations++;
                System.out.println("AVERAGE CHANGE : " + totalChange / totalIterations + "% faster");
            }
        }

    }
}


