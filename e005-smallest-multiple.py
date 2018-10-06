#!/usr/bin/python3.6
# created by cicek on 06.10.2018 18:13

number = 2000

while True:
    counter = 0

    for i in range(1,21):
        if (number % i == 0):
            counter += 1

    if (counter == 20):
        print(number)
        exit(0)
    else:
        number += 20

# 232792560