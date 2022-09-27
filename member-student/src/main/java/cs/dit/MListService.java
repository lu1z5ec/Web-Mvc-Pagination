package cs.dit;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MListService implements MemberService {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		MemberDao dao = new MemberDao();
		
		ArrayList<MemberDto> dtos = dao.list();
		System.out.println(dtos.size());
		
		request.setAttribute("dtos",dtos);
	
	}
}
