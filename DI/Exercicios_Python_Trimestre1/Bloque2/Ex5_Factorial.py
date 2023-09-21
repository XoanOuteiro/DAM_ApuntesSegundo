num = input("Introduza un número:")
fact = 1

if num.isdigit():

    if num == 0:

        print("0! = 1")

    else:
        for i in range(1,int(num) + 1):
            
            fact = fact*i

        print(f'{num}! = {fact}')

else:

    print("Error: O valor non pode ser decimal nin negativo")