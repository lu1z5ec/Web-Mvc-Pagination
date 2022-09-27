package cs.dit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MdeleteService implements MemberService {

	@Override
	public void execute(HttpServletRequest Request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Request.setCharacterEncoding("utf-8");
		String id = Request.getParameter("id");

		MemberDao dbPro = new MemberDao();
		dbPro.delete(id);
	}

}
