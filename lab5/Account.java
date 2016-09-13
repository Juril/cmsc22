/*
* Created by Juril Digamon on 09/13/16.
*/

import java.util.*;
import java.io.*;

class Account{
	private int accountNumber;
	private double balance = 0.0;

	Account(int accountNumber, double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	Account(int accountNumber){
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber(){
		return accountNumber;
	}

	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}

	public void credit(double amount){
		balance = balance + amount;
	}

	public void debit(double amount){
		if(balance >= amount){
			balance = balance - amount;
		}
		else{
			throw new IllegalArgumentException("Amount withdrawn exceeds the current balance!");
		}
	}

	public String toString(){
		return String.format("A/C no: %d, Balance=%.2f", accountNumber, balance);
	}

}
