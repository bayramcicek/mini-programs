#!/usr/bin/python3.6
# created by cicek on 19.03.2019 00:17

import math

print("Enter numbers: ")
unsortedList = [int(item) for item in input().split()]

"""6 14 45 78 18 47 53 83 91 81 77 84 99 64 42"""
print("unsorted list:\n" + str(unsortedList) + "\n")


# def findMyParent(a: int):
#     if (unsortedList.index(a) == 0):
#         print("root")
#         exit(0)
#     else:
#         parentIndex = math.floor((unsortedList.index(a) + 1) / 2)
#         parent = unsortedList[parentIndex - 1]
#         print(parent)


def heapify(unsortedList, index, size):
    min = index
    left_index = index * 2 + 1
    right_index = index * 2 + 2

    if ((left_index < size) and unsortedList[left_index] < unsortedList[min]):
        min = left_index

    if ((right_index < size) and unsortedList[right_index] < unsortedList[min]):
        min = right_index

    if (min != index):
        unsortedList[min], unsortedList[index] = unsortedList[index], unsortedList[min]
        heapify(unsortedList, min, size)


sortedList = list() # []


def heapSort(unsortedList):
    n = len(unsortedList)
    for i in range(n // 2 - 1, -1, -1):
        heapify(unsortedList, i, n)

    for i in range(n - 1, -1, -1):
        sortedList.append(unsortedList[0])
        print(sortedList)

        unsortedList[0], unsortedList[i] = unsortedList[i], unsortedList[0]
        heapify(unsortedList, 0, i)

    return sortedList


print("\nsorted list:\n" + str(heapSort(unsortedList)))

"""
Enter numbers: 
6 14 45 78 18 47 53 83 91 81 77 84 99 64 42
unsorted list:
[6, 14, 45, 78, 18, 47, 53, 83, 91, 81, 77, 84, 99, 64, 42]

[6]
[6, 14]
[6, 14, 18]
[6, 14, 18, 42]
[6, 14, 18, 42, 45]
[6, 14, 18, 42, 45, 47]
[6, 14, 18, 42, 45, 47, 53]
[6, 14, 18, 42, 45, 47, 53, 64]
[6, 14, 18, 42, 45, 47, 53, 64, 77]
[6, 14, 18, 42, 45, 47, 53, 64, 77, 78]
[6, 14, 18, 42, 45, 47, 53, 64, 77, 78, 81]
[6, 14, 18, 42, 45, 47, 53, 64, 77, 78, 81, 83]
[6, 14, 18, 42, 45, 47, 53, 64, 77, 78, 81, 83, 84]
[6, 14, 18, 42, 45, 47, 53, 64, 77, 78, 81, 83, 84, 91]
[6, 14, 18, 42, 45, 47, 53, 64, 77, 78, 81, 83, 84, 91, 99]

sorted list:
[6, 14, 18, 42, 45, 47, 53, 64, 77, 78, 81, 83, 84, 91, 99]

Process finished with exit code 0
"""
