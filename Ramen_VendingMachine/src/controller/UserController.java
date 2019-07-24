package controller;

import java.util.ArrayList;

import log.Log4J;
import model.domain.dto.Topping;
import ramen.exception.NotExistException;
import ramen.service.RamenService;
import ramen.view.EndView;
import ramen.view.FailView;

public class UserController extends AdminController {

	private static UserController instance = new UserController();
	private RamenService service = RamenService.getInstance();
	private Log4J log = Log4J.getInstance();

	UserController() {
		super();
	}
	
	public static UserController getInstance() {
		return instance;
	}

	public void toppingListView() {

		ArrayList<Topping> toppingList = service.getAllTopping();

		if (toppingList.size() != 0) {
			EndView.toppingListView(toppingList);
			log.info();
		} else {
			log.error();
		}
	}
	
	public void oneToppingView(String ToppingName) {

		Topping topping = service.getToppingName(ToppingName);
		
		EndView.selectToppingView("[ ������ �������ֽʽÿ�. ]");

		if (topping != null) {
			EndView.toppingView(topping);
			log.info();
		} else {
			EndView.messageView("--------- �����Ͻ� ����� �������� �ʽ��ϴ�. --------");
			log.error();
		}
	}
	
	public void totPay(String ramenName, String toppingName, int userMoney) {
		try {
			EndView.moneyView("�����Ͻ� �ݾ���" + userMoney + "���Դϴ�.");
			int change = service.payProcess(ramenName, toppingName, userMoney);
			if (change > 0) {
				EndView.changePriceMessage(change);
			} else {
				EndView.addPirceMessage(Math.abs(change));
			}
			log.info();
		} catch(NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
	
	public void process() {
		EndView.processMessage("������ �������Դϴ�." + "\n" + "����" + "\n" + "����" + "\n" + "����" + "\n" + "������ �Ϸ�Ǿ����ϴ�.");
		log.info();
	}
}







