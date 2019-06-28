package codility.exercises;

public class TapeEquilibrium {
    public static void main(String[] args) {
        int[] A = {100,-100,10,320,10,11,310};
        solution(A);
    }

    public static int solution(int[] A) {
        if (A.length == 2)
            return Math.abs(A[0]-A[1]);

        int [] s1 = new int[A.length-1];
        s1[0] = A[0];
        for (int i=1;i<A.length-1;i++) {
            s1[i] = s1[i-1] + A[i];
        }

        int [] s2 = new int[A.length-1];
        s2[A.length-2] = A[A.length-1];
        for (int i=A.length-3;i>=0;i--) {
            s2[i] = s2[i+1] + A[i+1];
        }

        int finalSum = Integer.MAX_VALUE;
        for (int j=0;j<s1.length;j++) {
            int sum = Math.abs(s1[j]-s2[j]);
            if (sum < finalSum)
                finalSum = sum;
        }
        return finalSum;
    }
}

/** A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

 Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

 The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

 In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

 For example, consider array A such that:

 A[0] = 3
 A[1] = 1
 A[2] = 2
 A[3] = 4
 A[4] = 3
 We can split this tape in four places:

 P = 1, difference = |3 − 10| = 7
 P = 2, difference = |4 − 9| = 5
 P = 3, difference = |6 − 7| = 1
 P = 4, difference = |10 − 3| = 7
 Write a function:

 class Solution { public int solution(int[] A); }

 that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

 For example, given:

 A[0] = 3
 A[1] = 1
 A[2] = 2
 A[3] = 4
 A[4] = 3
 the function should return 1, as explained above.

 Write an efficient algorithm for the following assumptions:

 N is an integer within the range [2..100,000];
 each element of array A is an integer within the range [−1,000..1,000].
 Copyright 2009–2019 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */