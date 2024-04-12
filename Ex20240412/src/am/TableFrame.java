package am;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import homework.EmpVO_Ans;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ArrayList<EmpVO_Ans> list;
	private JTable table;
	String[] c_name = {"사번","이름","직책","부서","입사일"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableFrame frame = new TableFrame();
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
	public TableFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		viewTable();
		
	}
	
	private void viewTable() {
		// ArrayList를 배열화 시켜라 : 2차원 배열

		list = new ArrayList<EmpVO_Ans>();
		
		EmpVO_Ans vo1 = new EmpVO_Ans("100", "AAA", "사원", "개발1", "2021");
		EmpVO_Ans vo2 = new EmpVO_Ans("200", "BBB", "대리", "개발2", "2022");
		EmpVO_Ans vo3 = new EmpVO_Ans("300", "CCC", "부장", "개발3", "2023");
		
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		
		// ---------------------------------------------------------------------
		
		
		String[][] ar2 = new String[list.size()][5];
		
		for(int i=0; i<ar2.length; i++) {
			
			// 리스트로부터 하나의 요소를 얻어낸다.
			EmpVO_Ans vo = list.get(i);
			
			// 배열에 저장시킨다.
			ar2[i][0] = vo.getEmpno(); 		// 사번
			ar2[i][1] = vo.getEname(); 		// 이름
			ar2[i][2] = vo.getDept(); 		// 직책
			ar2[i][3] = vo.getPos(); 		// 부서
			ar2[i][4] = vo.getHireDate(); 	// 입사일
						
		}
		
		table.setModel(new DefaultTableModel(ar2, c_name));
	}
	

}
