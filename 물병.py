import math


N,k = [int(n) for n in input('').split(' ')]


b_volume = [2**i for i in range(0,int(math.log(N,2)+2))]

b_number = [0]*len(b_volume)


def min_number(N,k):

    remain_volume = N

    for i in range(len(b_volume)-1,-1,-1) :
        if b_volume[i] <= remain_volume:
            b_number[i] = 1
            remain_volume -= b_volume[i]

min_number(N,k)


def squasing_number(k):
    added_bottle = 0
    b_sum_number = sum(b_number)

    for i in range(0,len(b_number)):

        if b_sum_number <= k : return added_bottle

        if b_sum_number <= k : return added_bottle

        if b_number[i] == 1 :
            b_number[i] -= 1
            b_number[i+1] += 1
            added_bottle += b_volume[i]
        
        elif b_number[i] == 2 :
            b_number[i] -= 2
            b_number[i+1] += 1
            b_sum_number -=1


added_bottle = squasing_number(k)
print(added_bottle)

