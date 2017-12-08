package com.sktelecom.jse.service;

import java.lang.reflect.Member;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.SkTelecomBean;

public interface Service {


	public String showMessage(MemberBean member, SkTelecomBean number);
	public String makeNumber();
	public String list();
	public String findByKey(String key);
	public String findByName(String name);
	public void updatePhoneNumber(String key);
	public void deleteMember(String key);
}
