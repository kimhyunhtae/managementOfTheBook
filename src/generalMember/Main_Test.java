package generalMember;

import java.util.Scanner;

public class Main_Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserImpl user = new UserImpl();
		int ch;

		while (true) {
			if (user.loginMember() == null) { // 로그인이 되지 않은 경우
				do {
					System.out.print("1.로그인 2.회원가입 3.종료 => ");
					ch = sc.nextInt();
				} while (ch < 1 || ch > 3);

				if (ch == 3)
					break;

				switch (ch) {
				case 1: {
					user.logIn();
					break;
				}
				case 2: {
					user.join();
					break;
				}

				}

			} else if (user.loginMember().getId() == "admin") { // 로그인 한 경우

				do {
					System.out.print("1.도서 관리 2.회원관리 3.로그아웃 4.종료 ");
					ch = sc.nextInt();
				} while (ch < 1 || ch > 4);

				if (ch == 4)
					break;
			}
		}
	}
}