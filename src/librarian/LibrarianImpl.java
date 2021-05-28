package librarian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LibrarianImpl implements Librarian {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static List<LibrarianVO> id_list = new LinkedList<LibrarianVO>();
	private LibrarianVO librarianvo; // 현재 로그인 중인 VO

	public LibrarianImpl() {
		LibrarianVO vo = new LibrarianVO();
		vo.setId("admin");
			vo.setPwd("admin");
			vo.setName("관리자");
			vo.setBirth("2000-10-10");
			vo.setPhone("010-1234-5678");
		id_list.add(vo);

	}

	@Override
	public void join() {
		Scanner sc = new Scanner(System.in);
		int secret = 1; // 사서 보안코드

		System.out.println("\n사서회원 가입");
		try {
			LibrarianVO vo = new LibrarianVO(); // 정보담는 vo 생성

			System.out.println("사서 보안코드 4자리를 입력하세요.");
			if (secret != sc.nextInt()) {
				System.out.println("코드가 일치하지 않아 프로그램을 종료합니다.");
				sc.close();
				System.exit(0);
			} else {

				System.out.print("아이디 ? ");
				vo.setId(br.readLine());

				if (readLibrarian(vo.getId()) != null) {
					System.out.println("등록된 아이디 입니다.\n");
					return;
				}

				System.out.print("패스워드 ? ");
				vo.setPwd(br.readLine());

				System.out.print("이름 ? ");
				vo.setName(br.readLine());

				System.out.print("생년월일 ? ");
				vo.setBirth(br.readLine());

				System.out.print("폰번호 ? ");
				vo.setPhone(br.readLine());

				id_list.add(vo); // vo를 userlist에 추가함
				System.out.println("회원 가입을 축하합니다. 로그인 하세요\n");

			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	
	}

	@Override
	public void logIn() {
		System.out.println("\n사서 로그인...");
		String id, pwd;

		try {
			System.out.print("아이디 ? ");
			id = br.readLine();

			System.out.print("패스워드 ? ");
			pwd = br.readLine();

			LibrarianVO vo = readLibrarian(id);

			if (vo != null) { // 일치하는 id가 있으면
				if (vo.getPwd().equals(pwd)) { // pw를 입력한 pwd와 비교해라
					librarianvo = vo; // 일치하면 현재 로그인 상태로 입력
					System.out.println("로그인을 성공하였습니다.");
					return;
				}
			} else {  //pw가 일치하지 않으면 
				System.out.println("아이디 또는 패스워드가 일치하지 않습니다.\n");
			} // logIn종료

		} catch (IOException e) {
			System.out.println(e.toString());
		}

	}

	@Override
	public void logOut() {
		librarianvo = null;
		
		System.out.println("로그아웃 되었습니다.\n");
		
	}

//		@Override
//		public void userSearch() {
//			System.out.println("\n이름 검색...");
//			try {
//				System.out.println("찾을 이름을 입력하세요. ");
//				String s1 = br.readLine();
//				UserVO vo = null;
//
//				for (UserVO data : list) {
//					if (data.getName().equals(s1)) {
//						vo = data;
//						break;
//					}
//				}
//
//				System.out.print(vo.getName() + "\t\t");
//				System.out.print(vo.getBirth() + "\t\t");
//				System.out.print(vo.getId() + "\t\t");
//				System.out.print(vo.getPhone() + "\n");
//
//				System.out.println("처음메뉴로 돌아갑니다.");
//
//			} catch (Exception e) {
//
//			}
//		}
	// 회원정보 검색

//		@Override
//		public void printUserList() {
//			System.out.println("\n회원가입 명단");
//			System.out.println("전체 인원수 : " + list.size());
//			for (UserVO vo : list) {
//				System.out.print(vo.getName() + "\t");
//				System.out.print(vo.getBirth() + "\t");
//				System.out.print(vo.getId() + "\t");
//				System.out.print(vo.getPwd() + "\t");
//				System.out.print(vo.getPhone() + "\n");
//
//			}
//			System.out.println();
//
//		}
	// 회원관리 -> 일반회원 명단 조회

	@Override
	public void librarianDelete() {

		LibrarianVO vo1 = readLibrarian(librarianvo.getId());
		LibrarianVO vo2 = readLibrarian("admin");

		try {
			if (librarianvo.getId() != "admin") {
				System.out.println("\n회원 탈퇴");

				System.out.print("패스워드를 다시 입력 하세요 ? ");
				String pwd = br.readLine();

				if (!vo1.getPwd().equals(pwd)) {
					System.out.println("패스워드가 일치하지 않습니다.\n");
					return;
				}

			} else if (librarianvo.getId() == "admin") {
				System.out.println("\n회원 삭제");

				System.out.println("삭제할 아이디? ");
				vo1 = readLibrarian(br.readLine());
				if (vo1 == null) {
					System.out.println("아이디가 존재하지 않습니다.");
					return;
				}
				System.out.print(vo1.getId() + "\t");
				System.out.print(vo1.getName() + "\t");
				System.out.print(vo1.getPhone() + "\t\n");
				System.out.println("삭제할 아이디가 맞나요? [Y/N] ");
				String s1 = br.readLine();

				if (s1.equals("Y") || s1.equals("y")) {
					System.out.print("관리자 패스워드를 입력 하세요 ? ");
					String pwd = br.readLine();

					if (!vo2.getPwd().equals(pwd)) {
						System.out.println("패스워드가 일치하지 않습니다.\n");
						return;
					}

				} else {
					System.out.println("삭제를 취소합니다.");
					return;
				}
			}

			id_list.remove(vo1);

			if (librarianvo.getId() != "admin") {
				System.out.println("회원탈퇴가 처리 되었습니다.\n");
			} else {
				System.out.println("회원삭제가 처리 되었습니다.\n");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		librarianvo = null;
	}

	private LibrarianVO readLibrarian(String id) {
		LibrarianVO vo = null; // vo 기본 null == 미로그인

		for (LibrarianVO data : id_list) { // userList전체에서
			if (data.getId().equals(id)) { // id하나하나 검색
				vo = data; // 일치하면 id에 해당하는 userList의 인덱스 정보 입력
				break;
			}
		}

		return vo; // 위에 일치하느 것 없으면 null
	}

	public LibrarianVO loginMember() {
		return librarianvo;

	}
}
