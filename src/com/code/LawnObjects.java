package com.code;

import java.awt.Color;
/**
 * 
 * @author Dries007
 *
 */
public enum LawnObjects
{
	Unmowed {
		@Override
		public Color getColor()
		{
			return new Color(33, 163, 7);
		}

		@Override
		public String getNiceName()
		{
			return this.name() + ":			";
		}
	}, Mowed {
		@Override
		public Color getColor()
		{
			return Color.GREEN;
		}

		@Override
		public String getNiceName()
		{
			return this.name() + ":			";
		}
	}, Border {
		@Override
		public Color getColor()
		{
			return Color.BLACK;
		}

		@Override
		public String getNiceName()
		{
			return this.name() + ":			";
		}
	}, HQ {
		@Override
		public Color getColor()
		{
			return Color.RED;
		}

		@Override
		public String getNiceName()
		{
			return this.name() + ":				";
		}
	}, Object {
		@Override
		public Color getColor()
		{
			return Color.GRAY;
		}

		@Override
		public String getNiceName()
		{
			return this.name() + ":			";	
		}
	};
	
	public abstract Color getColor();
	public abstract String getNiceName();
}
