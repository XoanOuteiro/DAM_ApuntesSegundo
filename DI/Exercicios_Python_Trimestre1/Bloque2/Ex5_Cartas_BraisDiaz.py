import random
num=0
xogar=1
puntos1=0
puntos2=0

print("Vai a xogar o xogador 1: ")

while xogar==1 and puntos1<=7.5:

    xogar=int(input("Queres seguir xogando? (Sí->1 || Non->Outro)"))

    print(xogar)

    if xogar==1:

        num=random.randint(1,10)

        if num==8 or num==9 or num==10:

            puntos1+=0.5

        else:

            puntos1+=num

        print(f"Tes {puntos1} puntos")

    else:

        print(f"Plantácheste con {puntos1} puntos")

    if puntos1>7.5:

        print(f"Perdiches. Sumaches {puntos1} puntos")
        
    
num=0
xogar=1

print("Vai a xogar o xogador 2: ")

while xogar==1 and puntos2<=7.5:

    xogar=int(input("Queres seguir xogando? (Sí->1 || Non->Outro)"))

    if xogar==1:

        num=random.randint(1,10)

        if num==8 or num==9 or num==10:

            puntos2+=0.5

        else:

            puntos2+=num

        print(f"Tes {puntos2} puntos")

    else:

        print(f"Plantácheste con {puntos2} puntos")

    if puntos2>7.5:
        
        print(f"Perdiches. Sumaches {puntos2} puntos")
        

if puntos1>puntos2 and puntos1<7.5:

    print("Gañou o xogador1.")

elif puntos2>puntos1 and puntos2<7.5:

    print("Gañou o xogador2.")

else:
    
    print("Non gañou ninguén.")