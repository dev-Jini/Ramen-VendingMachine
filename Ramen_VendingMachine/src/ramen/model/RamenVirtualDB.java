package ramen.model;

import java.util.ArrayList;
import model.domain.dto.Ramen;
import net.sf.json.JSONArray;

public class RamenVirtualDB {
	
	private static RamenVirtualDB instance = new RamenVirtualDB();
	private ArrayList<Ramen> ramenList = new ArrayList<Ramen>();
	
	private RamenVirtualDB() {
		
		ramenList.add(new Ramen("�Ŷ��", 3000, "3��"));
		ramenList.add(new Ramen("�����", 3000, "3��"));
		ramenList.add(new Ramen("�ȼ�����", 3000, "3��"));
		ramenList.add(new Ramen("�Ҵߺ�����", 2000, "3��"));
		ramenList.add(new Ramen("�ȵ������", 2000, "3��"));
		ramenList.add(new Ramen("¥�İ�Ƽ", 2000, "3��"));
	}
	
	public static RamenVirtualDB getInstance() {
		return instance;
	}
	
	public ArrayList<Ramen> getramenList() {
		return ramenList;
	}
	
	public void insertList(Ramen ramen) {
		ramenList.add(ramen);
	}
	
	public void deleteList(Ramen ramen) {
		ramenList.remove(ramen);
	}
	
	public JSONArray getjson() {
		JSONArray jsonArray = JSONArray.fromObject(ramenList);
		return jsonArray;
	}
}


