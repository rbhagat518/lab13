public class lab13 
{
	// ArrayList<Integer> field that is accessible to all my classes
	private java.util.ArrayList<Integer> ints = new java.util.ArrayList<Integer>();
	
	public void readData(String Filename)
	{
		try
		{
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(Filename)));
			String inn;
			while( (inn = input.readLine()) != null )
			{
				ints.add(Integer.valueOf(inn.trim()));
			}
			input.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	public long getTotalCount()
	{
		return ints.stream().count();
	}
	public long getOddCount()
	{
		return ints.stream().filter(ints -> ints % 2 == 1).count();
	}
	public long getEvenCount()
	{
		return ints.stream().filter(ints -> ints % 2 == 0).count();
	}
	public long getDistinctGreaterThanFiveCount()
	{
		return ints.stream().filter(ints -> ints > 5).distinct().count();
	}
	public Integer[] getResult1()
	{
		return ints.stream().filter(ints -> ints % 2 == 0).filter(ints -> ints > 5).filter(ints -> ints < 50).sorted().toArray(Integer[]::new);
	}
	public Integer[] getResult2()
	{
		return ints.stream().map(ints -> ints * ints).map(ints -> ints * 3).limit(50).toArray(Integer[]::new);
	}
	public Integer[] getResult3()
	{
		return ints.stream().filter(ints -> ints % 2 == 1).map(ints -> ints * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
	

}
