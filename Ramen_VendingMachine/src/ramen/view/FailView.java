package ramen.view;

import log.Log4J;

public class FailView {
	
	private static Log4J log = Log4J.getInstance();

	public static void failMessageView(String message) {
		System.out.println("�߻��� ��Ȳ : " + message);
		log.error();
	}
}
