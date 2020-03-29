#!/usr/bin/python3.6
# created by cicek on 21.03.2019 18:09

print("Enter list: ")
# unsortedList = input().split() # string
unsortedList = [int(num) for num in input().split()]  # integer
"""90 42 45 2 18 47 6 99 23 11"""
print("unsorted list:\n" + str(unsortedList) + "\n")


# if len(unsortedList) == 1:
#     print(unsortedList)


def sortMeInsertion(unsortedList):
    size = len(unsortedList)

    for index in range(1, size):
        while (index > 0 and unsortedList[index - 1] > unsortedList[index]):
            unsortedList[index - 1], unsortedList[index] = unsortedList[index], unsortedList[index - 1]
            index -= 1
        print(unsortedList)
    return unsortedList


print("\nsorted list:\n" + str(sortMeInsertion(unsortedList)))

"""
Enter list: 
90 42 45 2 18 47 6 99 23 11
unsorted list:
[90, 42, 45, 2, 18, 47, 6, 99, 23, 11]

[42, 90, 45, 2, 18, 47, 6, 99, 23, 11]
[42, 45, 90, 2, 18, 47, 6, 99, 23, 11]
[2, 42, 45, 90, 18, 47, 6, 99, 23, 11]
[2, 18, 42, 45, 90, 47, 6, 99, 23, 11]
[2, 18, 42, 45, 47, 90, 6, 99, 23, 11]
[2, 6, 18, 42, 45, 47, 90, 99, 23, 11]
[2, 6, 18, 42, 45, 47, 90, 99, 23, 11]
[2, 6, 18, 23, 42, 45, 47, 90, 99, 11]
[2, 6, 11, 18, 23, 42, 45, 47, 90, 99]

sorted list:
[2, 6, 11, 18, 23, 42, 45, 47, 90, 99]

Process finished with exit code 0
"""
