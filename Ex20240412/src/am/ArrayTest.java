package am;

import java.util.ArrayList;

import homework.EmpVO_Ans;

public class ArrayTest {

	public static void main(String[] args) {
		// 다차원 배열
		
		int[][] ar = new int[2][3];
		
		int[] a1 = new int[3];
		a1[0] = 100;
		a1[1] = 200;
		a1[2] = 300;
		
		int[] a2 = new int[3];
		a2[0] = 22;
		a2[1] = 23;
		a2[2] = 24;
		
		ar[0] = a1;
		ar[1] = a2;
		
		// 2차원 배열의 자원들 중 23을 얻어내기 위한 접근법은?
		System.out.println(ar[1][1]);
		
		// ArrayList를 배열화 시켜라 : 2차원 배열
		
		ArrayList<EmpVO_Ans> list = new ArrayList<EmpVO_Ans>();
		
		EmpVO_Ans vo1 = new EmpVO_Ans("100", "AAA", "사원", "개발1", "2024");
		EmpVO_Ans vo2 = new EmpVO_Ans("200", "BBB", "사원", "개발1", "2024");
		EmpVO_Ans vo3 = new EmpVO_Ans("300", "CCC", "사원", "개발1", "2024");
		
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
		
		System.out.println(ar2[1][2]);
		
	
		
		
	}

}
