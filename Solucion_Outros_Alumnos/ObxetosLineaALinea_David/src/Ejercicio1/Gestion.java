/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author a22davidil
 */
public class Gestion {

    private File fichero;
    Scanner entrada = new Scanner(System.in);
    private BufferedReader reader;
    private BufferedWriter writer;

    public Gestion(File fichero) {
        this.fichero = fichero;
        try {
            reader = new BufferedReader(new FileReader(fichero));
            writer = new BufferedWriter(new FileWriter(fichero.getAbsoluteFile(), true));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void consulta() {
        String dni = pedirDni();
        String datos = consultaDni(dni);
        if (datos != null) {
            mostrarEmpleado(datos);
        } else {
            System.out.println("El empleado no esta registrado o el dni no es válido");
        }
    }

    public void insercion() {
        String dni = pedirDni();
        if (dni != null) {
            String nombre = pedirNombre();
            String apellido = pedirApellido();
            String salario = pedirSalario();
            if (nombre != null && apellido != null && salario != null) {
                if (consultaDni(dni) == null) {
                    try {
                        reader.close();
                        writer.append("Dni: " + dni + "  Nombre: " + nombre + "  Apellido: " + apellido + "  Salario: " + salario);
                        writer.newLine();
                        writer.flush();
                        resetearReader();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    System.out.println("Dni ya registrado");
                }
            }
        }

    }

    public void modificacion() {
        String dni = pedirDni();
        if (dni != null) {
            String datos = consultaDni(dni);
            if (datos != null) {
                mostrarEmpleado(datos);
                String salario = pedirSalario();
                modificar(dni, salario, null);
            } else {
                System.out.println("DNI no registrado");
            }
        }
    }

    public void borrado() {
        String dni = pedirDni();
        if (dni != null) {
            String datos = consultaDni(dni);
            if (datos != null) {
                System.out.println("Se borrará: ");
                mostrarEmpleado(datos);
                modificar(dni, null, "-1");
            } else {
                System.out.println("DNI no registrado");
            }
        }
    }

    public void listar() {
        resetearReader();
        Stream<String> lineas = reader.lines();
        Iterator<String> iter = lineas.iterator();
        while (iter.hasNext()) {
            mostrarEmpleado(iter.next());
        }
    }

    public void cerrar() {
        try {
            writer.close();
            reader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private String pedirDni() {
        System.out.println("Introduce un dni");
        String dni = entrada.nextLine();
        if (dni.length() != 9) {
            System.out.println("Dni no valido");
            return null;
        }
        for (int contador = 0; contador + 1 < dni.length(); contador++) {
            if (!Character.isDigit(dni.charAt(contador))) {
                System.out.println("Dni no valido");
                return null;
            }
        }
        if (Character.isAlphabetic(dni.charAt(8))) {
            return dni;
        } else {
            System.out.println("Dni no valido");
            return null;
        }
    }

    private String pedirSalario() {
        System.out.println("Introduce un salario");
        String salario = entrada.nextLine();
        try {
            Float.valueOf(salario);
        } catch (NumberFormatException ex) {
            System.out.println("Salario no valido");
            return null;
        }
        return salario;
    }

    private String pedirNombre() {
        System.out.println("Introduce un nombre");
        String nombre = entrada.nextLine();
        if (nombre.length() > 10) {
            System.out.println("Nombre demasiado largo");
            return null;
        }
        return nombre;
    }

    private String pedirApellido() {
        System.out.println("Introduce un apellido");
        String nombre = entrada.nextLine();
        if (nombre.length() > 20) {
            System.out.println("Apellido demasiado largo");
            return null;
        }
        return nombre;
    }

    private void resetearReader() {
        try {
            reader.close();
            reader = new BufferedReader(new FileReader(fichero));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String consultaDni(String dni) {
        if (dni != null) {
            resetearReader();
            Stream<String> lineas = reader.lines();
            Iterator<String> iter = lineas.iterator();
            while (iter.hasNext()) {
                String temporal = iter.next();
                if (temporal.contains("Dni: " + dni)) {
                    return temporal;
                }
            }
        }
        return null;
    }

    private void mostrarEmpleado(String empleado) {
        if (!empleado.contains("Dni: -1")) {
            System.out.println();
            String[] datos = empleado.split("  ");
            for (int contador = 0; contador < datos.length; contador++) {
                System.out.println(datos[contador]);
            }
        }

    }

    //Cambia los parametros del empleado con el dni indicado. Moantiene el/los que sean null
    private void modificar(String dniModificar, String nuevoSalario, String nuevoDni) {
        try {
            String texto = "";
            String temporal;
            File ficheroNuevo = new File("Fichero nuevo");
            resetearReader();
            while ((temporal = reader.readLine()) != null) {
                if (temporal.contains(dniModificar)) {
                    if (nuevoSalario != null) {
                        String[] datosSeparados = temporal.split("Salario: ");
                        temporal = datosSeparados[0] + "Salario: " + nuevoSalario;
                    }
                    if (nuevoDni != null) {
                        String[] datosSeparados = temporal.split("Nombre: ");
                        temporal = "Dni: " + nuevoDni + "  Nombre: " + datosSeparados[1];
                    }
                }
                texto += temporal + "\n";
            }
            reader.close();
            writer.close();
            fichero.delete();

            String nombreFichero = fichero.getName();
            writer = new BufferedWriter(new FileWriter(ficheroNuevo));
            writer.write(texto);
            writer.flush();

            writer.close();
            ficheroNuevo.renameTo(fichero);
            fichero = new File(nombreFichero);

            writer = new BufferedWriter(new FileWriter(fichero.getAbsoluteFile(), true));
            resetearReader();
            ficheroNuevo.delete();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
