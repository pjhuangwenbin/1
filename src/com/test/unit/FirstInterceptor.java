package com.test.unit;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class FirstInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println(" login  firstintercept!");
		 String intercpt=arg0.invoke();
		System.out.println(" loginout  firstintercept!");
		return intercpt;
	}

}
