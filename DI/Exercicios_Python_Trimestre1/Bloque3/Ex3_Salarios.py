tnomes = ["Antonio","Felicia","Ana","Alejandro","Salome","Juan","Gerardo","Maria"]
tsalarios = [15000,23000,19000,30000,17000,18500,20000,23100]

print(str(tnomes))
print(str(tsalarios))



mayor = 0
pos = 0

for i, salario in enumerate(tsalarios):
    if salario > mayor:
        mayor = salario
        pos = i

print(f'El empleado con mayor salario {tnomes[pos]} y gana {mayor}')
    

menor = tsalarios[0]
pos = 0

for i, salario in enumerate(tsalarios):
    if salario < menor:
        mayor = salario
        pos = i

print(f'El empleado con mayor salario {tnomes[pos]} y gana {menor}')