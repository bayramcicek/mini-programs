#!/usr/bin/python3.6
# created by cicek on 19.12.2018 21:21

def percentage(buy, target):
    return (100*target)/buy-100

while(True):
    buy = float(input("alınan: "))
    if buy == -1: exit(0)

    target = float(input("hedef satış: "))
    print("%{0} kar".format(percentage(buy, target)))
    print("")

# alınan: 50
# hedef satış: 75
# %50.0 kar
#
# alınan: 100
# hedef satış: 110
# %10.0 kar
#
# alınan: