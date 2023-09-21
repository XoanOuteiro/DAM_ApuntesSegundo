import random

dict = {2:0,
        3:0,
        4:0,
        5:0,
        6:0,
        7:0,
        8:0,
        9:0,
        10:0,
        11:0,
        12:0}

nt = int(input("Introduza a cantidade de tiradas a realizar: "))

for i in range(nt):
    
    rn1 = random.randint(2,12)
    dict[rn1] += 1


print(dict)