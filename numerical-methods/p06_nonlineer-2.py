'''
/**
 * created by cicek on 09.04.2018 21:07
 */
'''

from math import *

#def f(x,y):
#    return(x**2+x*y-10)
#def g(x,y):
#    return(y+3*x*y**2-57)

xi = float(input("x için başlangıç değerini girin: ")) # küçük sayı girin yoksa math domain hatası alırsınız
yi = float(input("y için başlangıç değerini girin: "))

sayac=0

for n in range(100):

    prevx = xi
    prevy = yi

    xi = sqrt(10-xi*yi)
    yi = sqrt((57-yi)/(3*xi))

    if (prevx == xi and prevy == yi):
        print(xi,yi)
        print("kaçıncı denemede bulduk: " + str(sayac) + ". deneme")
        exit(1)
    else:
        sayac += 1