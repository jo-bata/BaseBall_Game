package kr.ac.skuniv.model;
import java.util.Random;

public class Model {
	public final int MAX_NUM = 4; // ���ڴ� 4�ڸ�
	public final int MAX_TRY = 10;  // �ִ� �õ� Ƚ�� 10ȸ�� ����  
	public int width = 150;
	public int heigth = 140;
	public int key_x = 770;  // one�� x ��ǥ
	public int key_y = 290;  // one�� y ��ǥ
	public int key_xy = 128; // key �̹����� ����, ����
	public int checkEntered = 0; // ��ǥ ���� ������ 1~12, �ƴϸ� 0
	private int[] realAnswer = new int[MAX_NUM];  // realAnswer
	private int[][] tryAnswer = { { 10, 10, 10, 10 },  // tryAnswer
								  { 10, 10, 10, 10 },
								  { 10, 10, 10, 10 },
								  { 10, 10, 10, 10 },
								  { 10, 10, 10, 10 },
								  { 10, 10, 10, 10 },
								  { 10, 10, 10, 10 },
								  { 10, 10, 10, 10 },
								  { 10, 10, 10, 10 },
								  { 10, 10, 10, 10 } };
	private int[][] result = new int[MAX_TRY][2];  // ��Ʈ����ũ, �� ����
	public static int count = 0;  // ���° �������� ī��Ʈ�ϴ� ����
	public static int tryCount = 0;  // �õ� Ƚ�� ī��Ʈ
	public static int checkCount = 0; // drawCheck ī��Ʈ
	public static int[][] checkMark = { { 0, 0, 0, 0 },   // ���׶��, ����, ����, ���� üũ�� �迭
			                     { 0, 0, 0, 0 },
			                     { 0, 0, 0, 0 },
			                     { 0, 0, 0, 0 },
			                     { 0, 0, 0, 0 },
			                     { 0, 0, 0, 0 },
			                     { 0, 0, 0, 0 },
			                     { 0, 0, 0, 0 },
			                     { 0, 0, 0, 0 },
			                     { 0, 0, 0, 0 } };
	//**************************************************************************************************************//
	// getter, setter
	public int[] getRealAnswer() {  // RealAnswer getter
		return realAnswer;
	}
	
	public void setRealAnswer() {  // ������ �����Ͽ� realAnswer�� ����� �޼ҵ�(RealAnswer setter)
		Random random = new Random();
		realAnswer[0] = random.nextInt(10);
		do{
			realAnswer[1] = random.nextInt(10);
		}while (realAnswer[0] == realAnswer[1]);
		do{
			realAnswer[2] = random.nextInt(10);
		}
		while (realAnswer[0] == realAnswer[2] || realAnswer[1] == realAnswer[2]);
		do{
			realAnswer[3] = random.nextInt(10);
		}
		while (realAnswer[0] == realAnswer[3] || realAnswer[1] == realAnswer[3] || realAnswer[2] == realAnswer[3]);
			
		System.out.println(realAnswer[0] + "" + realAnswer[1] + "" + realAnswer[2] + "" + realAnswer[3]);
	}
	
	public int[][] getTryAnswer() { return tryAnswer; }  // TryAnswer getter
	public int getTryAnswer(int x, int y) { return tryAnswer[x][y]; }  // TryAnswer getter
	
	public void setTryAnswer(int[][] tryAnswer) { this.tryAnswer = tryAnswer; }  // TryAnswer setter
	public void setTryAnswer(int x, int y, int value) {	tryAnswer[x][y] = value; }  // TryAnswer setter

	
	public int[][] getResult() { return result; }   // Result getter
	public int getResult(int x, int y) { return result[x][y]; }  // Result getter
	
	public void setResult(int[][] result) { this.result = result; }  // Result setter
	public void setResult(int x, int y, int value) { result[x][y] = value; }  // Result setter
	
	public int[][] getCheckMark() { return checkMark; } // checkMark getter
	@SuppressWarnings("static-access")
	public void setCheckMark(int [][] checkMark) { this.checkMark = checkMark; }  // checkMark setter
	//**************************************************************************************************************//
	public int[][] clearMap(int[][] map, int num, int value) {  // �迭�� �ʱ�ȭ �����ִ� �Լ�
		for(int i = 0; i < MAX_TRY; i++)
			for(int j = 0; j < num; j++)
				map[i][j] = value;
		return map;
	}
	//**************************************************************************************************************//
	public int checkStrike() {  // Strike �˻� �� �����ϴ� �޼ҵ�
		int strike = 0;
		for(int i = 0; i < MAX_NUM; i++)
			if(tryAnswer[tryCount][i] == realAnswer[i])
				strike++;
		return strike;
	}

	public int checkBall() {  // Ball �˻� �� �����ϴ� �޼ҵ�
		int ball = 0;
		for(int i = 0; i < MAX_NUM; i++)
			for(int j = 0; j < MAX_NUM; j++)
				if((i != j) && (tryAnswer[tryCount][i] == realAnswer[j]))
						ball++;
		return ball;
	}
	//**************************************************************************************************************//
	public Model() {
		setRealAnswer();
	}
}
