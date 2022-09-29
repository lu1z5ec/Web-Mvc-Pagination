package cs.dit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String viewPage = null;
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf(".do"));
		
		
		//select
		if(com !=null && com.equals("list")) {
			MemberService service = new MListService();
			service.execute(request, response);
			viewPage = "/WEB-INF/view/list.jsp";
		}
		else if(com !=null && com.equals("index")) {
			viewPage = "/WEB-INF/view/index.jsp";
		}
		
		//insert
		else if(com !=null && com.equals("insertForm")) {
			viewPage = "/WEB-INF/view/insertForm.jsp";
		}
		else if(com !=null && com.equals("insert")) {
			MemberService service = new MinsertService();
			service.execute(request, response);
			viewPage = "list.do";
		}
		
		//update
		else if(com !=null && com.equals("updateForm")) {
			MemberService service = new MListService();
			service.execute(request, response);
			viewPage ="WEB-INF/view/updateForm.jsp";
		}
		else if(com !=null && com.equals("update")) {
			MemberService service = new MupdateService();
			service.execute(request, response);
			viewPage ="list.do";
		}
		
		
		//update
		else if(com !=null && com.equals("delete")) {
			MemberService service = new MListService();
			service.execute(request, response);
			viewPage ="WEB-INF/view/updateForm.jsp";
		}
		else if(com !=null && com.equals("deletePro")) {
			MemberService service = new MdeleteService();
			service.execute(request, response);
			viewPage ="list.do";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
		//delete
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
