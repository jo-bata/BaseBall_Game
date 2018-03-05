package kr.ac.skuniv.controller;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import kr.ac.skuniv.model.Gamesound;
import kr.ac.skuniv.model.IntroModel;
import kr.ac.skuniv.model.RankingModel;
import kr.ac.skuniv.view.Intro;
import kr.ac.skuniv.view.Ranking;

public class RankingController implements MouseListener, MouseMotionListener {
	Frame frame;
	RankingModel rankingModel;
	Container contentPane;
	Ranking ranking;
	Gamesound scoresound;
	
	public RankingController(Frame frame, RankingModel rankingModel, Container contentPane, Ranking ranking, Gamesound scoresound) {
		this.frame = frame;
		this.rankingModel = rankingModel;
		this.contentPane = contentPane;
		this.ranking = ranking;
		this.scoresound = scoresound;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
	    //**************************************************************************************************************//
		// gomenu
		if ((x >= rankingModel.getGomenu_x() && x <= rankingModel.getGomenu_x() + rankingModel.width) && (y >= rankingModel.getGomenu_y() && y <= rankingModel.getGomenu_y() + rankingModel.heigth)) {
			IntroModel introModel = new IntroModel();
			Intro intro = new Intro(introModel);
			Gamesound menuclick = new Gamesound("menuclick.wav");
			menuclick.nothing();
			contentPane.remove(ranking);
			scoresound.stopSound();
			Gamesound menusound = new Gamesound("menu.wav");
			intro.addMouseListener(new IntroController(frame, introModel, contentPane, intro, menusound));
			intro.addMouseMotionListener(new IntroController(frame, introModel, contentPane, intro, menusound));
			contentPane.add(intro);
			frame.setSize(1000, 1000);
			frame.setVisible(true);
			System.out.println("gomenu Click");
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
	    //**************************************************************************************************************//
		// ³ë¶õ»ö
		if ((x >= rankingModel.getGomenu_x() && x <= rankingModel.getGomenu_x() + rankingModel.width) && (y >= rankingModel.getGomenu_y() && y <= rankingModel.getGomenu_y() + rankingModel.heigth))
			rankingModel.checkEntered = 1;
	    //**************************************************************************************************************//
		// Èò»ö
		if ((x >= rankingModel.getGomenu_x() && x <= rankingModel.getGomenu_x() + rankingModel.width) && (y >= rankingModel.getGomenu_y() && y <= rankingModel.getGomenu_y() + rankingModel.heigth))
		 ;
		else
			rankingModel.checkEntered = 0;
		ranking.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) { 
		// TODO Auto-generated method stub }
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {	
		// TODO Auto-generated method stub }
	}

	@Override
	public void mouseExited(MouseEvent arg0) { 
		// TODO Auto-generated method stub }
	}

	@Override
	public void mousePressed(MouseEvent arg0) { 
		// TODO Auto-generated method stub }
	}

	@Override
	public void mouseReleased(MouseEvent arg0) { 
		// TODO Auto-generated method stub }
	}
}
