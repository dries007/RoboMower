package com.code;
/**
 * 
 * @author Dries007
 *
 */
public enum Direction
{
	North
	{
		@Override
		public int[] getNext(int[] coords)
		{
			return new int[] { coords[0], coords[1] + 1 };
		}
	},
	NorthEast
	{
		@Override
		public int[] getNext(int[] coords)
		{
			return new int[] { coords[0] + 1, coords[1] + 1 };
		}
	},
	East
	{
		@Override
		public int[] getNext(int[] coords)
		{
			return new int[] { coords[0] + 1, coords[1] };
		}
	},
	SouthEast
	{
		@Override
		public int[] getNext(int[] coords)
		{
			return new int[] { coords[0] + 1, coords[1] - 1 };
		}
	},
	South
	{
		@Override
		public int[] getNext(int[] coords)
		{
			return new int[] { coords[0], coords[1] - 1 };
		}
	},
	SouthWest
	{
		@Override
		public int[] getNext(int[] coords)
		{
			return new int[] { coords[0] - 1, coords[1] - 1 };
		}
	},
	West
	{
		@Override
		public int[] getNext(int[] coords)
		{
			return new int[] { coords[0] - 1, coords[1] };
		}
	},
	NorthWest
	{
		@Override
		public int[] getNext(int[] coords)
		{
			return new int[] { coords[0] - 1, coords[1] + 1 };
		}
	};

	public abstract int[] getNext(int[] coords);
}
