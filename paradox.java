import java.io.*;
import java.util.*;
class days
{
	public int day;
	public int no;
	
	public days(int day, int no)
	{
      		this.day = day;
      		this.no = no;
   	}

       // getter
       public int getday() { return day; }
       public int getno() { return no; }
       // setter

       public void setday(int day) { this.day = day; }
       public void setno(int no) { this.no = no; }
}
class paradox
{
	public static void main(String args[])throws IOException
	{	
		int flag=1,c=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("ENTER NUMBER OF STUDENTS: ");
		int n=Integer.parseInt(br.readLine());
		days[] arr=new days[n];
		int[] ar=new int[n];
		Random rand=new Random();
		for(int i=0;i<n;i++)
		{
			ar[i]=rand.nextInt(365)+1;
			
		}
		System.out.println("Random numbers generated are: ");
		System.out.println();
		for(int i=0;i<n;i++)
		{	System.out.print(ar[i]+" ");
			if((i+1)%10==0)
			System.out.println();
		}
		for(int i=0;i<n;i++)
		{	flag=1;
			for (int j=0;j<c;j++)
			{
				if(arr[j].getday()==ar[i])
				{	flag=0;
					arr[j].setno(arr[j].getno()+1);
					break;
				}
			}
			if(flag==1)
			{	arr[c]=new days(ar[i],1);
				c++;
			}
		}
		int m=n*(n-1)/2;
		double p=1-Math.pow(0.997260274,m);
		System.out.println();
		System.out.println("PROBABILITY FOR "+n+" STUDENTS IS "+p);
		System.out.println();
		flag=0;
		for(int i=0;i<c;i++)
			if(arr[i].getno()>1){
				System.out.println(arr[i].getday()+"   "+arr[i].getno());
				flag++;
				}
			
	if(flag>0){
		System.out.println("SUCCESS CASE");
		System.out.println("REAPEATED BIRTHDATES AND ITS REPETITIONS ARE SHOWN ");
		System.out.println("FINAL COUNT IS: "+flag);
		}
		else
		System.out.println("FAILED CASE");
	}
}
