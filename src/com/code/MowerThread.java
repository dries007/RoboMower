package com.code;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

import com.gui.ThreadGui;
/**
 * 
 * @author Dries007
 *
 */
public class MowerThread implements Runnable
{
	Random rnd = new Random();
	public Thread thread;
	public ThreadGui gui;
	public int runsToDo = 0;
	public boolean done = false;
	public LawnObjects[] lawn;
	public MowerThread instance;
	private Rectangle pos;

	public MowerThread(int i)
	{
		thread = new Thread(this, "MowerThread " + i);
		pos = new Rectangle((i * 100), 0, 10 + (i * 100), 10);
	}

	@Override
	public void run()
	{
		while (runsToDo != 0)
		{
			mowTheLawn();

			runsToDo--;
		}
		done = true;
		System.gc();
	}

	@Override
	public String toString()
	{
		return thread.getName() + "[runsToDo=" + runsToDo + " done=" + done + "]";
	}

	public void go()
	{
		thread.start();
	}

	/**
	 * Mowing code
	 */
	private void mowTheLawn()
	{
		instance = this;
		int moves = 0;
		int with = Main.instance().with;
		Direction direction = Main.instance().direction;
		
		lawn = new LawnObjects[Main.instance().sizeX * Main.instance().sizeY];
		System.arraycopy(Main.instance().lawn, 0, lawn, 0, lawn.length);
		
		startGui();
		
		int[] curCoords = { Main.instance().HQx, Main.instance().HQy };
		int[] nextCoords = { Main.instance().HQx, Main.instance().HQy };

		while (count(LawnObjects.Unmowed) != 0)
		{
			moves++;

			nextCoords = direction.getNext(curCoords);
			while (get(nextCoords).equals(LawnObjects.Border) || get(nextCoords).equals(LawnObjects.Object))
			{
				direction = turn(direction);
				nextCoords = direction.getNext(curCoords);
			}
			
			try
			{
				Thread.sleep(Main.instance().delay);
			}
			catch (InterruptedException e) {}
			
			if (rnd.nextInt(Main.instance().rnd) == 0)
			{
				direction = turn(direction);
			}

			if(gui != null)
			{
				gui.panes[nextCoords[0] + (Main.instance().sizeX * nextCoords[1])].setBackground(Color.RED);
				gui.panes[nextCoords[0] + (Main.instance().sizeX * nextCoords[1])].updateUI();
				gui.panes[curCoords[0] + (Main.instance().sizeX * curCoords[1])].setBackground(get(curCoords).getColor());
				gui.panes[curCoords[0] + (Main.instance().sizeX * curCoords[1])].updateUI();
			}
			
			curCoords = nextCoords;
			for (int x = (curCoords[0] - with); x <= (curCoords[0] + with); x++)
			{
				for (int y = (curCoords[1] - with); y <= (curCoords[1] + with); y++)
				{
					if ((x > 0) && (x < Main.instance().sizeX) && (y > 0) && (y < Main.instance().sizeY))
					{
						mow(x, y);
					}
				}
			}
		}
		
		killGui();

		Main.instance().results.add(moves);
		Main.instance().runs --;
		Main.instance().runsDone ++;
		Main.instance().statusGui.updateRunsToDo();
		
		System.gc();
	}

	private void killGui()
	{
		if(gui != null)
		{
			gui.dispose();
			gui = null;
		}
	}

	private void startGui()
	{
		if(!Main.instance().showGuis) return;
		if(gui == null)
		{
			gui = new ThreadGui(instance, thread.getName(), pos);
			
			while(!gui.init)
			{
				try
				{
					Thread.sleep(10);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
			pos = gui.getBounds();
		}
		else
		{
			System.out.println("Whaat? Gui already open. " + thread.getName());
		}
	}

	public LawnObjects get(int[] coords)
	{
		return lawn[coords[0] + (Main.instance().sizeX * coords[1])];
	}

	private void mow(int x, int y)
	{
		int i = x + (Main.instance().sizeX * y);
		if (lawn[i].equals(LawnObjects.Unmowed))
		{
			lawn[i] = LawnObjects.Mowed;
			if(gui != null)
			{
				gui.panes[i].setBackground(LawnObjects.Mowed.getColor());
				gui.panes[i].updateUI();
			}
		}
	}

	private Direction turn(Direction direction)
	{
		int i = direction.ordinal() + (rnd.nextBoolean() ? 1 : -1);
		if (i == -1) i = Direction.values().length - 1;
		if (i == Direction.values().length) i = 0;
		return Direction.values()[i];
	}

	private int count(LawnObjects wanted)
	{
		int i = 0;
		for (LawnObjects obj : lawn)
		{
			if (obj.equals(wanted)) i++;
		}
		return i;
	}
}
