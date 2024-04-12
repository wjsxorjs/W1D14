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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EmpFrame1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField empno_tf;
	private JTextField ename_tf;
	private JTextField dept_tf;
	private JTextField pos_tf;
	private JTextField hiredate_tf;
	private JTextArea textArea;

	
	
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
					EmpFrame1 frame = new EmpFrame1();
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
	public EmpFrame1() {
		
		list = new ArrayList<>();
		
		f = new File(path);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JButton btnNewButton = new JButton("전체");
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("추가");
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("삭제");
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("검색");
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("종료");
		panel_2.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
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

}
