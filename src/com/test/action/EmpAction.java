package com.test.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMappings;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.interceptor.annotations.After;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.test.model.Emp;

@ParentPackage("mytest")
@Action(value = "empAction")
@Results({ @Result(name = "success", location = "/index.jsp"),
		@Result(name = "error", location = "/empadd.html") })
@InterceptorRefs({
		@InterceptorRef("defaultStack"),
		@InterceptorRef("FirstInterceptor"),
		/* @InterceptorRef("SecondInterceptor"), */
		@InterceptorRef(value = "annoInterceptor", params = { "includeMethods",
				"insert" }) })
public class EmpAction {
	private Emp emp;

	@Action(value = "insert", results = {
			@Result(name = "success", location = "/index.jsp"),
			@Result(name = "input", location = "/empadd.html") }
	/*, interceptorRefs = @InterceptorRef("SecondInterceptor")*/)
	// @Action(value = "insert")
	public String insert() {
		System.out.println(emp.getEname() + "    " + "insert");
		return "success";
	}

	// @Action(value = "update")
	@Action(value = "update", results = {
			@Result(name = "success", location = "/index.jsp"),
			@Result(name = "input", location = "/empadd.html") })
	public String update() {
		System.out.println(emp.getEmpno() + "    " + "update");
		return "success";
	}

	@Before
	public void annoBefore() {
		System.out.println("方法执行前");
	}

	@After
	public void annoAfter() {
		System.out.println("方法执行后");
	}

	@BeforeResult
	public void annoBeforeResult() {
		System.out.println("返回result之前执行");
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}
