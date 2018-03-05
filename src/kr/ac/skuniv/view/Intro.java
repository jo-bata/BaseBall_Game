package kr.ac.skuniv.view;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import kr.ac.skuniv.model.IntroModel;

@SuppressWarnings("serial")

public class Intro extends JPanel{
	Font title1 = new Font("±¼¸²", 120, 120);
	Font menu = new Font("±¼¸²", 60, 60);
	IntroModel introModel;
	ImageIcon introimage;
	ImageIcon title, menu0, menu1, menu2, menu3;
	ImageIcon e_menu0, e_menu1, e_menu2, e_menu3;
	
	public void drawMenu(Graphics g, IntroModel introModel) {
		g.drawImage(menu0.getImage(), 275, 440, 460, 130, null);
		g.drawImage(menu1.getImage(), 275, 560, 460, 130, null);
		g.drawImage(menu2.getImage(), 275, 680, 460, 130, null);
		g.drawImage(menu3.getImage(), 275, 800, 460, 130, null);
		
		switch(introModel.checkEntered) {
			case 1: g.drawImage(e_menu0.getImage(), 275, 440, 460, 130, null); break;
			case 2: g.drawImage(e_menu1.getImage(), 275, 560, 460, 130, null); break;
			case 3: g.drawImage(e_menu2.getImage(), 275, 680, 460, 130, null); break;
			case 4: g.drawImage(e_menu3.getImage(), 275, 800, 460, 130, null); break;
		}
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(introimage.getImage(), 0, 0, 982, 953, null);
		g.drawImage(title.getImage(), 33, 100, 920, 260, null);
		drawMenu(g, introModel);
		setOpaque(false);
	}
	
	public Intro(IntroModel introModel) {
		this.introModel = introModel;
		introimage = new ImageIcon("IntroImage.JPG");
		title = new ImageIcon("title.PNG");
		menu0 = new ImageIcon("menu0.PNG");
		menu1 = new ImageIcon("menu1.PNG");
		menu2 = new ImageIcon("menu2.PNG");
		menu3 = new ImageIcon("menu3.PNG");
		e_menu0 = new ImageIcon("e_menu0.PNG");
		e_menu1 = new ImageIcon("e_menu1.PNG");
		e_menu2 = new ImageIcon("e_menu2.PNG");
		e_menu3 = new ImageIcon("e_menu3.PNG");
	}
}
