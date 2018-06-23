for i in range(3,100): # between 3 and 100 - you can change these numbers

    prime = 1

    for k in range(2,i):
        if i % k == 0:
            prime = 0

    if prime != 0:
        print(i)
