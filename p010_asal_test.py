#!/usr/bin/python3.6
# created by cicek on 27.03.2019 18:06

import random

n = int(input("test edilecek sayıyı gir: "))

for i in range(10):
    a = random.randint(1,n)

    sonuc = (a**((n-1)/2)) % n

    if (sonuc == 1 or sonuc == -1):
        print(a, "asal değil")
        break
    else:
        print(a, "%50 ve yukarı ihtimalle asal olabilir")

"""
test edilecek sayıyı gir: 19
12 %50 ve yukarı ihtimalle asal olabilir
12 %50 ve yukarı ihtimalle asal olabilir
5 asal değil

Process finished with exit code 0
"""
