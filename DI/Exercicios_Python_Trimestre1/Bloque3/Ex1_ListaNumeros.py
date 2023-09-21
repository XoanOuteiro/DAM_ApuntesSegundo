import random

n = int(input("Cantos elementos quere que teña a lista? "))

mainlist = []

for i in range(n):
    
    mainlist.append(random.randint(1,10))

print(f'A súa lista é: {str(mainlist)}')

#construct a list of individual values and a list of repetitions of that lists length

unreplist = []
topclist = [0,0] #value - count

for j in mainlist:
    if j not in unreplist:
        unreplist.append(j) # we have a list containing all simple values

for k in unreplist:
    
    counter = 0

    for kk in mainlist:
        if kk == k:
            counter += 1

    if k != topclist[0] and counter >= topclist[1]:
        topclist[0] = k
        topclist[1] = counter

print(f'O valor mais repetido for {topclist[0]} con {topclist[1]} repeticións.')
    

    
        



    