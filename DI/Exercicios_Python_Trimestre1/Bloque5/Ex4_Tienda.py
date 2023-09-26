class Producto:

    cantidad_stock = 100

    def __init__(self, nombre, precio):

        self.nombre = nombre
        self.precio = precio

class Carrito:

    def __init__(self):

        self.productos = []

    def calcular_total():

        total : float

        for i in self.productos:

            total += i.precio

        return total
    
    def engadir(producto : Producto):
        self.productos.append(producto)
    
class Tienda:

    def __init__(self):

        self.listado_productos = []
    
class Cliente:

    carro : Carrito

    def __init__(self, carrito : Carrito):

        self.carro = carrito

    def engadir(producto : Producto):

        self.carro.engadir(producto)






