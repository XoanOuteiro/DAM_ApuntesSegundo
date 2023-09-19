palabra = "."

while len(palabra) <= 9:

    '''poderiamos ter unha condicional que comprobe se a palabra ten
    nove letras e de un output negativo'''
    
    palabra = input("Escolla unha palabra de 9 letras: ")

tresPrimeiras = palabra[:3]
tresUltimas = palabra[-3:]
cuartaASeptima = palabra[4:7]

print(f"""Primeiras tres letras:{tresPrimeiras}. 
Tres ultimas letras: {tresUltimas}. 
Cuarta a séptima: {cuartaASeptima}.""")