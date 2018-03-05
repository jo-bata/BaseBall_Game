package kr.ac.skuniv.view;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import kr.ac.skuniv.model.RankingModel;

@SuppressWarnings("serial")
public class Ranking extends JPanel{
	Font font = new Font("Ω≈∏Ì¡∂", 35, 35);
	RankingModel rankingModel;
	ImageIcon gamescore, e_gamescore;
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(gamescore.getImage(), 0, 0, 824, 627, null);
		switch(rankingModel.checkEntered) {
			case 1: g.drawImage(e_gamescore.getImage(), 0, 0, 824, 627, null); break;
		}
		g.setFont(font);
		g.drawString(rankingModel.getScore(), 55, 150);
		setOpaque(false);
	}
	
	public Ranking(RankingModel rankingModel) {
		this.rankingModel = rankingModel;
		gamescore = new ImageIcon("gamescore.PNG");
		e_gamescore = new ImageIcon("e_gamescore.PNG");
	}
}
