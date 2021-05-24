package librarian;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
	  Scanner sc = new Scanner(System.in);
	    private String bNo; 			// 도서번호 (ISBN)
	    private String bTitle; 			// 도서명
	    private String bAuthor; 		// 저자 
	    private String bGenre;			// 장르
	   
	    private String bPrice;				// 가격
	    
	    private boolean bAvailable;		// 대출가능여부
	    private ArrayList<Book> bookList = new ArrayList<Book>();	//<Book> 형태의 ArrayList에 책의 정보를 누적시킴
	 
	    public Book() {
	 
	    }
	 
	    public String getbNo() {
	        return bNo;
	    }
	 
	    public void setbNo(String bNo) {
	        this.bNo = bNo;
	    }
	 
	    public String getbTitle() {
	        return bTitle;
	    }
	 
	    public void setbTitle(String bTitle) {
	        this.bTitle = bTitle;
	    }
	 
	    public String getbAuthor() {
	        return bAuthor;
	    }
	 
	    public void setbAuthor(String bAuthor) {
	        this.bAuthor = bAuthor;
	    }
	 
	    public String getbGenre() {
	        return bGenre;
	    }
	 
	    public void setbGenre(String bGenre) {
	        this.bGenre = bGenre;
	    }
	 
	    
	    
	    public String getbPrice() {
			return bPrice;
		}

		public void setbPrice(String bPrice) {
			this.bPrice = bPrice;
		}

		public boolean isbAvailable() {
	        return bAvailable;
	    }
	 
	    public void setbAvailable(boolean bAvailable) {
	        this.bAvailable = bAvailable;
	    }
	   
	    
	    public void showMain() throws InterruptedException {
	        while (true) {
	            System.out.println("<<사서 로그인 中...>> 첫번째 화면");
	            System.out.println("[1] 도서 관리(등록/수정/삭제)\t [2] 전체 조회\t [3] 개별 조회\t [4] 도서 반납 및 대여\t [5] 회원 관리(조회/수정/삭제) [0] 종료");
	            String userInput = sc.nextLine();
	     
	            switch (userInput) {
	            case ("1"):
	                manageBook(); // 도서관리
	                break;
	     
	            case ("2"):
	                selectAll(); // 전체 조회
	                break;
	            case ("3"):
	                selectOne(); // 개별 조회
	                break;
	     
	            case ("4"):
	                checkBook(); // 도서 대여반납
	                break;
	            
	            case("5"):		
	            	manageUser();	// 회원관리
	            	break;
	                
	            case ("0"):
	                System.out.println("프로그램 종료");
	                sc.close();
	                System.exit(0);
	            default:
	                System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
	                break;
	            }
	        }//end while
	    }//end showMain
	    
	    public void manageBook() throws InterruptedException {
	    	while (true) {
	            System.out.println("<<사서 로그인 中...>> 도서관리");
	            System.out.println("[1] 도서 등록\t [2] 도서 정보 수정 \t [3] 등록된 도서 폐기\t [0] 종료");
	            String userInput = sc.nextLine();
	            switch (userInput) {
	            case ("1"):
	                insertBook(); // 도서관리
	                break;
	     
	            case ("2"):
	                updateBook();
	                break;
	            case ("3"):
	                deletebook();
	                break;
	            case ("0"):
	                System.out.println("프로그램 종료");
	                sc.close();
	                System.exit(0);
	            default:
	                System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
	                break;
	            }
	        }//end while
	    }//end showMain
	            
	    public void insertBook() throws InterruptedException {
	        while (true) {
	            Book book = new Book();
	            // 도서 번호는 중복되면 안 됨
	            while (true) {
	                int cnt=0;
	                System.out.println("도서 번호 입력");
	                String temp = sc.nextLine();
	                for (int i = 0; i < bookList.size(); i++) {
	                    if (temp.equals(bookList.get(i).getbNo())) {
	                        cnt++;
	                        System.out.println("도서 번호 중복입니다. 다시 입력하세요.");
	                        break;
	                    } // end if
	                } // end for
	                if(cnt==0) {
	                    book.setbNo(temp);
	                    break;
	                }
	            } // end while
	            System.out.println("책 제목 입력");
	            book.setbTitle(sc.nextLine());
	            System.out.println("작가 입력");
	            book.setbAuthor(sc.nextLine());
	            System.out.println("장르 입력");
	            book.setbGenre(sc.nextLine());
	            System.out.println("가격 입력");
	            book.setbPrice(sc.nextLine());
	            book.setbAvailable(true);
	            Thread.sleep(1000);
	 
	            // 컨펌 후에 리스트에 객체 저장
	            System.out.println("도서번호 : " + book.getbNo());
	            System.out.println("도서제목 : " + book.getbTitle());
	            System.out.println("지 은 이  : " + book.getbAuthor());
	            System.out.println("장     르  : " + book.getbGenre());
	            System.out.println("가     격  : " + book.getbPrice());
	            System.out.println("대여가능 : " + book.isbAvailable());
	 
	            System.out.println("입력하신 사항이 모두 맞습니까? 예(Y) 아니오(N)");
	            String confirm = sc.nextLine();
	            if (confirm.equalsIgnoreCase("y")) {
	                bookList.add(book);
	                System.out.println("======입력 완료=====");
	                break;
	            } else if (confirm.equalsIgnoreCase("n")) {
	                System.out.println("도서 정보를 새로 입력하세요.");
	            } else {
	                System.out.println("잘못 누르셨습니다. 초기 메뉴로 이동합니다");
	                break; // 초기메뉴로 이동
	            } // if-else end
	        } // end while
	 
	        Thread.sleep(1000);
	    }// end main
	    
	    // 책 정보 수정
	    public void updateBook() {
	        while (true) {
	            System.out.println("수정 할 책의 번호를 입력해주세요");
	            String temp = sc.nextLine();
	            int cnt = 0;
	            for (int i = 0; i < bookList.size(); i++) {
	                if (temp.equals(bookList.get(i).getbNo())) {
	                    System.out.println("새로운 제목 입력: ");
	                    bookList.get(i).setbTitle(sc.nextLine());
	                    System.out.println("새로운 지은이 입력: ");
	                    bookList.get(i).setbAuthor(sc.nextLine());
	                    System.out.println("새로운 장르 입력: ");
	                    bookList.get(i).setbGenre(sc.nextLine());
	                    System.out.println("새로운 가격 입력 :");
	                    bookList.get(i).setbPrice(sc.nextLine());
	                    cnt++;
	                    System.out.println("도서 수정 완료");
	                    break;
	                }
	            } // end for
	            if (cnt == 0) {
	                System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
	            } else {
	                break;// 메인으로
	            }
	        } // end while
	    }
	    
	    
	    
	 // 책 삭제
	    public void deletebook() {
	        while (true) {
	            System.out.println("삭제 할 책의 번호를 입력해주세요");
	            String temp = sc.nextLine();
	            int cnt = 0;
	            for (int i = 0; i < bookList.size(); i++) {
	                if (temp.equals(bookList.get(i).getbNo())) {
	                    bookList.remove(i);
	                    cnt++;
	                    System.out.println("도서 삭제 완료");
	                    break;
	                }
	            } // end for
	            if (cnt == 0) {
	                System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
	            } else {
	                break;// 메인으로
	            }
	        } // end while
	    }

	    public void manageUser() throws InterruptedException {
	    	while (true) {
	            System.out.println("<<사서 로그인 中...>> 회원관리");
	            System.out.println("[1] 일반회원 정보조회\t [2] 일반회원 정보수정 \t [3] 회원정보 폐기\t [0] 종료");
	            String userInput = sc.nextLine();
	            switch (userInput) {
	            case ("1"):
	                printUserList(); // 회원리스트 출력
	                break;
	     
	            case ("2"):
	                userUpdate(); // 회원정보 수정
	                break;
	                
	            case ("3"):
	                userDelete(); // 회원정보 삭제
	                break;
	            }
	    	}//end while
	    }//end manageUser
	    
	    public void printUserList() throws InterruptedException{
	    	while(true) {
	    		System.out.println("======회원가입 명단======");
	    		System.out.println("전체 인원수 : " + list.size());
	    		for (UserVO vo : list) {
	    			System.out.print(vo.getName() + "\t");
	    			System.out.print(vo.getBirth() + "\t");
	    			System.out.print(vo.getId() + "\t");
	    			System.out.print(vo.getPwd() + "\t");
	    			System.out.print(vo.getPhone() + "\n");
	    			
	    		}
	    		System.out.println();
	    		
	    	}
	    	
	    	public void userUpdate() {									
	    		if (uservo == null) {
	    			System.out.println("\n로그인이 필요 합니다.");
	    			return;
	    		}

	    		System.out.println("\n회원 정보 수정...");

	    		try {
	    			UserVO vo = readUser(uservo.getId());

	    			System.out.print("패스워드를 다시 입력 하세요 ? ");
	    			String pwd = br.readLine();

	    			if (!vo.getPwd().equals(pwd)) {
	    				System.out.println("패스워드가 일치하지 않습니다.\n");
	    				return;
	    			}

	    			System.out.print("수정할 패스워드 ? ");
	    			vo.setPwd(br.readLine());

	    			System.out.print("수정할 폰번호? ");
	    			vo.setPhone(br.readLine());

	    			System.out.println("회원 정보를 수정했습니다.\n");

	    		} catch (Exception e) {
	    			System.out.println(e.toString());
	    		}
	    }
	    	
	    	public void userDelete() {									
	    		
	    		UserVO vo1=readUser(uservo.getId());
	    		UserVO vo2=readUser("admin");
	    		
	    		try {
	    			if(uservo.getId()!="admin") {
	    				System.out.println("\n회원 탈퇴");
	    				
	    				System.out.print("패스워드를 다시 입력 하세요 ? ");
	    				String pwd = br.readLine();
	    				
	    				if(! vo1.getPwd().equals(pwd)) {
	    					System.out.println("패스워드가 일치하지 않습니다.\n");
	    					return;
	    				}
	    				
	    			} else if (uservo.getId()=="admin") {
	    				System.out.println("\n회원 삭제");
	    				
	    				System.out.println("삭제할 아이디? ");
	    				vo1=readUser(br.readLine());
	    				if (vo1==null) {
	    					System.out.println("아이디가 존재하지 않습니다.");
	    					return;
	    				}
	    				System.out.print(vo1.getId()+"\t");
	    				System.out.print(vo1.getName()+"\t");
	    				System.out.print(vo1.getPhone()+"\t\n");
	    				System.out.println("삭제할 아이디가 맞나요? [Y/N] ");
	    				String s1 = br.readLine();
	    				
	    				if (s1.equals("Y") || s1.equals("y") ) {
	    					System.out.print("관리자 패스워드를 입력 하세요 ? ");
	    					String pwd = br.readLine();
	    					
	    					if(! vo2.getPwd().equals(pwd)) {
	    						System.out.println("패스워드가 일치하지 않습니다.\n");
	    						return;
	    					}
	    					
	    				} else {
	    					System.out.println("삭제를 취소합니다.");
	    					return;
	    				}
	    			}
	    			
	    			list.remove(vo1);
	    			
	    			if(uservo.getId()!="admin") {
	    				System.out.println("회원탈퇴가 처리 되었습니다.\n");
	    			} else {
	    				System.out.println("회원삭제가 처리 되었습니다.\n");
	    			}
	    			
	    		} catch (Exception e) {
	    			System.out.println(e.toString());
	    		}
	    		
	    		uservo = null;
	    	}
	    
	                
	                
	                
	                
	    // 전체 조회
	    public void selectAll() throws InterruptedException {
	        while (true) {
	            System.out.println("보유 도서량:  " + bookList.size());
	            for (int i = 0; i < bookList.size(); i++) {
	                System.out.println("===============================");
	                System.out.println("책 번호 : " + bookList.get(i).getbNo());
	                System.out.println("책 제목 : " + bookList.get(i).getbTitle());
	                System.out.println("지은이  : " + bookList.get(i).getbAuthor());
	                System.out.println("장   르  : " + bookList.get(i).getbGenre());
	                System.out.println("가   격  : " + bookList.get(i).getbPrice());
	                System.out.println("대여가능 : " + bookList.get(i).isbAvailable());
	                System.out.println("===============================\n");
	 
	            } // end for
	            System.out.println("초기 메뉴 이동 : [b] \t 프로그램 종료 : [0]");
	            String temp = sc.nextLine();
	            if (temp.equalsIgnoreCase("b")) {
	                break;
	            } else if (temp.equals("0")) {
	                System.out.println("프로그램을 종료합니다.");
	                Thread.sleep(1000);
	                System.exit(0);
	            } else {
	                System.out.println("잘못 누르셨습니다. 초기화면으로 이동합니다.");
	                Thread.sleep(1000);
	                break; // 메인으로 돌아감
	            } // if-else end
	        } // while end
	    }// end selectAll
	    
	    
	 // 도서 번호로 검색
	    public void selectOne() {
	        while (true) {
	            System.out.println("검색 할 책의 번호를 입력해주세요");
	            String temp = sc.nextLine();
	            int cnt = 0;
	            for (int i = 0; i < bookList.size(); i++) {
	                if (temp.equals(bookList.get(i).getbNo())) {
	                    System.out.println("===============================");
	                    System.out.println("책 번호 : " + bookList.get(i).getbNo());
	                    System.out.println("책 제목 : " + bookList.get(i).getbTitle());
	                    System.out.println("지은이  : " + bookList.get(i).getbAuthor());
	                    System.out.println("장   르  : " + bookList.get(i).getbGenre());
	                    System.out.println("가   격  : " + bookList.get(i).getbPrice());
	                    System.out.println("대여가능 : " + bookList.get(i).isbAvailable());
	                    System.out.println("===============================\n");
	                    cnt++;
	                    break;
	                }
	            } // end for
	            if (cnt == 0) {
	                System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
	            } else {
	                break;// 메인으로
	            }
	        } // end while
	    }
	    	    
	 // 책 반납 및 대여
	    public void checkBook() {
	        while (true) {
	            System.out.println("해당 도서 번호를 입력해주세요");
	            String temp = sc.nextLine();
	            int cnt = 0;
	            for (int i = 0; i < bookList.size(); i++) {
	                if (temp.equals(bookList.get(i).getbNo())) {
	                    cnt++;
	                    boolean bStatus = bookList.get(i).isbAvailable();
	 
	                    if (bStatus) {
	                        bStatus = false;
	                        System.out.println("도서가 대여되었습니다.");
	                    } else {
	                        bStatus = true;
	                        System.out.println("도서가 반납되었습니다.");
	                    }
	                    bookList.get(i).setbAvailable(bStatus);
	                    break;
	                }
	            } // end for
	            if (cnt == 0) {
	                System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
	            } else {
	                break;// 메인으로
	            }
	        } // end while
	    }
}
