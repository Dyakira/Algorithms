package test;

import java.util.HashMap;

/**
 * Created by Dyakira on 2016/5/12.
 */
public class PrimesTest {


    //判断是否为素数
    public static boolean isPrime(int num) {
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {// 若能被整除，则说明不是素数，返回false
                isPrime = false;
                break;// 跳出循环
            }
        }
        return isPrime;
    }


    //digits sums
    public static int getDigitsSums(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        int fristPrime = 2;
        //循环100内的整数,并判断是否素数
        for (int i = 1000000; i <= 1000000000; i++) {
            if (isPrime(i) && isPrime(getDigitsSums(i))) {
                if (fristPrime != 2) {
                    System.out.println("result:" + fristPrime + i);
                    return;
                }
                fristPrime = i;
            }
        }

    }


    public static long primeSum(final int range) {
        int i, k;
        HashMap<Integer, Long> S = new HashMap<Integer, Long>();
        int r = (int) Math.sqrt(range);
        int p = range / r;
        int[] V = new int[r + p - 1];
        k = r + 1;
        for (i = 1; i < k; i++) {
            V[i - 1] = range / i;
        }
        int count = 1;
        for (i = r + p - 2; i >= r; i--) {
            V[i] = count++;
        }
        // ArrayUtils.printArray(V);
        for (i = 0; i < V.length; i++) {
            S.put(V[i], ((long) V[i] * (V[i] + 1) / 2 - 1));
        }
        // System.out.println(S);
        Long sp, p2;
        for (p = 2; p < r + 1; p++) {
            if (S.get(p) > S.get(p - 1)) {
                sp = S.get(p - 1);
                p2 = (long) (p * p);
                for (i = 0; i < V.length; i++) {
                    if (V[i] < p2) {
                        break;
                    }
                    S.put(V[i], S.get(V[i]) - p * (S.get(V[i] / p) - sp));
                }
            }
        }

        return S.get(range);
    }

}
