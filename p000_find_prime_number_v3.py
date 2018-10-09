#!/usr/bin/python3.6
# created by cicek on 09.10.2018 19:29

from math import ceil

prime_array = [2,]

def prime_numbers(x):

    for i in range(3, x):
        prime = 1
        for k in range(2, i):
            if (i % k == 0):
                prime = 0
                break

            if ((k > ceil(i/2))):
                break

        if (prime != 0):
            prime_array.append(i)

    print(prime_array)

value = int(input("Enter a number greater than 3: "))
prime_numbers(value)
