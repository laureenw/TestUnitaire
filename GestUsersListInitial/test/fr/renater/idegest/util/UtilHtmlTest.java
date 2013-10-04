package fr.renater.idegest.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilHtmlTest {

	@Test
	public void testToHtmlTab() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void tabVide(){
		 UtilHtml uh = new UtilHtml();
		 String arg[] = {};
		 String expectedHtmlTab = "(vide)";
		 assertEquals("toHtmlTab : tableau vide",expectedHtmlTab, uh.toHtmlTab(arg, 10));
	}
	
	@Test
	public void tabUnElement(){
		 UtilHtml uh = new UtilHtml();
		 String arg[] = {"A"};
		 String expectedHtmlTab = "<table><tr><td>A</td></tr></table>";
		 assertEquals("toHtmlTab: une ligne",expectedHtmlTab, uh.toHtmlTab(arg, arg.length));
	}
	
	@Test
	public void tabnMoinsUn(){
		UtilHtml uh = new UtilHtml();
		String arg[] = {"A", "B", "C"};
		String expectedHtmlTab ="<table><tr><td>A</td></tr><tr><td>B</td></tr><tr><td>...</td></tr></table>";
		assertEquals("toHtmlTab : cas moins 1",expectedHtmlTab, uh.toHtmlTab(arg, arg.length-1));
	}
	
	@Test
	public void tabnDivDeux(){
		 UtilHtml uh = new UtilHtml();
		 String arg[] = {"A", "B", "C"};
		 String expectedHtmlTab ="<table><tr><td>A</td></tr><tr><td>...</td></tr></table>";
		 assertEquals("toHtmlTab : cas médian impair",expectedHtmlTab, uh.toHtmlTab(arg, arg.length/2));
	}
	
	@Test
	public void tabMaxRowsZero(){
		UtilHtml uh = new UtilHtml();
		String arg[] = {"A", "B", "C"};
		String expectedHtmlTab ="<table></table>";
		assertEquals("toHtmlTab : cas maxRows 0",expectedHtmlTab, uh.toHtmlTab(arg, 0));
	}
	 

}
