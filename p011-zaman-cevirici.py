#!/usr/bin/python3.6
# created by cicek on 23.03.2019 14:00

def timeConversion(s):

    time = s.split(":", 3)
    # print(time)

    if "AM" in time[2][2:4]:
        # print("yes AM")

        strTime = ":".join(time)
        strTime1 = strTime.rpartition("A")
        if "12" in strTime1[0][0:2]:
            return ("00" + str(strTime1[0][2::]))
        else:
            return (str(strTime1[0]))

    if "PM" in time[2][2:4]:
        # print("\nyes PM")

        strTime = ":".join(time)
        strTime1 = strTime.rpartition("P")
        # print(strTime1[0])

        if ("0" in time[0][0]):
            # print("evet")
            zero = [int(item) for item in strTime1[0][1:2]]
            return (str(zero[0] + 12) + strTime1[0][2::])
        else:
            # print("else PM")
            zero = [int(item) for item in strTime1[0][1]]
            # print(str(zero[0] + 22) , end="")
            # print(strTime1[0][2::])
            if (zero[0] == 2):
                return (strTime1[0])
            else:
                return (str(zero[0] + 22) + strTime1[0][2::])



print("gir: ", end="")
input = input()
print(timeConversion(input))

"""
#!/bin/python3

import os
import sys

#
# Complete the timeConversion function below.
#

def timeConversion(s):

    time = s.split(":", 3)
    # print(time)

    if "AM" in time[2][2:4]:
        # print("yes AM")

        strTime = ":".join(time)
        strTime1 = strTime.rpartition("A")
        if "12" in strTime1[0][0:2]:
            return ("00" + str(strTime1[0][2::]))
        else:
            return (str(strTime1[0]))

    if "PM" in time[2][2:4]:
        # print("\nyes PM")

        strTime = ":".join(time)
        strTime1 = strTime.rpartition("P")
        # print(strTime1[0])

        if ("0" in time[0][0]):
            # print("evet")
            zero = [int(item) for item in strTime1[0][1:2]]
            return (str(zero[0] + 12) + strTime1[0][2::])
        else:
            # print("else PM")
            zero = [int(item) for item in strTime1[0][1]]
            # print(str(zero[0] + 22) , end="")
            # print(strTime1[0][2::])
            if (zero[0] == 2):
                return (strTime1[0])
            else:
                return (str(zero[0] + 22) + strTime1[0][2::])

if __name__ == '__main__':
    f = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = timeConversion(s)

    f.write(result + '\n')

    f.close()

"""