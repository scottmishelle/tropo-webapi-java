package com.tropo.simple.ivr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voxeo.tropo.ActionResult;
import com.voxeo.tropo.Tropo;
import com.voxeo.tropo.TropoResult;

@WebServlet(name="Redirect Servlet", value="/redirect")
public class RedirectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Tropo tropo = new Tropo();
		TropoResult result = tropo.parse(req);
		ActionResult actionResult = result.getActions().get(0);
		Integer choice = Integer.parseInt(actionResult.getValue());
		
		switch(choice) {
			case 1: tropo.say("We are going to redirect you to 911 please keep the phone open");
					break;
			case 2: tropo.say("Please give as a rank 1 to 10 for pain level");
					break;
			case 3: tropo.say("Thank you. We are going to redirect you now to one of our emergencies agents");
					break;
			default:tropo.say("Loool we don't have any other service chemlaka!");
					break;
		}
		tropo.say("http://ccmixter.org/content/DoKashiteru/DoKashiteru_-_you_(na-na-na-na).mp3");
		tropo.hangup();
		
		tropo.render(resp);
	}
}

