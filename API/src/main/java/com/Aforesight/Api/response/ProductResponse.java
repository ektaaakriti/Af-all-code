package com.Aforesight.Api.response;

public class ProductResponse {
	String Product;
	String count;
	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public ProductResponse(String product, String count) {
		super();
		Product = product;
		this.count = count;
	}

}
