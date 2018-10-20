#!/usr/bin/python3.6
# created by cicek on 20.10.2018 07:38

import math

for a in range(1, 1001):
    for b in range(1, 1001):
        if (a < b):
            if ( (b < math.sqrt((a**2 + b**2))) and (a + b + math.sqrt((a**2 + b**2)) == 1000) ):
                print("a{0}**2 + b{1}**2 = c{2}**2".format(a, b, math.sqrt((a**2 + b**2))))
                print(a * b * math.sqrt((a**2 + b**2)))
        else:
            continue

# a200**2 + b375**2 = c425.0**2
# 31875000.0
