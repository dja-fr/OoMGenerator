

import java.io.IOException;
import java.nio.ByteBuffer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
public class OutOfMemory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutOfMemory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memoryToalloc = 1024; //Megabytes
		
		String memoryParam = request.getParameter("memory");
		
		if(memoryParam != null && !"".equals(memoryParam)) {
			try {
				memoryToalloc = Integer.parseInt(memoryParam);
			}
			catch(Exception e) {
				System.err.println(e);
			}
			System.out.println("Allocate : "+memoryToalloc+" Mb");
			ByteBuffer[] bb = new ByteBuffer[10];
			for(int i = 0; i < 10; i++) {
				
				 bb[i] = ByteBuffer.allocate(memoryToalloc*1000*100);
				 System.out.println("Allocate["+i+"] : " + memoryToalloc/10 + " Mb");
			}
			
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
