package kr.ac.skuniv.model;

public class IntroModel {
	public int width = 460;
	public int heigth = 85;	
	private int gamestart_x = 275;
	private int gamestart_y = 575;
	public int checkEntered = 0; // 좌표 내에 들어오면 1~4, 아니면 0

	public int getGamestart_x() { return gamestart_x; }
	
	public void setGamestart_x(int gamestart_x) { this.gamestart_x = gamestart_x; }
	
	public int getGamestart_y() { return gamestart_y; }
	
	public void setGamestart_y(int gamestart_y) { this.gamestart_y = gamestart_y; }
}
