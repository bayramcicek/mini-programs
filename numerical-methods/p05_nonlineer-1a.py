'''
/**
 * created by cicek on 13.04.2018 10:03
 */
'''

# 3*(x**2) - y**2 = 8
# 8*(x**3) - 24*x = 1   problem kaç iterasyon sonrasında çözülür

from math import e

def f(x,y):
    return 3 * (x ** 2) - y ** 2 - 8
def g(x,y):
    return 8*(x**3) - 24*x - 1
def fx(x,y):
    return 6*x
def fy(x,y):
    return -2*y
def gx(x,y):
    return 3*(y**2) - 3*(x**2)
def gy(x,y):
    return 6*x*y

xi = float(input("xi sayısını gir: "))
yi = float(input("yi sayısını gir: "))

for z in range(100):
    deltayi = (fx(xi,yi)*g(xi,yi) - gx(xi,yi)*f(xi,yi)) / (fx(xi,yi)*gy(xi,yi) - fy(xi,yi)*gx(xi,yi))
    deltaxi = (f(xi,yi) - fy(xi,yi)*deltayi) / fx(xi,yi)

    xi += deltaxi
    yi += deltayi

    print(xi , yi)