package librarian;
//사서 로그인 및 회원관리

	public interface Librarian {

		public void join();				// 회원가입한다.		

		public void logIn();			// 로그인한다.			

		public void logOut();			// 로그아웃한다.		

//		public void userSearch(); 		// 가입된 회원을 검색한다.		
//		public void printUserList();	    // 회원리스트를 출력한다.	

			

		public void librarianDelete(); 		// 회원탈퇴, 삭제한다.	


}
