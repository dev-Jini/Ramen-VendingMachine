package ramen.model;

import java.util.ArrayList;

import model.domain.dto.Topping;

public class ToppingVirtualDB {
	
	private static ToppingVirtualDB instance = new ToppingVirtualDB();
	private ArrayList<Topping> toppingList = new ArrayList<Topping>();
	
	private ToppingVirtualDB() {
		
		toppingList.add(new Topping("ġ��", 300));
		toppingList.add(new Topping("��", 500));
		toppingList.add(new Topping("���", 200));
		toppingList.add(new Topping("����", 800));
		toppingList.add(new Topping("��", 500));
		toppingList.add(new Topping("���ξ���", 0));
	}
	
	public static ToppingVirtualDB getInstance() {
		return instance;
	}

	public ArrayList<Topping> getToppingList() {
		return toppingList;
	}

	public void insertList(Topping topping) {
		toppingList.add(topping);
	}
	
	public void deleteList(Topping topping) {
		toppingList.remove(topping);
	}
}
