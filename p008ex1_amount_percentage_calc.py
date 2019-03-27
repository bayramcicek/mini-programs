#!/usr/bin/python3.6
# created by cicek on 01.01.2019 01:54

def percentage(amount, target):
    return amount*(target/100)

while(True):
    amount = float(input("miktar: "))
    if amount == -1: exit(0)

    target = float(input("miktarın yüzde kaçı: %"))
    print("sonuç: ", percentage(amount, target))
    print("")

# miktar: 100
# miktarın yüzde kaçı: %70
# sonuç:  70.0
#
# miktar: 56
# miktarın yüzde kaçı: %12
# sonuç:  6.72
#
# miktar: