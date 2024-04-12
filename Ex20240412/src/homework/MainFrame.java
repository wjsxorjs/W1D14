package homework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	
	ArrayList<EmpVO> list = new ArrayList<EmpVO>();
	
	JTextArea textArea = new JTextArea();
	
	JPanel  p_empNo,
			p_empName,
			p_empDept,
			p_empPos,
			p_empDoe;
	
	JLabel l_empNo,
			l_empName,
			l_empDept,
			l_empPos,
			l_empDoe;
	
	JTextField  tf_empNo,
				tf_empName,
				tf_empDept,
				tf_empPos,
				tf_empDoe;
	
	JPanel 	gridP,
			flowP;
	
	JPanel mainP = new JPanel();
	
	JButton btn_All,
			btn_Add,
			btn_Del,
			btn_Sch,
			btn_Esc;
	
	File f = new File("C:/My_Study/io_test.txt");
	
	private void getList(){
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			
			Object obj = ois.readObject();
			
			if(obj instanceof ArrayList) {
				list = (ArrayList<EmpVO>) obj;
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch (Exception e3) {
				// TODO: handle exception
			}
		}
	}
	
	
	private void printList() {
		textArea.setText("   사번    |    이름    |    부서    |    직책    |    입사일   \r\n");
		textArea.append("======================================\r\n");
		for(int i=0; i<list.size();i++) {
			EmpVO vo = list.get(i);
			StringBuffer sb = new StringBuffer("    ");
			sb.append(vo.empNo);
			sb.append("   |   ");
			sb.append(vo.empName);
			sb.append("   |   ");
			sb.append(vo.empDept);
			sb.append("   |   ");
			sb.append(vo.empPos);
			sb.append("   |   ");
			sb.append(vo.empDoe);
			sb.append("\r\n");
			textArea.append(sb.toString());
		}
		textArea.revalidate();
	}
	
	private boolean initVO(EmpVO vo) {
		
		boolean result = false;
		String tmpNo = tf_empNo.getText().trim();
		if(tmpNo.length()==0) {
			JOptionPane.showMessageDialog(MainFrame.this, "사번을 입력해주십시오.");
			return result;
		}
		vo.setEmpNo(tmpNo);

		String tmpName = tf_empName.getText().trim();
		if(tmpName.length()==0) {
			JOptionPane.showMessageDialog(MainFrame.this, "이름을 입력해주십시오.");
			return result;
		}
		vo.setEmpName(tmpName);

		String tmpDept = tf_empDept.getText().trim();
		if(tmpDept.length()==0) {
			JOptionPane.showMessageDialog(MainFrame.this, "부서를 입력해주십시오.");
			return result;
		}
		vo.setEmpDept(tmpDept);

		String tmpPos = tf_empPos.getText().trim();
		if(tmpPos.length()==0) {
			JOptionPane.showMessageDialog(MainFrame.this, "직책을 입력해주십시오.");
			return result;
		}
		vo.setEmpPos(tmpPos);

		String tmpDoe = tf_empDoe.getText().trim();
		if(tmpDoe.length()==0) {
			JOptionPane.showMessageDialog(MainFrame.this, "입사일을 입력해주십시오.");
			return result;
		}
		vo.setEmpDoe(tmpDoe);
		 result = true;
		return result;
	}
	
	private void clearTF() {
		tf_empNo.setText("");
		tf_empName.setText("");
		tf_empDept.setText("");
		tf_empPos.setText("");
		tf_empDoe.setText("");

	}
	
	
	public MainFrame() {
		

		l_empNo = new JLabel("사번: ");
		l_empName = new JLabel("이름: ");
		l_empDept = new JLabel("부서: ");
		l_empPos = new JLabel("직책: ");
		l_empDoe = new JLabel("입사일: ");
		
		
		tf_empNo = new JTextField(10);
		tf_empName = new JTextField(10);
		tf_empDept = new JTextField(10);
		tf_empPos = new JTextField(10);
		tf_empDoe = new JTextField(10);
		
		
		
		p_empNo = new JPanel();
		p_empName = new JPanel();
		p_empDept = new JPanel();
		p_empPos = new JPanel();
		p_empDoe = new JPanel();
		

		p_empNo.add(l_empNo,BorderLayout.WEST);
		p_empNo.add(tf_empNo);
		
		p_empName.add(l_empName,BorderLayout.WEST);
		p_empName.add(tf_empName);
		
		p_empDept.add(l_empDept,BorderLayout.WEST);
		p_empDept.add(tf_empDept);

		p_empPos.add(l_empPos,BorderLayout.WEST);
		p_empPos.add(tf_empPos);
		
		p_empDoe.add(l_empDoe,BorderLayout.WEST);
		p_empDoe.add(tf_empDoe);
		
		
		
		gridP = new JPanel(new GridLayout(8,1));
		
		gridP.add(new JPanel());
		gridP.add(p_empNo);
		gridP.add(p_empName);
		gridP.add(p_empDept);
		gridP.add(p_empPos);
		gridP.add(p_empDoe);
		gridP.add(new JPanel());
		
		btn_All = new JButton("전체");
		btn_Add = new JButton("추가");
		btn_Del = new JButton("삭제");
		btn_Sch = new JButton("검색");
		btn_Esc = new JButton("종료");
		
		
		flowP = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		flowP.add(btn_All);
		flowP.add(btn_Add);
		flowP.add(btn_Del);
		flowP.add(btn_Sch);
		flowP.add(btn_Esc);
		
		getList();
		printList();
		
		
		this.add(gridP, BorderLayout.WEST);
		this.add(flowP,BorderLayout.SOUTH);
		this.add(textArea);
		
		
		this.setBounds(150, 150, 600, 400);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		btn_All.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				printList();
			}
		});
		

		btn_Add.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EmpVO vo = new EmpVO();
				boolean valid = initVO(vo);
				if(valid) {
					list.add(vo);
					JOptionPane.showMessageDialog(MainFrame.this, "해당 정보가 추가되었습니다.");
					clearTF();
				}
				
			}
		});
		

		btn_Esc.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ObjectOutputStream oos = null;
				try {
					oos = new ObjectOutputStream(new FileOutputStream(f));
					oos.writeObject(list);
					oos.flush();
				} catch (Exception e2) {
					// TODO: handle exception
				} finally {
					try {
						if(oos != null) {
							oos.close();
						}
					} catch (Exception e3) {
						// TODO: handle exception
					}
				}
				System.exit(0);
			}
		});
		
		
	}
	
	
	
	public static void main(String[] args) {
		new MainFrame();

	}

}
