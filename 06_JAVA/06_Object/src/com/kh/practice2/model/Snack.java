package com.kh.practice2.model;

public class Snack { // 클래스

	private String kind;
	private String name;
	private String flavor;
	private int numOf;
	private int price;

	public Snack() { // alt + shift + s 기본 생성자
	}

	public Snack(String kind, String name, String flavor, int numOf, int price) {
		this.kind = kind;
		this.name = name;
		this.flavor = flavor;
		this.numOf = numOf;
		this.price = price;

	}

	public String getKind() { // alt + shift + s  getter setter
		return kind;
	}

	public void setKind(String kind) { // alt + shift + s 필드 제작
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getNumOf() {
		return numOf;
	}

	public void setNumOf(int numOf) {
		this.numOf = numOf;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() { // alt + shift + s  toString
		return "Snack [kind=" + kind + ", name=" + name + ", flavor=" + flavor + ", numOf=" + numOf + ", price=" + price
				+ "]";
	}

}
