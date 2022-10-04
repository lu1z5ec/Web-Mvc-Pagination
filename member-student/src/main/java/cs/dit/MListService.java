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
		int p = 1, numOfRecords = 10;
		int count = dao.recordCount();
		
		String page = request.getParameter("p");
		if(page != null && !page.equals("")) {
			p = Integer.parseInt(page);
		}
		
		ArrayList<MemberDto> dtos = dao.list(p,numOfRecords);
		
		int startNum = p-((p-1)%5);
		int lastNum = (int)(Math.ceil((float)count/(float)numOfRecords));

		
		request.setAttribute("dtos",dtos);
		request.setAttribute("p",p);
		request.setAttribute("startNum",startNum);
		request.setAttribute("lastNum",lastNum);
	}

}