package homework;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField empno_tf;
	private JTextField ename_tf;
	private JTextField dept_tf;
	private JTextField pos_tf;
	private JTextField hiredate_tf;
	private JTextArea textArea;
	
	JButton btnNewButton,
			btnNewButton_1,
			btnNewButton_2,
			btnNewButton_3,
			btnNewButton_4,
			btnNewButton_5;

	// 상수화 - 사용자가 원하는 작업을 구별하기 위해 필요한 상수
	
	final static int TOTAL = 4; 
	final static int ADD = 3; 
	final static int DELETE = 2; 
	final static int SEARCH = 1; 
	final static int NONE = 0;
	
	int cmd;
	
	
	// 객체를 저장할 ArrayList 준비
	ArrayList<EmpVO_Ans> list;
	
	// 파일에 위의 list를 저장하기 위해 스트림을 준비
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	String path = "C:/My_Study/io_test_ans.txt";
	File f;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpFrame frame = new EmpFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmpFrame() {
		
		list = new ArrayList<>();
		
		f = new File(path);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(8, 1, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("사번:");
		panel_1.add(lblNewLabel);
		
		empno_tf = new JTextField();
		panel_1.add(empno_tf);
		empno_tf.setColumns(5);
		
		JPanel panel_1_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("이름:");
		panel_1_1.add(lblNewLabel_1);
		
		ename_tf = new JTextField();
		ename_tf.setColumns(5);
		panel_1_1.add(ename_tf);
		
		JPanel panel_1_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("부서:");
		panel_1_2.add(lblNewLabel_2);
		
		dept_tf = new JTextField();
		dept_tf.setColumns(5);
		panel_1_2.add(dept_tf);
		
		JPanel panel_1_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_1_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("직책:");
		panel_1_3.add(lblNewLabel_3);
		
		pos_tf = new JTextField();
		pos_tf.setColumns(5);
		panel_1_3.add(pos_tf);
		
		JPanel panel_1_4 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_1_4.getLayout();
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_1_4);
		
		JLabel lblNewLabel_4 = new JLabel("입사일:");
		panel_1_4.add(lblNewLabel_4);
		
		hiredate_tf = new JTextField();
		hiredate_tf.setColumns(5);
		panel_1_4.add(hiredate_tf);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_2.getLayout();
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("전체");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTotal();
			}
		});
		panel_2.add(btnNewButton);
		
		btnNewButton_1 = new JButton("추가");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// [추가] 버튼을 클릭했을 때 수행
				
				if(cmd != ADD) {
					cmd = ADD;
				} else {
									
				// 사용자가 입력한 사번, 이름,... 값을 가져온다.
				String empno = empno_tf.getText().trim();
				String ename = ename_tf.getText().trim();
				String dept = dept_tf.getText().trim();
				String pos = pos_tf.getText().trim();
				String hiredate = hiredate_tf.getText().trim();
				
				// 받은 값들을 하나의 객체화
				EmpVO_Ans vo = new EmpVO_Ans(empno, ename, pos, dept, hiredate);
				
				list.add(vo);
				
				// 저장완료의 의미로 메시지 창 보여주기
				JOptionPane.showMessageDialog(EmpFrame.this, "저장 완료");
				
				cmd = NONE;
				}
				initTxt();
				initBtn();
			}
		});
		panel_2.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("삭제");
		panel_2.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("검색");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmd!=SEARCH) {
					cmd = SEARCH;
				} else {
					
					
					cmd = NONE;
				}
				initTxt();
				initBtn();
			}
		});
		panel_2.add(btnNewButton_3); 
		
		btnNewButton_4 = new JButton("종료");
		btnNewButton_4.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				saveList();
				closed();
				System.exit(0);
			}
		});
		
		btnNewButton_5 = new JButton("취소");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmd = NONE;
				initTxt();
				initBtn();
			}
		});
		panel_2.add(btnNewButton_5);
		panel_2.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		// 파일로부터 ArrayList를 가져와 list에 저장
		readList();
		
		initTxt();
		initBtn();
	}
	
	
	private void saveList() {
		try {
			if(oos == null) {
				oos = new ObjectOutputStream(new FileOutputStream(f));
			}
			// 멤버 변수인 list를 저장
			oos.writeObject(list);
			oos.flush();
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void readList() {
		try {
			if(ois == null) {
				ois = new ObjectInputStream(new FileInputStream(f));
			}
			// 멤버 변수인 list를 저장
			Object obj = ois.readObject();
			
			if(obj instanceof ArrayList) {
				list = (ArrayList<EmpVO_Ans>) obj;
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void closed() {
		try {
			if(ois != null) {
				ois.close();
			}
			if(oos != null) {
				oos.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void viewTotal() {
		// list에 있는 모든 자원들을 문자열로 만들어서
		// JTextArea에 출력
		StringBuffer sb = new StringBuffer();
		sb.append(" -------------------------------------------------------------------------------------------------------------------------------------------------------\r\n");
		sb.append("\t사번\t이름\t부서\t직책\t입사일\r\n");
		sb.append(" -------------------------------------------------------------------------------------------------------------------------------------------------------\r\n");
		
		for(int i=0; i<list.size();i++) {
			EmpVO_Ans vo = list.get(i); // 요소 하나 얻어내기
			
			sb.append("\t");
			sb.append(vo.getEmpno());
			sb.append("\t");
			sb.append(vo.getEname());
			sb.append("\t");
			sb.append(vo.getDept());
			sb.append("\t");
			sb.append(vo.getPos());
			sb.append("\t");
			sb.append(vo.getHireDate());
			sb.append("\r\n");
		} // for문의 끝
		
		// sb가 가지고 있는 문자열의 집합을 JTextArea에 표현
		textArea.setText(sb.toString());
		
	}
	
	
	private void initTxt() {
		empno_tf.setEditable(false);
		ename_tf.setEditable(false);
		dept_tf.setEditable(false);
		pos_tf.setEditable(false);
		hiredate_tf.setEditable(false);
		switch(cmd) {
		case ADD: 
			empno_tf.setEditable(true);
			ename_tf.setEditable(true);
			dept_tf.setEditable(true);
			pos_tf.setEditable(true);
			hiredate_tf.setEditable(true);
			break;
		case DELETE:
			empno_tf.setEditable(true);
			break;
		case SEARCH:
			ename_tf.setEditable(true);
			break;
			
		}
	}
	
	private void initBtn() {
		btnNewButton.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		btnNewButton_2.setEnabled(false);
		btnNewButton_3.setEnabled(false);
		btnNewButton_4.setEnabled(false);
		switch (cmd) {
		case ADD:
			btnNewButton_1.setEnabled(true);
			break;
		case SEARCH:
			btnNewButton_3.setEnabled(true);
			break;
		case DELETE:
			btnNewButton_2.setEnabled(true);
			break;
		case NONE:
			btnNewButton.setEnabled(true);
			btnNewButton_1.setEnabled(true);
			btnNewButton_2.setEnabled(true);
			btnNewButton_3.setEnabled(true);
			btnNewButton_4.setEnabled(true);
			
			
			
			
		}
	}

}
