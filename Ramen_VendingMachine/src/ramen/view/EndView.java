package ramen.view;

import java.util.ArrayList;

import model.domain.dto.Ramen;
import model.domain.dto.Topping;
import net.sf.json.JSONArray;

public class EndView {
	
	public static void ramenListView(ArrayList<Ramen> ramenList) {
		
		System.out.println("[ ��� ��� ]");
		System.out.println("����̸�" + "\t" + "����" + "\t" + "�����ð�");
		
		for (Ramen v : ramenList) {
			if (v != null) {
				System.out.println(v.toString());
			}
		}
	}
	
	public static void toppingListView(ArrayList<Topping> toppingList) {

		System.out.println("[ ���� ��� ]");
		System.out.println("�̸�" + "\t" + "����");

		for (Topping v : toppingList) {
			if (v != null) {
				System.out.println(v.toString());
			}
		}
	}
	
	public static void messageView(String message) {
		System.out.println(message);
	}

	public static void selectRamenView(String msg) {
		System.out.println(msg);
		System.out.println();
	}
	
	public static void ramenView(Ramen ramen) {
		System.out.println("[ �����Ͻ� ��� ]");
		System.out.println(ramen);
	}
	
	public static void selectToppingView(String msg) {
		System.out.println(msg);
		System.out.println();
	}
	
	public static void toppingView(Topping topping) {
		System.out.println("[ �����Ͻ� ���� ]");
		System.out.println(topping);
	}

	public static void processMessage(String string) {
		System.out.println(string);
	}

	public static void addPirceMessage(int ramenTopping) {
		System.out.println("�����ؾ� �� ���� �ݾ��� " + ramenTopping + "�� �Դϴ�.");
	}

	public static void changePriceMessage(int change) {
		System.out.println("������ �ݾ��� " + change + "�� �Դϴ�.");
	}
	
	public static void ramenJsonView(JSONArray ramenList) {
		System.out.println(ramenList);
	}

	public static void moneyView(String msg) {
		System.out.println(msg);
		System.out.println();
	}

	public static void insertMessageView(String msg) {
		System.out.println(msg);
	}
}
