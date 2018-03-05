package kr.ac.skuniv.controller;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import kr.ac.skuniv.model.Gamesound;
import kr.ac.skuniv.model.IntroModel;
import kr.ac.skuniv.model.Model;
import kr.ac.skuniv.view.Board;
import kr.ac.skuniv.view.Intro;

public class Controller implements MouseListener, MouseMotionListener {
	Frame frame;
	Model model;
	Container contentPane;
	Board board;
	Gamesound playsound;

	public Controller(Frame frame, Model model, Container contentPane, Board board, Gamesound playsound) {
		this.frame = frame;
		this.model = model;
		this.contentPane = contentPane;
		this.board = board;
		this.playsound = playsound;
	}
	@SuppressWarnings("static-access")
	@Override
	public void mouseClicked(MouseEvent e) {
    //**************************************************************************************************************//
		int x = e.getX();
		int y = e.getY();
	//**************************************************************************************************************//
		// ���� ���
		if((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= 155 && y <= 155 + model.key_xy)) {
			Gamesound menuclick = new Gamesound("menuclick.wav");
			menuclick.nothing();
			board.guide("�� ���ӹ��\n- 0 ~ 9 ������ 4�ڸ� ���ڸ� ���ߴ� �����Դϴ�.\n- �ִ�õ� Ƚ���� 10ȸ�� ���ѵ˴ϴ�.\n- Strike : ���ڿ� �ڸ��� ��� �¾��� ��\n- Ball : ���ڴ� �°� �ڸ��� Ʋ���� ��\n- �¸����� : 4S �� ��� �ڸ��� ���ڸ� ���߸� �¸��մϴ�.\n\n�� �߰����\n- �޸��� : �õ��ߴ� ���ڿ� ���콺�� Ŭ���Ͽ� ���׶��(Strike), ����(Ball), ����(out)�� ǥ���� �� �ֽ��ϴ�.");
		}
	//**************************************************************************************************************//
		// �ٽ� �ϱ�
		if((x >= model.key_x + (model.width * 1) && x <= model.key_x + model.width + model.key_xy) && (y >= 155 && y <= 155 + model.key_xy)) {
			Gamesound playball = new Gamesound("playball.wav");
			playball.nothing();
			model.setRealAnswer();
			model.setTryAnswer(model.clearMap(model.getTryAnswer(), model.MAX_NUM, 10));
			model.setCheckMark(model.clearMap(model.getCheckMark(), model.MAX_NUM, 0));
			model.setResult(model.clearMap(model.getResult(), model.MAX_NUM - 2, 0));
			model.count = 0;
			model.tryCount = 0;
			model.checkCount = 0;
		}
	//**************************************************************************************************************//
		// ���� �޴�
		if((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= 155 && y <= 155 + model.key_xy)) {
			IntroModel introModel = new IntroModel();
			Intro intro = new Intro(introModel);
			Gamesound menuclick = new Gamesound("menuclick.wav");
			menuclick.nothing();
			contentPane.remove(board);
			playsound.stopSound();
			Gamesound menusound = new Gamesound("menu.wav");
			intro.addMouseListener(new IntroController(frame, introModel, contentPane, intro, menusound));
			intro.addMouseMotionListener(new IntroController(frame, introModel, contentPane, intro, menusound));
			contentPane.add(intro);
			frame.setSize(1000, 1000);
			frame.setVisible(true);
			System.out.println("gomenu Click");
		}
	//**************************************************************************************************************//
		// 1, 2, 3, 4, 5, 6, 7, 8, 9, 0
		if((model.tryCount < model.MAX_TRY) && (model.count >= 0 && model.count <= 3)) {
			if((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= model.key_y && y <= model.key_y + model.key_xy)) {
				Gamesound keyclick = new Gamesound("keyclick.wav");
				keyclick.nothing();
				model.setTryAnswer(model.tryCount, model.count, 1);
				model.count++;
			}
			if((x >= model.key_x + (model.width * 1) && x <= model.key_x + model.width + model.key_xy) && (y >= model.key_y && y <= model.key_y + model.key_xy)) {
				Gamesound keyclick = new Gamesound("keyclick.wav");
				keyclick.nothing();
				model.setTryAnswer(model.tryCount, model.count, 2);
				model.count++;
			}
			if((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= model.key_y && y <= model.key_y + model.key_xy)) {
				Gamesound keyclick = new Gamesound("keyclick.wav");
				keyclick.nothing();
				model.setTryAnswer(model.tryCount, model.count, 3);
				model.count++;
			}
			if((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= model.key_y + (model.heigth * 1) && y <= model.key_y + model.heigth + model.key_xy)) {
				Gamesound keyclick = new Gamesound("keyclick.wav");
				keyclick.nothing();
				model.setTryAnswer(model.tryCount, model.count, 4);
				model.count++;
			}
			if((x >= model.key_x + (model.width * 1) && x <= model.key_x + model.width + model.key_xy) && (y >= model.key_y + model.heigth && y <= model.key_y + model.heigth + model.key_xy)) {
				Gamesound keyclick = new Gamesound("keyclick.wav");
				keyclick.nothing();
				model.setTryAnswer(model.tryCount, model.count, 5);
				model.count++;
			}
			if((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= model.key_y + model.heigth && y <= model.key_y + model.heigth + model.key_xy)) {
				Gamesound keyclick = new Gamesound("keyclick.wav");
				keyclick.nothing();
				model.setTryAnswer(model.tryCount, model.count, 6);
				model.count++;
			}
			if((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= model.key_y + (model.heigth * 2) && y <= model.key_y + (model.heigth * 2) + model.key_xy)) {
				Gamesound keyclick = new Gamesound("keyclick.wav");
				keyclick.nothing();
				model.setTryAnswer(model.tryCount, model.count, 7);
				model.count++;
			}
			if((x >= model.key_x + model.width && x <= model.key_x + model.width + model.key_xy) && (y >= model.key_y + (model.heigth * 2) && y <= model.key_y + (model.heigth * 2) + model.key_xy)) {
				Gamesound keyclick = new Gamesound("keyclick.wav");
				keyclick.nothing();
				model.setTryAnswer(model.tryCount, model.count, 8);
				model.count++;
			}
			if((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= model.key_y + (model.heigth * 2) && y <= model.key_y + (model.heigth * 2) + model.key_xy)) {
				Gamesound keyclick = new Gamesound("keyclick.wav");
				keyclick.nothing();
				model.setTryAnswer(model.tryCount, model.count, 9);
				model.count++;
			}
			if((x >= model.key_x + model.width && x <= model.key_x + model.width + model.key_xy) && (y >= model.key_y + (model.heigth * 3) && y <= model.key_y + (model.heigth * 3) + model.key_xy)) {
				Gamesound keyclick = new Gamesound("keyclick.wav");
				keyclick.nothing();
				model.setTryAnswer(model.tryCount, model.count, 0);
				model.count++;
			}
		}
    //**************************************************************************************************************//
		// backspace
		if((model.tryCount < model.MAX_TRY) && (model.count > 0 && model.count <= 4)) {
			if((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= model.key_y + (model.heigth * 3) && y <= model.key_y + (model.heigth * 3) + model.key_xy)) {
				Gamesound keyclick = new Gamesound("keyclick.wav");
				keyclick.nothing();
				model.setTryAnswer(model.tryCount, model.count - 1, 10);
				if(model.count > 0)
					model.count--;
			}
		}
    //**************************************************************************************************************//
		// enter
		if((model.tryCount < model.MAX_TRY) && (model.count == 4)) {
			if((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= model.key_y + (model.heigth * 3) && y <= model.key_y + (model.heigth * 3) + model.key_xy)) {
					if(model.tryCount < model.MAX_TRY) {
						Gamesound enterclick = new Gamesound("enterclick.wav");
						enterclick.nothing();
						model.setResult(model.tryCount, 0, model.checkStrike());  // Strike ����
						model.setResult(model.tryCount, 1, model.checkBall());  // Ball ����
						if((model.tryCount != model.MAX_TRY - 1) && (model.getResult(model.tryCount, 0) == 4)) {  // 4S �϶� ���� Ŭ����
							board.clear("�����մϴ� ! ������ " + (model.tryCount + 1) + "�� ���� Ŭ���� �Ͽ����ϴ� !");
							IntroModel introModel = new IntroModel();
							Intro intro = new Intro(introModel);
							contentPane.remove(board);
							playsound.stopSound();
							Gamesound menusound = new Gamesound("menu.wav");
							intro.addMouseListener(new IntroController(frame, introModel, contentPane, intro, menusound));
							intro.addMouseMotionListener(new IntroController(frame, introModel, contentPane, intro, menusound));
							contentPane.add(intro);
							frame.setSize(1000, 1000);
							frame.setVisible(true);
							System.out.println("Game Clear gomenu");
						}
						model.tryCount++;  // �õ� Ƚ�� 1 ����		
						model.count = 0;  // �ڸ��� 0���� �ٽ� ����
						model.checkCount++;
					}
						
			}
		}
    //**************************************************************************************************************//
		// checkMark
		for(int i = 0; i < model.MAX_TRY; i++) {
			for(int j = 0; j < model.MAX_NUM; j++)
				if(model.checkCount > i)
					if((x >= 100 + (100 * j)&& x <= 100 + 20 + (100 * j)) && (y >= 340 - 30 + (55 * i) && y <= 340 + (55 * i))) {
						if(model.checkMark[i][j] == 0) {
							Gamesound strike = new Gamesound("strike.wav");
							strike.nothing();
						}
						if(model.checkMark[i][j] == 1) {
							Gamesound ball = new Gamesound("ball.wav");
							ball.nothing();
						}
						if(model.checkMark[i][j] == 2) {
							Gamesound out = new Gamesound("out.wav");
							out.nothing();
						}
						if(model.checkMark[i][j] == 3)
							model.checkMark[i][j] = 0;
						else
							model.checkMark[i][j]++;
					}
		}
    //**************************************************************************************************************//
		// MAX_TRY �϶� clear, fail
		if(model.tryCount == 10) {
			if(model.getResult(model.tryCount - 1, 0) == 4) {  // 4S �϶� ���� Ŭ����
				board.clear("�����մϴ� ! ������ " + model.tryCount + "�� ���� Ŭ���� �Ͽ����ϴ� !");
				IntroModel introModel = new IntroModel();
				Intro intro = new Intro(introModel);
				contentPane.remove(board);
				playsound.stopSound();
				Gamesound menusound = new Gamesound("menu.wav");
				intro.addMouseListener(new IntroController(frame, introModel, contentPane, intro, menusound));
				intro.addMouseMotionListener(new IntroController(frame, introModel, contentPane, intro, menusound));
				contentPane.add(intro);
				frame.setSize(1000, 1000);
				frame.setVisible(true);
				System.out.println("Game Clear gomenu");
			}
			else {  // ���� ����
				board.fail("������ Ŭ���� ���� ���߽��ϴ� ! ������ " + model.getRealAnswer()[0] + "" + model.getRealAnswer()[1] + ""  + model.getRealAnswer()[2] + ""  + model.getRealAnswer()[3] + "�Դϴ� !" );
				IntroModel introModel = new IntroModel();
				Intro intro = new Intro(introModel);
				contentPane.remove(board);
				playsound.stopSound();
				Gamesound menusound = new Gamesound("menu.wav");
				intro.addMouseListener(new IntroController(frame, introModel, contentPane, intro, menusound));
				intro.addMouseMotionListener(new IntroController(frame, introModel, contentPane, intro, menusound));
				contentPane.add(intro);
				frame.setSize(1000, 1000);
				frame.setVisible(true);
				System.out.println("Game fail gomenu");
			}
		}
		board.repaint();
//		for(int i = 0; i < model.MAX_TRY; i++)
//			System.out.println(model.checkMark[i][0] + ", " + model.checkMark[i][1] + ", " + model.checkMark[i][2] + ", " + model.checkMark[i][3]);
//		for(int i = 0; i < model.MAX_TRY; i++)
//			System.out.println(model.getTryAnswer()[i][0] + ", " + model.getTryAnswer()[i][1] + ", " + model.getTryAnswer()[i][2] + ", " + model.getTryAnswer()[i][3]);
//		intro.repaint();		
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
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	//**************************************************************************************************************//
		int x = e.getX();
		int y = e.getY();
	//**************************************************************************************************************//
		// ���콺�� �÷����� �� ��������� ĥ�� �� �ֵ��� ������ �ʱ�ȭ ������
		if((x >= model.key_x && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= 155 && y <= model.key_y + (model.heigth * 3) + model.key_xy)) {
			if((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= 155 && y <= 155 + model.key_xy)) {
				model.checkEntered = -3;
			}
			if((x >= model.key_x + (model.width * 1) && x <= model.key_x + model.width + model.key_xy) && (y >= 155 && y <= 155 + model.key_xy)) {
				model.checkEntered = -2;
			}
			if((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= 155 && y <= 155 + model.key_xy)) {
				model.checkEntered = -1;
			}
			if((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= model.key_y && y <= model.key_y + model.key_xy)) {
				model.checkEntered = 1;
			}
			if((x >= model.key_x + (model.width * 1) && x <= model.key_x + model.width + model.key_xy) && (y >= model.key_y && y <= model.key_y + model.key_xy)) {
				model.checkEntered = 2;
			}
			if((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= model.key_y && y <= model.key_y + model.key_xy)) {
				model.checkEntered = 3;
			}
			if((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= model.key_y + (model.heigth * 1) && y <= model.key_y + model.heigth + model.key_xy)) {
				model.checkEntered = 4;
			}
			if((x >= model.key_x + (model.width * 1) && x <= model.key_x + model.width + model.key_xy) && (y >= model.key_y + model.heigth && y <= model.key_y + model.heigth + model.key_xy)) {
				model.checkEntered = 5;
			}
			if((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= model.key_y + model.heigth && y <= model.key_y + model.heigth + model.key_xy)) {
				model.checkEntered = 6;
			}
			if((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= model.key_y + (model.heigth * 2) && y <= model.key_y + (model.heigth * 2) + model.key_xy)) {
				model.checkEntered = 7;
			}
			if((x >= model.key_x + model.width && x <= model.key_x + model.width + model.key_xy) && (y >= model.key_y + (model.heigth * 2) && y <= model.key_y + (model.heigth * 2) + model.key_xy)) {
				model.checkEntered = 8;
			}
			if((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= model.key_y + (model.heigth * 2) && y <= model.key_y + (model.heigth * 2) + model.key_xy)) {
				model.checkEntered = 9;
			}
			if((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= model.key_y + (model.heigth * 3) && y <= model.key_y + (model.heigth * 3) + model.key_xy)) {
				model.checkEntered = 10;
			}
			if((x >= model.key_x + model.width && x <= model.key_x + model.width + model.key_xy) && (y >= model.key_y + (model.heigth * 3) && y <= model.key_y + (model.heigth * 3) + model.key_xy)) {
				model.checkEntered = 11;
			}
			if((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= model.key_y + (model.heigth * 3) && y <= model.key_y + (model.heigth * 3) + model.key_xy)) {
				model.checkEntered = 12;
			}
		}
	//**************************************************************************************************************//
		// �ۿ����� 0���� �ʱ�ȭ
		if(
			((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= 155 && y <= 155 + model.key_xy)) ||
			((x >= model.key_x + (model.width * 1) && x <= model.key_x + model.width + model.key_xy) && (y >= 155 && y <= 155 + model.key_xy)) ||
			((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= 155 && y <= 155 + model.key_xy)) ||
			((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= model.key_y && y <= model.key_y + model.key_xy)) ||
			((x >= model.key_x + (model.width * 1) && x <= model.key_x + model.width + model.key_xy) && (y >= model.key_y && y <= model.key_y + model.key_xy)) ||
			((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= model.key_y && y <= model.key_y + model.key_xy)) ||
			((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= model.key_y + (model.heigth * 1) && y <= model.key_y + model.heigth + model.key_xy)) ||
			((x >= model.key_x + (model.width * 1) && x <= model.key_x + model.width + model.key_xy) && (y >= model.key_y + model.heigth && y <= model.key_y + model.heigth + model.key_xy)) || 
			((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= model.key_y + model.heigth && y <= model.key_y + model.heigth + model.key_xy)) ||
			((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= model.key_y + (model.heigth * 2) && y <= model.key_y + (model.heigth * 2) + model.key_xy)) ||
			((x >= model.key_x + model.width && x <= model.key_x + model.width + model.key_xy) && (y >= model.key_y + (model.heigth * 2) && y <= model.key_y + (model.heigth * 2) + model.key_xy)) ||
			((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= model.key_y + (model.heigth * 2) && y <= model.key_y + (model.heigth * 2) + model.key_xy)) ||
			((x >= model.key_x && x <= model.key_x + model.key_xy) && (y >= model.key_y + (model.heigth * 3) && y <= model.key_y + (model.heigth * 3) + model.key_xy)) ||
			((x >= model.key_x + model.width && x <= model.key_x + model.width + model.key_xy) && (y >= model.key_y + (model.heigth * 3) && y <= model.key_y + (model.heigth * 3) + model.key_xy)) ||
			((x >= model.key_x + (model.width * 2) && x <= model.key_x + (model.width * 2) + model.key_xy) && (y >= model.key_y + (model.heigth * 3) && y <= model.key_y + (model.heigth * 3) + model.key_xy))
		  )
			;
		else
			model.checkEntered = 0;
	//**************************************************************************************************************//
		board.repaint();
	}
}
