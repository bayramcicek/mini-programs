# 6*x1 - 2*x2 + x3 = 11
# x1 + 2*x2 -5*x3 = -1
# -2*x1 + 7*x2 + 2*x3 = 5

# jacobi iterasyonu

x1,x2,x3 = 50,50,50
calculator = 0

for i in range(100):

    prevx1, prevx2, prevx3 = x1, x2, x3 # x'lerin bir önceki değerini tutar

    x1, x2, x3 = 11/6 + 1/3*x2 - 1/6*x3, 5/7 + 2/7*x1 - 2/7*x3, 1/5 + 1/5*x1 + 2/5*x2

    if (prevx1 == x1 and prevx2 == x2 and prevx3 == x3): # x'ler önceki değerine eşit ise program bitsin
        print(calculator)
        print(x1, x2, x3)
        exit(1)
    else:
        calculator += 1