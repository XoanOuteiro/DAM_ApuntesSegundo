kg = float(input("Introduza seu peso en Kg: "))
hm = float(input("Introduza a sua estatura en metros: "))

imc = kg/(hm**2) #imc = peso/altura^2

print(f"Teu índice de masa corporal é {imc}")