package peuler;

import java.util.ArrayList;

/**
 * created by cicek on 06.03.2019 21:38
 */

public class e011_largest_product {
    public static void main(String[] args) {

        int sumRightLeft = 1;
        int sumUpDown = 1;
        int sumRightDiagonal = 1;
        int sumLeftDiagonal = 1;

        int temp = 1;
        int res = 1;

        ArrayList<Integer> answer = new ArrayList<Integer>();

        int[][] productArray = {{8, 2, 22, 97, 38, 15, 00, 40, 00, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8,}, /*0*/
                {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 00,}, /*1*/
                {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65,}, /*2*/
                {52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91,},   /*3*/
                {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80,},/*4*/
                {24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50,},  /*5*/
                {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70,},/*6*/
                {67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21,},  /*7*/
                {24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72,}, /*8*/
                {21, 36, 23, 9, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33, 97, 34, 31, 33, 95,}, /*9*/
                {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92,},   /*10*/
                {16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57,}, /*11*/
                {86, 56, 00, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58,},  /*12*/
                {19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40,},  /*13*/
                {04, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66,},  /*14*/
                {88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69,}, /*15*/
                {04, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36,}, /*16*/
                {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16,}, /*17*/
                {20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54,},  /*18*/
                {01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48,}, /*19*/


        };

        // sumRightLeft
        for (int row = 0; row < productArray.length; row++) {
            for (int column = 0; column < (productArray[row].length - 3); column++) {
                for (int limit = 0; limit < 4; limit++) {
//                    System.out.printf("%d ", productArray[row][column + limit]);
                    sumRightLeft *= (productArray[row][column + limit]);

                }
//                System.out.printf("\n");
//                System.out.printf(": %d\n", sumRightLeft);
                if (sumRightLeft > temp) {
                    res = sumRightLeft;
                    temp = sumRightLeft;

                }

                sumRightLeft = 1;
            }
        }

        System.out.printf("res sumRightLeft: %12d\n", res);
        answer.add(res);
        res = 1;
        temp = 1;

        // sumUpDown
        for (int row = 0; row < productArray.length - 3; row++) {
            for (int column = 0; column < (productArray[row].length); column++) {
                for (int limit = 0; limit < 4; limit++) {
//                    System.out.printf("%d ", productArray[row + limit][column]);
                    sumUpDown *= (productArray[row + limit][column]);

                }
//                System.out.printf("\n");
//                System.out.printf(": %d\n", sumUpDown);
                if (sumUpDown > temp) {
                    res = sumUpDown;
                    temp = sumUpDown;

                }

                sumUpDown = 1;
            }
        }

        System.out.printf("res sumUpDown: %15d\n", res);
        answer.add(res);
        res = 1;
        temp = 1;

        // sumRightDiagonal
        for (int row = 0; row < productArray.length - 3; row++) {
            for (int column = 0; column < (productArray[row].length - 3); column++) {
                for (int limit = 0; limit < 4; limit++) {
//                    System.out.printf("%d ", productArray[row + limit][column + limit]);
                    sumRightDiagonal *= (productArray[row + limit][column + limit]);

                }
//                System.out.printf("\n");
//                System.out.printf(": %d\n", sumRightDiagonal);
                if (sumRightDiagonal > temp) {
                    res = sumRightDiagonal;
                    temp = sumRightDiagonal;

                }

                sumRightDiagonal = 1;
            }
        }

        System.out.printf("res sumRightDiagonal: %d\n", res);
        answer.add(res);
        res = 1;
        temp = 1;

        // sumLeftDiagonal
        for (int row = 0; row < productArray.length - 3; row++) {
            for (int column = 3; column < (productArray[row].length); column++) {
                for (int limit = 0; limit < 4; limit++) {
//                    System.out.printf("%d ", productArray[row + limit][column - limit]);
                    sumLeftDiagonal *= (productArray[row + limit][column - limit]);

                }
//                System.out.printf("\n");
//                System.out.printf(": %d\n", sumLeftDiagonal);
                if (sumLeftDiagonal > temp) {
                    res = sumLeftDiagonal;
                    temp = sumLeftDiagonal;

                }

                sumLeftDiagonal = 1;
            }
        }

        System.out.printf("res sumLeftDiagonal: %9d\n", res);
        answer.add(res);

        System.out.printf("" + answer + "\n");
        int cevap = 1;
        for (int a: answer
             ) {
            if (a > cevap){
                cevap = a;
            }
        }

        System.out.printf("cevap : %d", cevap);


    } // main
}

/*
res sumRightLeft:     48477312
res sumUpDown:        51267216
res sumRightDiagonal: 40304286
res sumLeftDiagonal:  70600674
[48477312, 51267216, 40304286, 70600674]
cevap : 70600674
Process finished with exit code 0
 */

/*
8,  2, 22, 97, 38, 15, 00, 40, 00, 75,  4,  5,  7, 78, 52, 12, 50, 77, 91,  8,  // 0
49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48,  4, 56, 62, 00, // 1
81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30,  3, 49, 13, 36, 65, // 2
52, 70, 95, 23,  4, 60, 11, 42, 69, 24, 68, 56,  1, 32, 56, 71, 37,  2, 36, 91, // 3
22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80, // 4
24, 47, 32, 60, 99,  3, 45,  2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50, // 5
32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70, // 6
67, 26, 20, 68,  2, 62, 12, 20, 95, 63, 94, 39, 63,  8, 40, 91, 66, 49, 94, 21, // 7
24, 55, 58,  5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72, // 8
21, 36, 23,  9, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33, 97, 34, 31, 33, 95, // 9
78, 17, 53, 28, 22, 75, 31, 67, 15, 94,  3, 80,  4, 62, 16, 14,  9, 53, 56, 92, // 10
16, 39,  5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54, 24, 36, 29, 85, 57, // 11
86, 56, 00, 48, 35, 71, 89,  7,  5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58, // 12
19, 80, 81, 68,  5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77,  4, 89, 55, 40, // 13
4, 52,  8, 83, 97, 35, 99, 16,  7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66,  // 14
88, 36, 68, 87, 57, 62, 20, 72,  3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69, // 15
4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18,  8, 46, 29, 32, 40, 62, 76, 36,  // 16
20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74,  4, 36, 16, // 17
20, 73, 35, 29, 78, 31, 90,  1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57,  5, 54, // 18
1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52,  1, 89, 19, 67, 48,  // 19

 */
