from datetime import datetime

#declaramos as variables onde gardaremos os datos finais
fyears = 0
fmonths = 0
fdays = 0

#solicitamos a data de nacemento do usuario
ano = int(input("Introduza ano de nacemento: "))
mes = int(input("Introduza mes de nacemento: "))
dia = int(input("Introduza dia de nacemento: "))

#pedimos a data actual
hoxe = datetime.now()

#realizamos os subsets apropiados para ter datos operables
cyear = hoxe.year
cmonth = hoxe.month
cday = hoxe.day

#Fluxo condicional para comprobar se este ano se cumple que fy=cy-iy
if cmonth >= mes:

    if cday >= dia:

        fyears = cyear - ano

    else:

        fyears = (cyear - ano) - 1

else:

    fyears = (cyear - ano) - 1

print(f"Tes {fyears} anos")