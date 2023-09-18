hora = int(input("Introduza o numero de horas: "))
min = int(input("Introduza o numero de minutos: "))
seg = int(input("Introduza o numero de segundos: "))

total_sec= (hora*3600)+(min*60)+seg

print(f"{hora}hr:{min}min:{seg}s = {total_sec}s")