# find fibonacci numbers

typeValue = int(input("enter a number border (it will print till number that you'll write): "))
a, b = 0, 1
while b < typeValue:
    print(b,end="\n") # go to bottom row per number
    a, b = b, a+b
