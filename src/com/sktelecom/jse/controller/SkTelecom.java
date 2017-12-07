package com.sktelecom.jse.controller;

import javax.swing.JOptionPane;

import com.sktelecom.jse.domain.GalaxyBean;
import com.sktelecom.jse.domain.IphoneBean;
import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.SkTelecomBean;
import com.sktelecom.jse.service.Service;
import com.sktelecom.jse.serviceimpl.ServiceImpl;

public class SkTelecom {
	public static void main(String[] args) {
		Service service = new ServiceImpl();
		SkTelecomBean sbean ;
		GalaxyBean gbean ;
		IphoneBean Ibean ;
		MemberBean mbean ;
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료 1. 개통 2.삭제")) {
			case "0" : return;
			case "1" :
				sbean = new SkTelecomBean();
				gbean = new GalaxyBean();
				mbean = new MemberBean();
				sbean.setName((JOptionPane.showInputDialog("원하시는 기종 입력하세요\n"
						+ "1.갤럭시"
						+ "2.아이폰"
						+ "3.기타 기종")
						.equals("1"))?"갤럭시" : "아이폰");
				
				mbean.setName(JOptionPane.showInputDialog("가입자 이름"));
				JOptionPane.showMessageDialog(null, service.showMessage(mbean, sbean));
				break;
				case "2" :
					Ibean = new IphoneBean();
					Ibean.setName(JOptionPane.showInputDialog("가입자 이름"));
					break;
				default :
						
						break;
				}
			}
		}
	}

