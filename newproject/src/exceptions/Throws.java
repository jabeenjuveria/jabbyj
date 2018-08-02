package exceptions;

public class Throws {

	public static void main(String[] args) {
		Throws t=new Throws();
		try
		{
			for(int i=0;i<5;i++)
			{t.getJunk();
			System.out.println(i);
			}
		}
		catch(InterruptedException iex)
		{
		iex.printStackTrace();}
		}
		
       public void getJunk()throws InterruptedException
       { Thread.sleep(1000);
	}

}
