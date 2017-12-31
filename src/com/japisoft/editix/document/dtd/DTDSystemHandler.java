package com.japisoft.editix.document.dtd;

import javax.swing.Icon;

import com.japisoft.framework.xml.parser.node.FPNode;
import com.japisoft.xmlpad.SharedProperties;
import com.japisoft.xmlpad.editor.XMLPadDocument;
import com.japisoft.xmlpad.helper.handler.AbstractHelperHandler;
import com.japisoft.xmlpad.helper.model.AbstractDescriptor;
import com.japisoft.xmlpad.helper.model.BasicDescriptor;

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
public class DTDSystemHandler extends AbstractHelperHandler {
	
	protected void installDescriptors( 
			FPNode currentNode,
			XMLPadDocument document, 
			int offset,
			String addedString ) {

		// Complete content from the current text sequence

		( ( AbstractDescriptor )addDescriptor( 
				new BasicDescriptor( 
						addedString + "ELEMENT �>" ) ) ).setComment( "DTD Element description" );

		( ( AbstractDescriptor )addDescriptor( 
				new BasicDescriptor( 
						addedString + "ENTITY �name \"\">" ) ) ).setComment( "DTD Entity" );

		AbstractDescriptor d = ( ( AbstractDescriptor )addDescriptor( 
				new BasicDescriptor( 
						addedString + "ATTLIST �>", true ) ) );
		d.setComment( "DTD Attributs description" );

		( ( AbstractDescriptor )addDescriptor( 
				new BasicDescriptor( 
						addedString + "NOTATION �>" ) ) ).setComment( "XML comment" );
		
		( ( AbstractDescriptor )addDescriptor( 
				new BasicDescriptor( 
						addedString + "-- -->" ) ) ).setComment( "XML comment" );

	}

	protected String getActivatorSequence() {
		return "<!";
	}	

	public boolean haveDescriptors(
			FPNode currentNode,
			XMLPadDocument document, 
			boolean insertBefore, 
			int offset, 
			String activatorString ) {

		if ( activatorString != null && 
				!"!".equals( activatorString ) )
			return false;

		if ( activatorString == null )
			if ( document.isBetweenTagDelimiters( offset ) )
				return false;

		return match( 
				document, 
				offset, 
				activatorString, 
				"<!" );
	}

	protected Icon getDefaultIcon() {
		return SharedProperties.getDefaultSystemHelperIcon();
	}

	public String getTitle() {
		return "DTD";
	}	
}