package com.metap.util.tm;

import java.util.ArrayList;
import java.util.List;

import com.metap.util.refrect.UIDesc;
import com.metap.util.refrect.UIParam;
import com.metap.util.refrect.UIType;

public class Mountain {	
	public static final String[] Mountains = new String[]{
		"��","��","��","��","��","��","î","��","��","��","��","��","��","��","δ","��","��","��","��","��","��","Ǭ","��","��"
	};
	
	private int idx;
	@UIDesc(label="ɽ�ң�",name="mt",type=UIType.Spinner,data=UIParam.KEY_MOUNTAIN)
	private String mt;
	
	public Mountain(int m){
		idx = m;
		mt = Mountains[idx];
	}
	public Mountain(String mountain){
		mt = mountain;
		idx = find(mountain);
	}
	
	public String getMt() {
		return mt;
	}
	public void setMt(String mt) {
		idx = TMUtil.findIdx(Mountains, mt);
		this.mt = mt;
	}
	public String getShan(){
		return Mountains[idx];
	}
	
	public String getXiang(){
		return Mountains[(idx+12)%24];
	}
	
	public int find(String m){
		for(int i=0;i< Mountains.length;i++){
			if(Mountains[i].equals(m)){
				return i;
			}
		}
		
		return -1;
	}

	public boolean contains(String s){
		boolean result = false;
		if(mt.contains(s) || getXiang().contains(s)){
			result = true;
		}
		
		return result;
	}
	
	public List<String> getWXChs(){
		List<String> list = new ArrayList<String>();
		list.add("����");list.add(getMt());list.add("ɽ");list.add("��");list.add(TMUtil.getWX(getMt()));
		list.add("ENTER");
		return list;
	}
	
	public List<String> getDSChs(){
		List<String> list = new ArrayList<String>();
		list.add("����");list.add(getMt());list.add("ɽ");list.add("��");list.add(TMUtil.getDS(getMt()));
		list.add("ENTER");
		return list;
	}
	
	@Override
	public String toString() {
		return String.format("%sɽ%s��", Mountains[idx],Mountains[(idx+12)%24]);
	}
	
	
}
