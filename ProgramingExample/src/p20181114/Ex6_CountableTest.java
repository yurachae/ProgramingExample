package p20181114;

public class Ex6_CountableTest {
	public static void main(String[] args) {
		Ex6_Countable[] c = { new Ex6_Bird("뻐꾸기"), new Ex6_Bird("독수리"), new Ex6_Tree("사과나무"), new Ex6_Tree("밤나무") };

		for(Ex6_Countable a : c) {
			a.count();
		}
		
		// 배열에 있는 갯수만큼 반복.
		for (int i = 0; i < c.length; i++) {
			// 배열의 한 원소가 Bird 타입이라면 Bird타입으로 강제 형변환을 해서
			// 구현클래스에 정의되어 있는 메소드를 사용해서 출력함.
			if (c[i] instanceof Ex6_Bird) {
				((Ex6_Bird)c[i]).fly();				
			
				
			// 배열의 한 원소가 Tree 타입이라면 Tree타입으로 강제 형변환을 해서
			// 구현클래스에 정의되어 있는 메소드를 사용해서 출력함.
			} else if (c[i] instanceof Ex6_Tree) {
				((Ex6_Tree)c[i]).ripen();

			}
		}
	}

}
