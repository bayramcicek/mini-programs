'''
/**
 * created by cicek on 24.06.2018 01:08
 */
'''
input1 = int(input("enter a (positive)number to find whether it is a prime number or not? : "))
primeArray = [2]
for i in range(3,(input1+1)):

    prime = 1

    for k in range(2,i):
        if i % k == 0:
            prime = 0

    if prime != 0:
        primeArray.append(i)
if input1 in primeArray:
    print(str(input1) + " is a prime number")
else:
    print(str(input1) + " is not a prime number")
