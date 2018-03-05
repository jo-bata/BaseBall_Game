package kr.ac.skuniv.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RankingModel {
	public int width = 225;
	public int heigth = 70;	
	private int gomenu_x = 550;
	private int gomenu_y = 15;
	public int checkEntered = 0; // ��ǥ ���� ������ 1~4, �ƴϸ� 0
	
	public int getGomenu_x() { return gomenu_x; }
	
	public void setGomenu_x(int gomenu_x) { this.gomenu_x = gomenu_x; }
	
	public int getGomenu_y() { return gomenu_y; }
	
	public void setGomenu_y(int gomenu_y) { this.gomenu_y = gomenu_y; }
	
	public String getScore() {  // 
		FileReader reader = null;
		String str = "";
		try {
			reader = new FileReader("score.txt");
			while(true) {
				int data = reader.read();
				if (data == - 1)
					break;
				char ch = (char) data;
				char[] chr = { ch };
				str += Character.toString(chr[0]);
			}
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		}
		catch (IOException ioe) {
			System.out.println("������ ���� �� �����ϴ�.");
		}
		finally {
			try {
				reader.close();
			}
			catch (Exception e) {
				
			}
		}
		return str;
	}
}
