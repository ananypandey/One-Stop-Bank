package boops;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
class Customer
{
	private String name;
	private Double amount;
	private ArrayList<Double> transaction;
	Customer(String name)
	{
		this.name=name;
		amount=0.0;
		transaction = new ArrayList<Double>();
	}
	void AddAmount(Double val)
	{
		transaction.add(val);
		amount+=val;
	}
	void TakeAmount(Double val)
	{
		int n=transaction.size();
		if(val>amount)
		{
			System.out.println("Amount cannot be deposited");
		}
		else
		{
			amount-=val;
			transaction.add(val*-1);
		}
	}
	public void ShowTransaction()
	{
		int n=transaction.size();
		System.out.println("Printing Transaction For" +" "+ name);
		for(int i=0;i<n;i++)
		{
			System.out.println(transaction.get(i));
		}
	}
	public void Amountleft()
	{
		System.out.println("Amount Left" + " "+amount);
	}
	public String getName() 
	{
		return name;
	}
}
class Branch
{
	private String bname;
	private ArrayList<Customer> cust;
	Branch(String bname)
	{
		this.bname=bname;
		cust=new ArrayList<Customer>();
	}
	public String getBname() 
	{
		return bname;
	}
	void AddCustomer(Customer obj)
	{
		cust.add(obj);
	}
	void CustomerDetails(String name)
	{
		for(int i=0;i<cust.size();i++)
		{
			if(cust.get(i).getName()==name)
			{
				System.out.println("Branch" + " "+bname);
				System.out.println(cust.get(i).getName());
				cust.get(i).Amountleft();
				cust.get(i).ShowTransaction();
			}
		}
	}
	
}
class Bank
{
	private String bank_name;
	static private HashMap<String,ArrayList<Branch>> branch_exist = new HashMap<String,ArrayList<Branch>>();
	Bank(String bank_name)
	{
		if(branch_exist.containsKey(bank_name))
		{
			System.out.println("Bank Already exists, cannot be created further");
		}
		else
		{
			this.bank_name=bank_name;
			branch_exist.put(bank_name, new ArrayList<Branch>());
			System.out.println("Bank Created Successfuly ");
		}
	}
	void add_Branch(Branch b)
	{
		ArrayList<Branch> check_area_list;
		if(branch_exist.get(bank_name).size()==0)
		{
			check_area_list= new ArrayList<Branch>();
			check_area_list.add(b);
			branch_exist.put(bank_name,check_area_list);
			System.out.println("First branch added successfully");
		}
		else
		{
			System.out.println("Just checking");
			//System.out.println(branch_exist.get(bank_name).size());
			int aflag=0;
			for(int i=0;i<branch_exist.get(bank_name).size();i++)
			{
				if(branch_exist.get(bank_name).get(i).getBname()==b.getBname())
				{
					System.out.println("Given Branch For Given Bank Already Exists");
					aflag=1;
					break;
				}
				/*else
				{
					branch_exist.get(bank_name).add(b);
					System.out.println("branch added successfully");
					break;
				}*/
			}
			if(aflag==0)
			{
				branch_exist.get(bank_name).add(b);
				System.out.println("branch added successfully");
			}
		}
	}
	void get_Branches(String bank_name)
	{
		System.out.println("Branches Present For" + bank_name + "are :");
		for(int i=0;i<branch_exist.get(bank_name).size();i++ )
		{
			System.out.println(branch_exist.get(bank_name).get(i).getBname());
		}
	}
	
}
public class boops 
{
	public static void main(String anay [])
	{
		Branch brobj = new Branch("Banglore");
		Branch brobj1 = new Branch("Kharghar");
		Bank baobj = new Bank("SBI");
		baobj.add_Branch(brobj);
		baobj.add_Branch(brobj1);
		baobj.get_Branches("SBI");
		
	}
}
