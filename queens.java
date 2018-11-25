import java.io.*;
class Queens
{
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String [][]a;
	int n,s=0;
	
	public static void main(String arghh[])throws IOException
	{
		//Take input for the number of queens and grid
		System.out.println("Enter the range");
		Queens obj=new Queens();
		obj.n=Integer.parseInt(br.readLine());
		
		//Initialise the double dimension array as a chessboard
		obj.a=new String[obj.n][obj.n];
		
		//Assign default values to the chessboard
		for(int i=0;i<obj.n;i++)
			for(int j=0;j<obj.n;j++)
			obj.a[i][j]="0";
		
		//Calling the login function.
		//The 2nd and 3rd variables are the passed to start the iteration from these values.
		//In this case it is default as zero.
		obj.generate(obj.a,0,0);
		
		//Print the output on the screen as the total solutions possible
		System.out.println("Total Soulutions "+obj.s);
	}
	
	void generate(String [][]a, int x, int y)
	{
		//Start Iteration with the xth row
		for(int i=x;i<n;i++)
		{
			//Start iteration with the yth column
			for(int j=y;j<n;j++)
			{
				//IMPORTANT: Make the value of 'y' as zero so that this loop starts from the yth column only once.
				//When 'i' is incremented, the loop of 'j' should start with 0.
				//x is made zero as a good practice.
				x=0;
				y=0;
				
				//Cheack if the (i,j) is the right position for the queens to be placed.
				if(checkValidity(a,i,j))
				{
					//Place the queens
					a[i][j]="*";
					
					//Check if the grid is complete or not.
					//This is a helper function which counts the numebr of solutions generated and prints them.
					checkGrid(a);
					
					//Recursive call to place the next queen
					generate(a,i,j);
					
					//Remove the queen when the code backtracks to find other combinations.
					//IMPORTANT: This is important for backtracking.
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
		//Check if the queens hits any other queen or not
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
	
	//Display the chessboard
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
