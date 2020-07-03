package com.jfsfeb.stockmanagementsystemhibernate.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfsfeb.stockmanagementsystemhibernate.exception.ExceptionSMS;

public class ValidationSMS {

	public boolean validateId(int id) throws ExceptionSMS {
		String idRegEx = "[0-9]{3}";
		boolean result = false;

		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new ExceptionSMS("Please Enter valid Id, It Should Contain Exact 3 Digits");
		}
		return result;
	}

	public boolean validateName(String name) throws ExceptionSMS {
		String nameRegEx = "^[A-Za-z\\s]+$";
		boolean result = false;

		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new ExceptionSMS("Name Should Contains only Alphabets");
		}
		return result;
	}

	public boolean validateEmail(String emailId) throws ExceptionSMS {
		String emailRegEx = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		boolean result = false;

		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(emailId);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new ExceptionSMS("Enter The Proper Email ID");
		}
		return result;
	}

	public boolean validatePassword(String password) throws ExceptionSMS {
		String passwordRegEx = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$";
		boolean result = false;

		Pattern pattern = Pattern.compile(passwordRegEx);
		Matcher matcher = pattern.matcher(password);

		if (matcher.matches()) {
			result = true;
		} else {
			throw new ExceptionSMS(
					"Enter Valid Passsword with min 6 Characters, One Uppercase and Lowercase and a Symbol ");
		}
		return result;
	}

	public boolean validateMobileNumber(Long mobileNumber) throws ExceptionSMS {
		String mobileNumberRegEx = "(0/91)?[6-9][0-9]{9}";
		boolean result = false;
		if (Pattern.matches(mobileNumberRegEx, String.valueOf(mobileNumber))) {
			result = true;
		} else {
			throw new ExceptionSMS("Mobile Number  will start with  6 to 9 and It should contains 10 numbers...!");
		}
		return result;
	}

	public boolean validateStockPrice(double stockprice) throws ExceptionSMS {
		String stockPriceRegEx = "[0-9]{1,7}(\\.[0-9]*)?";
		boolean result = false;

		if (Pattern.matches(stockPriceRegEx, String.valueOf(stockprice))) {
			result = true;
		} else {
			throw new ExceptionSMS("Please Enter valid amount");
		}
		return result;
	}

}

