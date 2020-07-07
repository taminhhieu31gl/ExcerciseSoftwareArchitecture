package services;

public class TestFacade {
	public static void main(String[] args) {
		ShopFacade.getInstance().buyProductByCashWithFreeShipping("hieuta81pk@gmail.com");
		ShopFacade.getInstance().buyProductByPaypalWithStandardShipping("hieuta@gmail.com", "0124.678.910");
	}
}
