package finalhackathon;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;

public class battery {

	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("C:\\Users\\Megha\\Downloads\\Battery.txt");
			BufferedReader in=new BufferedReader(fr);
			String ln="";
			JSONObject foregd=new JSONObject();
			String Foregroundactivities="";
			String fore="";
			String percentage="";
			while((ln=in.readLine())!=null)
			{
				
				
				if(ln.contains("Foreground activities:"))
				{
					Foregroundactivities=ln;
					fore=Foregroundactivities.trim();
					String a[]=fore.split("\\s+");
					fore=a[2]+" "+a[3]+" "+a[4]+" "+a[5]+" "+a[6]+" "+a[7];
					foregd.put("Foreground_time", fore);
				}
				else if(ln.contains("Uid u0a202"))
				{
					String array[]=ln.split("\\s+");
					percentage=array[3];
					foregd.put("Battery_drain", percentage);
					float batper=Float.parseFloat(percentage);
					float battery=batper/1000;
					foregd.put("Battery_percentage", (String.format("%.3f",battery)));
				}
			}
			System.out.println(foregd);
			FileWriter file=new FileWriter("E:\\batteryoutput.json");
			file.write(foregd.toJSONString());
			file.close();
			fr.close();
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
