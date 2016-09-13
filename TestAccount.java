/*
 * A Test Driver for the Account class.
 * Created by Juril Digamon on 09/13/16.
 */
public class TestAccount{
	public static void main(String[] args){
		Account a1 = new Account(666, 1000.53);
		System.out.println(a1);

		a1.setBalance(100.23);
		a1.credit(100000);
		a1.debit(1000);
		System.out.println(a1);

		Account a2 = new Account(123);
		System.out.println(a2);

		a1.setBalance(1);
		a1.debit(1000);
	}
}