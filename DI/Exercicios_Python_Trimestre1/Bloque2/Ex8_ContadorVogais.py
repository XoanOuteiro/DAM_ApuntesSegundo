vogais = ['A','E','I','O','U','a','e','i','o','u','á','é','í','ó','ú']
nvogais = 0

palabra = input("Introduza unha palabra: ")

for i in palabra:
    if i in vogais:
        nvogais += 1

print(f'{palabra} ten {nvogais} vogais.')