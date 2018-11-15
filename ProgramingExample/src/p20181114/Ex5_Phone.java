package p20181114;
//부모 인터페이스
//10개 버튼 있음.
//전화를 걸고 받을 수 있음.
public interface Ex5_Phone {
	
	int[] button = new int[10];
	
	
	//추상메소드
	public void HangIn() ;	//전화받기
	public void HangOut(); 	//전화걸기

	//디폴트메소드
	default void buttonSetting() {
		for(int i =0; i<button.length; i++) {
			button[i] = i;
		}
	}
}
