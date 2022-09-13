package Bank;

import java.util.Scanner;

public class BankDetails {
	private String accno;
	private String name;
	private String acc_type;
	private long balance;
 Scanner sc=new Scanner(System.in);
	//opening an account
	public void openAccount()
	{
		System.out.print("Enter Account Number:");
		accno=sc.next();
		System.out.print("Enter Account Type:");
		acc_type=sc.next();
		System.out.print("Enter Name of the customer:");
		name=sc.next();
		System.out.print("Enter Balance:");
		balance=sc.nextLong();
			
	}
	//Displaying the Account Details
	public void AccountDetails() {
		System.out.println("Name of account holder:" +name);
		System.out.println("Account Number:" +accno);
		System.out.println("Account Type:" +acc_type);
		System.out.println("Balance:" +balance);
	}
	//deposit money
	public void deposit() {
		long amount;
		System.out.println("Enter the amount to deposit");
		amount=sc.nextLong();
		balance=balance+amount;
		System.out.println("Balance after deposit:"+balance);
	}
	//withdrawing amount
	public void withdrawl() {
		long amount;
		System.out.println("Enter the amount to withdraw:");
		amount=sc.nextLong();
		if(balance>=amount)
		{
			balance=balance-amount;
			System.out.println("Balance after withdrawal:"+balance);
		}
		else
		{
			System.out.println("Balance is less than"+amount+ "\tTransaction failed ");
		}
	}
	//to search an account number
	public boolean search(String acc_no) {
		if(accno.equals(acc_no))
		{
			AccountDetails();
			return(true);
		}
		return(false);
	}
}

class Bank{
	public static void main(String arg[]){
		Scanner sc=new Scanner(System.in);
		System.out.print(" Select How many customers want to input?");
		int n=sc.nextInt();
		BankDetails C[]=new BankDetails[n];
		for(int i=0;i<C.length;i++)
		{
			C[i]=new BankDetails();
			C[i].openAccount();
		}
		int ch;
		do {
			System.out.println("\nBanking system");
			System.out.println("1.Opening Accounts\n 2.Search by Account number \n3.Deposit the Amount \n 4.Withdraw \n5.Exit");
			System.out.println("Enter Your Choice:");
			ch=sc.nextInt();
			switch(ch) {
			case 1:for(int i=0;i<C.length;i++)
			{
				C[i].AccountDetails();
			}
			break;
			case 2:System.out.print("Enter account number:");
				String acc_no=sc.next();
				boolean found=false;
				for(int i=0;i<C.length;i++)
				{
					found=C[i].search(acc_no);
					if(found) {
						break;
					}
				}
				if(!found) {
					System.out.println("Account doesnt exist...");
				}
				break;
			case 3:System.out.print("Enter Account Number:");
			acc_no=sc.next();
			found=false;
			for(int i=0;i<C.length;i++)
			{
				found=C[i].search(acc_no);
			         if(found)
			           {
				          C[i].deposit();
				          break;
			           }
			}
			if(!found) {
				
			   System.out.println("Account doesnt exist....");
			}
			break;
			case 4:
				System.out.print("Enter Account Number");
				acc_no=sc.next();
				found=false;
				for(int i=0;i<C.length;i++)
				{
					found=C[i].search(acc_no);
				         if(found)
				           {
					          C[i].withdrawl();
					          break;
				           }
				}
				if(!found) {
					
				   System.out.println("Account doesnt exist...");
				}
				break;
			case 5:
				System.out.println("End");
				break;
			
		}
		
	}
		while(ch!=5);
	
	}
	
	
}