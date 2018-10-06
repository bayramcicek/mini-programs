#!/usr/bin/python3.6
# created by cicek on 06.10.2018 17:04

result = []

for i in range(100, 1000):
    for d in range(100, 1000):
        product = i*d
        strProduct = list(str(product))

        copyProduct = strProduct.copy()
        strProduct.reverse()

        if(strProduct == copyProduct):
            result.append(product)

result.sort()
print(result[-1])
