package com.demo.beans;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
	@Value("${prod.pid}")
	private int pid;
	@Value("${prod.pname}")
	private String pname;
	@Value("${prod.qty}")
	private int qty;
	@Autowired
	//@Qualifier("c1")
	Category c;
	public Product() {
		super();
		System.out.println("in product default constructor");
	}
	public Product(int pid, String pname, int qty) {
		super();
		System.out.println("in product parametrized  constructor");
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		System.out.println("in setpid");
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		System.out.println("in setpname");
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		System.out.println("in setqty");
		this.qty = qty;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", c=" + c + "]";
	}
	public Category getC() {
		return c;
	}
	public void setC(Category c) {
		this.c = c;
	}
	
	

}
