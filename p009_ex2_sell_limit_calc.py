#!/usr/bin/python3.6
# created by cicek on 01.01.2019 01:57

def percentage(buy, perc):
    return buy*(perc/100) + buy

while(True):
    buy = float(input("alınan seviye: "))
    if buy == -1: exit(0)

    perc = float(input("yüzde kaç kar: %"))
    print("minimum satış limiti: ", percentage(buy, perc))
    print("")

# alınan seviye: 100
# yüzde kaç kar: %50
# minimum satış limiti:  150.0
#
# alınan seviye: 80
# yüzde kaç kar: %26
# minimum satış limiti:  100.8
#
# alınan seviye: