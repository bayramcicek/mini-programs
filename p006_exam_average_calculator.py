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
    print("ortalama: {0}\n".format(average(vize, final)))

# vize puanınızı giriniz: 50
# final puanınızı giriniz: 80
# ortalama: 68.0
#
# vize puanınızı giriniz: 40
# final puanınızı giriniz: 60
# ortalama: 52.0
#
# vize puanınızı giriniz: 100
# final puanınızı giriniz: 100
# ortalama: 100.0
#
# vize puanınızı giriniz: 49
# final puanınızı giriniz: 50
# ortalama: 49.6
#
# vize puanınızı giriniz:

