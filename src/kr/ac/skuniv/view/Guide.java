package kr.ac.skuniv.view;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import kr.ac.skuniv.model.GuideModel;

@SuppressWarnings("serial")
public class Guide extends JPanel {
	GuideModel guideModel;
	ImageIcon gameguide, e_gameguide;
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(gameguide.getImage(), 0, 0, 824, 627, null);
		switch(guideModel.checkEntered) {
			case 1: g.drawImage(e_gameguide.getImage(), 0, 0, 824, 627, null); break;
		}
		setOpaque(false);
	}
	
	public Guide(GuideModel guideModel) {
		this.guideModel = guideModel;
		gameguide = new ImageIcon("gameguide.PNG");
		e_gameguide = new ImageIcon("e_gameguide.PNG");
	}
}
