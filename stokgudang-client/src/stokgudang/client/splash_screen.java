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
import javax.swing.JPanel;

/**
 *
 * @author Riki subagja
 */
public class splash_screen extends JPanel{
    private final Image img;
    
    public splash_screen(){
        img = new ImageIcon(getClass().getResource("stokgudang/client/img/inventori.jpeg")).getImage();
    }
    
    @Override
    protected  void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gd = (Graphics2D)g.create();
        gd.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        gd.dispose();
    }
}
