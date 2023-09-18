palabra = "."

while len(palabra) <= 9:

    palabra = input("Escolla unha palabra de 9 letras: ")

tresPrimeiras = palabra[:3]
tresUltimas = palabra[-3:]

print(f"Primeiras tres letras:{tresPrimeiras}. Tres ultimas letras: {tresUltimas}")