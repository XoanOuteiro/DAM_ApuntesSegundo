pesoBoneca = 0.075
pesoPallaso = 0.112
prezo = 3.5

nPallasos = int(input("Numero de pallasos: "))
nBonecas = int(input("Numero de bonecas: "))

pTpallasos = nPallasos * pesoPallaso
pTbonecas = nBonecas * pesoBoneca
pT = pTpallasos + pTbonecas

prezoPallasos = pTpallasos * prezo
prezoBonecas = pTbonecas * prezo

prezoTotal = prezoBonecas + prezoPallasos

print(f"O peso total é de: {pT:.2f} cun prezo de: {prezoTotal:.2f}")