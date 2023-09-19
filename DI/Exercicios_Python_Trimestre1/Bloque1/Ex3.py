iseg = int(input("Introduza o numero de segundos: "))

horas = iseg // 3600
seg = iseg % 3600
min = seg // 60
seg %= 60

print(f"{iseg}seg = {horas}hr:{min}min:{seg}s")