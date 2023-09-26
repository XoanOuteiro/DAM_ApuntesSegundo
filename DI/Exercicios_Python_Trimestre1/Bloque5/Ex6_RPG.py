import random

class Enemigo:
    def __init__(self, nombre):
        self.nombre = nombre
        self.vida = random.randint(50, 100)
        self.ataque = random.randint(5, 15)
        self.defensa = random.randint(3, 10)

    def esta_vivo(self):
        # si la vida es mayor que cero
        return self.vida > 0
    
    def atacar(self, personaje):

        danio = self.ataque - personaje.defensa

        if danio > 0:

            personaje.vida -= danio
            
            print(f"{self.nombre} ataca a {personaje.nombre} y le causa {danio} puntos de daño.")

        else:

            print(f"{self.nombre} ataca a {personaje.nombre} y le causa {danio} puntos de daño.")

    def mostrar_estado(self):

        print(f"{self.nombre}: Vida = {self.vida}, Ataque = {self.ataque}, Defensa = {self.defensa}.")


class Personaje:
    def __init__(self, nombre):
        self.nombre = nombre
        self.vida = 100
        self.ataque = 10
        self.defensa = 5
        self.experiencia = 0

    def atacar(self, enemigo : Enemigo):
        #variable danio es el resultado de ataque menos defensa
        danio = self.ataque - enemigo.defensa
        
        if danio > 0:
            #al enemigo le restamos vidas
            enemigo.vida -= danio

            print(f"{self.nombre} ataca a {enemigo.nombre} y le causa {danio} puntos de daño.")

        else:

            print(f"{self.nombre} ataca a {enemigo.nombre}, pero no causa daño.")

    def ganar_experiencia(self, cantidad):

        #suma experiencia
        self.experiencia += cantidad

        print(f"{self.nombre} ha ganado {cantidad} puntos de experiencia.")

    def esta_vivo(self):

        #si la vida es mayor que cero
        return self.vida > 0

    def mostrar_estado(self):

        print(f"{self.nombre}: Vida = {self.vida}, Ataque = {self.ataque}, Defensa = {self.defensa}, Experiencia = {self.experiencia}")


def main():
 
    nombre_personaje = input("Ingresa el nombre de tu personaje: ")
    personaje = Personaje(nombre_personaje)
    enemigos = [Enemigo("Orco"), Enemigo("Shawk"), Enemigo("Drago")]

    while personaje.esta_vivo():

        enemigo = random.choice(enemigos)

        print(f"\nTe encuentras con un {enemigo.nombre} enemigo.")

        while enemigo.esta_vivo() and personaje.esta_vivo():

            print("\nEstado actual:")

            personaje.mostrar_estado()

            enemigo.mostrar_estado()
 
            accion = input("¿Qué deseas hacer? (atacar/huir): ").lower()

            if accion == "atacar":

                personaje.atacar(enemigo)

                if enemigo.esta_vivo():

                    enemigo.atacar(personaje)

            elif accion == "huir":

                print("Escapas del combate.")
                break

            else:

                print("Acción no válida. Ingresa 'atacar' o 'huir'.")

        if enemigo.vida <= 0:

            experiencia_ganada = random.randint(10, 20)

            personaje.ganar_experiencia(experiencia_ganada)

            print(f"Has derrotado al {enemigo.nombre} enemigo y ganado {experiencia_ganada} puntos de experiencia.")

        else:

            print(f"Has sido derrotado por el {enemigo.nombre} enemigo.")
                
    print("\nEl juego ha terminado.")

    if personaje.experiencia >= 50:

        print(f"{personaje.nombre} ha ganado el juego y se ha convertido en un gran guerrero.")


if __name__ == '__main__':
    main()
