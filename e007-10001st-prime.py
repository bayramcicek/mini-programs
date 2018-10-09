#!/usr/bin/python3.6
# created by cicek on 09.10.2018 20:16

prime_array = [2,]

def prime_numbers(limit):

    i, k, counter = 3, 2, 1

    while (counter != limit):
        prime = 1
        while True:
            if (i % k == 0):
                prime = 0
                break

            elif (k > (i/2)):
                break

            k += 1

        if (prime != 0):

            prime_array.append(i)
            del prime_array[0]
            counter += 1

        i += 1
        k = 2

    print(prime_array)

limit = int(input("What is the (X)st prime number?\nplease enter X: "))

if (limit == 1):
    print(2)
    exit(0)

prime_numbers(limit)

'''
output:

What is the (X)st prime number?
please enter X: 10001
[104743]

'''
