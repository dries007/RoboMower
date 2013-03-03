package com.code;

import java.awt.Toolkit;
import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import com.gui.MainGui;
import com.gui.StatusGui;
import com.gui.ThreadGui;
/**
 * Main java class.
 * 
 * -------------
 * (c) RoboMower 2013 
 * -------------
 * 
 * @author Dries007
 *
 */
public class Main
{
	/*
	 * Static instance part
	 */
	private static Main instance;

	public static void main(String[] args)
	{
		instance = new Main();
	}

	public static Main instance()
	{
		return instance;
	}

	/*
	 * non static part
	 */

	public MainGui mainGui;
	public StatusGui statusGui;

	public List<Integer> results = Collections.synchronizedList(new ArrayList<Integer>());

	public int runs, runsDone, cores;
	public int sizeX, sizeY;
	public int HQx, HQy;
	public int with;
	public int rnd;
	public Direction direction;
	public LawnObjects[] lawn;
	public int maxSize;
	public int delay;
	public boolean showGuis;
	public int average = 0;
	
	public ArrayList<String> opbjects;
	public MowerThread[] mowerThreads;

	public Main()
	{
		mainGui = new MainGui();
		mainGui.setVisible(true);
	}

	public void go()
	{
		ThreadGui.SIZE = maxSize;
		boolean fits = false;
		while(!fits)
		{
			if(ThreadGui.SIZE > 1)
			{
				if((ThreadGui.SIZE * sizeY) > Toolkit.getDefaultToolkit().getScreenSize().height)
				{
					ThreadGui.SIZE --;
				}
				else
				{
					fits = true;	
				}
			}
			else
			{
				fits = true;
			}
			
		}
		
		makeLawn();
		threading();

		statusGui = new StatusGui();
		
		saveData(new File("C:/Users/Dries007/Desktop/Test.txt"));
		
		System.gc();
	}

	private void makeLawn()
	{
		lawn = new LawnObjects[sizeX * sizeY];

		for (int i = 0; i < lawn.length; i++)
		{
			lawn[i] = LawnObjects.Unmowed;
		}

		for (int x = 0; x < sizeX; x++)
		{
			lawn[x + (sizeX * 0)] = LawnObjects.Border;
			lawn[x + (sizeX * (sizeY - 1))] = LawnObjects.Border;
		}

		for (int y = 1; y < sizeY; y++)
		{
			lawn[0 + (sizeX * y)] = LawnObjects.Border;
			lawn[(sizeX - 1) + (sizeX * y)] = LawnObjects.Border;
		}

		for (String txt : opbjects)
		{
			String[] var = txt.split(";");
			int minX = Integer.parseInt(var[0]);
			int minY = Integer.parseInt(var[1]);
			int maxX = Integer.parseInt(var[2]);
			int maxY = Integer.parseInt(var[3]);

			for (int x = minX; x <= maxX; x++)
			{
				for (int y = minY; y <= maxY; y++)
				{
					lawn[x + (sizeX * y)] = LawnObjects.Object;
				}
			}
		}

		lawn[HQx + (sizeX * HQy)] = LawnObjects.HQ;
	}

	private void threading()
	{
		int runs = this.runs;
		if (cores > runs) cores = runs;

		mowerThreads = new MowerThread[cores];

		for (int i = 0; i < cores; i++)
		{
			mowerThreads[i] = new MowerThread(i);
		}

		while (runs != 0)
		{
			for (int i = 0; i < cores; i++)
			{
				if (runs == 0) break;

				runs--;
				mowerThreads[i].runsToDo++;
			}
		}

		for (int i = 0; i < cores; i++)
		{
			mowerThreads[i].go();
			
			try
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public int count(LawnObjects wanted)
	{
		int i = 0;
		for (LawnObjects obj : lawn)
		{
			if (obj.equals(wanted)) i++;
		}
		return i;
	}
	
	public LawnObjects get(int[] coords)
	{
		return lawn[coords[0] + (sizeX * coords[1])];
	}
	
	public void saveData(File file)
	{
		System.out.println(file.getAbsolutePath());
		
		try
		{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			if(file.exists()) file.delete();
			file.createNewFile();
			PrintWriter pw = new PrintWriter(file);
			
			pw.println("File genereated: " + df.format(Calendar.getInstance().getTime()));
			pw.println();
			pw.println("RoboMower v0.1");
			pw.println("(c) Dries007");
			pw.println("--------------------");
			pw.println("Program Parameters:");
			pw.println("	- Lawn size:			" + (sizeX-2) + " by " + (sizeY-2));
			pw.println("	- Base station:			" + HQx + "; " + HQy);
			pw.println("	- Runs planned:			" + runs + runsDone);
			pw.println("	- Runs done:			" + runsDone);
			pw.println("	- Mower threads:		" + cores);
			pw.println("	- Random turn chance:	1 in " + rnd);
			pw.println("	- GUIs on:				" + showGuis);
			pw.println("	- Pixels per unit:		" + maxSize);
			pw.println("	- Mower with:			" + with);
			pw.println("	- Time per move:		" + delay);
			pw.println("	- Startup direction:	" + direction.name());
			pw.println("Results:");
			pw.println("	- Average:				" + average);
			pw.println("	- List:");
			for(int i : results) pw.println("		> " + i);
			pw.println("The lawn:");
			pw.println("	- Total area: 			" + lawn.length);
			pw.println("	- Objects:");
			for(LawnObjects obj : LawnObjects.values()) pw.println("		- " + obj.getNiceName() + count(obj));
			pw.println("	- Map:");
			pw.println("		- Legend:");
			for(int i=0;i<LawnObjects.values().length;i++) pw.println("			- " + LawnObjects.values()[i].getNiceName().replaceFirst("	", "") + LawnObjects.values()[i].ordinal());
			pw.println("		- Full map:");
			for(int y = 0; y < sizeY; y++)
			{
				String s = "";
				for(int x = 0; x < sizeX; x++)
				{
					s = get(new int[] {x, y}).ordinal() + " " + s;
				}
				pw.println("			> " + s);
			}
			
			pw.close();
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
}
