package p20181112;

public class Ex01_TwoPoint {

	int point1X;
	int point1Y;
	int point2X;
	int point2Y;


	// 두점 사이의 거리 구하기.
	public  double distance(int point1X, int point1Y, int point2X, int point2Y) {

		int x = Math.abs(point1X - point2X);
		int y = Math.abs(point1Y - point2Y);
		
		double result = Math.sqrt(x*x + y*y);
		return result;
	}
}
