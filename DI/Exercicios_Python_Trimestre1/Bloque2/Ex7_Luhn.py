numero = input("Numero da tarxeta: ")

lonxitude = len(numero)

numero_invertido = numero[::-1]

print(numero_invertido)

i=0
resultado=0

while i<lonxitude:

    if i%2==0:

        resultado+=int(numero_invertido[i])

    else:

        numpar = int(numero_invertido[i])*2

        if numpar>9:

            resultado+=numpar//10+numpar%10

        else:

            resultado+=numpar

    i+=1

print("Resultado do algoritmo de Luhn", resultado)

if resultado%10==0:

    print("A tarxeta é válida")

else:

    print("A tarxeta non é válida")
        
    

