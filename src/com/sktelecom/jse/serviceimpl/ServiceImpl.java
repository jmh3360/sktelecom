package com.sktelecom.jse.serviceimpl;

import java.util.Random;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.SkTelecomBean;
import com.sktelecom.jse.service.Service;

public class ServiceImpl implements Service{
	   
	MemberBean[] members ;
	SkTelecomBean[] skt;
	
	private int memberCount, phoneCount, customNum;
	
	public ServiceImpl() {
		memberCount = phoneCount = 0;
		customNum = 1000;
		members = new MemberBean[3];
		skt = new SkTelecomBean[3];
	}
	
	public void addUser(MemberBean member, SkTelecomBean skt) {
		String customNum = createCustomNum();
		System.out.println("생성된 커스텀 넘버" + customNum);
		member.setCustomNum(customNum);
		skt.setCustomNum(customNum);
		this.members[memberCount++] = member;
		System.out.println("멤버내용"+members[0].getCustomNum() + members[0].getName());
		this.skt[phoneCount++] = skt;
		
		
	}
	@Override
	public String showMessage(MemberBean member, SkTelecomBean skt) {
		//다른 곳에 메서드 사용할때 타입 지정 안해줘도 됨.
		addUser(member,skt) ;
		skt.setNumber(makeNumber());
		String message = String.format("[%s]님 이름으로 [%s] [%s]폰이 개통되었습니다.", member.getName(),skt.getNumber()
				,skt.getName());
		return message;
		
	}

	@Override
	public String makeNumber() {
		
	
		return "010-"+String.valueOf((int) (Math.random() * 9000+1000))+"-"
		+String.valueOf((int) (Math.random() * 9000+1000)) ;
	}
	//getter, setter 와 동시에 가지고 있는 형태
	public String createCustomNum() {
		
		return String.valueOf(customNum++);
		
	}
	@Override
	public String list() {
		String res = "";
		for(int i = 0; i < phoneCount; i++){
			if(members[i].getCustomNum()
					.equalsIgnoreCase(skt[i]
							.getCustomNum())) {
				res = res.concat("이름"+members[i].getName() +"전화번호"+ skt[i].getNumber() +"회원번호" +skt[i].getCustomNum()+"\n" );
				
			
			}
		}
		return res;
	}

	@Override
	public String findByKey(String key) {
		String res = "";
		for(int i = 0; i < phoneCount; i++) {
			if(members[i].getCustomNum().equals(key)) {
				res = res.concat("이름"+members[i].getName() +"전화번호"+ skt[i].getNumber() +"회원번호" +skt[i].getCustomNum()+"\n" );
			
			}
		}
		
		return res;
	}

	@Override
	public String findByName(String name) {
		String res = "";
		for(int i = 0; i < phoneCount; i++) {
			if(members[i].getName().equals(name)) {
				res = res.concat("이름"+members[i].getName() +"전화번호"+ skt[i].getNumber() +"회원번호" +skt[i].getCustomNum()+"\n" );
			}
		}
		
		return res;
	}

	@Override
	public void updatePhoneNumber(String key) {
		
		String res = "";
		for(int i = 0; i < phoneCount; i++) {
			if(members[i].getCustomNum().equals(key)) {
				skt[i].setNumber(makeNumber());
			}
		}
		makeNumber();
		
	}

	@Override
	public void deleteMember(String key) {
	for(int i = 0; i < phoneCount; i++) {
		if(members[i].getCustomNum().equals(skt[i].getCustomNum()) && members[i].getCustomNum().equals(key)) {
				members[i] = null;
				skt[i] = null;
				members[i] = members[phoneCount-1];
				skt[i] = skt[phoneCount-1];
				skt[phoneCount-1] = null;
				members[phoneCount-1] = null;
				phoneCount --;
				break;
		}
	}
		
	}
	
}


