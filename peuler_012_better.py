#!/usr/bin/python3
import math


class Solution:
    @staticmethod
    def number_of_factor(self):
        count = 0
        if self == 1:
            return 1

        for i in range(1, math.ceil(math.sqrt(self))):
            if self % i == 0:
                count += 2

        if math.ceil(math.sqrt(self)) == math.floor(math.sqrt(self)):
            count += 1

        return count


test = Solution
triangle_arr = [0]
temp, box, curr_num = 0, 0, 0

for i in range(1, 1001):
    while temp <= i:
        box += 1
        curr_num = (box * (box + 1)) / 2
        temp = test.number_of_factor(curr_num)
    triangle_arr.append(curr_num)
    print(curr_num)

# number_test = int(input())
#
# limit_list = []
# for a in range(number_test):
#     limit_list.append(int(input()))
#
# for limit in limit_list:
#     print(int(triangle_arr[limit]))
