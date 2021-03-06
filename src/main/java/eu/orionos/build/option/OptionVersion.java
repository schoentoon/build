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
package eu.orionos.build.option;

import eu.orionos.build.ErrorCode;

public class OptionVersion extends Option {

	public OptionVersion(char c, String s, boolean operands) {
		super(c, s, operands);
	}
	
	public OptionVersion()
	{
		this('V', "version", false);
	}

	@Override
	public void option() {
		System.out.println("Build");
		System.out.println("A simple build system built by the Orion project");
		System.out.println("Version 0.2");
		System.exit(ErrorCode.SUCCESS);
	}

	@Override
	public String help() {
		String ret = "-V | --version\tDisplay version information about the product";
		return ret;
	}

}
