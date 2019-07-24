package controller;

import java.util.ArrayList;

import log.Log4J;
import model.domain.dto.Ramen;
import net.sf.json.JSONArray;
import ramen.exception.NotExistException;
import ramen.service.RamenService;
import ramen.view.EndView;
import ramen.view.FailView;

public class AdminController {

	private static AdminController instance = new AdminController();
	private RamenService service = RamenService.getInstance();
	private Log4J log = Log4J.getInstance();

	public AdminController(){}
	public static AdminController getInstance() {
		return instance;
	}

	// ��ü ��� �˻�
	public void ramenListView() {

		ArrayList<Ramen> ramenList = service.getAllRamen();

		if (ramenList.size() != 0) {
			EndView.ramenListView(ramenList);
			log.info();
		} else {
			log.error();
		}
	}

	// Ư�� ��� ����
	public void oneRamenView(String ramenName) {

		Ramen ramen = service.getRamenName(ramenName);
		
		EndView.selectRamenView("[ ����� �������ֽʽÿ�. ]");

		if (ramen != null) {
			EndView.ramenView(ramen);
			log.info();
		} else {
			EndView.messageView("--------- �����Ͻ� ����� �������� �ʽ��ϴ�. --------");
			log.error();
		}
	}

	// ��� ����Ʈ �߰�
	public void insertRamen(Ramen newramen) {
		service.ramenListInsert(newramen);
		EndView.insertMessageView(newramen.getName() + " �����ǰ� �߰��Ǿ����ϴ�.");
		log.info();
	}

	// ��� ���� ����
	public void updateRamenPrice(String ramenName) {
		try {
			service.listUpdatePrice(ramenName);
			EndView.messageView("������ ���� �Ǿ����ϴ�.");
			log.info();
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}

	// Ư�� ��� ����
	public void deleteRamen(String ramenName) {
		try {
			service.ramenListDelete(ramenName);
			EndView.messageView("���� �Ǿ����ϴ�.");
			log.info();
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
	
	// ��� ������ JSON���� ��������
	public void JsonListView() {
		JSONArray ramenList = service.getAllJson();		
		if(ramenList.size() != 0) {
			EndView.ramenJsonView(ramenList);	
			log.info();
		} else {
			EndView.messageView("��� ����Ʈ�� �������� �ʽ��ϴ�.");
			log.error();
		}
	}
}


