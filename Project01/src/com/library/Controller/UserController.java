package com.library.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.Model.UserDbUtil;
import com.library.Pojo.User;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDbUtil userDbUtil;

	public UserController() {
		super();
		userDbUtil = new UserDbUtil();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String getAction = request.getParameter("action");
		if (getAction == null) {
			getAllUser(request, response);
		} else {
			switch (getAction) {
			case "ADD":
				addUser(request, response);
				break;
			case "DELETE":
				deleteUser(request, response);
				break;
			case "LOAD":
				loadUser(request, response);
				break;
			case "UPDATE":
				updateUser(request, response);
				break;
			default:
				getAllUser(request, response);
			}
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		int userId = Integer.parseInt(request.getParameter("userId"));

		user.setUserId(userId);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);

		userDbUtil.updateUser(user);
		getAllUser(request, response);
	}

	private void loadUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		int userId = Integer.parseInt(request.getParameter("userId"));
		user = userDbUtil.getUserById(userId);
		request.setAttribute("UPDATE_USER", user);
		RequestDispatcher rd = request.getRequestDispatcher("/updateUser.jsp");
		rd.forward(request, response);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		userDbUtil.deleteUser(userId);
		getAllUser(request, response);
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");

		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		userDbUtil.adddUser(user);

		try {
			getAllUser(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void getAllUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> userList = userDbUtil.getAllUser();
		request.setAttribute("USERLIST", userList);
		RequestDispatcher rd = request.getRequestDispatcher("/userList.jsp");
		rd.forward(request, response);
	}
}
