package semester3.practice.lifo;


/**
 * Der Lifospeicher speichert eine vorher fest definierte Anzahl an Elementen gleichen Typs temporär nach dem Lifo-Prinzip.
 * 
 * Die Zugriffsoperationen push() und pop() können erst nach dem create() genutzt werden
 * 
 * @author Leo
 * @version 0.1, 07.11.2019
 */

public class LifoMemory {
	
	private Object[] memory;
	private Class<?> type;
	
	/**
	 * Erzeugen und Rückgabe eines leeren Lifospeichers für Datenelement vom Typ <b>type</b> und einer Länge von <b>length</b>.s
	 * 
	 * @param length Länge des Speichers
	 * @param type Typ der zulässigen Elemente
	 * @return Lifospeicher-Objekt
	 * @throws ClassNotFoundException Typ existiert nicht
	 * @throws NegativeArraySizeException Länge ist kleiner als 0
	 */
	public static LifoMemory create(int length, String type) throws ClassNotFoundException  {
		return new LifoMemory(length, type);
	}
	
	/*
	 * TO-DO: Dokumentation schreiben
	 */
	private LifoMemory(int length, String type) throws ClassNotFoundException {		
		this.memory = new Object[length];
		this.type = Class.forName(type);
	}
	
	/**
	 * Fügt ein Element zum Speicher hinzu.
	 * 
	 * @param element Element das zum Speicher hinzugefügt wird
	 * @throws ArrayStoreException Falscher Typ des Elements
	 * @throws NullPointerException Element ist null
	 * @throws IndexOutOfBoundsException Speicher ist voll
	 */
	public void push(Object element) {
		
		if(element.getClass() != this.type) throw new ArrayStoreException();
		
		for(int i = 0; i < this.memory.length; i++) {		
			if(this.memory[i] == null) {
				this.memory[i] = element;
				break;
			} else if(i == this.memory.length - 1) throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Entfernt das zuletzt hinzugefügte Element aus dem Speicher.
	 * 
	 * @return Entferntes Element
	 * @throws IndexOutOfBoundsException Speicher ist leer
	 */
	public Object pop() {				
		for(int i = this.memory.length - 1; i >= 0; i--) {
			if(this.memory[i] != null) {
				return this.memory[i];
			}
		}
		
		throw new IndexOutOfBoundsException();
	}
}
