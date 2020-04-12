'''
/**
 * created by cicek on 06.06.2018 02:55
 */
'''

def f(x):
    return(x**2+2)

a, b = 1, 2
n = 1024

integral1 = 0
integral2 = 0
integral3 = 0

h = (b-a)/n

for i in range(n):
    integral1 += f(a+ i*h)*h

for i in range(1, n+1):
    integral2 += f(a+ i*h)*h

for i in range(1, 2*n, 2):
    integral3 += f(a+ i*h /2)*h

print(integral1, integral2, integral3)
for a in range(1,3,2):
    print(a)
