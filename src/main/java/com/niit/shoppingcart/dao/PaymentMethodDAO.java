package com.niit.shoppingcart.dao;
import java.util.List;
public interface PaymentMethodDAO {
	public List  getPaymentStatus();
    public String update(String id);
}
