package models.entities;

public class Fruit {
	//TODO: attributes
	private int id;
	private String name;
	
	//TODO: constructors
	public Fruit() {
		
	}
	public Fruit(int id, String name) {
		this.id = id;
		this.name = name;
	}
	//TODO: getters-setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}//:~
