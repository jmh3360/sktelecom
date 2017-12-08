package com.sktelecom.jse.controller;

import javax.swing.JOptionPane;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.SkTelecomBean;
import com.sktelecom.jse.service.Service;
import com.sktelecom.jse.serviceimpl.ServiceImpl;

public class SkTelecom {
	public static void main(String[] args) {
		Service service = new ServiceImpl();
		SkTelecomBean sbean ;
		MemberBean mbean ;
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료 1. 개통 2.목록 3.고객번호검색"
					+ "4.이름검색"
					+ "5.번호변경"
					+ "6.번호 삭제")) {
			case "0" : return;
			case "1" :
				sbean = new SkTelecomBean();
				mbean = new MemberBean();
				sbean.setName((JOptionPane.showInputDialog("원하시는 기종 입력하세요\n"
						+ "1.갤럭시"
						+ "2.아이폰")
						.equals("1"))?
								"갤럭시" : "아이폰");
				
				mbean.setName(JOptionPane.showInputDialog("가입자 이름"));
				JOptionPane.showMessageDialog(null, service.showMessage(mbean, sbean));
				break;
						
			case "2" :
				JOptionPane.showMessageDialog(null, 
					service.list());
			break;
			case "3" : 
				JOptionPane.showMessageDialog(null, service.findByKey(JOptionPane.showInputDialog("고객번호를 입력하세요")));
			break;	
			case "4" :
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름 입력하세요")));
				break;
			case "5" :
				service.updatePhoneNumber(JOptionPane.showInputDialog("전화번호 변경 할"
						+ "고객번호를 입력하세요"));
				break;
			case "6" :
				service.deleteMember(JOptionPane.showInputDialog("삭제 할 고객번호를 입력하세요"));
				break;
				
				
			}
			
			}
		}
	}

