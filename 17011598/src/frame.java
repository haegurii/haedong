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
	// �ʱ�ȭ�� ��ư
	JButton btmgr = new JButton("������");
	JButton btmem = new JButton("ȸ��");
	JButton btback = new JButton("�ڷΰ���");
	
	// ������ ȭ�� ��ư
	JButton btmgrinit = new JButton("�ʱ�ȭ");
	JButton btmgrinsert = new JButton("�Է�");
	JButton btmgrdelete = new JButton("����");
	JButton btmgrupdate = new JButton("����");
	JButton btmgrselect = new JButton("��ü��ȸ");
	
	// ������ ȭ�� ���̺� 7��
	JTable[] mgrtable = new JTable[7];
	JScrollPane[] mgrscroll = new JScrollPane[7];
	
	// ������ ȭ�� ���̺� �Է�, ����, ���� ��ư 
	JButton[] btmgrinserttable = new JButton[7];
	JButton[] btmgrdeletetable = new JButton[7];
	JButton[] btmgrupdatetable = new JButton[7];
	
	// ������ ȭ�� ���̺� Ȯ�� ��� ��ư
	JButton btmgrcanceltable = new JButton("���");
	// 0 -> insert 		1 -> delete		2-> update 		3 -> select
	JButton[] btmgrchecktable = new JButton[4];
	
	
	// ������ ȭ�� ���̺� ������ �Է� �޴� �ؽ�Ʈ�ڽ�
	JTextField[] mgrtextfield = new JTextField[9];
	JLabel[] mgrlabel = new JLabel[9];
	JTextField mgrwheretextfield = new JTextField();
	JLabel mgrtablelabel;
	JLabel mgrwherelabel = new JLabel("���ǽ� �Է�");
	
	// ȸ�� ȭ�� ��ư
	JButton btmemmoviesearch = new JButton("��ȭ ��ȸ");
	JButton btmemreservationsearch = new JButton("���� ��ȸ");
	
	// ��ȭ��ȸ �ؽ�Ʈ�ڽ� ��
	JTextField[] memtfmoviesearch = new JTextField[4];
	JLabel[] memlblmoviesearch = new JLabel[4];
	JTextField memtfmoviesearchID = new JTextField();
	JLabel memlblmoviesearchID = new JLabel("ȸ��ID");
	JTextField memtfmoviesearchpayment = new JTextField();
	JLabel memlblmoviesearchpayment = new JLabel("�������");
	
	// ��ȭ��ȸ ��� ���� ��ȸ ��ư
	JButton btmemmoviesearchlookup = new JButton("��ȸ");
	JButton btmemmoviesearchcancle = new JButton("���");
	JButton[] btmemmoviesearchreservation = new JButton[4];
	
	// ��ȭ���� ��ȭ ������ �¼� ���̺� 
	JTable memmoviesearchmovietable;
	JScrollPane memmoviesearchmoviescroll;
	JTable memmoviesearchmoviescheduletable;
	JScrollPane memmoviesearchmovieschedulescroll;
	JTable memmoviesearchseattable;
	JScrollPane memmoviesearchseatscroll;
	
	// ������ȸ Ȯ�� ��� ���� ���� ��ư
	JButton btmemreservationsearchcheck = new JButton("Ȯ��");
	JButton btmemreservationsearchcancle = new JButton("���");
	JButton btmemreservationsearchremove = new JButton("����");
	JButton btmemreservationsearchchangemovie = new JButton("��ȭ����");
	JButton btmemreservationsearchchangeschedule = new JButton("����������");
	JButton btmemreservationsearchchangecancel = new JButton("�������");
	JButton[] btmemreservationsearchchangereservation = new JButton[3];
	
	// ������ȸ ���̺�
	// ��ȭ��, ����, �󿵰���ȣ, �¼���ȣ, �ǸŰ��� ���̺�
	JTable memreservationsearchtable;
	JScrollPane memreservationsearchscroll;
	// �󿵰�, ������, Ƽ�� ���̺�
	JTable memreservationsearchtheatertable;
	JScrollPane memreservationsearchtheaterscroll;
	JTable memreservationsearchscheduletable;
	JScrollPane memreservationsearchschedulescroll;
	JTable memreservationsearchtickettable;
	JScrollPane memreservationsearchticketscroll;
	// ��ȭ, ������, �¼� ���� ���̺�
	JTable memreservationsearchchangemovietable;
	JScrollPane memreservationsearchchangemoviescroll;
	JTable memreservationsearchchangescheduletable;
	JScrollPane memreservationsearchchangeschedulescroll;
	JTable memreservationsearchchangeseattable;
	JScrollPane memreservationsearchchangeseatscroll;
	
	
	
	// ������ȸ ID�Է� �� �ؽ�Ʈ �ڽ�
	JLabel memlblreservationsearchID = new JLabel("ID�Է�");
	JTextField memtfreservationsearchID = new JTextField();
	
	
	
	public frame() {
		this.setTitle("��ȭ ���� ����Ʈ");
		this.setLayout(null);
		this.setSize(1500,800);
		
		// �ʱ�޴� ����
		InitMainMenu();
		
		// ������ �޴� ����
		InitManagerMenu();
		
		// ������ ���̺� ����
		InitManagerTable();
		
		// ������ ���̺� �Է� ���� ���� ��ư ����
		InitManagerButton();
		
		// ������ ���̺� ������ �Է� �޴� �ؽ�Ʈ�ڽ� ����
		InitManagerTextField();
		
		// ȸ�� �޴� ����
		InitMemberMenu();
		
		// ȸ�� ��ȭ��ȸ �� �ؽ�Ʈ �ڽ� ����
		InitMemberMovieSearchTextField();
		
		// ȸ�� ��ȭ��ȸ ��ȸ ��� ���� ��ư ����
		InitMemberMovieSearchButton();
		
		// ȸ�� ��ȭ��ȸ ���̺� ����
		InitMemberMovieSearchTable();
		
		// ȸ�� ������ȸ Ȯ�� ��� ���� ���� ��ư ����
		InitMemberReservationSearchButton();
		
		// ȸ�� ������ȸ ���̺� ����
		InitMemberReservationSearchTable();
		
		// ȸ�� ������ȸ �� �ؽ�Ʈ �ڽ� ����
		InitMemberReservationSearchTextField();
		
		this.setVisible(true);
		
	}
	// ���� �޴�
	private void InitMainMenu() {
		// ������ ��ư
		btmgr.setSize(100, 100);
		btmgr.setLocation(600, 300);
		btmgr.addActionListener(new BtmgrListener());
		this.add(btmgr);
				
		// ȸ�� ��ư
		btmem.setSize(100, 100);
		btmem.setLocation(800, 300);
		btmem.addActionListener(new BtmemListener());
		this.add(btmem);
				
		// �ڷΰ��� ��ư
		btback.setSize(100,50);
		btback.setLocation(1380,10);
		btback.addActionListener(new BtBackListener());
		btback.setVisible(false);
		this.add(btback);
	}
	// ������ �޴�
	private void InitManagerMenu() {
		// ������ �ʱ�ȭ ��ư
		btmgrinit.setSize(100,50);
		btmgrinit.setLocation(0, 10);
		btmgrinit.setVisible(false);
		this.add(btmgrinit);
				
		// ������ �Է� ��ư
		btmgrinsert.setSize(100,50);
		btmgrinsert.setLocation(100, 10);
		btmgrinsert.addActionListener(new BtmgrInsertListener());
		btmgrinsert.setVisible(false);
		this.add(btmgrinsert);
				
		// ������ ���� ��ư
		btmgrdelete.setSize(100,50);
		btmgrdelete.setLocation(200, 10);
		btmgrdelete.addActionListener(new BtmgrDeleteListener());
		btmgrdelete.setVisible(false);
		this.add(btmgrdelete);
				
		// ������ ���� ��ư
		btmgrupdate.setSize(100,50);
		btmgrupdate.setLocation(300, 10);
		btmgrupdate.addActionListener(new BtmgrUpdateListener());
		btmgrupdate.setVisible(false);
		this.add(btmgrupdate);
				
		// ������ ��ü��ȸ ��ư
		btmgrselect.setSize(100,50);
		btmgrselect.setLocation(400, 10);
		btmgrselect.setVisible(false);
		btmgrselect.addActionListener(new BtmgrSelectListener());
		this.add(btmgrselect);
	}
	// ������ �ؽ�Ʈ�ڽ� �ʱ�ȭ
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
	// ������ ��ư �ʱ�ȭ
	private void InitManagerButton() {
		// ��ҹ�ư
		btmgrcanceltable.setSize(100,50);
		btmgrcanceltable.setLocation(1000,400);
		btmgrcanceltable.setVisible(false);
		btmgrcanceltable.addActionListener(new BtmgrCancleListener());
		this.add(btmgrcanceltable);
		// ��ü��ȸ Ȯ�ι�ư
		btmgrchecktable[3] = new JButton("Ȯ��");
		btmgrchecktable[3].setSize(100,50);
		btmgrchecktable[3].setLocation(1350,50);
		btmgrchecktable[3].setVisible(false);
		this.add(btmgrchecktable[3]);
		// �Է� ���� ���� Ȯ�� ��ư
		for(int i=0;i<3;i++) {
			btmgrchecktable[i] = new JButton("Ȯ��");
			btmgrchecktable[i].setSize(100,50);
			btmgrchecktable[i].setLocation(1000,300);
			btmgrchecktable[i].setVisible(false);
			this.add(btmgrchecktable[i]);
		}
		btmgrchecktable[0].addActionListener(new BtmgrInsertCheckListener());
		btmgrchecktable[1].addActionListener(new BtmgrDeleteCheckListener());
		btmgrchecktable[2].addActionListener(new BtmgrUpdateCheckListener());
		btmgrchecktable[3].addActionListener(new BtmgrSelectCheckListener());
		
		String[] name = {"��ȭ","������","�󿵰�","Ƽ��","�¼�","ȸ����","��������"};
		for(int i=0;i<7;i++) {
			// �Է¹�ư
			btmgrinserttable[i] = new JButton(name[i]);
			btmgrinserttable[i].setSize(100,50);
			btmgrinserttable[i].setLocation(100*i,10);
			btmgrinserttable[i].setVisible(false);
			this.add(btmgrinserttable[i]);
			
			// ������ư
			btmgrdeletetable[i] = new JButton(name[i]);
			btmgrdeletetable[i].setSize(100,50);
			btmgrdeletetable[i].setLocation(100*i,10);
			btmgrdeletetable[i].setVisible(false);
			this.add(btmgrdeletetable[i]);
			
			// �����ư
			btmgrupdatetable[i] = new JButton(name[i]);
			btmgrupdatetable[i].setSize(100,50);
			btmgrupdatetable[i].setLocation(100*i,10);
			btmgrupdatetable[i].setVisible(false);
			this.add(btmgrupdatetable[i]);
		}
		// �Է¹�ư �̺�Ʈ
		btmgrinserttable[0].addActionListener(new BtmgrInsertMovieListener());
		btmgrinserttable[1].addActionListener(new BtmgrInsertMovieScheduleListener());
		btmgrinserttable[2].addActionListener(new BtmgrInsertTheaterListener());
		btmgrinserttable[3].addActionListener(new BtmgrInsertTicketListener());
		btmgrinserttable[4].addActionListener(new BtmgrInsertSeatListener());
		btmgrinserttable[5].addActionListener(new BtmgrInsertCustomerListener());
		btmgrinserttable[6].addActionListener(new BtmgrInsertReservationListener());
		
		// ������ư �̺�Ʈ
		btmgrdeletetable[0].addActionListener(new BtmgrDeleteMovieListener());
		btmgrdeletetable[1].addActionListener(new BtmgrDeleteMovieScheduleListener());
		btmgrdeletetable[2].addActionListener(new BtmgrDeleteTheaterListener());
		btmgrdeletetable[3].addActionListener(new BtmgrDeleteTicketListener());
		btmgrdeletetable[4].addActionListener(new BtmgrDeleteSeatListener());
		btmgrdeletetable[5].addActionListener(new BtmgrDeleteCustomerListener());
		btmgrdeletetable[6].addActionListener(new BtmgrDeleteReservationListener());
		
		// �����ư �̺�Ʈ
		btmgrupdatetable[0].addActionListener(new BtmgrUpdateMovieListener());
		btmgrupdatetable[1].addActionListener(new BtmgrUpdateMovieScheduleListener());
		btmgrupdatetable[2].addActionListener(new BtmgrUpdateTheaterListener());
		btmgrupdatetable[3].addActionListener(new BtmgrUpdateTicketListener());
		btmgrupdatetable[4].addActionListener(new BtmgrUpdateSeatListener());
		btmgrupdatetable[5].addActionListener(new BtmgrUpdateCustomerListener());
		btmgrupdatetable[6].addActionListener(new BtmgrUpdateReservationListener());
	}
	
	
	// ������ ���̺� ���� �� �ʱ�ȭ
	private void InitManagerTable() {
		String[] movie = {"��ȭ��ȣ","��ȭ��","�󿵽ð�","�󿵵��", 
				"������", "����", "�帣", "��ȭ�Ұ�" ,"������ ����"};
		String[] movieschedule = {"��������ȣ", "��ȭ��ȣ", "�󿵰���ȣ", "�󿵽�����", 
				"�󿵿���", "��ȸ��","�󿵽��۽ð�"};
		String[] theater = {"�󿵰���ȣ", "�¼���","�󿵰���뿩��"};
		String[] ticket = {"Ƽ�Ϲ�ȣ", "��������ȣ", "�󿵰���ȣ", "�¼���ȣ", 
				"���Ź�ȣ", "�߱ǿ���", "ǥ�ذ���", "�ǸŰ���"};
		String[] seat = {"�¼���ȣ", "�󿵰���ȣ", "�¼���뿩��"};
		String[] customer = {"ȸ�����̵�", "����", "�޴�����ȣ", "���ڸ����ּ�"};
		String[] reservation = {"���Ź�ȣ", "�������", "��������", "�����ݾ�", 
				"ȸ�����̵�", "��������"};
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
			// 1��
			if(i==0 || i==1) {
				mgrscroll[i].setSize(700,150);
				mgrscroll[i].setLocation(700*i,150);
			}
			// 2��
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
			// 3��
			else {
				mgrscroll[i].setSize(700,150);
				mgrscroll[i].setLocation(700*(i-5),550);
			}
			mgrscroll[i].setVisible(false);
			this.add(mgrscroll[i]);
			
		}
		
	}
	
	// ȸ�� �޴�
	private void InitMemberMenu() {
		// ȸ�� ��ȭ��ȸ ��ư
		btmemmoviesearch.setSize(100,50);
		btmemmoviesearch.setLocation(0, 10);
		btmemmoviesearch.setVisible(false);
		btmemmoviesearch.addActionListener(new BtmemMovieSearchListener());
		this.add(btmemmoviesearch);
						
		// ȸ�� ������ȸ ��ư
		btmemreservationsearch.setSize(100,50);
		btmemreservationsearch.setLocation(100, 10);
		btmemreservationsearch.setVisible(false);
		btmemreservationsearch.addActionListener(new BtmemReservationSearchListener());
		this.add(btmemreservationsearch);
	}
	
	// ȸ�� ��ȭ��ȸ �� �ؽ�Ʈ �ڽ� ����
	private void InitMemberMovieSearchTextField() {
		
		String[] label = {"��ȭ��", "������", "����", "�帣"};
		for(int i=0;i<4;i++) {
			// ��ȭ��ȸ ��
			memlblmoviesearch[i] = new JLabel(label[i]);
			memlblmoviesearch[i].setSize(100,30);
			memlblmoviesearch[i].setLocation(100, 150+50*i);
			memlblmoviesearch[i].setVisible(false);
			this.add(memlblmoviesearch[i]);
			
			// ��ȭ��ȸ �ؽ�Ʈ �ڽ�
			memtfmoviesearch[i] = new JTextField();
			memtfmoviesearch[i].setSize(200,30);
			memtfmoviesearch[i].setLocation(250, 150+50*i);
			memtfmoviesearch[i].setVisible(false);
			this.add(memtfmoviesearch[i]);
		}
		// ID �� �ؽ�Ʈ �ڽ�
		memlblmoviesearchID.setSize(100,30);
		memlblmoviesearchID.setLocation(100, 150);
		memlblmoviesearchID.setVisible(false);
		this.add(memlblmoviesearchID);
		
		memtfmoviesearchID.setSize(200,30);
		memtfmoviesearchID.setLocation(250, 150);
		memtfmoviesearchID.setVisible(false);
		this.add(memtfmoviesearchID);
		
		// ������� �� �ؽ�Ʈ �ڽ�
		memlblmoviesearchpayment.setSize(100,30);
		memlblmoviesearchpayment.setLocation(100, 200);
		memlblmoviesearchpayment.setVisible(false);
		this.add(memlblmoviesearchpayment);
		
		memtfmoviesearchpayment.setSize(200,30);
		memtfmoviesearchpayment.setLocation(250, 200);
		memtfmoviesearchpayment.setVisible(false);
		this.add(memtfmoviesearchpayment);

	}
	
	// ȸ�� ��ȭ��ȸ ��ư ����
	private void InitMemberMovieSearchButton() {
		// ��ȭ��ȸ�޴� ��ȸ ��� ��ư
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
		
		// ��ȭ��ȸ�޴� ���Ź�ư
		for(int i=0;i<4;i++) {
			btmemmoviesearchreservation[i] = new JButton("����");
			btmemmoviesearchreservation[i].setSize(100,50);
			btmemmoviesearchreservation[i].setLocation(1000,250);
			btmemmoviesearchreservation[i].setVisible(false);
			this.add(btmemmoviesearchreservation[i]);	
		}
		
		// ��ȭ��ȸ�޴� ���Ź�ư �̺�Ʈ
		btmemmoviesearchreservation[0].addActionListener(new BtmemMovieSearchReservationMovieListener());
		btmemmoviesearchreservation[1].addActionListener(new BtmemMovieSearchReservationScheduleListener());
		btmemmoviesearchreservation[2].addActionListener(new BtmemMovieSearchReservationSeatListener());
		btmemmoviesearchreservation[3].addActionListener(new BtmemMovieSearchReservationInfoListener());
		
	}
	
	// ��ȭ��ȸ ���̺� ����
	private void InitMemberMovieSearchTable() {
		String[] movie = {"��ȭ��ȣ","��ȭ��","�󿵽ð�","�󿵵��", 
				"������", "����", "�帣", "��ȭ�Ұ�" ,"������ ����"};
		String[] movieschedule = {"��������ȣ", "��ȭ��ȣ", "�󿵰���ȣ", "�󿵽�����", 
				"�󿵿���", "��ȸ��","�󿵽��۽ð�"};
		String[] seat = {"�¼���ȣ", "�󿵰���ȣ", "�¼���뿩��"};
		
		String[][] moviedata = {{"1","1","1","1","1","1","1","1","1"},
				{"2","2","2","2","2","2","2","2","2"}};
		String[][] moviescheduledata = {{"1","1","1","1","1","1","1"}};
		String[][] seatdata = {{"1","1","1"}};
		
		// ��ȭ���� ��ȭ ���̺�
		memmoviesearchmovietable = new JTable(moviedata,movie);
		memmoviesearchmoviescroll = new JScrollPane(memmoviesearchmovietable);
		memmoviesearchmoviescroll.setSize(700,150);
		memmoviesearchmoviescroll.setLocation(0,150);
		memmoviesearchmoviescroll.setVisible(false);
		this.add(memmoviesearchmoviescroll);
		// ��ȭ���� ������ ���̺�
		memmoviesearchmoviescheduletable = new JTable(moviescheduledata,movieschedule);
		memmoviesearchmovieschedulescroll = new JScrollPane(memmoviesearchmoviescheduletable);
		memmoviesearchmovieschedulescroll.setSize(700,150);
		memmoviesearchmovieschedulescroll.setLocation(0,150);
		memmoviesearchmovieschedulescroll.setVisible(false);
		this.add(memmoviesearchmovieschedulescroll);
		
		// ��ȭ���� �¼� ���̺�
		memmoviesearchseattable = new JTable(seatdata,seat);
		memmoviesearchseatscroll = new JScrollPane(memmoviesearchseattable);
		memmoviesearchseatscroll.setSize(350,150);
		memmoviesearchseatscroll.setLocation(0,150);
		memmoviesearchseatscroll.setVisible(false);
		this.add(memmoviesearchseatscroll);
	}
	
	// ȸ�� ������ȸ ��ư ���� 
	private void InitMemberReservationSearchButton() {
		// ������ȸ Ȯ�� ��� ���� ���� ��ư
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
		
		
		// ������ȸ�޴� ���Ź�ư
		for(int i=0;i<3;i++) {
			btmemreservationsearchchangereservation[i] = new JButton("����");
			btmemreservationsearchchangereservation[i].setSize(100,50);
			btmemreservationsearchchangereservation[i].setLocation(1000,250);
			btmemreservationsearchchangereservation[i].setVisible(false);
			this.add(btmemreservationsearchchangereservation[i]);	
		}
		// ������ȸ�޴� ���Ź�ư �̺�Ʈ
		btmemreservationsearchchangereservation[0].addActionListener(new BtmemReservationSearchChangeMovieListener());
		btmemreservationsearchchangereservation[1].addActionListener(new BtmemReservationSearchChangeScheduleListener());
		btmemreservationsearchchangereservation[2].addActionListener(new BtmemReservationSearchChangeSeatListener());
		
		
		// ������ȸ�޴� ������� ��ư
		btmemreservationsearchchangecancel.setSize(100,50);
		btmemreservationsearchchangecancel.setLocation(1000,350);
		btmemreservationsearchchangecancel.setVisible(false);
		btmemreservationsearchchangecancel.addActionListener(new BtmemReservationSearchChangeCancleListener());
		this.add(btmemreservationsearchchangecancel);
		
	}
	
	// ȸ�� ������ȸ ���̺� ���� 
	private void InitMemberReservationSearchTable() {
		String[] memreservation = {"��ȭ��", "����", "�󿵰���ȣ", 
				"�¼���ȣ", "�ǸŰ���"};
		String[] movie = {"��ȭ��ȣ","��ȭ��","�󿵽ð�","�󿵵��", 
				"������", "����", "�帣", "��ȭ�Ұ�" ,"������ ����"};
		String[] movieschedule = {"��������ȣ", "��ȭ��ȣ", "�󿵰���ȣ", "�󿵽�����", 
				"�󿵿���", "��ȸ��","�󿵽��۽ð�"};
		String[] seat = {"�¼���ȣ", "�󿵰���ȣ", "�¼���뿩��"};
		String[] theater = {"�󿵰���ȣ", "�¼���","�󿵰���뿩��"};
		String[] ticket = {"Ƽ�Ϲ�ȣ", "��������ȣ", "�󿵰���ȣ", "�¼���ȣ", 
				"���Ź�ȣ", "�߱ǿ���", "ǥ�ذ���", "�ǸŰ���"};
		String[][] moviedata = {{"1","1","1","1","1","1","1","1","1"},
				{"2","2","2","2","2","2","2","2","2"}};
		String[][] moviescheduledata = {{"1","1","1","1","1","1","1"}};
		String[][] seatdata = {{"1","1","1"}};
		String[][] theaterdata = {{"1","1","1"}};
		String[][] ticketdata = {{"1","1","1","1","1","1","1","1"}};
		String[][] memreservationdata = {{"1","1","1","1","1"}};
		
		// ������ȸ ��ȭ��, ����, �󿵰���ȣ, �¼���ȣ, �ǸŰ��� ���̺�
		memreservationsearchtable = new JTable(memreservationdata,memreservation);
		memreservationsearchscroll = new JScrollPane(memreservationsearchtable);
		memreservationsearchscroll.setSize(400,150);
		memreservationsearchscroll.setLocation(0,150);
		memreservationsearchscroll.setVisible(false);
		this.add(memreservationsearchscroll);
		// ������ȸ �󿵰� ���̺�
		memreservationsearchtheatertable = new JTable(theaterdata,theater);
		memreservationsearchtheaterscroll = new JScrollPane(memreservationsearchtheatertable);
		memreservationsearchtheaterscroll.setSize(350,150);
		memreservationsearchtheaterscroll.setLocation(700,150);
		memreservationsearchtheaterscroll.setVisible(false);
		this.add(memreservationsearchtheaterscroll);
		// ������ȸ ������ ���̺�
		memreservationsearchscheduletable = new JTable(moviescheduledata,movieschedule);
		memreservationsearchschedulescroll = new JScrollPane(memreservationsearchscheduletable);
		memreservationsearchschedulescroll.setSize(700,150);
		memreservationsearchschedulescroll.setLocation(0,150);
		memreservationsearchschedulescroll.setVisible(false);
		this.add(memreservationsearchschedulescroll);
		// ������ȸ Ƽ�� ���̺�
		memreservationsearchtickettable = new JTable(ticketdata,ticket);
		memreservationsearchticketscroll = new JScrollPane(memreservationsearchtickettable);
		memreservationsearchticketscroll.setSize(700,150);
		memreservationsearchticketscroll.setLocation(0,350);
		memreservationsearchticketscroll.setVisible(false);
		this.add(memreservationsearchticketscroll);
		// ������ȸ ��ȭ ���� ���̺�
		memreservationsearchchangemovietable = new JTable(moviedata,movie);
		memreservationsearchchangemoviescroll = new JScrollPane(memreservationsearchchangemovietable);
		memreservationsearchchangemoviescroll.setSize(700,150);
		memreservationsearchchangemoviescroll.setLocation(0,150);
		memreservationsearchchangemoviescroll.setVisible(false);
		this.add(memreservationsearchchangemoviescroll);
		// ������ȸ ������ ���� ���̺�
		memreservationsearchchangescheduletable = new JTable(moviescheduledata,movieschedule);
		memreservationsearchchangeschedulescroll = new JScrollPane(memreservationsearchchangescheduletable);
		memreservationsearchchangeschedulescroll.setSize(700,150);
		memreservationsearchchangeschedulescroll.setLocation(0,150);
		memreservationsearchchangeschedulescroll.setVisible(false);
		this.add(memreservationsearchchangeschedulescroll);
				
		// ������ȸ �¼� ���� ���̺�
		memreservationsearchchangeseattable = new JTable(seatdata,seat);
		memreservationsearchchangeseatscroll = new JScrollPane(memreservationsearchchangeseattable);
		memreservationsearchchangeseatscroll.setSize(350,150);
		memreservationsearchchangeseatscroll.setLocation(0,150);
		memreservationsearchchangeseatscroll.setVisible(false);
		this.add(memreservationsearchchangeseatscroll);
		
	}
	
	// ȸ�� ������ȸ �� �ؽ�Ʈ �ڽ� ���� 
	private void InitMemberReservationSearchTextField() {
		
		
		// ID �� �ؽ�Ʈ �ڽ�
		memlblreservationsearchID.setSize(100,30);
		memlblreservationsearchID.setLocation(100, 150);
		memlblreservationsearchID.setVisible(false);
		this.add(memlblreservationsearchID);
		
		memtfreservationsearchID.setSize(200,30);
		memtfreservationsearchID.setLocation(250, 150);
		memtfreservationsearchID.setVisible(false);
		this.add(memtfreservationsearchID);
		
	}
	
	
	// �ڷΰ��� ��ư Ŭ��
	private class BtBackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// ������ �޴� ��ư ������
			btmgrinit.setVisible(false);
			btmgrinsert.setVisible(false);
			btmgrdelete.setVisible(false);
			btmgrupdate.setVisible(false);
			btmgrselect.setVisible(false);
			
			// ȸ�� �޴� ��ư ������
			btmemmoviesearch.setVisible(false);
			btmemreservationsearch.setVisible(false);
			
			// �ʱ�޴� ���̱�
			btmgr.setVisible(true);
			btmem.setVisible(true);
			
			// �ڷΰ��� ��ư ���̱�
			btback.setVisible(false);
		}
	}
	
	// �ʱ�޴� ������ ��ư Ŭ�� 
	private class BtmgrListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// �ʱ�޴� ������
			btmgr.setVisible(false);
			btmem.setVisible(false);
			// �ڷΰ��� ��ư ���̱�
			btback.setVisible(true);
			
			// ������ �޴� ��ư ���̱�
			btmgrinit.setVisible(true);
			btmgrinsert.setVisible(true);
			btmgrdelete.setVisible(true);
			btmgrupdate.setVisible(true);
			btmgrselect.setVisible(true);
		}
	}
	// �ʱ�޴� ȸ�� ��ư Ŭ��
	private class BtmemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// �ʱ�޴� ������
			btmgr.setVisible(false);
			btmem.setVisible(false);
			// �ڷΰ��� ��ư ���̱�
			btback.setVisible(true);
			
			// ȸ�� �޴� ��ư ���̱�
			btmemmoviesearch.setVisible(true);
			btmemreservationsearch.setVisible(true);
			
		}
	}
	
	// ������ �Է� ��ư Ŭ��
	private class BtmgrInsertListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// �ڷΰ��� ��ư �����
			btback.setVisible(false);
						
			// ������ �޴� ��ư �����
			btmgrinit.setVisible(false);
			btmgrinsert.setVisible(false);
			btmgrdelete.setVisible(false);
			btmgrupdate.setVisible(false);
			btmgrselect.setVisible(false);
			
			
			// ������ ���̺� ��ư ���̱�
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(true);
			}
		}
	}
	// ������ ���� ��ư Ŭ��
	private class BtmgrDeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// �ڷΰ��� ��ư �����
			btback.setVisible(false);
						
			// ������ �޴� ��ư �����
			btmgrinit.setVisible(false);
			btmgrinsert.setVisible(false);
			btmgrdelete.setVisible(false);
			btmgrupdate.setVisible(false);
			btmgrselect.setVisible(false);
			
			
			// ������ ���̺� ��ư ���̱�
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(true);
			}
		}
	}
	// ������ ���� ��ư Ŭ��
	private class BtmgrUpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// �ڷΰ��� ��ư �����
			btback.setVisible(false);
						
			// ������ �޴� ��ư �����
			btmgrinit.setVisible(false);
			btmgrinsert.setVisible(false);
			btmgrdelete.setVisible(false);
			btmgrupdate.setVisible(false);
			btmgrselect.setVisible(false);
			
			
			// ������ ���̺� ��ư ���̱�
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(true);
			}
		}
	}
	// ������ ��ü��ȸ ��ư Ŭ��
	private class BtmgrSelectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// ������ �޴� �����
			btmgrinit.setVisible(false);
			btmgrinsert.setVisible(false);
			btmgrdelete.setVisible(false);
			btmgrupdate.setVisible(false);
			btmgrselect.setVisible(false);
			btback.setVisible(false);
			
			// ���̺� ���̱�
			for(int i=0;i<7;i++) {
				mgrscroll[i].setVisible(true);
			}
			btmgrchecktable[3].setVisible(true);
			
		}
	}
	
	// ������ �Է� ��ư�� Ŭ������ ��ȭ��ư�� Ŭ��
	private class BtmgrInsertMovieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] movie = {"��ȭ��ȣ","��ȭ��","�󿵽ð�","�󿵵��", 
					"������", "����", "�帣", "��ȭ�Ұ�" ,"������ ����"};
			
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("movie");
			mgrtablelabel.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<9;i++) {
				mgrlabel[i].setText(movie[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// ������ �Է¹�ư�� Ŭ�� �� ������ Ŭ��
	private class BtmgrInsertMovieScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] movieschedule = {"��������ȣ", "��ȭ��ȣ", "�󿵰���ȣ", "�󿵽�����", 
					"�󿵿���", "��ȸ��","�󿵽��۽ð�"};
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("movieschedule");
			mgrtablelabel.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<7;i++) {
				mgrlabel[i].setText(movieschedule[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// ������ �Է¹�ư�� Ŭ�� �� �󿵰� Ŭ��
	private class BtmgrInsertTheaterListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] theater = {"�󿵰���ȣ", "�¼���","�󿵰���뿩��"};
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("theater");
			mgrtablelabel.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<3;i++) {
				mgrlabel[i].setText(theater[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// ������ �Է¹�ư�� Ŭ�� �� Ƽ�� Ŭ��
	private class BtmgrInsertTicketListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] ticket = {"Ƽ�Ϲ�ȣ", "��������ȣ", "�󿵰���ȣ", "�¼���ȣ", 
					"���Ź�ȣ", "�߱ǿ���", "ǥ�ذ���", "�ǸŰ���"};
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("ticket");
			mgrtablelabel.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<8;i++) {
				mgrlabel[i].setText(ticket[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// ������ �Է¹�ư�� Ŭ�� �� �¼� Ŭ��
	private class BtmgrInsertSeatListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] seat = {"�¼���ȣ", "�󿵰���ȣ", "�¼���뿩��"};
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("seat");
			mgrtablelabel.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<3;i++) {
				mgrlabel[i].setText(seat[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// ������ �Է¹�ư�� Ŭ�� �� ȸ���� Ŭ��
	private class BtmgrInsertCustomerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] customer = {"ȸ�����̵�", "����", "�޴�����ȣ", "���ڸ����ּ�"};
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("customer");
			mgrtablelabel.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<4;i++) {
				mgrlabel[i].setText(customer[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// ������ �Է¹�ư�� Ŭ�� �� �������� Ŭ��
	private class BtmgrInsertReservationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] reservation = {"���Ź�ȣ", "�������", "��������", "�����ݾ�", 
					"ȸ�����̵�", "��������"};
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrinserttable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("reservation");
			mgrtablelabel.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<6;i++) {
				mgrlabel[i].setText(reservation[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[0].setVisible(true);
		}
	}
	// ������ �Է¹�ư�� Ŭ�� �� Ȯ�ι�ư Ŭ��
	private class BtmgrInsertCheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// �����κ�
			if(mgrtablelabel.getText().equals("movie")) {
				
			}
			else if(mgrtablelabel.getText().equals("movieschedule")) {
				
			}
			else if(mgrtablelabel.getText().equals("theater")) {}
			
			// ������ �޴� ���̱�
			btmgrinit.setVisible(true);
			btmgrinsert.setVisible(true);
			btmgrdelete.setVisible(true);
			btmgrupdate.setVisible(true);
			btmgrselect.setVisible(true);
			btback.setVisible(true);
			
			// ������ ���̺� �̸� �����
			mgrtablelabel.setText("");
			mgrtablelabel.setVisible(false);
			// ������ ���̺� �Է�â �����
			for(int i=0;i<9;i++) {
				mgrlabel[i].setText("");
				mgrlabel[i].setVisible(false);
				mgrtextfield[i].setText("");
				mgrtextfield[i].setVisible(false);
			}
			// Ȯ�� ��� ��ư �����
			btmgrcanceltable.setVisible(false);
			btmgrchecktable[0].setVisible(false);
		}
	}
	// ������ ������ư�� Ŭ�� �� ��ȭ Ŭ��
	private class BtmgrDeleteMovieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("movie");
			mgrtablelabel.setVisible(true);
			
			// where ���� �Է� �ڽ� ���̱�
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// ������ ������ư�� Ŭ�� �� ������ Ŭ��
	private class BtmgrDeleteMovieScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("movieschedule");
			mgrtablelabel.setVisible(true);
			
			// where ���� �Է� �ڽ� ���̱�
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// ������ ������ư�� Ŭ�� �� �󿵰� Ŭ��
	private class BtmgrDeleteTheaterListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("theater");
			mgrtablelabel.setVisible(true);
			
			// where ���� �Է� �ڽ� ���̱�
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// ������ ������ư�� Ŭ�� �� Ƽ�� Ŭ��
	private class BtmgrDeleteTicketListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("ticket");
			mgrtablelabel.setVisible(true);
			
			// where ���� �Է� �ڽ� ���̱�
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// ������ ������ư�� Ŭ�� �� �¼� Ŭ��
	private class BtmgrDeleteSeatListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("seat");
			mgrtablelabel.setVisible(true);
			
			// where ���� �Է� �ڽ� ���̱�
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// ������ ������ư�� Ŭ�� �� ȸ���� Ŭ��
	private class BtmgrDeleteCustomerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("customer");
			mgrtablelabel.setVisible(true);
			
			// where ���� �Է� �ڽ� ���̱�
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// ������ ������ư�� Ŭ�� �� �������� Ŭ��
	private class BtmgrDeleteReservationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrdeletetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("reservation");
			mgrtablelabel.setVisible(true);
			
			// where ���� �Է� �ڽ� ���̱�
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			mgrwherelabel.setVisible(true);
			
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[1].setVisible(true);
		}
	}
	// ������ ������ư�� Ŭ�� �� Ȯ�� Ŭ��
	private class BtmgrDeleteCheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// �����κ�
			if(mgrtablelabel.getText().equals("movie")) {
				
			}
			else if(mgrtablelabel.getText().equals("movieschedule")) {
				
			}
			else if(mgrtablelabel.getText().equals("theater")) {}
			
			// ������ �޴� ���̱�
			btmgrinit.setVisible(true);
			btmgrinsert.setVisible(true);
			btmgrdelete.setVisible(true);
			btmgrupdate.setVisible(true);
			btmgrselect.setVisible(true);
			btback.setVisible(true);
			
			// ������ ���̺� �̸� �����
			mgrtablelabel.setText("");
			mgrtablelabel.setVisible(false);
			// ������ ���̺� �Է�â �����
			for(int i=0;i<9;i++) {
				mgrlabel[i].setText("");
				mgrlabel[i].setVisible(false);
				mgrtextfield[i].setText("");
				mgrtextfield[i].setVisible(false);
			}
			// ���ǽ� �Է�â �����
			mgrwherelabel.setVisible(false);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(false);
			
			
			// Ȯ�� ��� ��ư �����
			btmgrcanceltable.setVisible(false);
			for(int i=0;i<4;i++) {
				btmgrchecktable[i].setVisible(false);
			}
		}
	}
	// ������ �����ư�� Ŭ�� �� ��ȭ Ŭ��
	private class BtmgrUpdateMovieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] movie = {"��ȭ��ȣ","��ȭ��","�󿵽ð�","�󿵵��", 
					"������", "����", "�帣", "��ȭ�Ұ�" ,"������ ����"};
			
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("movie");
			mgrtablelabel.setVisible(true);
			
			// ���ǽ� �Է�â ���̱�
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<9;i++) {
				mgrlabel[i].setText(movie[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// ������ �����ư�� Ŭ�� �� ������ Ŭ��
	private class BtmgrUpdateMovieScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] movieschedule = {"��������ȣ", "��ȭ��ȣ", "�󿵰���ȣ", "�󿵽�����", 
					"�󿵿���", "��ȸ��","�󿵽��۽ð�"};
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("movieschedule");
			mgrtablelabel.setVisible(true);
			
			// ���ǽ� �Է�â ���̱�
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<7;i++) {
				mgrlabel[i].setText(movieschedule[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// ������ �����ư�� Ŭ�� �� �󿵰� Ŭ��
	private class BtmgrUpdateTheaterListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] theater = {"�󿵰���ȣ", "�¼���","�󿵰���뿩��"};
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("theater");
			mgrtablelabel.setVisible(true);
			
			// ���ǽ� �Է�â ���̱�
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<3;i++) {
				mgrlabel[i].setText(theater[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// ������ �����ư�� Ŭ�� �� Ƽ�� Ŭ��
	private class BtmgrUpdateTicketListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] ticket = {"Ƽ�Ϲ�ȣ", "��������ȣ", "�󿵰���ȣ", "�¼���ȣ", 
					"���Ź�ȣ", "�߱ǿ���", "ǥ�ذ���", "�ǸŰ���"};
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("ticket");
			mgrtablelabel.setVisible(true);
			
			// ���ǽ� �Է�â ���̱�
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<8;i++) {
				mgrlabel[i].setText(ticket[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// ������ �����ư�� Ŭ�� �� �¼� Ŭ��
	private class BtmgrUpdateSeatListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] seat = {"�¼���ȣ", "�󿵰���ȣ", "�¼���뿩��"};
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("seat");
			mgrtablelabel.setVisible(true);
			
			// ���ǽ� �Է�â ���̱�
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<3;i++) {
				mgrlabel[i].setText(seat[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// ������ �����ư�� Ŭ�� �� ȸ���� Ŭ��
	private class BtmgrUpdateCustomerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] customer = {"ȸ�����̵�", "����", "�޴�����ȣ", "���ڸ����ּ�"};
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("customer");
			mgrtablelabel.setVisible(true);
			
			// ���ǽ� �Է�â ���̱�
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<4;i++) {
				mgrlabel[i].setText(customer[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// ������ �����ư�� Ŭ�� �� �������� Ŭ��
	private class BtmgrUpdateReservationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] reservation = {"���Ź�ȣ", "�������", "��������", "�����ݾ�", 
					"ȸ�����̵�", "��������"};
			// ������ ���̺� ��ư �����
			for(int i=0;i<7;i++) {
				btmgrupdatetable[i].setVisible(false);
			}
			
			// ������ ���̺� �̸� ���̱�
			mgrtablelabel.setText("reservation");
			mgrtablelabel.setVisible(true);
			
			// ���ǽ� �Է�â ���̱�
			mgrwherelabel.setVisible(true);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(true);
			
			// ������ ���̺� �Է�â ���̱�
			for(int i=0;i<6;i++) {
				mgrlabel[i].setText(reservation[i]);
				mgrlabel[i].setVisible(true);
				mgrtextfield[i].setVisible(true);
			}
			// Ȯ�� ��� ��ư ���̱�
			btmgrcanceltable.setVisible(true);
			btmgrchecktable[2].setVisible(true);
		}
	}
	// ������ �����ư�� Ŭ�� �� Ȯ�� Ŭ��
	private class BtmgrUpdateCheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// �����κ�
			if(mgrtablelabel.getText().equals("movie")) {
				
			}
			else if(mgrtablelabel.getText().equals("movieschedule")) {
				
			}
			else if(mgrtablelabel.getText().equals("theater")) {}
			
			// ������ �޴� ���̱�
			btmgrinit.setVisible(true);
			btmgrinsert.setVisible(true);
			btmgrdelete.setVisible(true);
			btmgrupdate.setVisible(true);
			btmgrselect.setVisible(true);
			btback.setVisible(true);
			
			// ������ ���̺� �̸� �����
			mgrtablelabel.setText("");
			mgrtablelabel.setVisible(false);
			
			// ���ǽ� �Է�â �����
			mgrwherelabel.setVisible(false);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(false);
			
			// ������ ���̺� �Է�â �����
			for(int i=0;i<9;i++) {
				mgrlabel[i].setText("");
				mgrlabel[i].setVisible(false);
				mgrtextfield[i].setText("");
				mgrtextfield[i].setVisible(false);
			}
			// Ȯ�� ��� ��ư �����
			btmgrcanceltable.setVisible(false);
			btmgrchecktable[2].setVisible(false);
		}
	}
	
	
	// ������ ��ü��ȸ ��ư Ŭ�� 
	private class BtmgrSelectCheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// ������ �޴� ���̱�
			btmgrinit.setVisible(true);
			btmgrinsert.setVisible(true);
			btmgrdelete.setVisible(true);
			btmgrupdate.setVisible(true);
			btmgrselect.setVisible(true);
			btback.setVisible(true);
			
			// ���̺� �����
			for(int i=0;i<7;i++) {
				mgrscroll[i].setVisible(false);
			}
			btmgrchecktable[3].setVisible(false);
			
			
		}
	}
	// ������ ��ҹ�ư Ŭ��
	private class BtmgrCancleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			// ������ �޴� ���̱�
			btmgrinit.setVisible(true);
			btmgrinsert.setVisible(true);
			btmgrdelete.setVisible(true);
			btmgrupdate.setVisible(true);
			btmgrselect.setVisible(true);
			btback.setVisible(true);
			
			// ������ ���̺� �̸� �����
			mgrtablelabel.setText("");
			mgrtablelabel.setVisible(false);
			mgrwherelabel.setVisible(false);
			mgrwheretextfield.setText("");
			mgrwheretextfield.setVisible(false);
			
			
			// ������ ���̺� �Է�â �����
			for(int i=0;i<9;i++) {
				mgrlabel[i].setText("");
				mgrlabel[i].setVisible(false);
				mgrtextfield[i].setText("");
				mgrtextfield[i].setVisible(false);
			}
			// Ȯ�� ��� ��ư �����
			btmgrcanceltable.setVisible(false);
			for(int i=0;i<4;i++) {
				btmgrchecktable[i].setVisible(false);
			}
		}
	}
	
	// ȸ���޴����� ��ȭ��ȸ ��ư Ŭ��
	private class BtmemMovieSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// ȸ�� �޴� �����
			btmemmoviesearch.setVisible(false);
			btmemreservationsearch.setVisible(false);
			
			// ��ȭ��, ������, ����, �帣 �ؽ�Ʈ�ڽ� �� ���̱�
			for(int i=0;i<4;i++) {
				memtfmoviesearch[i].setVisible(true);
				memlblmoviesearch[i].setVisible(true);
			}
			// �ڷΰ��� ��ư �����
			btback.setVisible(false);
			
			// ��ȸ ��� ��ư ���̱�
			btmemmoviesearchlookup.setVisible(true);
			btmemmoviesearchcancle.setVisible(true);
			
			
			
		}
	}
	
	private class BtmemReservationSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// ȸ�� �޴� �����
			btmemmoviesearch.setVisible(false);
			btmemreservationsearch.setVisible(false);
			
			// ID�Է� �� �ؽ�Ʈ �ڽ� ���̱�
			memlblreservationsearchID.setVisible(true);
			memtfreservationsearchID.setVisible(true);
			
			// �ڷΰ��� ��ư �����
			btback.setVisible(false);
			
			// Ȯ�� ��� ��ư ���̱�
			btmemreservationsearchcheck.setVisible(true);
			btmemreservationsearchcancle.setVisible(true);
			
		}
	}
	
	
	// ��ȭ��ȸ ��ư Ŭ���� ��ȸ��ư Ŭ��
	private class BtmemMovieSearchLookupListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// �ؽ�Ʈ �ڽ� �����
			for(int i=0;i<4;i++) {
				memlblmoviesearch[i].setVisible(false);
				memtfmoviesearch[i].setVisible(false);
				memtfmoviesearch[i].setText("");
			}
			// ��ȸ ��ư �����
			btmemmoviesearchlookup.setVisible(false);
			
			// ��ȭ ���̺� ����
			memmoviesearchmoviescroll.setVisible(true);
			
			// ���� ��� ��ư ���̱�
			btmemmoviesearchreservation[0].setVisible(true);
			btmemmoviesearchcancle.setVisible(true);
			
		}
	}
	
	// ��ȭ ���̺� ȭ�鿡�� ���� ��ư Ŭ�� (��ȭ -> ������)
	private class BtmemMovieSearchReservationMovieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// ������ ���̺� ���̱�
			memmoviesearchmovieschedulescroll.setVisible(true);
			
			// ��ȭ ���̺� �����
			memmoviesearchmoviescroll.setVisible(false);
			
			// ���� ���� ��ư �����
			btmemmoviesearchreservation[0].setVisible(false);
			
			// ���� ��ư ���̱�
			btmemmoviesearchreservation[1].setVisible(true);
			
		}
	}
	
	// ��ȭ ���̺� ȭ�鿡�� ���� ��ư Ŭ�� (������ -> �¼�)
	private class BtmemMovieSearchReservationScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// ������ ���̺� �����
			memmoviesearchmovieschedulescroll.setVisible(false);
			
			// �¼� ���̺� ���̱�
			memmoviesearchseatscroll.setVisible(true);
			
			// ���� ���� ��ư �����
			btmemmoviesearchreservation[1].setVisible(false);
			
			// ���� ��ư ���̱�
			btmemmoviesearchreservation[2].setVisible(true);
			
		}
	}
	// ��ȭ ���̺� ȭ�鿡�� ���� ��ư Ŭ�� (�¼� -> ��������)
	private class BtmemMovieSearchReservationSeatListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// �¼� ���̺� �����
			memmoviesearchseatscroll.setVisible(false);
			
			// �������� ������� ID �� �ؽ�Ʈ �ڽ� ���̱�
			memlblmoviesearchID.setVisible(true);
			memtfmoviesearchID.setVisible(true);
			memtfmoviesearchpayment.setVisible(true);
			memlblmoviesearchpayment.setVisible(true);
			
			// ���� ���� ��ư �����
			btmemmoviesearchreservation[2].setVisible(false);
			
			// ���� ��ư ���̱�
			btmemmoviesearchreservation[3].setVisible(true);
			
		}
	}
	// ��ȭ ���̺� ȭ�鿡�� ���� ��ư Ŭ�� (�������� -> ȸ���޴�)
	private class BtmemMovieSearchReservationInfoListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// �������� ������� ID �� �ؽ�Ʈ �ڽ� �����
			memlblmoviesearchID.setVisible(false);
			memtfmoviesearchID.setVisible(false);
			memtfmoviesearchID.setText("");
			memlblmoviesearchpayment.setVisible(false);
			memtfmoviesearchpayment.setVisible(false);
			memtfmoviesearchpayment.setText("");
			
			// ���� ��� ��ư �����
			btmemmoviesearchreservation[3].setVisible(false);
			btmemmoviesearchcancle.setVisible(false);
			
			// ȸ�� �޴� ���̱�
			btmemmoviesearch.setVisible(true);
			btmemreservationsearch.setVisible(true);
			
			// �ڷΰ��� ��ư ���̱�
			btback.setVisible(true);
			
		}
	}
	
	// ��ȭ��ȸ ��ư Ŭ���� ��ҹ�ư Ŭ��
	private class BtmemMovieSearchCancleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// �ؽ�Ʈ �ڽ� �����
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
			
			// ��ȭ ���̺� �����
			memmoviesearchmoviescroll.setVisible(false);
			
			// ������ ���̺� �����
			memmoviesearchmovieschedulescroll.setVisible(false);
			
			// �¼� ���̺� �����
			memmoviesearchseatscroll.setVisible(false);
			
			// ��ȸ ��ư �����
			btmemmoviesearchlookup.setVisible(false);
			
			// ���� ��ư �����
			for(int i=0;i<4;i++) {
				btmemmoviesearchreservation[i].setVisible(false);
			}
			
			// ȸ���޴� ���̱�
			btmemmoviesearch.setVisible(true);
			btmemreservationsearch.setVisible(true);
			
			// �ڷΰ��� ��ư ���̱�
			btback.setVisible(true);
			
			// ��� ��ư �����
			btmemmoviesearchcancle.setVisible(false);
			
		}
	}
	
	// ������ȸ ��ư Ŭ���� Ȯ�ι�ư Ŭ��
	private class BtmemReservationSearchCheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// �ؽ�Ʈ �ڽ� �����
			memlblreservationsearchID.setVisible(false);
			memtfreservationsearchID.setVisible(false);
			memtfreservationsearchID.setText("");
			
			
			// ��ȭ ���̺� ���̱�
			memreservationsearchscroll.setVisible(true);
			
			// Ȯ�� ��ư �����
			btmemreservationsearchcheck.setVisible(false);
			
			
			// ���� ��ȭ���� ���������� ��ư ���̱�
			btmemreservationsearchremove.setVisible(true);
			btmemreservationsearchchangemovie.setVisible(true);
			btmemreservationsearchchangeschedule.setVisible(true);
			
		}
	}
	
	// ������ȸ ��ư Ŭ���� ������ư Ŭ��
	private class BtmemReservationSearchRemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			/*
			String[] memreservation = {"��ȭ��", "����", "�󿵰���ȣ", 
					"�¼���ȣ", "�ǸŰ���"};
			String[][] memreservationdata = {{"2","2","2","2","2"}};
			
			DefaultTableModel m = new DefaultTableModel(memreservationdata,memreservation);
			memreservationsearchtable.setModel(m);
			*/
			
			
			// ȸ���޴� ���̱�
			btmemmoviesearch.setVisible(true);
			btmemreservationsearch.setVisible(true);
			btback.setVisible(true);
			
			// ��ȭ ���̺� �����
			memreservationsearchscroll.setVisible(false);
			
			// ���� ��ȭ���� ���������� ��� ��ư �����
			btmemreservationsearchremove.setVisible(false);
			btmemreservationsearchchangemovie.setVisible(false);
			btmemreservationsearchchangeschedule.setVisible(false);
			btmemreservationsearchcancle.setVisible(false);
			
		}
	}
	
	// ������ȸ ��ư Ŭ���� ��ȭ���� ��ư Ŭ�� 
	private class BtmemReservationSearchMovieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// ��ȭ���� ��ȭ ���̺� ���̱�
			memreservationsearchchangemoviescroll.setVisible(true);
			
			// ��ȭ���� ���Ź�ư ������ҹ�ư ���̱�
			btmemreservationsearchchangereservation[0].setVisible(true);
			btmemreservationsearchchangecancel.setVisible(true);
			
			
			// ��ȭ ���̺� �����
			memreservationsearchscroll.setVisible(false);
			
			// ���� ��ȭ���� ���������� ��� ��ư �����
			btmemreservationsearchremove.setVisible(false);
			btmemreservationsearchchangemovie.setVisible(false);
			btmemreservationsearchchangeschedule.setVisible(false);
			btmemreservationsearchcancle.setVisible(false);
			
		}
	}
	
	// ������ȸ ��ư Ŭ���� ���������� ��ư Ŭ��
	private class BtmemReservationSearchScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// ��ȭ���� ������ ���̺� ���̱�
			memreservationsearchchangeschedulescroll.setVisible(true);
			
			// ��ȭ���� ���Ź�ư ������ҹ�ư ���̱�
			btmemreservationsearchchangereservation[1].setVisible(true);
			btmemreservationsearchchangecancel.setVisible(true);
			
			// ��ȭ ���̺� �����
			memreservationsearchscroll.setVisible(false);
			
			// ���� ��ȭ���� ���������� ��� ��ư �����
			btmemreservationsearchremove.setVisible(false);
			btmemreservationsearchchangemovie.setVisible(false);
			btmemreservationsearchchangeschedule.setVisible(false);
			btmemreservationsearchcancle.setVisible(false);
			
		}
	}
	
	// ������ȸ ��ư Ŭ���� ��ȭ���� Ŭ���� ���Ź�ư Ŭ�� (��ȭ -> ������)
	private class BtmemReservationSearchChangeMovieListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// ��ȭ���� ��ȭ ���̺� �����
			memreservationsearchchangemoviescroll.setVisible(false);
			
			// ��ȭ���� ������ ���̺� ���̱�
			memreservationsearchchangeschedulescroll.setVisible(true);
			
			// ��ȭ���� ���� ��ư ���̱�
			btmemreservationsearchchangereservation[1].setVisible(true);
			
			// ��ȭ���� ���� ���� ��ư �����
			btmemreservationsearchchangereservation[0].setVisible(false);
		}
	}
	
	// ������ȸ ��ư Ŭ���� ��ȭ���� Ŭ���� ���Ź�ư Ŭ�� (������ -> �¼�)
	private class BtmemReservationSearchChangeScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// ��ȭ���� ������ ���̺� �����
			memreservationsearchchangeschedulescroll.setVisible(false);
			
			// ��ȭ���� �¼� ���̺� ���̱�
			memreservationsearchchangeseatscroll.setVisible(true);
			
			// ��ȭ���� ���� ��ư ���̱�
			btmemreservationsearchchangereservation[2].setVisible(true);
			
			// ��ȭ���� ���� ���� ��ư �����
			btmemreservationsearchchangereservation[1].setVisible(false);
		}
	}
	
	// ������ȸ ��ư Ŭ���� ��ȭ���� Ŭ���� ���Ź�ư Ŭ�� (�¼� -> ������ȸ�޴�)
	private class BtmemReservationSearchChangeSeatListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// ��ȭ���� �¼� ���̺� �����
			memreservationsearchchangeseatscroll.setVisible(false);
			
			// ��ȭ���� ���Ź�ư, ������ҹ�ư �����
			btmemreservationsearchchangereservation[2].setVisible(false);
			btmemreservationsearchchangecancel.setVisible(false);
			
			// ȸ���޴� ���̱�
			btmemmoviesearch.setVisible(true);
			btmemreservationsearch.setVisible(true);
			btback.setVisible(true);
			
			
		}
	}
	
	// ������ȸ ��ư Ŭ���� ��ҹ�ư Ŭ��
	private class BtmemReservationSearchCancleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// �ؽ�Ʈ �ڽ� �����
			memlblreservationsearchID.setVisible(false);
			memtfreservationsearchID.setVisible(false);
			memtfreservationsearchID.setText("");
			
			
			// ��ȭ ���̺� �����
			memreservationsearchscroll.setVisible(false);
			
			// Ȯ�� ���� ��ȭ���� ���������� ��ư �����
			btmemreservationsearchcheck.setVisible(false);
			btmemreservationsearchremove.setVisible(false);
			btmemreservationsearchchangemovie.setVisible(false);
			btmemreservationsearchchangeschedule.setVisible(false);
			
			// ȸ���޴� ���̱�
			btmemmoviesearch.setVisible(true);
			btmemreservationsearch.setVisible(true);
			
			// �ڷΰ��� ��ư ���̱�
			btback.setVisible(true);
			
			// ��� ��ư �����
			btmemreservationsearchcancle.setVisible(false);
			
		}
	}
	
	// ������ȸ ��ư Ŭ���� ��ȭ���� Ŭ���� ������� ��ư Ŭ�� 
	private class BtmemReservationSearchChangeCancleListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			// ��ȭ���� ��ȭ, ������, �¼� ���̺� �����
			memreservationsearchchangemoviescroll.setVisible(false);
			memreservationsearchchangeschedulescroll.setVisible(false);
			memreservationsearchchangeseatscroll.setVisible(false);
			
			// ��ȭ���� ���Ź�ư ������ҹ�ư �����
			for(int i=0;i<3;i++) {
				btmemreservationsearchchangereservation[i].setVisible(false);
			}
			btmemreservationsearchchangecancel.setVisible(false);
			
			// ��ȭ ���̺� ���̱�
			memreservationsearchscroll.setVisible(true);
			
			// ���� ��ȭ���� ���������� ��� ��ư ���̱�
			btmemreservationsearchremove.setVisible(true);
			btmemreservationsearchchangemovie.setVisible(true);
			btmemreservationsearchchangeschedule.setVisible(true);
			btmemreservationsearchcancle.setVisible(true);
			
			
		}
	}
}
