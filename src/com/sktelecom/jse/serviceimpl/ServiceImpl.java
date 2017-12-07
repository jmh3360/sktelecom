package com.sktelecom.jse.serviceimpl;

import java.util.Random;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.SkTelecomBean;
import com.sktelecom.jse.service.Service;

public class ServiceImpl implements Service{
	   
	MemberBean[] members ;
	SkTelecomBean[] stk;
	private int memberCount, phoneCount;
	
	public ServiceImpl() {
		memberCount = phoneCount = 0;
		members = new MemberBean[2];
		stk = new SkTelecomBean[2];
	}
	
	public void addUser(MemberBean member, SkTelecomBean skt) {
		
		skt.getCustomNum();
		this.members[memberCount++] = member;
		this.stk[phoneCount++] = skt;
		
		
	}
	@Override
	public String showMessage(MemberBean member, SkTelecomBean skt) {
		
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
}

