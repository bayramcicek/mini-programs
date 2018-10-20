#!/usr/bin/python3.6
# created by cicek on 20.10.2018 18:50

print(2)
for i in range(3, 100, 2):  # between 3 and 100 - you can change these numbers

    prime = 1

    for k in range(2, i):
        if i % k == 0:
            prime = 0
            break

        elif (k > (i / 2)):
            break

    if prime != 0:
        print(i)