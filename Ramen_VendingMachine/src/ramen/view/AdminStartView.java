package ramen.view;

import controller.AdminController;
import model.domain.dto.Ramen;

public class AdminStartView {

	public static void main(String[] args) {

		AdminController controller = AdminController.getInstance();

		controller.ramenListView();
 
		System.out.println();
		controller.insertRamen(new Ramen("�ʱ���", 3000, "4��"));
		
		System.out.println();
		controller.ramenListView();
		System.out.println();
		controller.oneRamenView("�̸�");
		System.out.println();
		
		controller.updateRamenPrice("�Ҵߺ�����");
		System.out.println();
		controller.ramenListView();
		System.out.println();
		
		controller.deleteRamen("�ʱ���");
		System.out.println();
		controller.ramenListView();
		System.out.println();
		
		System.out.println("��� ������ JSON���� ��������");
		controller.JsonListView();
	}
}
