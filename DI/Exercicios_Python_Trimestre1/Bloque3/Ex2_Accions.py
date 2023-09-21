import random

n = int(input("Cantos elementos quere que teña a lista? "))

mainlist = []

for i in range(n):
    
    mainlist.append(random.randint(1,10))

print(f'A súa lista é: {str(mainlist)}')

opt = int(input("""Indique que quere facer:
1. Ordene a lista e mostre por pantalla
2. Borre un elemento solicitado por teclado
3. Engada un elemento aleatorio ao final
4. Tome os elementos que estean entre N/5 e
N/3 posicións (división enteira) \n"""))

if opt == 1:
    mainlist.sort()

    print(f'A sua lista ordenada é: {mainlist}')

elif opt == 2:

    pos = int(input("Indique a posicion 0 a n-1 do elemento que vai a eliminar: "))
    print(mainlist)
    mainlist.pop(pos)
    print(f'Lista sen elemento indicado: {mainlist}')

elif opt == 3:

    mainlist.append(random.randint(1,50))

    print(f'A súa lista cun elemento aleatorio ao final é: {mainlist}')

elif opt == 4:

    print(f'Os elementos entre a terceira e quinta posición son: {mainlist[2:5]}')

else:

    print("Opcion non valida")