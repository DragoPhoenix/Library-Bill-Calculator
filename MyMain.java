import java.util.*;
class MyMain
{
	int b=0,m=0;
	Book books[]=new Book[10000];
	Member members[]= new Member[10000];
	Scanner sc=new Scanner(System.in);
	void create_Book()
	{
		String i;
		int q;
		System.out.println("Enter Book ID");
		i=sc.next();
		System.out.println("Enter Book Quantity");
		q=sc.nextInt();
		Book obj=new Book(i,q);
		books[b]=obj;
		b++;
	}
	void create_Member()
	{
		String i;
		System.out.println("Enter Member ID");
		i=sc.next();
		Member obj=new Member(i);
		members[m]=obj;
		m++;
	}
	void Issue()
	{
		String bi,mi;
		int day,month;
		System.out.println("Enter Book ID");
		bi=sc.next();
		for(int i=0;i<b;i++)
		{
			if(bi.equals(books[i].id))
			{
				if(books[i].quantity==0)
				{
					System.out.println("Book not available, All Copies are lent");
					return;
				}
				books[i].quantity--;
				System.out.println("Enter Member ID");
				mi=sc.next();
				System.out.println("Enter Date (day number) and (month number)");
				day=sc.nextInt();
				month=sc.nextInt();
				for(i=0;i<m;i++)
				{
					if(mi.equals(members[i].id))
					{
						members[i].B_id=bi;
						members[i].day_i=day;
						members[i].month_i=month;
						return;
					}
				}
				System.out.println("Member not found");
				return;
			}
		}
		System.out.println("Invalid ID");
	}
	void Return()
	{
		String mi,bi;
		int day,month;
		System.out.println("Enter Member ID");
		mi=sc.next();
		System.out.println("Enter Date (day number) and (month number)");
		day=sc.nextInt();
		month=sc.nextInt();
		for(int i=0;i<m;i++)
		{
			if(members[i].id.equals(mi))
			{
				members[i].month=month;
				members[i].month_r=month;
				members[i].day_r=day;
				bi=members[i].B_id;
				members[i].calculate();
				for(i=0;i<b;i++)
				{
					if(bi.equals(books[i].id))
					{
						books[i].quantity++;
						break;
					}
				}
				return;
			}
		}
		System.out.println("Member ID not Found");
	}
	void Print()
	{
		int month;
		System.out.println("Enter Month (Number) for which you want to Print Bills");
		month=sc.nextInt();
		System.out.println("Bills as on last day of entered month are-:");
		for(int i=0;i<m;i++)
		{
			if(members[i].B_id.equals(""))
			{
				if(members[i].month!=month)
				{
					System.out.println("Member ID= "+members[i].id+"\t\tAmount= 100");
				}
				else
				{
					System.out.println("Member ID= "+members[i].id+"\t\tAmount= "+(100+members[i].amt));
				}
			}
			else
			{
				System.out.println("Member ID= "+members[i].id+"\t\tAmount= "+(100+members[i].calculate(30,month)));
			}
		}
	}
	public static void main(String args[])
	{
		int op;
		MyMain ob=new MyMain();
		System.out.println("Don't Enter Duplicate IDs");
		System.out.println("All months have been assumed to have 30 days and all dates have been assumed to be from same year");
		System.out.println("If a person issues a book on 1st of a month the penalty starts adding from 9th onwards, this has been assumed.");
		System.out.println("Once a book is returned the Bill can be seen by Entering Return month in Print Bills option\n\n");
		while(true)
		{
			System.out.println("Enter your choice of operation");
			System.out.println("Enter 1 to create Book");
			System.out.println("Enter 2 to create Member");
			System.out.println("Enter 3 to Issue a Book");
			System.out.println("Enter 4 to Return a Book");
			System.out.println("Enter 5 to Print Bills");
			System.out.println("Enter 0 to Exit");
			
			op=ob.sc.nextInt();
			if(op==0)
				break;
			switch(op)
			{
				case 1:ob.create_Book();
				break;
				case 2:ob.create_Member();
				break;
				case 3:ob.Issue();
				break;
				case 4:ob.Return();
				break;
				case 5:ob.Print();
				break;
				default:
				System.out.println("Enter valid option");
			}
			System.out.println();
		}
	}
}