package ramen.view;

import controller.UserController;

public class UserStartView {
	
	public static void main(String[] args) {
		
		UserController controller = UserController.getInstance();
		
		controller.ramenListView();
		System.out.println();
		
		controller.toppingListView();
		System.out.println();
		
		controller.oneRamenView("�Ŷ��");
		System.out.println();
		
		controller.oneToppingView("��");
		System.out.println();
		
		controller.totPay("�Ŷ��", "��", 1000);
		System.out.println();
		
		controller.process();
		System.out.println();
	}
}
