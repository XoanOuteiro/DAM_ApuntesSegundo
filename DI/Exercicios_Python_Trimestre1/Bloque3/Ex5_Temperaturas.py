d = {"Vigo":0.0,"A Coruña":0.0,"Ourense":0.0,"Pontevedra":0.0,"Lugo":0.0,"Ferrol":0.0}

cidade = str(input("Indique que cidade vai actualizar: "))

if cidade in d:

    t = float(input("Indique unha nova temperatura: "))

    d[cidade] = t

    print(d)

else:
    print("Esa cidade non existe.")