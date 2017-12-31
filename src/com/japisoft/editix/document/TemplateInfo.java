package com.japisoft.editix.document;

import javax.swing.Icon;

import com.japisoft.framework.xml.parser.node.FPNode;

/**
This program is available under two licenses : 

1. For non commercial usage : 

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

2. For commercial usage :

You need to get a commercial license for source usage at : 

http://www.editix.com/buy.html

Copyright (c) 2018 Alexandre Brillant - JAPISOFT SARL - http://www.japisoft.com

@author Alexandre Brillant - abrillant@japisoft.com
@author JAPISOFT SARL - http://www.japisoft.com

*/
public class TemplateInfo {

	public String label;
	public String location;
	public String type;
	public boolean system;
	public Icon icon;
	public String encoding;
	public String content;
	public String defDTDLocation;
	public String defDTDRoot;
	public String help;

	public FPNode toXML() {
		FPNode node2 = new FPNode( FPNode.TAG_NODE, "template" );
		String labelTmp = label.replaceAll( "<", "&lt;" ).replaceAll( ">", "&gt;" );
		node2.setAttribute( "label", labelTmp );
		node2.setAttribute( "type", type );
		if ( help != null )
			node2.setAttribute( "help", help );
		if ( location != null ) {
			node2.setAttribute( "location", location );
		}
		node2.setAttribute( "system", ( system ) ? "true" : "false" );
		return node2;
	}

}