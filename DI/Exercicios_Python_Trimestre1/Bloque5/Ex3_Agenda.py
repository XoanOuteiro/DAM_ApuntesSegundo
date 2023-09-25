class Contacto:
    def __init__(self,nombre,correo,numero):
        self.nombre = nombre
        self.correo = correo
        self.numero = numero

    def __str__(self):
        return f"{self.nombre} // {self.numero}"

class Agenda:

    def __init__(self):
        self.contactos = []

    def agregar(self,contacto):
        self.contactos.append(contacto)

    def buscar(self,nombre):
        for i in self.contactos:
            if i.nombre == nombre:
                return i

    def eliminar(self,nombre):
        self.contactos.remove(self.buscar(nombre))


def main():

    agenda = Agenda()

    salir = False

    while not salir:

        opt = input("Introduzca una opción: 0-> Salir, 1->Agregar, 2->Eliminar, 3->Buscar ... ")

        if opt == '0':

            salir = True
        
        elif opt == '1':

            nombre = input("Introduza el nombre: ")
            correo = input("Introduzca el correo: ")
            numero = input("Introduzca el numero: ")

            agenda.agregar(Contacto(nombre,correo,numero))

        elif opt == '2':

            nombre = input("Introduzca el nombre: ")

            agenda.eliminar(nombre)

        elif opt == '3':

            nombre = input("Introduzca el nombre: ")

            print(f"Su usuario es: {agenda.buscar(nombre)}")

        else:

            print("Opcion no válida")


if __name__ == '__main__':
    main()

