
import java.io.*;
import java.util.*;
public class Duplicates
{
	public static Map<String,String> data=new HashMap<String,String>();
	public static HashSet<String> dups=new HashSet<String>();
	public static BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String args[])throws IOException
	{
		System.out.print("Enter the directory to check for duplicates : ");
		String path=obj.readLine();
		String paths[]=path.split("/");
		String cont="";
		do
		{
			File folder = new File(path); 
			File[] listOfFiles = folder.listFiles();
			data.clear();
			dups.clear();
			getFileData(listOfFiles, paths);
			findDuplicates();
			System.out.println("1. Delete a duplicate file\n2.Merge 2 duplicate files");
			int choice=Integer.parseInt(obj.readLine());
			switch(choice)
			{
				case 1:deleteDuplicates(paths);
					   break;
				case 2:mergeFiles(paths);
					   break;
				default:break;
			}
			System.out.print("Check again for duplicate files (y\\n)? : ");
			cont=obj.readLine();
		}
		while(cont.equals("Y") || cont.equals("y") || cont.equals("yes"));
	}

	public static void getFileData(File[] listOfFiles, String[] paths)
	{
		int count=0;
		for (int i = 0; i < listOfFiles.length; i++)
		{
			if (listOfFiles[i].isFile())
			{
				count++;
				String filename1="";
				for(int j=0;j<paths.length;j++)
					filename1+=paths[j]+"/";
				filename1+=listOfFiles[i].getName().substring(0, listOfFiles[i].getName().length());
				String temp="";
				try
				{
					File file = new File(filename1);
					Scanner scanner = new Scanner(file);
					while (scanner.hasNextLine())
					{
						temp+=scanner.nextLine()+"\n";
					}
					scanner.close();
				}
				catch(Exception e){}
				data.put(listOfFiles[i].getName(),temp);
			}
		}
	}
	public static void findDuplicates()
	{
		for (Map.Entry<String, String> entry : data.entrySet())
		{
			for(Map.Entry<String, String> entry2 : data.entrySet())
			{
				if(entry.getKey().equals(entry2.getKey()))
					continue;
				if(entry.getValue().equals(entry2.getValue()))
				{
					dups.add(entry.getKey());
					dups.add(entry2.getKey());
				}
			}
			if(dups.size()==0)
				continue;
			else
			{
				System.out.println(entry.getKey()+" has these dups:");
				int i=1;
				Iterator iterator = dups.iterator();
				while(iterator.hasNext())
				{
					System.out.println(i+". "+iterator.next());
					i++;
				}
				System.out.println();
				dups.clear();
			}
		}
	}
	public static void deleteDuplicates(String[] paths)throws IOException
	{
		System.out.println("Enter the filename to delete: ");
		String deletion = obj.readLine();
		Process p;
		try
		{
			String del="";
			for(int j=0;j<paths.length;j++)
				del+=paths[j]+"/";
			del+=deletion;
			p=Runtime.getRuntime().exec("rm "+del);
		}
		catch(Exception e){}
	}
	public static void mergeFiles(String[] paths)throws IOException
	{
		System.out.println("Enter the 2 files to be merged (the second file will be deleted): ");
		String f1=obj.readLine();
		String f2=obj.readLine();
		String temp="";
		for(int j=0;j<paths.length;j++)
		temp+=paths[j]+"/";
		f1=temp+f1;
		f2=temp+f2;
		String f1text="", f2text="";
		File file = new File(f1);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine())
		{
			f1text+=scanner.nextLine()+"\n";
		}
		scanner.close();
		file = new File(f2);
		scanner = new Scanner(file);
		while (scanner.hasNextLine())
		{
			f2text+=scanner.nextLine()+"\n";
		}
		scanner.close();
		f1text=f1text+f2text;
		file = new File(f1);
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(f1text);
		bw.close();
		Process p;
		try
		{
			p=Runtime.getRuntime().exec("rm "+f2);
		}
		catch(Exception e){}
	}
}