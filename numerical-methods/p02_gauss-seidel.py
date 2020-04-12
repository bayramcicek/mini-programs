# 3*x1-0.1*x2-0.2*x3 = 7.85
# 0.1*x1+7*x2-0.3*x3 = -19.3
# 0.3*x1-0.2*x2+10*x3 = 71.4

# x1 = (7.85 +0.1*x2 + 0.2*x3)/3
# x2 = (-19.3 - 0.1*x1 + 0.3*x3)/7
# x3 = (71.4 - 0.3*x1 + 0.2*x2)/10

x2, x3 = 0, 0
counter = 0

for i in range(100):

    prevx2, prevx3 = x2, x3 # önceki değeri tutar

    x1 = (7.85 +0.1*x2 + 0.2*x3)/3
    prevx1 = x1
    x2 = (-19.3 - 0.1*x1 + 0.3*x3)/7
    x3 = (71.4 - 0.3*x1 + 0.2*x2)/10

    if (prevx1 == x1 and prevx2 == x2 and prevx3 == x3): # önceki değer aynıysa yazdır.
        print(counter)
        print(x1, x2, x3)
        exit(1)
    else:
        counter += 1
