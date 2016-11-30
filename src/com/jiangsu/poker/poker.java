package com.jiangsu.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class poker {

	public static void main(String[] args) {
		String[] num = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] color = {"红桃","方片","梅花","黑桃"};
		
		HashMap<Integer,String> hm = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		int index = 0;
		
		//拼接扑克牌，并将索引和扑克牌存储在 hm 中
		for(String s1 : num){
			for(String s2 : color){
				hm.put(index,s2.concat(s1));
				list.add(index);
				index++;
			}
		}
		hm.put(index,"小王");
		list.add(index);
		index++;
		hm.put(index, "大王");
		list.add(index);
		
		//洗牌
		Collections.shuffle(list);
		
		//发牌
		TreeSet<Integer> gaojin = new TreeSet<>();
		TreeSet<Integer> longwu = new TreeSet<>();
		TreeSet<Integer> jiangsu = new TreeSet<>();
		TreeSet<Integer> dipai = new TreeSet<>();
		
		for(int i=0 ;i<list.size();i++){
			if(i>=list.size()-3){
				dipai.add(list.get(i));
			}else if(i%3==0){
			    gaojin.add(list.get(i));
			}else if(i%3==1){
				longwu.add(list.get(i));
			}else{
				jiangsu.add(list.get(i));
			}
		}
		
		//看牌
		lookpoker(hm,gaojin,"高进");
		lookpoker(hm,longwu,"龙五");
		lookpoker(hm,jiangsu,"江苏");
		lookpoker(hm,dipai,"底牌");

	}
	
	public static void lookpoker(HashMap<Integer,String>hm,TreeSet<Integer>ts,String name){
		for(Integer i : ts){
			System.out.print(name+"的牌是:"+hm.get(i));
		}
		System.out.println();
	}

}
