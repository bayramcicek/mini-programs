'''

  created by cicek on 07.07.2018 21:25

'''

try:
    firstNumber = int(input("enter first number: "))
    secondNumber = int(input("enter second number: "))
except:
        print("\nenter a positive number. Please try again!")
        exit(0)

if (firstNumber <= 0) or (secondNumber <= 0) :
    print("\nenter a positive value, please!")
    exit(0)

leastNumber = 0

# find least number
if (firstNumber < secondNumber):
    leastNumber = firstNumber
else:
    leastNumber = secondNumber

# find multiply
multiply = firstNumber*secondNumber

# create an array for firstNumber and secondNumber
firstNumberArray = []
secondNumberArray = []

# assign first values of numbers
addFirstNumber = firstNumber
addSecondNumber = secondNumber

# append multiples of firstNumber
while (addFirstNumber <= multiply):
    firstNumberArray.append(addFirstNumber)
    addFirstNumber += firstNumber

# append multiples of firstNumber
while (addSecondNumber <= multiply):
    secondNumberArray.append(addSecondNumber)
    addSecondNumber += secondNumber

# find LCM(x,y)
for i in firstNumberArray:
    if i in secondNumberArray:
        print("\nLCM(" + str(firstNumber) + "," + str(secondNumber) + ") = " + str(i))
        exit(1)
