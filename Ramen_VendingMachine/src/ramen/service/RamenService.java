package ramen.service;

import java.util.ArrayList;

import model.domain.dto.Ramen;
import model.domain.dto.Topping;
import net.sf.json.JSONArray;
import ramen.exception.NotExistException;
import ramen.model.RamenVirtualDB;
import ramen.model.ToppingVirtualDB;

public class RamenService {
	
	private static RamenService instance = new RamenService();
	private RamenVirtualDB ramenVirtualData = RamenVirtualDB.getInstance();
	private ToppingVirtualDB toppingVirtualData = ToppingVirtualDB.getInstance();
	
	private RamenService(){}
	public static RamenService getInstance() {
		return instance;
	}
		
	// ��ü ��� �����ֱ�
	public ArrayList<Ramen> getAllRamen() {
		return ramenVirtualData.getramenList();
	}
	
	// ��� �˻�
	public Ramen getRamenName(String RamenName) {

		ArrayList<Ramen> ramen = ramenVirtualData.getramenList();

		for (int i = 0; i < ramen.size(); i++) {
			if (ramen != null && ramen.get(i).getName().equals(RamenName)) {
				return ramen.get(i);
			}
		}
		return null;
	}
	
	// ��� �˻� ����ó��
	public Ramen getRamenNameExcept(String RamenName) throws NotExistException {

		Ramen ramen = getRamenName(RamenName);

		if (ramen == null) {
			throw new NotExistException("--------- �����Ͻ� ����� �������� �ʽ��ϴ�. --------");
		}
		return ramen;
	}
	
	// ��� ����Ʈ �߰�
	public void ramenListInsert(Ramen newRamen) {
		ramenVirtualData.insertList(newRamen);
	}
	
	
	// ��� ����Ʈ ���� ����
	public void listUpdatePrice(String ramenName) throws NotExistException {
		
		Ramen search = getRamenName(ramenName);
		
		if(search == null) {
			throw new NotExistException("-------- ���� ������ ����Ʈ�� �������� �ʽ��ϴ�. --------");
		} else {
			search.setPrice(search.getPrice() - 500);
		}
	}
	
	// ��� ����Ʈ ����
	public void ramenListDelete(String ramenName) throws NotExistException {

		Ramen search = getRamenName(ramenName);
		if (search == null) {
			throw new NotExistException("-------- ������ �� �ִ� ����Ʈ�� �������� �ʽ��ϴ�. --------");
		}
		ramenVirtualData.deleteList(search);
	}
	
	
	// ��ü ���� �����ֱ�
	public ArrayList<Topping> getAllTopping() {
		return toppingVirtualData.getToppingList();
	}
	
	// ���� ����
	public Topping getToppingName(String ToppingName) {

		ArrayList<Topping> topping = toppingVirtualData.getToppingList();

		for (int i = 0; i < topping.size(); i++) {
			if (topping != null && topping.get(i).getName().equals(ToppingName)) {
				return topping.get(i);
			}
		}
		return null;
	}

	// ���� ���� ����ó��
	public Ramen getToppingNameExcept(String ToppingName) throws NotExistException {

		Ramen topping = getRamenName(ToppingName);

		if (topping == null) {
			throw new NotExistException("--------- �����Ͻ� ����� �������� �ʽ��ϴ�. --------");
		}
		return topping;
	}
	
	// ���� ����Ʈ �߰�
	public void toppingListInsert(Topping newTopping) {
		toppingVirtualData.insertList(newTopping);
	}
	
	// ���� ����Ʈ ����
	public void ToppingListDelete(String toppingName) throws NotExistException {
		
		Ramen search = getRamenName(toppingName);
		if (search == null) {
			throw new NotExistException("-------- ������ �� �ִ� ����Ʈ�� �������� �ʽ��ϴ�. --------");
		}
		ramenVirtualData.deleteList(search);
	}
	
	// ��� ���μ���
	public int payProcess(String ramenName, String toppingName, int userMoney) throws NotExistException {
		
		Ramen ramen = getRamenName(ramenName); 
		Topping topping = getToppingName(toppingName);
		
		int tot = ramen.getPrice() + topping.getPrice();
		
		if (ramenName == null) {
			throw new NotExistException("--------- �����Ͻ� ����� �������� �ʽ��ϴ�. --------");
		} else if (userMoney > tot) {
			return userMoney - tot;
		} else if(userMoney < tot) {
			return userMoney - tot;
		} else if(userMoney == tot) {
			return userMoney - tot;
		}
		return tot;
	}
	
	// ��� ������ json���� ��������
	public JSONArray getAllJson() {
		return ramenVirtualData.getjson();
	}
}

























