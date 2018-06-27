a = input("enter a number that will divided by 2:  ")

try:
    print(2/int(a))
except ZeroDivisionError:
    print("ZeroDivisionError error")
except ValueError:
    print("ValueError error")
except :
    print("unexpected error")

else:
    print("Process finished")
finally:
    print("END")
