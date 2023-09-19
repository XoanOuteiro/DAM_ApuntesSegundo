import random

n = 0
intentos = [0,0]
n_xog = -1

for i in range(2):

    print(f"\n >Turno do xogador {i+1}")

    n = random.randint(1,100)

    while n_xog != n:

        n_xog = -1  #reseteo de valor

        while n_xog<1 or n_xog >100: #solicitamos ao usuario

            n_xog = int(input("Introduza un número entre 1 e 100: "))

            if n_xog<1 or n_xog>100:

                print("Valor non válido.")

        if n > n_xog:

            print("O número e maior")
            intentos[i] += 1

        elif n < n_xog:

            print("O numero e menor")
            intentos[i] += 1
        
        else:

            print(f"Correcto. Tiveches {intentos[i]} intentos")


print(f">>>FIN: O xogador 1 tivo {intentos[0]} e o 2 tivo {intentos[1]}")

if intentos[0] > intentos[1]:
    
    print("Ganou o xogador 2")

elif intentos[0] == intentos [1]:

    print("Empate")

else:

    print("Gañou o xogador 1")