# 1729
# 1+7+2+9= 19
# 19 * 91 = 1729

ramanujan = []
for n in range(1000,10000): # you can change the range to whatever you want
    top = 0
    for i in list(str(n)):
        top +=int(i)
    if(top<10):
        continue

    # reverse number (exp: 19 --> 91)
    reverseTop = int( list(str(top))[-1] + list(str(top))[-2] )
    if(top*reverseTop == n):
        ramanujan.append(n)

print(ramanujan)
