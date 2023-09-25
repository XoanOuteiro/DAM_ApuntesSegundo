class CuentaBancaria:
    def __init__(self,titular,saldo):
        self.titular = titular
        self.saldo = saldo

    def depositar(self, cantidad):
        self.saldo += cantidad

        print(f"Teu saldo: {self.saldo}")
    
    def retirar(self, cantidad):
        
        if cantidad < self.saldo:
            self.saldo -= cantidad

            print(f"Teu saldo: {self.saldo}")

        else:
            print("Saldo Insuficiente.")

def main():
    c1 = CuentaBancaria("Usuario",200)

    salir = False

    while not salir:

        opt = input("Introduzca una opción: 0-> Salir, 1->Depositar, 2->Retirar ... ")

        if opt == '0':
            salir = True
        elif opt == '1':
            cantidad = int(input("Introduza a cantidad a depositar: "))

            c1.depositar(cantidad)
        
        elif opt == '2':
            cantidad = int(input("Introduza a cantidad a depositar: "))

            c1.retirar(cantidad)

        else:
            print("Opcion non valida.")
        
if __name__ == '__main__':
    main()