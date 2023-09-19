num = -1

while num <= 0: #solicitude de datos
    
    num = int(input("Introduza un número positivo enteiro:"))

while num > 1: #algoritmo da conxetura

    if num%2 == 0:

        num /=2

    else:

        num *= 3
        num += 1

    print(num,end=" ")    
    
    