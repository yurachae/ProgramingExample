package shopEx;

// 쇼핑몰 규격을 정의한 인터페이스, 모든 쇼핑몰은 IShop 인터페이스를 구현해야 함.
public interface IShop {
	//쇼핑몰의 이름 
	public abstract void setTitle(String title);
	//사용자 등록
	public abstract void genUser();
	//상품 등록
	public abstract void genProduct();
	//쇼핑몰 실행 
	public abstract void start();
}
