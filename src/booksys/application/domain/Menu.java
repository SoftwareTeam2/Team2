package booksys.application.domain;

public class Menu {
	private String menuName;
	private double price;
	private int menuCount;
	
	public Menu(String m, double p, int mc) {
		menuName = m;
		price = p;
		menuCount = mc;
	}
	
	public String getMenuName() {
		return menuName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getMenuCount() {
		return menuCount;
	}
}
