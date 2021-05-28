package librarian;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		LibrarianImpl librarian = new LibrarianImpl();
		

		int ch;
				
		while (true) {
			if (librarian.loginMember() == null) { // 로그인이 돼있지 않은 경우
				do {
					System.out.print("1.로그인 2.회원가입 3.종료 ");
					ch = sc.nextInt();
				
				if (ch == 3) {
					System.out.println("프로그램이 종료되었습니다.");
					break;}

				switch (ch) {
				case 1: {
					librarian.logIn();
					bookMenu();
					break;
				}
				case 2: {
					librarian.join();
					break;
				}

				} // switch 끝
				} while (true); // do 끝
			}
		}
	} // 로그인이 돼있지 않은 경우 끝

	
	static void bookMenu() { // 사서 로그인 한 경우
		BookImpl book = new BookImpl();
		LibrarianImpl librarian = new LibrarianImpl();

		Scanner sc = new Scanner(System.in);
		
		int ch;
		do {
			System.out.print("1.도서 관리 2.회원관리 3.로그아웃 4.이전메뉴 ");
			ch = sc.nextInt();
		} while (ch < 1 || ch > 4);

		if (ch == 4)
			return;
	


		switch (ch) {
		case 1:
			do {
				System.out.print("1.도서등록 2.도서수정 3.도서삭제 4.도서검색 5.도서리스트 6.복귀  ");
				ch = sc.nextInt();
			} while (ch < 1 || ch > 6);

			if (ch == 6)
				break;

			switch (ch) {

			case 1:
				book.bookAdd();
				bookMenu();
				break; // 도서 등록
			case 2:
				book.bookUpdate();
				bookMenu();
				break; // 도서 수정
			case 3:
				book.bookDelete();
				bookMenu();
				break; // 도서 삭제
				
			case 4:
				book.bookSearch();
				bookMenu();
				break; // 도서명검색
			case 5:
				book.printBookList();
				bookMenu();
				break; // 도서리스트
			}
			break;
		
		case 2:
			do {
				System.out.print("1.회원 리스트 2.이름검색 3.회원삭제 4.복귀  ");
				ch = sc.nextInt();
			} while (ch < 1 || ch > 4);

			if (ch == 4)
				break;

//			switch (ch) {
//			case 1:
//				user.printUserList();
//				break; // 회원리스트
//			case 2:
//				user.userSecrch();
//				break; // 아이디검색
//			case 3:
//				user.userDelete();
//				break; // 유저 삭제
//			}
//			break;
		case 3:
			librarian.logOut();
			return; // 로그아웃
//
//		}
	}// 사서 로그인 한 경우끝
}
}