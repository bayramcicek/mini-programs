#!/usr/bin/python3.6
# created by cicek on 04.10.2018 23:41

from math import floor

number = int(input("enter a number greater than 3: "))
print("your number is: {0}".format(number))

if (number <= 3):
    print("please enter a number greater than 3")
    exit(0)

def prime_factor(num):

    i = 2
    prime_list = []

    num_1 = floor(num/i)

    while (i <= num_1):
        if (num % i == 0):
            prime_list.append(i)
            num /= i
            if (num == 1):
                break
        else:
            i += 1


    return prime_list

result = prime_factor(number)

print("The prime factors of", number, "\b:", result)
print("The largest prime factors of", number, "\b:", result[-1])

