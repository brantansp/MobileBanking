package mBankingUtilityCenter;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.net.*;

public class Selector extends Applet implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	java.awt.List l;
	   boolean okToDisplay = false;
	   String targetFrame = "";

	   public void init() {
	     setLayout(new BorderLayout());
	     add(l = new java.awt.List(5), "Center");
	     l.addActionListener(this);
	     targetFrame = getParameter("targetFrame");
	     }

	   public void actionPerformed(ActionEvent ae) {
	     if (okToDisplay) {
	        try {
	          URL urlToDisplay = new URL(ae.getActionCommand());
	          getAppletContext().showDocument(urlToDisplay, targetFrame);
	          }
	        catch (Exception e) { e.printStackTrace(); }
	        }
	     }

	   public void insertData(String arrayAsAString) {
	   int i = 0;
	   String s;
	   StringTokenizer st =
	      new StringTokenizer(arrayAsAString, "|");

	   while(st.hasMoreTokens()){
	     s = st.nextToken();
	     l.add(s); // or l.addItem(s);
	      System.out.println(s);
	     }
	   okToDisplay  = true;
	   }
}
