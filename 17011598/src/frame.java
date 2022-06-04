import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class frame extends JFrame{
	// 초기화면 버튼
	JButton btmgr = new JButton("관리자");
	JButton btmem = new JButton("회원");
	JButton btback = new JButton("뒤로가기");
	
	// 관리자 화면 버튼
	JButton btmgrinit = new JButton("초기화");
	JButton btmgrinsert = new JButton("입력");
	JButton btmgrdelete = new JButton("삭제");
	JButton btmgrupdate = new JButton("변경");
	JButton btmgrselect = new JButton("전체조회");
	
	// 관리자 화면 테이블 7개
	JTable[] mgrtable = new JTable[7];
	JScrollPane[] mgrscroll = new JScrollPane[7];
	
	// 관리자 화면 테이블 입력, 삭제, 변경 버튼 
	JButton[] btmgrinserttable = new JButton[7];
	JButton[] btmgrdeletetable = new JButton[7];
	JButton[] btmgrupdatetable = new JButton[7];
	
	// 관리자 화면 테이블 확인 취소 버튼
	JButton btmgrcanceltable = new JButton("취소");
	// 0 -> insert 		1 -> delete		2-> update 		3 -> select
	JButton[] btmgrchecktable = new JButton[4];
	
	
	// 관리자 화면 테이블 데이터 입력 받는 텍스트박스
	JTextField[] mgrtextfield = new JTextField[9];
	JLabel[] mgrlabel = new JLabel[9];
	JTextField mgrwheretextfield = new JTextField();
	JLabel mgrtablelabel;
	JLabel mgrwherelabel = new JLabel("조건식 입력");
	
	// 회원 화면 버튼
	JButton btmemmoviesearch = new JButton("영화 조회");
	JButton btmemreservationsearch = new JButton("예매 조회");
	
	// 영화조회 텍스트박스 라벨
	JTextField[] memtfmoviesearch = new JTextField[4];
	JLabel[] memlblmoviesearch = new JLabel[4];
	JTextField memtfmoviesearchID = new JTextField();
	JLabel memlblmoviesearchID = new JLabel("회원ID");
	JTextField memtfmoviesearchpayment = new JTextField();
	JLabel memlblmoviesearchpayment = new JLabel("결제방법");
	
	// 영화조회 취소 예매 조회 버튼
	JButton btmemmoviesearchlookup = new JButton("조회");
	JButton btmemmoviesearchcancle = new JButton("취소");
	JButton[] btmemmoviesearchreservation = new JButton[4];
	
	// 영화예매 영화 상영일정 좌석 테이블 
	JTable memmoviesearchmovietable;
	JScrollPane memmoviesearchmoviescroll;
	JTable memmoviesearchmoviescheduletable;
	JScrollPane memmoviesearchmovieschedulescroll;
	JTable memmoviesearchseattable;
	JScrollPane memmoviesearchseatscroll;
	
	// 예매조회 확인 취소 삭제 변경 버튼
	JButton btmemreservationsearchcheck = new JButton("확인");
	JButton btmemreservationsearchcancle = new JButton("취소");
	JButton btmemreservationsearchremove = new JButton("삭제");
	JButton btmemreservationsearchchangemovie = new JButton("영화변경");
	JButton btmemreservationsearchchangeschedule = new JButton("상영일정변경");
	JButton btmemreservationsearchchangecancel = new JButton("예매취소");
	JButton[] btmemreservationsearchchangereservation = new JButton[3];
	
	// 예매조회 테이블
	// 영화명, 상영일, 상영관번호, 좌석번호, 판매가격 테이블
	JTable memreservationsearchtable;
	JScrollPane memreservationsearchscroll;
	// 상영관, 상영일정, 티켓 테이블
	JTable memreservationsearchtheatertable;
	JScrollPane memreservationsearchtheaterscroll;
	JTable memreservationsearchscheduletable;
	JScrollPane memreservationsearchschedulescroll;
	JTable memreservationsearchtickettable;
	JScrollPane memreservationsearchticketscroll;
	// 영화, 상영일정, 좌석 변경 테이블
	JTable memreservationsearchchangemovietable;
	JScrollPane memreservationsearchchangemoviescroll;
	JTable memreservationsearchchangescheduletable;
	JScrollPane memreservationsearchchangeschedulescroll;
	JTable memreservationsearchchangeseattable;
	JScrollPane memreservationsearchchangeseatscroll;
	
	
	
	// 예매조회 ID입력 라벨 텍스트 박스
	JLabel memlblreservationsearchID = new JLabel("ID입력");
	JTextField memtfreservationsearchID = new JTextField();
	
	
	
	public frame() {
		this.setTitle("영화 예매 사이트");
		this.setLayout(null);
		this.setSize(1500,800);
		
		// 초기메뉴 생성
		InitMainMenu();
		
		// 관리자 메뉴 생성
		InitManagerMenu();
		
		// 관리자 테이블 생성
		InitManagerTable();
		
		// 관리자 테이블 입력 삭제 변경 버튼 생성
		InitManagerButton();
		
		// 관리자 테이블 데이터 입력 받는 텍스트박스 생성
		InitManagerTextField();
		
		// 회원 메뉴 생성
		InitMemberMenu();
		
		// 회원 영화조회 라벨 텍스트 박스 생성
		InitMemberMovieSearchTextField();
		
		// 회원 영화조회 조회 취소 예매 버튼 생성
		InitMemberMovieSearchButton();
		
		// 회원 영화조회 테이블 생성
		InitMemberMovieSearchTable();
		
		// 회원 예매조회 확인 취소 삭제 변경 버튼 생성
		InitMemberReservationSearchButton();
		
		// 회원 예매조회 테이블 생성
		InitMemberReservationSearchTable();
		
		// 회원 예매조회 라벨 텍스트 박스 생성
		InitMemberReservationSearchTextField();
		
		this.setVisible(true);
		
	}
	// 시작 메뉴
	private void InitMainMenu() {
		// 관리자 버튼
		btmgr.setSize(100, 100);
		btmgr.setLocation(600, 300);
		btmgr.addActionListener(new BtmgrListener());
		this.add(btmgr);
				
		// 회원 버튼
		btmem.setSize(100, 100);
		btmem.setLocation(800, 300);
		btmem.addActionListener(new BtmemListener());
		this.add(btmem);
				
		// 뒤로가기 버튼
		btback.setSize(100,50);
		btback.setLocation(1380,10);
		btback.addActionListener(new BtBackListener());
		btback.setVisible(false);
		this.add(btback);
	}
	// 관리자 메뉴
	private void InitManagerMenu() {
		// 관리자 초기화 버튼
		btmgrinit.setSize(100,50);
		btmgrinit.setLocation(0, 10);
		btmgrinit.setVisible(false);
		this.add(btmgrinit);
				
		// 관리자 입력 버튼
		btmgrinsert.setSize(100,50);
		btmgrinsert.setLocation(100, 10);
		btmgrinsert.addActionListener(new BtmgrInsertListener());
		btmgrinsert.setVisible(false);
		this.add(btmgrinsert);
				
		// 관리자 삭제 버튼
		btmgrdelete.setSize(100,50);
		btmgrdelete.setLocation(200, 10);
		btmgrdelete.addActionListener(new BtmgrDeleteListener());
		btmgrdelete.setVisible(false);
		this.add(btmgrdelete);
				
		// 관리자 변경 버튼
		btmgrupdate.setSize(100,50);
		btmgrupdate.setLocation(300, 10);
		btmgrupdate.addActionListener(new BtmgrUpdateListener());
		btmgrupdate.setVisible(false);
		this.add(btmgrupdate);
				
		// 관리자 전체조회 버튼
		btmgrselect.setSize(100,50);
		btmgrselect.setLocation(400, 10);
		btmgrselect.setVisible(false);
		btmgrselect.addActionListener(new BtmgrSelectListener());
		this.add(btmgrselect);
	}
	// 관리자 텍스트박스 초기화
	private void InitManagerTextField() {
		mgrtablelabel = new JLabel("a");
		mgrtablelabel.setSize(100,30);
		mgrtablelabel.setLocation(100, 100);
		mgrtablelabel.setVisible(false);
		this.add(mgrtablelabel);
		
		mgrwherelabel.setSize(100,30);
		mgrwherelabel.setLocation(500,250);
		mgrwherelabel.setVisible(false);
		this.add(mgrwherelabel);
		
		mgrwheretextfield.setSize(300,100);
		mgrwheretextfield.setLocation(500,300);
		mgrwheretextfield.setVisible(false);
		this.add(mgrwheretextfield);
		
		for(int i=0;i<9;i++) {
			mgrlabel[i] = new JLabel("a");
			mgrlabel[i].setSize(100,30);
			mgrlabel[i].setLocation(100, 150+50*i);
			mgrlabel[i].setVisible(false);
			this.add(mgrlabel[i]);
			
			mgrtextfield[i] = new JTextField();
			mgrtextfield[i].setSize(200,30);
			mgrtextfield[i].setLocation(250, 150+50*i);
			mgrtextfield[i].setVisible(false);
			this.add(mgrtextfield[i]);
		}
	}
	// 관리자 버튼 초기화
	private void InitManagerButton() {
		// 취소버튼
		btmgrcanceltable.setSize(100,50);
		btmgrcanceltable.setLocation(1000,400);
		btmgrcanceltable.setVisible(false);
		btmgrcanceltable.addActionListener(new BtmgrCancleListener());
		this.add(btmgrcanceltable);
		// 전체조회 확인버튼
		btmgrchecktable[3] = new JButton("확인");
		btmgrchecktable[3].setSize(100,50);
		btmgrchecktable[3].setLocation(1350,50);
		btmgrchecktable[3].setVisible(false);
		this.add(btmgrchecktable[3]);
		// 입력 삭제 변경 확인 버튼
		for(int i=0;i<3;i++) {
			btmgrchecktable[i] = new JButton("확인");
			btmgrchecktable[i].setSize(100,50);
			btmgrchecktable[i].setLocation(1000,300);
			btmgrchecktable[i].setVisible(false);
			this.add(btmgrchecktable[i]);
		}
		btmgrchecktable[0].addActionListener(new BtmgrInsertCheckListener());
		btmgrchecktable[1].addActionListener(new BtmgrDeleteCheckListener());
		btmgrchecktable[2].addActionListener(new BtmgrUpdateCheckListener());
		btmgrchecktable[3].addActionListener(new BtmgrSelectCheckListener());
		
		String[] name = {"영화","상영일정","상영관","티켓","좌석","회원고객","예매정보"};
		for(int i=0;i<7;i++) {
			// 입력버튼
			btmgrinserttable[i] = new JButton(name[i]);
			btmgrinserttable[i].setSize(100,50);
			btmgrinserttable[i].setLocation(100*i,10);
			btmgrinserttable[i].setVisible(false);
			this.add(btmgrinserttable[i]);
			
			// 삭제버튼
			btmgrdeletetable[i] = new JButton(name[i]);
			btmgrdeletetable[i].setSize(100,50);
			btmgrdeletetable[i].setLocation(100*i,10);
			btmgrdeletetable[i].setVisible(false);
			this.add(btmgrdeletetable[i]);
			
			// 변경버튼
			btmgrupdatetable[i] = new JButton(name[i]);
			btmgrupdatetable[i].setSize(100,50);
			btmgrupdatetable[i].setLocation(100*i,10);
			btmgrupdatetable[i].setVisible(false);
			this.add(btmgrupdatetable[i]);
		}
		// 입력버튼 이벤트
		btmgrinserttable[0].addActionListener(new BtmgrInsertMovieListener());
		btmgrinserttable[1].addActionListener(new BtmgrInsertMovieScheduleListener());
		btmgrinserttable[2].addActionListener(new BtmgrInsertTheaterListener());
		btmgrinserttable[3].addActionListener(new BtmgrInsertTicketListener());
		btmgrinserttable[4].addActionListener(new BtmgrInsertSeatListener());
		btmgrinserttable[5].addActionListener(new BtmgrInsertCustomerListener());
		btmgrinserttable[6].addActionListener(new BtmgrInsertReservationListener());
		
		// 삭제버튼 이벤트
		btmgrdeletetable[0].addActionListener(new BtmgrDeleteMovieListener());
		btmgrdeletetable[1].addActionListener(new BtmgrDeleteMovieScheduleListener());
		btmgrdeletetable[2].addActionListener(new BtmgrDeleteTheaterListener());
		btmgrdeletetable[3].addActionListener(new BtmgrDeleteTicketListener());
		btmgrdeletetable[4].addActionListener(new BtmgrDeleteSeatListener());
		btmgrdeletetable[5].addActionListener(new BtmgrDeleteCustomerListener());
		btmgrdeletetable[6].addActionListener(new BtmgrDeleteReservationListener());
		
		// 변경버튼 이벤트
		btmgrupdatetable[0].addActionListener(new BtmgrUpdateMovieListener());
		btmgrupdatetable[1].addActionListener(new BtmgrUpdateMovieScheduleListener());
		btmgrupdatetable[2].addActionListener(new BtmgrUpdateTheaterListener());
		btmgrupdatetable[3].addActionListener(new BtmgrUpdateTicketListener());
		btmgrupdatetable[4].addActionListener(new BtmgrUpdateSeatListener());
		btmgrupdatetable[5].addActionListener(new BtmgrUpdateCustomerListener());
		btmgrupdatetable[6].addActionListener(new BtmgrUpdateReservationListener());
	}
	
	
	// 관리자 테이블 생성 및 초기화
	private void InitManagerTable() {
		String[] movie = {"영화번호","영화명","상영시간","상영등급", 
				"감독명", "배우명", "장르", "영화소개" ,"개봉일 정보"};
		String[] movieschedule = {"상영일정번호", "영화번호", "상영관번호", "상영시작일", 
				"상영요일", "상영회차","상영시작시간"};
		String[] theater = {"상영관번호", "좌석수","상영관사용여부"};
		String[] ticket = {"티켓번호", "상영일정번호", "상영관번호", "좌석번호", 
				"예매번호", "발권여부", "표준가격", "판매가격"};
		String[] seat = {"좌석번호", "상영관번호", "좌석사용여부"};
		String[] customer = {"회원아이디", "고객명", "휴대폰번호", "전자메일주소"};
		String[] reservation = {"예매번호", "결제방법", "결제상태", "결제금액", 
				"회원아이디", "결제일자"};
		String[][] moviedata = {{"1","1","1","1","1","1","1","1","1"},
				{"2","2","2","2","2","2","2","2","2"}};
		String[][] moviescheduledata = {{"1","1","1","1","1","1","1"}};
		String[][] theaterdata = {{"1","1","1"}};
		String[][] ticketdata = {{"1","1","1","1","1","1","1","1"}};
		String[][] seatdata = {{"1","1","1"}};
		String[][] customerdata = {{"1","1","1","1"}};
		String[][] reservationdata = {{"1","1","1","1","1","1"}};
		
		mgrtable[0] = new JTable(moviedata,movie);
		mgrtable[1] = new JTable(moviescheduledata,movieschedule);
		mgrtable[2] = new JTable(theaterdata,theater);
		mgrtable[3] = new JTable(ticketdata,ticket);
		mgrtable[4] = new JTable(seatdata,seat);
		mgrtable[5] = new JTable(customerdata,customer);
		mgrtable[6] = new JTable(reservationdata,reservation);
		
		for(int i=0;i<7;i++) {
			mgrscroll[i] = new JScrollPane(mgrtable[i]);
			// 1층
			if(i==0 || i==1) {
				mgrscroll[i].setSize(700,150);
				mgrscroll[i].setLocation(700*i,150);
			}
			// 2층
			else if(i==2) {
				mgrscroll[i].setSize(350,150);
				mgrscroll[i].setLocation(0,350);
			}
			else if(i==3) {
				mgrscroll[i].setSize(700,150);
				mgrscroll[i].setLocation(350,350);
			}
			else if(i==4) {
				mgrscroll[i].setSize(350,150);
				mgrscroll[i].setLocation(1050,350);
			}
			// 3층
			else {
				mgrscroll[i].setSize(700,150);
				mgrscroll[i].setLocation(700*(i-5),550);
			}
			mgrscroll[i].setVisible(false);
			this.add(mgrscroll[i]);
			
		}
		
	}
	
	// 회원 메뉴
	private void InitMemberMenu() {
		// 회원 영화조회 버튼
		btmemmoviesearch.setSize(100,50);
		btmemmoviesearch.setLocation(0, 10);
		btmemmoviesearch.setVisible(false);
		btmemmoviesearch.addActionListener(new BtmemMovieSearchListener());
		this.add(btmemmoviesearch);
						
		// 회원 예매조회 버튼
		btmemreservationsearch.setSize(100,50);
		btmemreservationsearch.setLocation(100, 10);
		btmemreservationsearch.setVisible(false);
		btmemreservationsearch.addActionListener(new BtmemReservationSearchListener());
		this.add(btmemreservationsearch);
	}
	
	// 회원 영화조회 라벨 텍스트 박스 생성
	private void InitMemberMovieSearchTextField() {
		
		String[] label = {"영화명", "감독명", "배우명", "장르"};
		for(int i=0;i<4;i++) {
			// 영화조회 라벨
			memlblmoviesearch[i] = new JLabel(label[i]);
			memlblmoviesearch[i].setSize(100,30);
			memlblmoviesearch[i].setLocation(100, 150+50*i);
			memlblmoviesearch[i].setVisible(false);
			this.add(memlblmoviesearch[i]);
			
			// 영화조회 텍스트 박스
			memtfmoviesearch[i] = new JTextField();
			memtfmoviesearch[i].setSize(200,30);
			memtfmoviesearch[i].setLocation(250, 150+50*i);
			memtfmoviesearch[i].setVisible(false);
			this.add(memtfmoviesearch[i]);
		}
		// ID 라벨 텍스트 박스
		memlblmoviesearchID.setSize(100,30);
		memlblmoviesearchID.setLocation(100, 150);
		memlblmoviesearchID.setVisible(false);
		this.add(memlblmoviesearchID);
		
		memtfmoviesearchID.setSize(200,30);
		memtfmoviesearchID.setLocation(250, 150);
		memtfmoviesearchID.setVisible(false);
		this.add(memtfmoviesearchID);
		
		// 결제방법 라벨 텍스트 박스
		memlblmoviesearchpayment.setSize(100,30);
		memlblmoviesearchpayment.setLocation(100, 200);
		memlblmoviesearchpayment.setVisible(false);
		this.add(memlblmoviesearchpayment);
		
		memtfmoviesearchpayment.setSize(200,30);
		memtfmoviesearchpayment.setLocation(250, 200);
		memtfmoviesearchpayment.setVisible(false);
		this.add(memtfmoviesearchpayment);

	}
	
	// 회원 영화조회 버튼 생성
	private void InitMemberMovieSearchButton() {
		// 영화조회메뉴 조회 취소 버튼
		btmemmoviesearchlookup.setSize(100,50);
		btmemmoviesearchlookup.setLocation(1000,250);
		btmemmoviesearchlookup.setVisible(false);
		btmemmoviesearchlookup.addActionListener(new BtmemMovieSearchLookupListener());
		this.add(btmemmoviesearchlookup);
				
		btmemmoviesearchcancle.setSize(100,50);
		btmemmoviesearchcancle.setLocation(1000,350);
		btmemmoviesearchcancle.setVisible(false);
		btmemmoviesearchcancle.addActionListener(new BtmemMovieSearchCancleListener());
		this.add(btmemmoviesearchcancle);
		
		// 영화조회메뉴 예매버튼
		for(int i=0;i<4;i++) {
			btmemmoviesearchreservation[i] = new JButton("예매");
			btmemmoviesearchreservation[i].setSize(100,50);
			btmemmoviesearchreservation[i].setLocation(1000,250);
			btmemmoviesearchreservation[i].setVisible(false);
			this.add(btmemmoviesearchreservation[i]);	
		}
		
		// 영화조회메뉴 예매버튼 이벤트
		btmemmoviesearchreservation[0].addActionListener(new BtmemMovieSearchReservationMovieListener());
		btmemmoviesearchreservation[1].addActionListener(new BtmemMovieSearchReservationScheduleListener());
		btmemmoviesearchreservation[2].addActionListener(new BtmemMovieSearchReservationSeatListener());
		btmemmoviesearchreservation[3].addActionListener(new BtmemMovieSearchReservationInfoListener());
		
	}
	
	// 영화조회 테이블 생성
	private void InitMemberMovieSearchTable() {
		String[] movie = {"영화번호","영화명","상영시간","상영등급", 
				"감독명", "배우명", "장르", "영화소개" ,"개봉일 정보"};
		String[] movieschedule = {"상영일정번호", "영화번호", "상영관번호", "상영시작일", 
				"상영요일", "상영회차","상영시작시간"};
		String[] seat = {"좌석번호", "상영관번호", "좌석사용여부"};
		
		String[][] moviedata = {{"1","1","1","1","1","1","1","1","1"},
				{"2","2","2","2","2","2","2","2","2"}};
		String[][] moviescheduledata = {{"1","1","1","1","1","1","1"}};
		String[][] seatdata = {{"1","1","1"}};
		
		// 영화예매 영화 테이블
		memmoviesearchmovietable = new JTable(moviedata,movie);
		memmoviesearchmoviescroll = new JScrollPane(memmoviesearchmovietable);
		memmoviesearchmoviescroll.setSize(700,150);
		memmoviesearchmoviescroll.setLocation(0,150);
		memmoviesearchmoviescroll.setVisible(false);
		this.add(memmoviesearchmoviescroll);
		// 영화예매 상영일정 테이블
		memmoviesearchmoviescheduletable = new JTable(moviescheduledata,movieschedule);
		memmoviesearchmovieschedulescroll = new JScrollPane(memmoviesearchmoviescheduletable);
		memmoviesearchmovieschedulescroll.setSize(700,150);
		memmoviesearchmovieschedulescroll.setLocation(0,150);
		memmoviesearchmovieschedulescroll.setVisible(false);
		this.add(memmoviesearchmovieschedulescroll);
		
		// 영화예매 좌석 테이블
		memmoviesearchseattable = new JTable(seatdata,seat);
		memmoviesearchseatscroll = new JScrollPane(memmoviesearchseattable);
		memmoviesearchseatscroll.setSize(350,150);
		memmoviesearchseatscroll.setLocation(0,150);
		memmoviesearchseatscroll.setVisible(false);
		this.add(memmoviesearchseatscroll);
	}
	
	// 회원 예매조회 버튼 생성 
	private void InitMemberReservationSearchButton() {
		// 예매조회 확인 취소 삭제 변경 버튼
		btmemreservationsearchcheck.setSize(120,50);
		btmemreservationsearchcheck.setLocation(1000,450);
		btmemreservationsearchcheck.setVisible(false);
		btmemreservationsearchcheck.addActionListener(new BtmemReservationSearchCheckListener());
		this.add(btmemreservationsearchcheck);
				
		btmemreservationsearchcancle.setSize(120,50);
		btmemreservationsearchcancle.setLocation(1000,550);
		btmemreservationsearchcancle.setVisible(false);
		btmemreservationsearchcancle.addActionListener(new BtmemReservationSearchCancleListener());
		this.add(btmemreservationsearchcancle);
		
		btmemreservationsearchremove.setSize(120,50);
		btmemreservationsearchremove.setLocation(1000,250);
		btmemreservationsearchremove.setVisible(false);
		btmemreservationsearchremove.addActionListener(new BtmemReservationSearchRemoveListener());
		this.add(btmemreservationsearchremove);
		
		btmemreservationsearchchangemovie.setSize(120,50);
		btmemreservationsearchchangemovie.setLocation(1000,350);
		btmemreservationsearchchangemovie.setVisible(false);
		btmemreservationsearchchangemovie.addActionListener(new BtmemReservationSearchMovieListener());
		this.add(btmemreservationsearchchangemovie);
		
		btmemreservationsearchchangeschedule.setSize(120,50);
		btmemreservationsearchchangeschedule.setLocation(1000,450);
		btmemreservationsearchchangeschedule.setVisible(false);
		btmemreservationsearchchangeschedule.addActionListener(new BtmemReservationSearchScheduleListener());
		this.add(btmemreservationsearchchangeschedule);
		
		
		// 예매조회메뉴 예매버튼
		for(int i=0;i<3;i++) {
			btmemreservationsearchchangereservation[i] = new JButton("예매");
			btmemreservationsearchchangereservation[i].setSize(100,50);
			btmemreservationsearchchangereservation[i].setLocation(1000,250);
			btmemreservationsearchchangereservation[i].setVisible(false);
			this.add(btmemreservationsearchchangereservation[i]);	
		}
		// 예매조회메뉴 예매버튼 이벤트
		btmemreservationsearchchangereservation[0].addActionListener(new BtmemReservationSearchChangeMovieListener());
		btmemreservationsearchchangereservation[1].addActionListener(new BtmemReservationSearchChangeScheduleListener());
		btmemreservationsearchchangereservation[2].addActionListener(new BtmemReservationSearchChangeSeatListener());
		
		
		// 예매조회메뉴 예매취소 버튼
		btmemreservationsearchchangecancel.setSize(100,50);
		btmemreservationsearchchangecancel.setLocation(1000,350);
		btmemreservationsearchchangecancel.setVisible(false);
		btmemreservationsearchchangecancel.addActionListener(new BtmemReservationSearchChangeCancleListener());
		this.add(btmemreservationsearchchangecancel);
		
	}
	
	// 회원 예매조회 테이블 생성 
	private void InitMemberReservationSearchTable() {
		String[] memreservation = {"영화명", "상영일", "상영관번호", 
				"좌석번호", "판매가격"};
		String[] movie = {"영화번호","영화명","상영시간","상영등급", 
				"감독명", "배우명", "장르", "영화소개" ,"개봉일 정보"};
		String[] movieschedule = {"상영일정번호", "영화번호", "상영관번호", "상영시작일", 
				"상영요일", "상영회차","상영시작시간"};
		String[] seat = {"좌석번호", "상영관번호", "좌석사용여부"};
		String[] theater = {"상영관번호", "좌석수","상영관사용여부"};
		String[] ticket = {"티켓번호", "상영일정번호", "상영관번호", "좌석번호", 
				"예매번호", "발권여부", "표준가격", "판매가격"};
		String[][] moviedata = {{"1","1","1","1","1","1","1","1","1"},
				{"2","2","2","2","2","2","2","2","2"}};
		String[][] moviescheduledata = {{"1","1","1","1","1","1","1"}};
		String[][] seatdata = {{"1","1","1"}};
		String[][] theaterdata = {{"1","1","1"}};
		String[][] ticketdata = {{"1","1","1","1","1","1","1","1"}};
		String[][] memreservationdata = {{"1","1","1","1","1"}};
		
		// 예매조회 영화명, 상영일, 상영관번호, 좌석번호, 판매가격 테이블
		memreservationsearchtable = new JTable(memreservationdata,memreservation);
		memreservationsearchscroll = new JScrollPane(memreservationsearchtable);
		memreservationsearchscroll.setSize(400,150);
		memreservationsearchscroll.setLocation(0,150);
		memreservationsearchscroll.setVisible(false);
		this.add(memreservationsearchscroll);
		// 예매조회 상영관 테이블
		memreservationsearchtheatertable = new JTable(theaterdata,theater);
		memreservationsearchtheaterscroll = new JScrollPane(memreservationsearchtheatertable);
		memreservationsearchtheaterscroll.setSize(350,150);
		memreservationsearchtheaterscroll.setLocation(700,150);
		memreservationsearchtheaterscroll.setVisible(false);
		this.add(memreservationsearchtheaterscroll);
		// 예매조회 상영일정 테이블
		memreservationsearchscheduletable = new JTable(moviescheduledata,movieschedule);
		memreservationsearchschedulescroll = new JScrollPane(memreservationsearchscheduletable);
		memreservationsearchschedulescroll.setSize(700,150);
		memreservationsearchschedulescroll.setLocation(0,150);
		memreservationsearchschedulescroll.setVisible(false);
		this.add(memreservationsearchschedulescroll);
		// 예매조회 티켓 테이블
		memreservationsearchtickettable = new JTable(ticketdata,ticket);
		memreservationsearchticketscroll = new JScrollPane(memreservationsearchtickettable);
		memreservationsearchticketscroll.setSize(700,150);
		memreservationsearchticketscroll.setLocation(0,350);
		memreservationsearchticketscroll.setVisible(false);
		this.add(memreservationsearchticketscroll);
		// 예매조회 영화 변경 테이블
		memreservationsearchchangemovietable = new JTable(moviedata,movie);
		memreservationsearchchangemoviescroll = new JScrollPane(memreservationsearchchangemovietable);
		memreservationsearchchangemoviescroll.setSize(700,150);
		memreservationsearchchangemoviescroll.setLocation(0,150);
		memreservationsearchchangemoviescroll.setVisible(false);
		this.add(memreservationsearchchangemoviescroll);
		// 예매조회 상영일정 변경 테이블
		memreservationsearchchangescheduletable = new JTable(moviescheduledata,movieschedule);
		memreservationsearchchangeschedulescroll = new JScrollPane(memreservationsearchchangescheduletable);
		memreservationsearchchangeschedulescroll.setSize(700,150);
		memreservationsearchchangeschedulescroll.setLocation(0,150);
		memreservationsearchchangeschedulescroll.setVisible(false);
		this.add(memreservationsearchchangeschedulescroll);
				
		// 예매조회 좌석 변경 테이블
		memreservationsearchchangeseattable = new JTable(seatdata,seat);
		memreservationsearchchangeseatscroll = new JScrollPane(memreservationsearchchangeseattable);
		memreservationsearchchangeseatscroll.setSize(350,150);
		memreservationsearchchangeseatscroll.setLocation(0,150);
		memreservationsearchchangeseatscroll.setVisible(false);
		this.add(memreservationsearchchangeseatscroll);
		
	}
	
	// 회원 예매조회 라벨 텍스트 박스 생성 
	private void InitMemberReservationSearchTextField() {
		
		
		// ID 라벨 텍스트 박스
		memlblreservationsearchID.setSize(100,30);
		memlblreservationsearchID.setLocation(100, 150);
		memlblreservationsearchID.setVisible(false);
		this.add(memlblreservationsearchID);
		
		memtfreservationsearchID.setSize(200,30);
		memtfreservationsearchID.setLocation(250, 150);
		memtfreservationsearchID.setVisible(false);
		this.add(memtfreservationsearchID);
		
	}
	
	
	// 뒤로가기 버튼 클릭
	private class BtBackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 관리자 메뉴 버튼 가리기
			btmgrinit.setVisible(false);
			btmgrinsert.setVisible(false);
			btmgrdelete.setVisible(false);
			btmgrupdate.setVisible(false);
			btmgrselect.setVisible(false);
			
			// 회원 메뉴 버튼 가리기
			btmemmoviesearch.setVisible(false);
			btmemreservationsearch.setVisible(false);
			
			// 초기메뉴 보이기
			btmgr.setVisible(true);
			btmem.setVisible(true);
			
			// 뒤로가기 버튼 보이기
			btback.setVisible(false);
		}
	}
	
	// 초기메뉴 관리자 버튼 클릭 
	private class BtmgrListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 초기메뉴 가리기
			btmgr.setVisible(false);
			btmem.setVisible(false);
			// 뒤로가기 버튼 보이기
			btback.setVisible(true);
			
			// 관리자 메뉴 버튼 보이기
			btmgrinit.setVisible(true);
			btmgrinsert.setVisible(true);
			btmgrdelete.setVisible(true);
			btmgrupdate.setVisible(true);
			btmgrselect.setVisible(true);
		}
	}
	// 초기메뉴 회원 버튼 클릭
	private class BtmemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 초기메뉴 가리기
			btmgr.setVisible(false);
			btmem.setVisible(false);
			// 뒤로가기 버튼 보이기
			btback.setVisible(true);
			
			// 회원 메뉴 버튼 보이기
			btmemmoviesearch.setVisible(true);
			btmemreservationsearch.setVisible(true);
			
		}
	}
	
	// 관리자 입력 버튼 클릭
	private class BtmgrInsertListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 뒤로가기 버튼 숨기기
			btback.setVisible(false);
						
			// 관리자 메뉴 버튼 숨기기
			btmgrinit.setVisible(false);
			btmgrinsert.setVisible(false);
			btmgrdelete.setVisible(false);
			btmgrupdate.setVisible(false);
			btmgrselect.setVisible(false);
			
			
			// 관리자 테이블 버튼 보이기
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(true);
			}
		}
	}
	// 관리자 삭제 버튼 클릭
	private class BtmgrDeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 뒤로가기 버튼 숨기기
			btback.setVisible(false);
						
			// 관리자 메뉴 버튼 숨기기
			btmgrinit.setVisible(false);
			btmgrinsert.setVisible(false);
			btmgrdelete.setVisible(false);
			btmgrupdate.setVisible(false);
			btmgrselect.setVisible(false);
			
			
			// 관리자 테이블 버튼 보이기
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(true);
			}
		}
	}
	// 관리자 변경 버튼 클릭
	private class BtmgrUpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 뒤로가기 버튼 숨기기
			btback.setVisible(false);
						
			// 관리자 메뉴 버튼 숨기기
			btmgrinit.setVisible(false);
			btmgrinsert.setVisible(false);
			btmgrdelete.setVisible(false);
			btmgrupdate.setVisible(false);
			btmgrselect.setVisible(false);
			
			
			// 관리자 테이블 버튼 보이기
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(true);
			}
		}
	}
	// 관리자 전체조회 버튼 클릭
	private class BtmgrSelectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// 관리자 메뉴 숨기기
			btmgrinit.setVisible(false);
			btmgrinsert.setVisible(false);
			btmgrdelete.setVisible(false);
			btmgrupdate.setVisible(false);
			btmgrselect.setVisible(false);
			btback.setVisible(false);
			
			// 테이블 보이기
			for(int i=0;i<7;i++) {
				mgrscroll[i].setVisible(true);
			}
			btmgrchecktable[3].setVisible(true);
			
		}
	}
	
	// 관리자 입력 버튼을 클릭한후 영화버튼을 클릭
	private class BtmgrInsertMovieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] movie = {"영화번호","영화명","상영시간","상영등급", 
					"감독명", "배우명", "장르", "영화소개" ,"개봉일 정보"};
			
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("movie");
			mgrtablelabel.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<9;i++) {
				mgrlabel[i].setText(movie[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// 관리자 입력버튼을 클릭 후 상영일정 클릭
	private class BtmgrInsertMovieScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] movieschedule = {"상영일정번호", "영화번호", "상영관번호", "상영시작일", 
					"상영요일", "상영회차","상영시작시간"};
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("movieschedule");
			mgrtablelabel.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<7;i++) {
				mgrlabel[i].setText(movieschedule[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// 관리자 입력버튼을 클릭 후 상영관 클릭
	private class BtmgrInsertTheaterListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] theater = {"상영관번호", "좌석수","상영관사용여부"};
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("theater");
			mgrtablelabel.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<3;i++) {
				mgrlabel[i].setText(theater[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// 관리자 입력버튼을 클릭 후 티켓 클릭
	private class BtmgrInsertTicketListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] ticket = {"티켓번호", "상영일정번호", "상영관번호", "좌석번호", 
					"예매번호", "발권여부", "표준가격", "판매가격"};
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("ticket");
			mgrtablelabel.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<8;i++) {
				mgrlabel[i].setText(ticket[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// 관리자 입력버튼을 클릭 후 좌석 클릭
	private class BtmgrInsertSeatListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] seat = {"좌석번호", "상영관번호", "좌석사용여부"};
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("seat");
			mgrtablelabel.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<3;i++) {
				mgrlabel[i].setText(seat[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// 관리자 입력버튼을 클릭 후 회원고객 클릭
	private class BtmgrInsertCustomerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] customer = {"회원아이디", "고객명", "휴대폰번호", "전자메일주소"};
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("customer");
			mgrtablelabel.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<4;i++) {
				mgrlabel[i].setText(customer[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// 관리자 입력버튼을 클릭 후 예매정보 클릭
	private class BtmgrInsertReservationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] reservation = {"예매번호", "결제방법", "결제상태", "결제금액", 
					"회원아이디", "결제일자"};
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("reservation");
			mgrtablelabel.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<6;i++) {
				mgrlabel[i].setText(reservation[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// 관리자 입력버튼을 클릭 후 확인버튼 클릭
	private class BtmgrInsertCheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 쿼리부분
			if(mgrtablelabel.getText().equals("movie")) {
				
			}
			else if(mgrtablelabel.getText().equals("movieschedule")) {
				
			}
			else if(mgrtablelabel.getText().equals("theater")) {}
			
			// 관리자 메뉴 보이기
			btmgrinit.setVisible(true);
			btmgrinsert.setVisible(true);
			btmgrdelete.setVisible(true);
			btmgrupdate.setVisible(true);
			btmgrselect.setVisible(true);
			btback.setVisible(true);
			
			// 관리자 테이블 이름 숨기기
			mgrtablelabel.setText("");
			mgrtablelabel.setVisible(false);
			// 관리자 테이블 입력창 숨기기
			for(int i=0;i<9;i++) {
				mgrlabel[i].setText("");
				mgrlabel[i].setVisible(false);
				mgrtextfield[i].setText("");
				mgrtextfield[i].setVisible(false);
			}
			// 확인 취소 버튼 숨기기
			btmgrcanceltable.setVisible(false);
			btmgrchecktable[0].setVisible(false);
		}
	}
	// 관리자 삭제버튼을 클릭 후 영화 클릭
	private class BtmgrDeleteMovieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("movie");
			mgrtablelabel.setVisible(true);
			
			// where 조건 입력 박스 보이기
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// 관리자 삭제버튼을 클릭 후 상영일정 클릭
	private class BtmgrDeleteMovieScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("movieschedule");
			mgrtablelabel.setVisible(true);
			
			// where 조건 입력 박스 보이기
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// 관리자 삭제버튼을 클릭 후 상영관 클릭
	private class BtmgrDeleteTheaterListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("theater");
			mgrtablelabel.setVisible(true);
			
			// where 조건 입력 박스 보이기
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// 관리자 삭제버튼을 클릭 후 티켓 클릭
	private class BtmgrDeleteTicketListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("ticket");
			mgrtablelabel.setVisible(true);
			
			// where 조건 입력 박스 보이기
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// 관리자 삭제버튼을 클릭 후 좌석 클릭
	private class BtmgrDeleteSeatListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("seat");
			mgrtablelabel.setVisible(true);
			
			// where 조건 입력 박스 보이기
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// 관리자 삭제버튼을 클릭 후 회원고객 클릭
	private class BtmgrDeleteCustomerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("customer");
			mgrtablelabel.setVisible(true);
			
			// where 조건 입력 박스 보이기
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// 관리자 삭제버튼을 클릭 후 예매정보 클릭
	private class BtmgrDeleteReservationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("reservation");
			mgrtablelabel.setVisible(true);
			
			// where 조건 입력 박스 보이기
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// 관리자 삭제버튼을 클릭 후 확인 클릭
	private class BtmgrDeleteCheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 쿼리부분
			if(mgrtablelabel.getText().equals("movie")) {
				
			}
			else if(mgrtablelabel.getText().equals("movieschedule")) {
				
			}
			else if(mgrtablelabel.getText().equals("theater")) {}
			
			// 관리자 메뉴 보이기
			btmgrinit.setVisible(true);
			btmgrinsert.setVisible(true);
			btmgrdelete.setVisible(true);
			btmgrupdate.setVisible(true);
			btmgrselect.setVisible(true);
			btback.setVisible(true);
			
			// 관리자 테이블 이름 숨기기
			mgrtablelabel.setText("");
			mgrtablelabel.setVisible(false);
			// 관리자 테이블 입력창 숨기기
			for(int i=0;i<9;i++) {
				mgrlabel[i].setText("");
				mgrlabel[i].setVisible(false);
				mgrtextfield[i].setText("");
				mgrtextfield[i].setVisible(false);
			}
			// 조건식 입력창 숨기기
			mgrwherelabel.setVisible(false);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(false);
			
			
			// 확인 취소 버튼 숨기기
			btmgrcanceltable.setVisible(false);
			for(int i=0;i<4;i++) {
				btmgrchecktable[i].setVisible(false);
			}
		}
	}
	// 관리자 변경버튼을 클릭 후 영화 클릭
	private class BtmgrUpdateMovieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] movie = {"영화번호","영화명","상영시간","상영등급", 
					"감독명", "배우명", "장르", "영화소개" ,"개봉일 정보"};
			
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("movie");
			mgrtablelabel.setVisible(true);
			
			// 조건식 입력창 보이기
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<9;i++) {
				mgrlabel[i].setText(movie[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// 관리자 변경버튼을 클릭 후 상영일정 클릭
	private class BtmgrUpdateMovieScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] movieschedule = {"상영일정번호", "영화번호", "상영관번호", "상영시작일", 
					"상영요일", "상영회차","상영시작시간"};
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("movieschedule");
			mgrtablelabel.setVisible(true);
			
			// 조건식 입력창 보이기
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<7;i++) {
				mgrlabel[i].setText(movieschedule[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// 관리자 변경버튼을 클릭 후 상영관 클릭
	private class BtmgrUpdateTheaterListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] theater = {"상영관번호", "좌석수","상영관사용여부"};
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("theater");
			mgrtablelabel.setVisible(true);
			
			// 조건식 입력창 보이기
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<3;i++) {
				mgrlabel[i].setText(theater[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// 관리자 변경버튼을 클릭 후 티켓 클릭
	private class BtmgrUpdateTicketListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] ticket = {"티켓번호", "상영일정번호", "상영관번호", "좌석번호", 
					"예매번호", "발권여부", "표준가격", "판매가격"};
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("ticket");
			mgrtablelabel.setVisible(true);
			
			// 조건식 입력창 보이기
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<8;i++) {
				mgrlabel[i].setText(ticket[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// 관리자 변경버튼을 클릭 후 좌석 클릭
	private class BtmgrUpdateSeatListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] seat = {"좌석번호", "상영관번호", "좌석사용여부"};
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("seat");
			mgrtablelabel.setVisible(true);
			
			// 조건식 입력창 보이기
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<3;i++) {
				mgrlabel[i].setText(seat[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// 관리자 변경버튼을 클릭 후 회원고객 클릭
	private class BtmgrUpdateCustomerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] customer = {"회원아이디", "고객명", "휴대폰번호", "전자메일주소"};
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("customer");
			mgrtablelabel.setVisible(true);
			
			// 조건식 입력창 보이기
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<4;i++) {
				mgrlabel[i].setText(customer[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// 관리자 변경버튼을 클릭 후 예매정보 클릭
	private class BtmgrUpdateReservationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] reservation = {"예매번호", "결제방법", "결제상태", "결제금액", 
					"회원아이디", "결제일자"};
			// 관리자 테이블 버튼 숨기기
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// 관리자 테이블 이름 보이기
			mgrtablelabel.setText("reservation");
			mgrtablelabel.setVisible(true);
			
			// 조건식 입력창 보이기
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// 관리자 테이블 입력창 보이기
			for(int i=0;i<6;i++) {
				mgrlabel[i].setText(reservation[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// 확인 취소 버튼 보이기
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// 관리자 변경버튼을 클릭 후 확인 클릭
	private class BtmgrUpdateCheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 쿼리부분
			if(mgrtablelabel.getText().equals("movie")) {
				
			}
			else if(mgrtablelabel.getText().equals("movieschedule")) {
				
			}
			else if(mgrtablelabel.getText().equals("theater")) {}
			
			// 관리자 메뉴 보이기
			btmgrinit.setVisible(true);
			btmgrinsert.setVisible(true);
			btmgrdelete.setVisible(true);
			btmgrupdate.setVisible(true);
			btmgrselect.setVisible(true);
			btback.setVisible(true);
			
			// 관리자 테이블 이름 숨기기
			mgrtablelabel.setText("");
			mgrtablelabel.setVisible(false);
			
			// 조건식 입력창 숨기기
			mgrwherelabel.setVisible(false);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(false);
			
			// 관리자 테이블 입력창 숨기기
			for(int i=0;i<9;i++) {
				mgrlabel[i].setText("");
				mgrlabel[i].setVisible(false);
				mgrtextfield[i].setText("");
				mgrtextfield[i].setVisible(false);
			}
			// 확인 취소 버튼 숨기기
			btmgrcanceltable.setVisible(false);
			btmgrchecktable[2].setVisible(false);
		}
	}
	
	
	// 관리자 전체조회 버튼 클릭 
	private class BtmgrSelectCheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 관리자 메뉴 보이기
			btmgrinit.setVisible(true);
			btmgrinsert.setVisible(true);
			btmgrdelete.setVisible(true);
			btmgrupdate.setVisible(true);
			btmgrselect.setVisible(true);
			btback.setVisible(true);
			
			// 테이블 숨기기
			for(int i=0;i<7;i++) {
				mgrscroll[i].setVisible(false);
			}
			btmgrchecktable[3].setVisible(false);
			
			
		}
	}
	// 관리자 취소버튼 클릭
	private class BtmgrCancleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// 관리자 메뉴 보이기
			btmgrinit.setVisible(true);
			btmgrinsert.setVisible(true);
			btmgrdelete.setVisible(true);
			btmgrupdate.setVisible(true);
			btmgrselect.setVisible(true);
			btback.setVisible(true);
			
			// 관리자 테이블 이름 숨기기
			mgrtablelabel.setText("");
			mgrtablelabel.setVisible(false);
			mgrwherelabel.setVisible(false);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(false);
			
			
			// 관리자 테이블 입력창 숨기기
			for(int i=0;i<9;i++) {
				mgrlabel[i].setText("");
				mgrlabel[i].setVisible(false);
				mgrtextfield[i].setText("");
				mgrtextfield[i].setVisible(false);
			}
			// 확인 취소 버튼 숨기기
			btmgrcanceltable.setVisible(false);
			for(int i=0;i<4;i++) {
				btmgrchecktable[i].setVisible(false);
			}
		}
	}
	
	// 회원메뉴에서 영화조회 버튼 클릭
	private class BtmemMovieSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 회원 메뉴 숨기기
			btmemmoviesearch.setVisible(false);
			btmemreservationsearch.setVisible(false);
			
			// 영화명, 감독명, 배우명, 장르 텍스트박스 라벨 보이기
			for(int i=0;i<4;i++) {
				memtfmoviesearch[i].setVisible(true);
				memlblmoviesearch[i].setVisible(true);
			}
			// 뒤로가기 버튼 숨기기
			btback.setVisible(false);
			
			// 조회 취소 버튼 보이기
			btmemmoviesearchlookup.setVisible(true);
			btmemmoviesearchcancle.setVisible(true);
			
			
			
		}
	}
	
	private class BtmemReservationSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 회원 메뉴 숨기기
			btmemmoviesearch.setVisible(false);
			btmemreservationsearch.setVisible(false);
			
			// ID입력 라벨 텍스트 박스 보이기
			memlblreservationsearchID.setVisible(true);
			memtfreservationsearchID.setVisible(true);
			
			// 뒤로가기 버튼 숨기기
			btback.setVisible(false);
			
			// 확인 취소 버튼 보이기
			btmemreservationsearchcheck.setVisible(true);
			btmemreservationsearchcancle.setVisible(true);
			
		}
	}
	
	
	// 영화조회 버튼 클릭후 조회버튼 클릭
	private class BtmemMovieSearchLookupListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 텍스트 박스 숨기기
			for(int i=0;i<4;i++) {
				memlblmoviesearch[i].setVisible(false);
				memtfmoviesearch[i].setVisible(false);
				memtfmoviesearch[i].setText("");
			}
			// 조회 버튼 숨기기
			btmemmoviesearchlookup.setVisible(false);
			
			// 영화 테이블 보기
			memmoviesearchmoviescroll.setVisible(true);
			
			// 예매 취소 버튼 보이기
			btmemmoviesearchreservation[0].setVisible(true);
			btmemmoviesearchcancle.setVisible(true);
			
		}
	}
	
	// 영화 테이블 화면에서 예매 버튼 클릭 (영화 -> 상영일정)
	private class BtmemMovieSearchReservationMovieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 상영일정 테이블 보이기
			memmoviesearchmovieschedulescroll.setVisible(true);
			
			// 영화 테이블 숨기기
			memmoviesearchmoviescroll.setVisible(false);
			
			// 이전 예매 버튼 숨기기
			btmemmoviesearchreservation[0].setVisible(false);
			
			// 예매 버튼 보이기
			btmemmoviesearchreservation[1].setVisible(true);
			
		}
	}
	
	// 영화 테이블 화면에서 예매 버튼 클릭 (상영일정 -> 좌석)
	private class BtmemMovieSearchReservationScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 상영일정 테이블 숨기기
			memmoviesearchmovieschedulescroll.setVisible(false);
			
			// 좌석 테이블 보이기
			memmoviesearchseatscroll.setVisible(true);
			
			// 이전 예매 버튼 숨기기
			btmemmoviesearchreservation[1].setVisible(false);
			
			// 예매 버튼 보이기
			btmemmoviesearchreservation[2].setVisible(true);
			
		}
	}
	// 영화 테이블 화면에서 예매 버튼 클릭 (좌석 -> 예매정보)
	private class BtmemMovieSearchReservationSeatListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 좌석 테이블 숨기기
			memmoviesearchseatscroll.setVisible(false);
			
			// 예매정보 결제방법 ID 라벨 텍스트 박스 보이기
			memlblmoviesearchID.setVisible(true);
			memtfmoviesearchID.setVisible(true);
			memtfmoviesearchpayment.setVisible(true);
			memlblmoviesearchpayment.setVisible(true);
			
			// 이전 예매 버튼 숨기기
			btmemmoviesearchreservation[2].setVisible(false);
			
			// 예매 버튼 보이기
			btmemmoviesearchreservation[3].setVisible(true);
			
		}
	}
	// 영화 테이블 화면에서 예매 버튼 클릭 (예매정보 -> 회원메뉴)
	private class BtmemMovieSearchReservationInfoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 예매정보 결제방법 ID 라벨 텍스트 박스 숨기기
			memlblmoviesearchID.setVisible(false);
			memtfmoviesearchID.setVisible(false);
			memtfmoviesearchID.setText("");
			memlblmoviesearchpayment.setVisible(false);
			memtfmoviesearchpayment.setVisible(false);
			memtfmoviesearchpayment.setText("");
			
			// 예매 취소 버튼 숨기기
			btmemmoviesearchreservation[3].setVisible(false);
			btmemmoviesearchcancle.setVisible(false);
			
			// 회원 메뉴 보이기
			btmemmoviesearch.setVisible(true);
			btmemreservationsearch.setVisible(true);
			
			// 뒤로가기 버튼 보이기
			btback.setVisible(true);
			
		}
	}
	
	// 영화조회 버튼 클릭후 취소버튼 클릭
	private class BtmemMovieSearchCancleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 텍스트 박스 숨기기
			memlblmoviesearchID.setVisible(false);
			memtfmoviesearchID.setVisible(false);
			memtfmoviesearchID.setText("");
			memlblmoviesearchpayment.setVisible(false);
			memtfmoviesearchpayment.setVisible(false);
			memtfmoviesearchpayment.setText("");
			for(int i=0;i<4;i++) {
				memlblmoviesearch[i].setVisible(false);
				memtfmoviesearch[i].setVisible(false);
				memtfmoviesearch[i].setText("");
			}
			
			// 영화 테이블 숨기기
			memmoviesearchmoviescroll.setVisible(false);
			
			// 상영일정 테이블 숨기기
			memmoviesearchmovieschedulescroll.setVisible(false);
			
			// 좌석 테이블 숨기기
			memmoviesearchseatscroll.setVisible(false);
			
			// 조회 버튼 숨기기
			btmemmoviesearchlookup.setVisible(false);
			
			// 예매 버튼 숨기기
			for(int i=0;i<4;i++) {
				btmemmoviesearchreservation[i].setVisible(false);
			}
			
			// 회원메뉴 보이기
			btmemmoviesearch.setVisible(true);
			btmemreservationsearch.setVisible(true);
			
			// 뒤로가기 버튼 보이기
			btback.setVisible(true);
			
			// 취소 버튼 숨기기
			btmemmoviesearchcancle.setVisible(false);
			
		}
	}
	
	// 예매조회 버튼 클릭후 확인버튼 클릭
	private class BtmemReservationSearchCheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 텍스트 박스 숨기기
			memlblreservationsearchID.setVisible(false);
			memtfreservationsearchID.setVisible(false);
			memtfreservationsearchID.setText("");
			
			
			// 영화 테이블 보이기
			memreservationsearchscroll.setVisible(true);
			
			// 확인 버튼 숨기기
			btmemreservationsearchcheck.setVisible(false);
			
			
			// 삭제 영화변경 상영일정변경 버튼 보이기
			btmemreservationsearchremove.setVisible(true);
			btmemreservationsearchchangemovie.setVisible(true);
			btmemreservationsearchchangeschedule.setVisible(true);
			
		}
	}
	
	// 예매조회 버튼 클릭후 삭제버튼 클릭
	private class BtmemReservationSearchRemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			/*
			String[] memreservation = {"영화명", "상영일", "상영관번호", 
					"좌석번호", "판매가격"};
			String[][] memreservationdata = {{"2","2","2","2","2"}};
			
			DefaultTableModel m = new DefaultTableModel(memreservationdata,memreservation);
			memreservationsearchtable.setModel(m);
			*/
			
			
			// 회원메뉴 보이기
			btmemmoviesearch.setVisible(true);
			btmemreservationsearch.setVisible(true);
			btback.setVisible(true);
			
			// 영화 테이블 숨기기
			memreservationsearchscroll.setVisible(false);
			
			// 삭제 영화변경 상영일정변경 취소 버튼 숨기기
			btmemreservationsearchremove.setVisible(false);
			btmemreservationsearchchangemovie.setVisible(false);
			btmemreservationsearchchangeschedule.setVisible(false);
			btmemreservationsearchcancle.setVisible(false);
			
		}
	}
	
	// 예매조회 버튼 클릭후 영화변경 버튼 클릭 
	private class BtmemReservationSearchMovieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 영화예매 영화 테이블 보이기
			memreservationsearchchangemoviescroll.setVisible(true);
			
			// 영화예매 예매버튼 예매취소버튼 보이기
			btmemreservationsearchchangereservation[0].setVisible(true);
			btmemreservationsearchchangecancel.setVisible(true);
			
			
			// 영화 테이블 숨기기
			memreservationsearchscroll.setVisible(false);
			
			// 삭제 영화변경 상영일정변경 취소 버튼 숨기기
			btmemreservationsearchremove.setVisible(false);
			btmemreservationsearchchangemovie.setVisible(false);
			btmemreservationsearchchangeschedule.setVisible(false);
			btmemreservationsearchcancle.setVisible(false);
			
		}
	}
	
	// 예매조회 버튼 클릭후 상영일정변경 버튼 클릭
	private class BtmemReservationSearchScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 영화예매 상영일정 테이블 보이기
			memreservationsearchchangeschedulescroll.setVisible(true);
			
			// 영화예매 예매버튼 예매취소버튼 보이기
			btmemreservationsearchchangereservation[1].setVisible(true);
			btmemreservationsearchchangecancel.setVisible(true);
			
			// 영화 테이블 숨기기
			memreservationsearchscroll.setVisible(false);
			
			// 삭제 영화변경 상영일정변경 취소 버튼 숨기기
			btmemreservationsearchremove.setVisible(false);
			btmemreservationsearchchangemovie.setVisible(false);
			btmemreservationsearchchangeschedule.setVisible(false);
			btmemreservationsearchcancle.setVisible(false);
			
		}
	}
	
	// 예매조회 버튼 클릭후 영화변경 클릭후 예매버튼 클릭 (영화 -> 상영일정)
	private class BtmemReservationSearchChangeMovieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 영화예매 영화 테이블 숨기기
			memreservationsearchchangemoviescroll.setVisible(false);
			
			// 영화예매 상영일정 테이블 보이기
			memreservationsearchchangeschedulescroll.setVisible(true);
			
			// 영화예매 예매 버튼 보이기
			btmemreservationsearchchangereservation[1].setVisible(true);
			
			// 영화예매 이전 예매 버튼 숨기기
			btmemreservationsearchchangereservation[0].setVisible(false);
		}
	}
	
	// 예매조회 버튼 클릭후 영화변경 클릭후 예매버튼 클릭 (상영일정 -> 좌석)
	private class BtmemReservationSearchChangeScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 영화예매 상영일정 테이블 숨기기
			memreservationsearchchangeschedulescroll.setVisible(false);
			
			// 영화예매 좌석 테이블 보이기
			memreservationsearchchangeseatscroll.setVisible(true);
			
			// 영화예매 예매 버튼 보이기
			btmemreservationsearchchangereservation[2].setVisible(true);
			
			// 영화예매 이전 예매 버튼 숨기기
			btmemreservationsearchchangereservation[1].setVisible(false);
		}
	}
	
	// 예매조회 버튼 클릭후 영화변경 클릭후 예매버튼 클릭 (좌석 -> 예매조회메뉴)
	private class BtmemReservationSearchChangeSeatListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 영화예매 좌석 테이블 숨기기
			memreservationsearchchangeseatscroll.setVisible(false);
			
			// 영화예매 예매버튼, 예매취소버튼 숨기기
			btmemreservationsearchchangereservation[2].setVisible(false);
			btmemreservationsearchchangecancel.setVisible(false);
			
			// 회원메뉴 보이기
			btmemmoviesearch.setVisible(true);
			btmemreservationsearch.setVisible(true);
			btback.setVisible(true);
			
			
		}
	}
	
	// 예매조회 버튼 클릭후 취소버튼 클릭
	private class BtmemReservationSearchCancleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 텍스트 박스 숨기기
			memlblreservationsearchID.setVisible(false);
			memtfreservationsearchID.setVisible(false);
			memtfreservationsearchID.setText("");
			
			
			// 영화 테이블 숨기기
			memreservationsearchscroll.setVisible(false);
			
			// 확인 삭제 영화변경 상영일정변경 버튼 숨기기
			btmemreservationsearchcheck.setVisible(false);
			btmemreservationsearchremove.setVisible(false);
			btmemreservationsearchchangemovie.setVisible(false);
			btmemreservationsearchchangeschedule.setVisible(false);
			
			// 회원메뉴 보이기
			btmemmoviesearch.setVisible(true);
			btmemreservationsearch.setVisible(true);
			
			// 뒤로가기 버튼 보이기
			btback.setVisible(true);
			
			// 취소 버튼 숨기기
			btmemreservationsearchcancle.setVisible(false);
			
		}
	}
	
	// 예매조회 버튼 클릭후 영화변경 클릭후 예매취소 버튼 클릭 
	private class BtmemReservationSearchChangeCancleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// 영화예매 영화, 상영일정, 좌석 테이블 숨기기
			memreservationsearchchangemoviescroll.setVisible(false);
			memreservationsearchchangeschedulescroll.setVisible(false);
			memreservationsearchchangeseatscroll.setVisible(false);
			
			// 영화예매 예매버튼 예매취소버튼 숨기기
			for(int i=0;i<3;i++) {
				btmemreservationsearchchangereservation[i].setVisible(false);
			}
			btmemreservationsearchchangecancel.setVisible(false);
			
			// 영화 테이블 보이기
			memreservationsearchscroll.setVisible(true);
			
			// 삭제 영화변경 상영일정변경 취소 버튼 보이기
			btmemreservationsearchremove.setVisible(true);
			btmemreservationsearchchangemovie.setVisible(true);
			btmemreservationsearchchangeschedule.setVisible(true);
			btmemreservationsearchcancle.setVisible(true);
			
			
		}
	}
}
