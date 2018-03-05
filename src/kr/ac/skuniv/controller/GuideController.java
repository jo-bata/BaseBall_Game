package kr.ac.skuniv.controller;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import kr.ac.skuniv.model.IntroModel;
import kr.ac.skuniv.model.Gamesound;
import kr.ac.skuniv.model.GuideModel;
import kr.ac.skuniv.view.Intro;
import kr.ac.skuniv.view.Guide;

public class GuideController implements MouseListener, MouseMotionListener{
	Frame frame;
	GuideModel guideModel;
	Container contentPane;
	Guide guide;
	Gamesound guidesound;
	
	public GuideController(Frame frame, GuideModel guideModel, Container contentPane, Guide guide, Gamesound guidesound) {
		this.frame = frame;
		this.guideModel = guideModel;
		this.contentPane = contentPane;
		this.guide = guide;
		this.guidesound = guidesound;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		if ((x >= guideModel.getGomenu_x() && x <= guideModel.getGomenu_x() + guideModel.width) && (y >= guideModel.getGomenu_y() && y <= guideModel.getGomenu_y() + guideModel.heigth)) {
			IntroModel introModel = new IntroModel();
			Intro intro = new Intro(introModel);
			Gamesound menuclick = new Gamesound("menuclick.wav");
			menuclick.nothing();
			contentPane.remove(guide);
			guidesound.stopSound();
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
		
		if ((x >= guideModel.getGomenu_x() && x <= guideModel.getGomenu_x() + guideModel.width) && (y >= guideModel.getGomenu_y() && y <= guideModel.getGomenu_y() + guideModel.heigth))
			guideModel.checkEntered = 1;
		
		if ((x >= guideModel.getGomenu_x() && x <= guideModel.getGomenu_x() + guideModel.width) && (y >= guideModel.getGomenu_y() && y <= guideModel.getGomenu_y() + guideModel.heigth))
		 ;
		else
			guideModel.checkEntered = 0;
		guide.repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
