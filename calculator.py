#!/usr/bin/python3
# created by cicek on Feb 01, 2020 21:00

# simple calculator

def addition(first, second):
    return first + second


def subtraction(first, second):
    return first - second


def multiplication(first, second):
    return first * second


def division(first, second):
    return first / second


try:
    decision = int(input("1 for addition\n"
                         "2 for subtraction\n"
                         "3 for multiplication\n"
                         "4 for division\n"
                         ": "))

    if (decision < 1) or (decision > 4):
        print("\nplease enter correct value!!!")
    else:
        first_input = int(input("\nenter first value: "))
        second_input = int(input("enter second value: "))

        if decision == 1:
            result = addition(first_input, second_input)
            print("result: {0}".format(result))
        elif decision == 2:
            result = subtraction(first_input, second_input)
            print("result: {0}".format(result))
        elif decision == 3:
            result = multiplication(first_input, second_input)
            print("result: {0}".format(result))
        else:
            result = division(first_input, second_input)
            print("result: {0}".format(result))

except:
    print("\nplease enter correct value!!!")
