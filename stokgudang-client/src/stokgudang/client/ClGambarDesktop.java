/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.client;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author Riki subagja
 */
public class ClGambarDesktop  extends JDesktopPane {
    protected void paintComponent(Graphics graph)
	{
		Graphics2D g2D = (Graphics2D) graph.create();
		
		Image img = new ImageIcon(getClass().getResource("gambariventori.jpg")).getImage();
		
		g2D.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		g2D.dispose();
	}
}
