class Member
{
	String id; // member Id
	String B_id; // Borrowed Book Id, only one can be borrowed at a time
	int amt,month;
	int day_i,month_i,day_r,month_r;
	Member(String m)
	{
		id=m;
		B_id="";
		amt=month=day_i=month_i=day_r=month_r=0;
	}
	void calculate()
	{
		int n=0,m;
		if(month_r==month_i)
		{
			n=day_r-day_i;
		}
		else
		{
			n=(month_r-month_i-1)*30;
			n+=30-day_i;
			n+=day_r;
		}
		if(n<=7)
			amt=0;
		else if(n>7&&n<=30)
		{
			amt=(n-7)*10;
		}
		else
		{
			m=n/30;
			amt=(n-30)*m*50;
			amt+=230;	
		}
		day_i=month_i=day_r=month_r=0;
		B_id="";
	}
	int calculate(int dayr,int monthr)
	{
		int n=0,m;
		if(monthr==month_i)
		{
			n=dayr-day_i;
		}
		else
		{
			n=(monthr-month_i-1)*30;
			n+=30-day_i;
			n+=dayr;
		}
		if(n<=7)
			amt=0;
		else if(n>7&&n<=30)
		{
			amt=(n-7)*10;
		}
		else
		{
			m=n/30;
			amt=(n-30)*m*50;
			amt+=230;
		}
		n=amt;
		amt=0;
		return n;
	}
}