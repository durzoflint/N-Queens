import java.io.*;
class Queens
{
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String [][]a;
	int n,s=0;
	public static void main(String arghh[])throws IOException
	{
		System.out.println("Enter the range");
		Queens obj=new Queens();
		obj.n=Integer.parseInt(br.readLine());
		obj.a=new String[obj.n][obj.n];
		for(int i=0;i<obj.n;i++)
		for(int j=0;j<obj.n;j++)
		obj.a[i][j]="0";
		obj.generate(obj.a,0,0);
		System.out.println("Total Soulutions "+obj.s);
	}
	void generate(String [][]a,int x,int y)
	{
		for(int i=x;i<n;i++)
		{
			for(int j=y;j<n;j++)
			{
				x=0;
				y=0;
				if(checkValidity(a,i,j))
				{
					a[i][j]="*";
					checkGrid(a);
					generate(a,i,j);
					a[i][j]="0";
				}
			}
		}
	}
	void checkGrid(String [][]a)
	{
		int c=0,d=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(checkValidity(a,i,j)==false)
				c++;
				if(a[i][j].equals("*"))
				d++;
			}
		}
		if(c==n*n&&d==n)
		{
			s++;
			display(a);
		}
	}
	boolean checkValidity(String [][]a,int i,int j)
	{
		for(int x=0;x<n;x++)
		{
			if(i-x>=0&&j-x>=0)
				if(a[i-x][j-x].equals("*"))
					return false;
			if(i-x>=0&&j+x<n)
				if(a[i-x][j+x].equals("*"))
					return false;
			if(i+x<n&&j-x>=0)
				if(a[i+x][j-x].equals("*"))
					return false;
			if(i+x<n&&j+x<n)
				if(a[i+x][j+x].equals("*"))
					return false;
			if(a[x][j].equals("*")||a[i][x].equals("*"))
				return false;
		}
		return true;
	}
	void display(String [][]a)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			System.out.print(a[i][j]+" ");
			System.out.println();
		}
		System.out.println("Total Solutions till now "+s+"\n");
	}
}
