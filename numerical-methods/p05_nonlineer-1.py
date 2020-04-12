'''
/**
 * created by cicek on 09.04.2018 21:07
 */
'''

from math import e

def f(x,y):
    return(4-x**2-y**2)
def g(x,y):
    return(1-e**x-y)
def fx(x,y):
    return(-2*x)
def fy(x,y):
    return(-2*y)
def gx(x,y):
    return(-e**x)
def gy(x,y):
    return(-1)

xi = float(input("x için başlangıç değerini girin: "))
yi = float(input("y için başlangıç değerini girin: "))

# for n in range(100):
sayac = 0
while (1 == 1):
    prevx = xi
    prevy = yi

    deltayi = (-f(xi,yi)*gx(xi,yi)+fx(xi,yi)*g(xi,yi))/(gx(xi,yi)*fy(xi,yi)-fx(xi,yi)*gy(xi,yi))
    deltaxi = (-f(xi,yi)-fy(xi,yi)*deltayi)/fx(xi,yi)

    xi = xi + deltaxi
    yi = yi + deltayi

    if (prevx == xi and prevy == yi):
        print(xi,yi)
        print(sayac)
        exit(1)
    else:
        sayac += 1