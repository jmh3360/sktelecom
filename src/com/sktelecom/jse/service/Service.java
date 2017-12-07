package com.sktelecom.jse.service;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.SkTelecomBean;

public interface Service {


	public String showMessage(MemberBean member, SkTelecomBean number);
	public String makeNumber();
}
