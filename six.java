import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class six {
	private static void multiply() throws Exception {
		File file=new File("data.txt");
		Scanner scan=new Scanner(file);
		String num1=scan.nextLine();
		String num2=scan.nextLine();
		scan.close();
		ArrayList<Byte> left=StringToDigits(num1);
		ArrayList<Byte> right=StringToDigits(num2);
		ArrayList<Byte> result= new ArrayList<Byte>(left.size()+right.size());
		for(int i=0;i<(left.size()+right.size());++i)
		{
			result.add((byte)0);
		}
		for(int rightPos=0;rightPos<right.size();++rightPos)
		{
			byte rightDigit=right.get(rightPos);
			byte temp=0;
			System.out.println("Multiplication is");
			for(int leftPos=0;leftPos<left.size();++leftPos)
			{
				temp+=result.get(rightPos+leftPos);
				temp+=rightDigit+left.get(leftPos);
				result.set(leftPos + rightPos ,(byte)(temp%10) );
				temp /= 10;
			}
			int destPos=rightPos + left.size();
			while(temp!=0)
			{
				result.set(destPos, (byte)(temp % 10));
				temp /= 10;
				destPos++;
			}
			
		}
		for(int i=result.size()-1;i>=0;--i)
		{
			System.out.print(result.get(i));
		}
		
	}

	private static ArrayList<Byte> StringToDigits(String num) {
		ArrayList<Byte> result=new ArrayList<Byte>(num.length());
		for(int i=num.length()-1;i>=0;--i)
		{
			char c=num.charAt(i);
			if(c < '0'|| c > '9')
			{
				System.out.println("Invalid input");
				System.exit(1);
			}
			result.add(num.length()-1-i, (byte)(c-'0'));
		}
		return result;
	}

	public static void main(String[] args) throws Exception	{
		File file=new File("data.txt");
		Scanner scan=new Scanner(System.in);
		System.out.print("Input 1");
		String input1=scan.next();
		System.out.println("Input 2:");
		String input2=scan.next();
		scan.close();
		PrintWriter out=new PrintWriter(file);
		out.println(input1);
		out.println(input2);
		out.close();
		multiply();
		
	}

	
}

