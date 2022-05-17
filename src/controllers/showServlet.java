package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;
import utill.DBUtil;

/**
 * Servlet implementation class showServlet
 */
@WebServlet(name = "ShowServlet", urlPatterns = { "/show" })
public class showServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public showServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Message m = em.find(Message.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("message",  m);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/messages/show.jsp");




        response.getWriter().append("Served at: ").append(request.getContextPath());
        rd.forward(request, response);
    }

}
