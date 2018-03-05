package kr.ac.skuniv.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.ac.skuniv.model.Gamesound;
import kr.ac.skuniv.model.Model;

@SuppressWarnings("serial")

public class Board extends JPanel {
	Font font = new Font("굴림", 80, 80);
	Font font2 = new Font("신명조", 35, 35);
	Model model;
	ImageIcon back, baseball_ball, guide, restart, gomenu;
	ImageIcon zero, one, two, three, four, five, six, seven, eight, nine, backspace, enter;
	ImageIcon e_guide, e_restart, e_gomenu, e_zero, e_one, e_two, e_three, e_four, e_five, e_six, e_seven, e_eight, e_nine, e_backspace, e_enter;
	ImageIcon circle, triangle, x;
	// **************************************************************************************************************//
	public void drawKeyboard(Graphics g, Model model) {
		g.drawRect(model.key_x - 20, 150, 470, 700);  // 750, 130 470
		g.drawLine(model.key_x - 20, 280, 1220, 280);
		g.drawImage(guide.getImage(), model.key_x, 155, null);
		g.drawImage(restart.getImage(), model.key_x + model.width, 155, null);
		g.drawImage(gomenu.getImage(), model.key_x + (model.width * 2), 155, null);
		g.drawImage(one.getImage(), model.key_x, model.key_y, null);
		g.drawImage(two.getImage(), model.key_x + model.width, model.key_y, null);
		g.drawImage(three.getImage(), model.key_x + (model.width * 2), model.key_y, null);
		g.drawImage(four.getImage(),model.key_x, model.key_y + model.heigth, null);
		g.drawImage(five.getImage(), model.key_x + model.width, model.key_y + model.heigth, null);
		g.drawImage(six.getImage(), model.key_x + (model.width * 2), model.key_y + model.heigth, null);
		g.drawImage(seven.getImage(), model.key_x, model.key_y + (model.heigth * 2), null);
		g.drawImage(eight.getImage(), model.key_x + model.width, model.key_y + (model.heigth * 2), null);
		g.drawImage(nine.getImage(), model.key_x + (model.width * 2), model.key_y + (model.heigth * 2), null);
		g.drawImage(backspace.getImage(), model.key_x, model.key_y + (model.heigth * 3), null);
		g.drawImage(zero.getImage(), model.key_x + model.width, model.key_y + (model.heigth * 3), null);
		g.drawImage(enter.getImage(), model.key_x + (model.width * 2), model.key_y + (model.heigth * 3), null);
		
		switch(model.checkEntered) {
			case -3: g.drawImage(e_guide.getImage(), model.key_x, 155, null); break;
			case -2: g.drawImage(e_restart.getImage(), model.key_x + model.width, 155, null); break;
			case -1: g.drawImage(e_gomenu.getImage(), model.key_x + (model.width * 2), 155, null); break;
			case 1: g.drawImage(e_one.getImage(), model.key_x, model.key_y, null); break;
			case 2: g.drawImage(e_two.getImage(), model.key_x + model.width, model.key_y, null); break;
			case 3: g.drawImage(e_three.getImage(), model.key_x + (model.width * 2), model.key_y, null); break;
			case 4: g.drawImage(e_four.getImage(),model.key_x, model.key_y + model.heigth, null); break;
			case 5: g.drawImage(e_five.getImage(), model.key_x + model.width, model.key_y + model.heigth, null); break;
			case 6: g.drawImage(e_six.getImage(), model.key_x + (model.width * 2), model.key_y + model.heigth, null); break;
			case 7: g.drawImage(e_seven.getImage(), model.key_x, model.key_y + (model.heigth * 2), null); break;
			case 8: g.drawImage(e_eight.getImage(), model.key_x + model.width, model.key_y + (model.heigth * 2), null); break;
			case 9: g.drawImage(e_nine.getImage(), model.key_x + (model.width * 2), model.key_y + (model.heigth * 2), null); break;
			case 10: g.drawImage(e_backspace.getImage(), model.key_x, model.key_y + (model.heigth * 3), null); break;
			case 11: g.drawImage(e_zero.getImage(), model.key_x + model.width, model.key_y + (model.heigth * 3), null); break;
			case 12: g.drawImage(e_enter.getImage(), model.key_x + (model.width * 2), model.key_y + (model.heigth * 3), null); break;
		}
	}
	// **************************************************************************************************************//
	public void guide(String message) {
		JOptionPane.showMessageDialog(this, message, "Game Guide", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void clear(String message) {
		Gamesound batting_suc = new Gamesound("batting_suc.wav");
		batting_suc.nothing();
		JOptionPane.showMessageDialog(this, message, "Game Clear", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void fail(String message) {
		Gamesound batting_fail = new Gamesound("batting_fail.wav");
		batting_fail.nothing();
		JOptionPane.showMessageDialog(this, message, "Game Fail", JOptionPane.PLAIN_MESSAGE);
	}
	// **************************************************************************************************************//
	@SuppressWarnings("static-access")
	public void drawTry(Graphics g, Model model) {  // 마우스를 클릭하여 입력되는 tryAnswer를 그려주는 메소드
		if(model.tryCount < model.MAX_TRY) {
			for (int i = 0; i < model.MAX_NUM; i++) {
				switch (model.getTryAnswer()[model.tryCount][i]) {
					case 10: g.drawImage(baseball_ball.getImage(), 60 + (model.width * i), model.width, null); break;
					case 9: g.drawImage(nine.getImage(), 60 + (model.width * i), model.width, null);  break;
					case 8: g.drawImage(eight.getImage(), 60 + (model.width * i), model.width, null);  break;
					case 7: g.drawImage(seven.getImage(), 60 + (model.width * i), model.width, null);  break;
					case 6: g.drawImage(six.getImage(), 60 + (model.width * i), model.width, null);  break;
					case 5: g.drawImage(five.getImage(), 60 + (model.width * i), model.width, null);  break;
					case 4: g.drawImage(four.getImage(), 60 + (model.width * i), model.width, null);  break;
					case 3: g.drawImage(three.getImage(), 60 + (model.width * i), model.width, null);  break;
					case 2: g.drawImage(two.getImage(), 60 + (model.width * i), model.width, null);  break;
					case 1: g.drawImage(one.getImage(), 60 + (model.width * i), model.width, null);  break;
					case 0: g.drawImage(zero.getImage(), 60 + (model.width * i), model.width, null);  break;
				}
			}
		}
		else
			for (int i = 0; i < model.MAX_NUM; i++)
				g.drawImage(baseball_ball.getImage(), 60 + (model.width * i), model.width, null);
	}
	// **************************************************************************************************************//
	@SuppressWarnings("static-access")
	public void drawCheck(Graphics g, Model model) {  // 확인버튼을 눌렀을때 4자리의 숫자와 스트라이크, 볼 결과를 그려주는 메소드
		if(model.checkCount > 0) {
			for(int i = 0; i < model.tryCount; i++) {
				for(int j = 0; j < model.MAX_NUM; j++)
					g.drawString("" + model.getTryAnswer()[i][j], 100 + (100 * j), 340 + (55 * i));
				g.setColor(Color.RED);
				g.drawString("S", 500, 340 + (55 * i));
				g.setColor(Color.BLACK);
				g.drawString("" + model.getResult()[i][0], 530, 340 + (55 * i));
				g.setColor(Color.BLUE);
				g.drawString("B", 575, 340 + (55 * i));
				g.setColor(Color.BLACK);
				g.drawString("" + model.getResult()[i][1], 605, 340 + (55 * i));
			}
		}
	}
	// **************************************************************************************************************//
	@SuppressWarnings("static-access")
	public void drawMark(Graphics g, Model model) {  // 동그라미, 세모, 엑스, 공백 표시를 그려주는 메소드
		if(model.tryCount < model.MAX_TRY) {
			for (int i = 0; i < model.MAX_TRY; i++)
				for (int j = 0; j < model.MAX_NUM; j++)
					switch (model.checkMark[i][j]) {
						case 0: ; break;
						case 1: g.drawImage(circle.getImage(), 92 + (100 * j), 310 + (55 * i), null);  break;
						case 2: g.drawImage(triangle.getImage(), 92 + (100 * j), 310 + (55 * i), null);  break;
						case 3: g.drawImage(x.getImage(), 92 + (100 * j), 310 + (55 * i), null);  break;
					}
		}
	}
	// **************************************************************************************************************//
	public void paint(Graphics g) {  // 게임화면을 그려주는 메소드
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(back.getImage(), 0, 0, 1300, 950, null);
		g.drawRect(50, 150, 600, 130);
		g.drawRect(50, 300, 600, 550);
		g.drawLine(475, 300, 475, 850);
		drawTry(g, model);  // 클릭되어지는 현재 tryAnswer를 그린다.
		g.setFont(font2);
		drawCheck(g, model);  // tryAnswer와 Strike 그리고 Ball을 그린다.
		drawMark(g, model);  // 동그라미, 세모, 엑스 메모를 가능하게한다.
		drawKeyboard(g, model);  // Keyboard를 그린다.

		g.setFont(font);
//		g.drawString("KEYBOARD", model.key_x, model.key_y - 45);
		// g.drawString(""+model.getNum(), 50, 100);
		setOpaque(false);
	}

	// **************************************************************************************************************//
	public Board(Model model) {
		this.model = model;
		back = new ImageIcon("back.PNG");
		baseball_ball = new ImageIcon("baseball_ball.PNG");
		guide = new ImageIcon("guide.PNG");
		restart = new ImageIcon("restart.PNG");
		gomenu = new ImageIcon("gomenu.PNG");
		zero = new ImageIcon("zero.PNG");
		one = new ImageIcon("one.PNG");
		two = new ImageIcon("two.PNG");
		three = new ImageIcon("three.PNG");
		four = new ImageIcon("four.PNG");
		five = new ImageIcon("five.PNG");
		six = new ImageIcon("six.PNG");
		seven = new ImageIcon("seven.PNG");
		eight = new ImageIcon("eight.PNG");
		nine = new ImageIcon("nine.PNG");
		backspace = new ImageIcon("backspace.PNG");
		enter = new ImageIcon("enter.PNG");
		e_guide = new ImageIcon("e_guide.PNG");
		e_restart = new ImageIcon("e_restart.PNG");
		e_gomenu = new ImageIcon("e_gomenu.PNG");
		e_zero = new ImageIcon("e_zero.PNG");
		e_one = new ImageIcon("e_one.PNG");
		e_two = new ImageIcon("e_two.PNG");
		e_three = new ImageIcon("e_three.PNG");
		e_four = new ImageIcon("e_four.PNG");
		e_five = new ImageIcon("e_five.PNG");
		e_six = new ImageIcon("e_six.PNG");
		e_seven = new ImageIcon("e_seven.PNG");
		e_eight = new ImageIcon("e_eight.PNG");
		e_nine = new ImageIcon("e_nine.PNG");
		e_backspace = new ImageIcon("e_backspace.PNG");
		e_enter = new ImageIcon("e_enter.PNG");
		circle = new ImageIcon("circle.PNG");
		triangle = new ImageIcon("triangle.PNG");
		x = new ImageIcon("x.PNG");
	}
}
