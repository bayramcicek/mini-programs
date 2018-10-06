CiftTop = 0
n , fib , fib1 , fib2 = 4000000 , 0 , 1 , 1

while(fib <=n): 
    if(fib % 2 == 0):
        CiftTop = CiftTop + fib

    fib = fib1 + fib2
    fib1 = fib2
    fib2 = fib

print(CiftTop)
