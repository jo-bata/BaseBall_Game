package kr.ac.skuniv.model;

public class GuideModel {
	public int width = 225;
	public int heigth = 70;	
	private int gomenu_x = 550;
	private int gomenu_y = 15;
	public int checkEntered = 0; // 좌표 내에 들어오면 1~4, 아니면 0
	
	public int getGomenu_x() { return gomenu_x; }
	
	public void setGomenu_x(int gomenu_x) { this.gomenu_x = gomenu_x; }
	
	public int getGomenu_y() { return gomenu_y; }
	
	public void setGomenu_y(int gomenu_y) { this.gomenu_y = gomenu_y; }
}
