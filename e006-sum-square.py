#!/usr/bin/python3.6
# created by cicek on 08.10.2018 21:21

def difference(x):

    sum_of_square, square_of_sum, sum = 0, 0, 0

    for i in range(1, (x+1)):
        sum += i
        sum_of_square += i**2


    square_of_sum = sum**2
    print("The square of the sum of the first {0} natural numbers: {1}".format(x, square_of_sum))
    print("The sum of the squares of the first {0} natural numbers: {1}".format(x, sum_of_square))
    print("Difference:", square_of_sum - sum_of_square)



input = int(input("Enter a natural number: "))
difference(input)
