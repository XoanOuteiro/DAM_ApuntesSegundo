package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import model.Empleado;

public class EmpleadoController {


	private String path;
	File f;

	public EmpleadoController() {
		path="./misEmpleadosa.xml";
		f= new File(path);
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public boolean insertarEmpleado(Empleado e) {
		try {
			DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
			DocumentBuilder db= dbf.newDocumentBuilder();
			Document registroEmpleados=null;
			
			if(f.exists() && f.length()>0) {
				registroEmpleados= db.parse(f);			
			}else {
				DOMImplementation dom = db.getDOMImplementation();
				registroEmpleados= dom.createDocument(null, "empleados", null);
				registroEmpleados.setXmlVersion("1.0");
			}


			//Creamos un nodo empleado
			Element empleado= registroEmpleados.createElement("empleado");
			//Lo añadimos como hijo de empleados
			registroEmpleados.getDocumentElement().appendChild(empleado);
			//Creamos el nodo ID
			Element id= registroEmpleados.createElement("id");
			//Creamos el nodo texto con el valor de la ID
			Text texto= registroEmpleados.createTextNode(e.getnIF());
			//Añadimos el valor al nodo ID
			id.appendChild(texto);
			//Añadimos el nodo ID a empleado
			empleado.appendChild(id);
			Element nombre= registroEmpleados.createElement("nombre");
			texto= registroEmpleados.createTextNode(e.getNombre());
			nombre.appendChild(texto);
			empleado.appendChild(nombre);
			Element apellidos= registroEmpleados.createElement("apellido");
			texto= registroEmpleados.createTextNode(e.getApellido());
			apellidos.appendChild(texto);
			empleado.appendChild(apellidos);
			Element salario= registroEmpleados.createElement("salario");
			texto= registroEmpleados.createTextNode(String.valueOf(e.getSalario()));
			salario.appendChild(texto);
			empleado.appendChild(salario);

			Source origen= new DOMSource(registroEmpleados);
			Result resultado= new StreamResult(f);
			Transformer transformador = TransformerFactory.newInstance().newTransformer();
			transformador.transform(origen, resultado);
			return true;

		} catch (DOMException e1) {

			e1.printStackTrace();

		} catch (ParserConfigurationException e1) {

			e1.printStackTrace();
		} catch (SAXException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		} catch (TransformerConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TransformerFactoryConfigurationError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		return false;
	}

	//modificar
	
	public boolean modificarEmpleado(Empleado e) {
		try {
			ArrayList<Empleado> empleadosList =new ArrayList<Empleado>();
			//Creamos el DocumentBuilder para poder obtener el Document
			DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=dbf.newDocumentBuilder();
			//Leemos el Document desde el fichero 
			Document registroEmpleados= builder.parse(f);
			//Normalizamos el documento para evitar errores de lectura.
			registroEmpleados.getDocumentElement().normalize();



			//Creamos una lista de todos los nodos empleado
			NodeList empleados= registroEmpleados.getElementsByTagName("empleado");



			//Recorremos la lista.
			for(int i=0; i<empleados.getLength();i++) {
				//Obtenemos el primer nodo de la lista
				Node emple= empleados.item(i);
				//En caso de que ese nodo sea un Elemento
				if(emple.getNodeType()==Node.ELEMENT_NODE) {
					//Creamos el elemento empleado y leemos su información
					Element empleado= (Element)emple;
					if(empleado.getElementsByTagName("id").item(0).getTextContent().equals(e.getnIF())) {
						//empleado.getParentNode().removeChild(empleado);
						empleado.getElementsByTagName("id").item(0).setTextContent(e.getnIF());
						empleado.getElementsByTagName("nombre").item(0).setTextContent(e.getNombre());
						empleado.getElementsByTagName("apellido").item(0).setTextContent(e.getApellido());
						empleado.getElementsByTagName("salario").item(0).setTextContent(String.valueOf(e.getSalario()));
						
						
						
						
						
						
						
						
						
						Source origen = new DOMSource(registroEmpleados);
						Result resultado = new StreamResult(f);
						Transformer t= TransformerFactory.newInstance().newTransformer();
						t.transform(origen, resultado);
						return true;
					}
				}
			}
			
			
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TransformerConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TransformerFactoryConfigurationError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
	}
	//Borrar
	public boolean borrarEmpleado(Empleado e) {
		try {
			ArrayList<Empleado> empleadosList =new ArrayList<Empleado>();
			//Creamos el DocumentBuilder para poder obtener el Document
			DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=dbf.newDocumentBuilder();
			//Leemos el Document desde el fichero 
			Document registroEmpleados= builder.parse(f);
			//Normalizamos el documento para evitar errores de lectura.
			registroEmpleados.getDocumentElement().normalize();



			//Creamos una lista de todos los nodos empleado
			NodeList empleados= registroEmpleados.getElementsByTagName("empleado");



			//Recorremos la lista.
			for(int i=0; i<empleados.getLength();i++) {
				//Obtenemos el primer nodo de la lista
				Node emple= empleados.item(i);
				//En caso de que ese nodo sea un Elemento
				if(emple.getNodeType()==Node.ELEMENT_NODE) {
					//Creamos el elemento empleado y leemos su información
					Element empleado= (Element)emple;
					if(empleado.getElementsByTagName("id").item(0).getTextContent().equals(e.getnIF())) {
						empleado.getParentNode().removeChild(empleado);
						Source origen = new DOMSource(registroEmpleados);
						Result resultado = new StreamResult(f);
						Transformer t= TransformerFactory.newInstance().newTransformer();
						t.transform(origen, resultado);
						return true;
					}
				}
			}
			
			
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TransformerConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TransformerFactoryConfigurationError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		//Consultar 1

		public Empleado consultarEmpleado(String nif) {
			try {
				ArrayList<Empleado> empleadosList =new ArrayList<Empleado>();
				//Creamos el DocumentBuilder para poder obtener el Document
				DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
				DocumentBuilder builder=dbf.newDocumentBuilder();
				//Leemos el Document desde el fichero 
				Document registroEmpleados= builder.parse(f);
				//Normalizamos el documento para evitar errores de lectura.
				registroEmpleados.getDocumentElement().normalize();



				//Creamos una lista de todos los nodos empleado
				NodeList empleados= registroEmpleados.getElementsByTagName("empleado");



				//Recorremos la lista.
				for(int i=0; i<empleados.getLength();i++) {
					//Obtenemos el primer nodo de la lista
					Node emple= empleados.item(i);
					//En caso de que ese nodo sea un Elemento
					if(emple.getNodeType()==Node.ELEMENT_NODE) {
						//Creamos el elemento empleado y leemos su información
						Element empleado= (Element)emple;
						if(empleado.getElementsByTagName("id").item(0).getTextContent().equals(nif)) {

							return new Empleado(empleado.getElementsByTagName("id").item(0).getTextContent(), 
									empleado.getElementsByTagName("nombre").
									item(0).getTextContent(), 
									empleado.getElementsByTagName("apellido").
									item(0).getTextContent(), 
									Double.valueOf(empleado.getElementsByTagName("salario").
											item(0).getTextContent()));

						}

					}
				}

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}


		//Consultar todos
		public ArrayList<Empleado> listarEmpleados(){

			try {
				ArrayList<Empleado> empleadosList =new ArrayList<Empleado>();
				//Creamos el DocumentBuilder para poder obtener el Document
				DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
				DocumentBuilder builder=dbf.newDocumentBuilder();
				//Leemos el Document desde el fichero 
				Document registroEmpleados= builder.parse(f);
				//Normalizamos el documento para evitar errores de lectura.
				registroEmpleados.getDocumentElement().normalize();

				

				//Creamos una lista de todos los nodos empleado
				NodeList empleados= registroEmpleados.getElementsByTagName("empleado");
				//Mostramos el nº de elementos empleado que hemos encontrado
				

				//Recorremos la lista.
				for(int i=0; i<empleados.getLength();i++) {
					//Obtenemos el primer nodo de la lista
					Node emple= empleados.item(i);
					//En caso de que ese nodo sea un Elemento
					if(emple.getNodeType()==Node.ELEMENT_NODE) {
						//Creamos el elemento empleado y leemos su información
						Element empleado= (Element)emple;

						empleadosList.add(new Empleado(
								empleado.getElementsByTagName("id").item(0).getTextContent(), 
								empleado.getElementsByTagName("nombre").item(0).getTextContent(), 
								empleado.getElementsByTagName("apellido").item(0).getTextContent(), 
								Double.valueOf(empleado.getElementsByTagName("salario").item(0).getTextContent())));
					}
				}

				return empleadosList;

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
