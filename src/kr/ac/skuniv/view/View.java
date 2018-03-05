package kr.ac.skuniv.view;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import kr.ac.skuniv.controller.IntroController;
import kr.ac.skuniv.model.Gamesound;
import kr.ac.skuniv.model.IntroModel;
import kr.ac.skuniv.model.Model;

public class View {
	Model model = new Model();
	IntroModel introModel = new IntroModel();
	Intro intro = new Intro(introModel);
	Gamesound menusound = new Gamesound("menu.wav");
	
	public View() {
		JFrame frame = new JFrame("Baseball Game");  // �����Ӹ�
		Container contentPane = frame.getContentPane();
		contentPane.add(intro);
		intro.addMouseListener(new IntroController(frame, introModel, contentPane, intro, menusound));
		intro.addMouseMotionListener(new IntroController(frame, introModel, contentPane, intro, menusound));
		frame.setPreferredSize(new Dimension(1000, 1000));  // ������ũ�� ����
		frame.setLocation(10,10);  //������ ���� ��ġ ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);		
	}
}
