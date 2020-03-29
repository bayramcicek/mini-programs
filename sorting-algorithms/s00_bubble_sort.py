#!/usr/bin/python3.6
# created by cicek on 10.03.2019 22:33

print("enter numbers: ")
bubbleList = [int(num) for num in input().split()]


def sortMyList(myList):
    length = len(myList)

    for i in range(length - 1):
        swap = False

        for j in range(length - 1 - i):
            if (myList[j] > myList[j + 1]):
                myList[j], myList[j + 1] = myList[j + 1], myList[j]
                swap = True

        if (not swap): break

    return myList

print(sortMyList(bubbleList))

"""
enter numbers: 
8 5 1 13 6 2
[1, 2, 5, 6, 8, 13]

Process finished with exit code 0
"""