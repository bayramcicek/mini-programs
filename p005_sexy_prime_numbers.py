# http://www.wiki-zero.com/index.php?q=aHR0cHM6Ly9lbi53aWtpcGVkaWEub3JnL3dpa2kvU2V4eV9wcmltZQ

# sexy numbers up to the number entered
limit = int(input("enter a number limit: "))

# control
if (limit <= 2):
    print("none")
    exit(0)

# created a sexyPrime array
sexyPrime=[]

# append all prime numbers to sexyPrime array that up to given number limit
for i in range(3,limit):
    prime = 1

    for k in range(2,i):
        if i % k == 0:
            prime = 0
    if prime == 1:
        sexyPrime.append(i)

# print sexy prime numbers whose difference is 6
for x in sexyPrime:
    if ( (sexyPrime.count(x+6)) == 1 ):
        print(str(x),str(x+6))
