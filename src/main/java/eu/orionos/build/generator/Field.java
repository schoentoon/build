/*  Build - Hopefully a simple build system
    Copyright (C) 2013 - Bart Kuivenhoven

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA. 

    A version of the licence can also be found at http://gnu.org/licences/
*/
package eu.orionos.build.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Field {
	protected static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static boolean askBoolean() throws IOException
	{
		while (true)
		{
			System.out.print("[y/N] ");
			String s = input.readLine();
			if (s.toLowerCase().equals("y") || s.toLowerCase().equals("yes"))
				return true;
			else if (s.toLowerCase().equals("n") || s.toLowerCase().equals("no") || s.equals(""))
				return false;
		}
	}

	public static int askInt() throws IOException
	{
		while (true)
		{
			System.out.print("[0..9] ");
			String s = input.readLine();
			try {
				int i = Integer.parseInt(s);
				return i;
			} catch (NumberFormatException e) {
				System.out.println(s + " is an invalid number!");
			}
		}
	}

	public static String askString() throws IOException
	{
		System.out.print(": ");
		return input.readLine();
	}

	public abstract String toJSON();
}
