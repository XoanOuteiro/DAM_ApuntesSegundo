class Autor:
    def __init__(self,nombre,nacionalidad):
        self.nombre = nombre
        self.nacionalidad = nacionalidad



class Libro:
    autor : Autor

    def __init__(self,autor,titulo,precio):
        self.autor = autor
        self.titulo = titulo
        self.precio = precio

    def __str__(self):
       return f"Autor: {self.autor.nombre} || Titulo: {self.titulo} || Precio: {self.precio}"

def main():
    autor = Autor("Juan","Argentina")

    libro = Libro(autor,"Titulo Ejemplo","15eur")

    print(libro)

if __name__ == "__main__":
    main()
