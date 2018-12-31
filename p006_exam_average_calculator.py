#!/usr/bin/python3.6
# created by cicek on 06.12.2018 00:46

def average(midterm, final):
    mid = (0.4)*midterm
    fin = (0.6)*final
    result = mid + fin
    return result

while(True):
    vize = int(input("vize puanınızı giriniz: "))
    if vize == -1: exit(0)
    final = int(input("final puanınızı giriniz: "))
    print(average(vize, final))
