package ch04;

public class SwitchTest3 {

	public static void main(String[] args) {
		switch (args[0]) {
		case "h":
			System.out.println("도움말 출력");
		case "all":
			System.out.println("전체 목록 출력");
		default:
			System.out.println("잘못된 입력");
		}
	}
}
