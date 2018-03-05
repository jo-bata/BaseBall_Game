package kr.ac.skuniv.controller;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import kr.ac.skuniv.model.Gamesound;
import kr.ac.skuniv.model.GuideModel;
import kr.ac.skuniv.model.IntroModel;
import kr.ac.skuniv.model.Model;
import kr.ac.skuniv.model.RankingModel;
import kr.ac.skuniv.view.Board;
import kr.ac.skuniv.view.Guide;
import kr.ac.skuniv.view.Intro;
import kr.ac.skuniv.view.Ranking;

public class IntroController implements MouseListener, MouseMotionListener {
	Frame frame;
	IntroModel introModel;
	Container contentPane;
	Intro intro;
	Gamesound menusound, guidesound, playsound, scoresound;

	public IntroController(Frame frame, IntroModel introModel, Container contentPane, Intro intro, Gamesound menusound) {
		this.frame = frame;
		this.introModel = introModel;
		this.contentPane = contentPane;
		this.intro = intro;
		this.menusound = menusound;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
	    //**************************************************************************************************************//
		// Game Guide Click
		if ((x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() - 120 && y <= introModel.getGamestart_y() - 120 + introModel.heigth)) {
			GuideModel guideModel = new GuideModel();
			Guide guide = new Guide(guideModel);
			Gamesound menuclick = new Gamesound("menuclick.wav");
			menuclick.nothing();
			contentPane.remove(intro);
			menusound.stopSound();
			Gamesound guidesound = new Gamesound("guide.wav");
			guide.addMouseListener(new GuideController(frame, guideModel, contentPane, guide, guidesound));
			guide.addMouseMotionListener(new GuideController(frame, guideModel, contentPane, guide, guidesound));
			contentPane.add(guide);
			frame.setSize(840, 655);
			frame.setVisible(true);
			System.out.println("Game Guide Click");
		}
	    //**************************************************************************************************************//
		// Game Start Click
		if ((x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() && y <= introModel.getGamestart_y() + introModel.heigth)) {
			Model model = new Model();
			Board board = new Board(model);
			Gamesound menuclick = new Gamesound("menuclick.wav");
			menuclick.nothing();
			contentPane.remove(intro);
			menusound.stopSound();
			Gamesound playsound = new Gamesound("playball_1.wav");
			board.addMouseListener(new Controller(frame, model, contentPane, board, playsound));
			board.addMouseMotionListener(new Controller(frame, model, contentPane, board, playsound));
			contentPane.add(board);
			frame.setSize(1300, 950);
			frame.setVisible(true);
			System.out.println("Game Start Click");
			// 배열과 변수들 초기화
			model.setRealAnswer();
			model.setTryAnswer(model.clearMap(model.getTryAnswer(), model.MAX_NUM, 10));
			model.setCheckMark(model.clearMap(model.getCheckMark(), model.MAX_NUM, 0));
			model.setResult(model.clearMap(model.getResult(), model.MAX_NUM - 2, 0));
			model.count = 0;
			model.tryCount = 0;
			model.checkCount = 0;
		}
		
		if ((x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() + 120 && y <= introModel.getGamestart_y() + 120 + introModel.heigth)) {
			RankingModel rankingModel = new RankingModel();
			Ranking ranking = new Ranking(rankingModel);
			Gamesound menuclick = new Gamesound("menuclick.wav");
			menuclick.nothing();
			contentPane.remove(intro);
			menusound.stopSound();
			Gamesound scoresound = new Gamesound("scoreboard.wav");
			ranking.addMouseListener(new RankingController(frame, rankingModel, contentPane, ranking, scoresound));
			ranking.addMouseMotionListener(new RankingController(frame, rankingModel, contentPane, ranking, scoresound));
			contentPane.add(ranking);
			frame.setSize(840, 655);
			frame.setVisible(true);
			System.out.println("Scoreboard Click");
		}
		
		if ((x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() + 120 * 2 && y <= introModel.getGamestart_y() + 120 * 3 + introModel.heigth)) {
			Gamesound menuclick = new Gamesound("menuclick.wav");
			menuclick.nothing();
			System.exit(1);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		if((x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() - 120 && y <= introModel.getGamestart_y() + 120 * 3 + introModel.heigth)) {
			if ((x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() - 120 && y <= introModel.getGamestart_y() - 120 + introModel.heigth)) {
				introModel.checkEntered = 1;
			}
			if ((x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() && y <= introModel.getGamestart_y() + introModel.heigth)) {
				introModel.checkEntered = 2;
			}
			
			if ((x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() + 120 && y <= introModel.getGamestart_y() + 120 + introModel.heigth)) {
				introModel.checkEntered = 3;
			}
			
			if ((x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() + 120 * 2 && y <= introModel.getGamestart_y() + 120 * 3 + introModel.heigth)) {
				introModel.checkEntered = 4;
			}
		}
		
		if (
			(x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() - 120 && y <= introModel.getGamestart_y() - 120 + introModel.heigth) ||
			(x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() && y <= introModel.getGamestart_y() + introModel.heigth) ||
			(x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() + 120 && y <= introModel.getGamestart_y() + 120 + introModel.heigth) ||
			(x >= introModel.getGamestart_x() && x <= introModel.getGamestart_x() + introModel.width) && (y >= introModel.getGamestart_y() + 120 * 2 && y <= introModel.getGamestart_y() + 120 * 3 + introModel.heigth)
		   )
			;
		else
			introModel.checkEntered = 0;
		intro.repaint();
	}
}
