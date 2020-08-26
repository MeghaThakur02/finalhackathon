package finalhackathon;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;

public class memory
{

	public static void main(String[] args)  
	{
		try {
		FileReader fr=new FileReader("C:\\Users\\Megha\\Downloads\\Memory.txt");
		BufferedReader in=new BufferedReader(fr);
		float avg=0;float max=0;
		float sum=0;
		int i=1;
		String line;
		
		
		JSONObject values=new JSONObject();
		JSONObject value=new JSONObject();
		JSONObject avgmemory=new JSONObject();
		JSONObject maxmemory=new JSONObject();
		JSONObject userName=new JSONObject();
		JSONObject fin=new JSONObject();
		int c=0;
		while((line=in.readLine())!=null)
		{
			if(c%2!=0)
			{
				String splitvalues[]=line.split("\\s+");
				float mem_val=Float.parseFloat(splitvalues[2]);
				mem_val=mem_val/1024;
				if(max<mem_val)
				{
					max=mem_val;
				}
				sum=sum+mem_val;
				String s=i+"s";
				values.put(s, (String.format("%.2f",mem_val)));
				i++;
				
			}

			c++;
			
		}
		avg=sum/c;
		
		fin.put("AverageMemory(MB)", (String.format("%.2f",avg)));
		fin.put("MaxMemory(MB)", (String.format("%.2f",max)));
		fin.put("value", values);
		fin.put("Usecasename", "HomePage");
		System.out.println(fin);
		FileWriter file=new FileWriter("E:\\memoryoutput.json");
		file.write(fin.toJSONString());
		file.close();
		fr.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}