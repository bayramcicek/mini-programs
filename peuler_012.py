limit_list = []
number_test = int(input())

for a in range(number_test):
    limit_list.append(int(input()))

for limit in limit_list:
    i = 1
    while True:
        num = (i * (i + 1)) / 2
        curr_div = 0
        rr = round(num / 2) + 1
        myList = ([True] * rr)

        for k in range(1, rr):
            if myList[k]:
                if num % k == 0:
                    curr_div += 1

                else:
                    for s in range(k * k, rr, k):
                        myList[s] = False
        if curr_div >= limit:
            print(int(num))
            break

        i += 1
