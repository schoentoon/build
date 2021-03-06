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

import java.io.IOException;
import java.util.ArrayList;

import eu.orionos.build.ErrorCode;
import eu.orionos.build.Syntax;

public class Module {
	private String name;

	private ArrayList<Field> fields = new ArrayList<Field>();

	public Module()
	{
		try {
		while (this.name == null || this.name.equals(""))
		{
			System.out.print("Specify the unique module id");
			this.name = Field.askString();
		}
		fields.add(new BuildInfo());
		fields.add(new Executables());
		fields.add(new Flags());
		fields.add(new Dependencies());
		} catch (IOException e) {
			System.out.println("Input reading triggered an error");
			System.exit(ErrorCode.GENERIC);
		}
	}

	public String getJSON()
	{
		String json = "{\n";
		json += "\"" + Syntax.MODULE_NAME + "\" : \"" + name + "\",\n";
		Field[] f = fields.toArray(new Field[fields.size()]);
		for (int i = 0; i < f.length; i++)
		{
			String tmp = f[i].toJSON();
			if (!tmp.equals(""))
			{
				if (i != 0)
					json += ",\n";
				json += f[i].toJSON();
			}
		}
		json += "\n}\n";
		return json;
	}
}
