package request;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import hibernate.*;

@Controller
public class ShowPedidos {
	
	@RequestMapping("/showPedidos")
	public String getPedidos(@RequestParam("key")String keyParam, HttpServletRequest request) {
		CRUD connectionDB=new CRUD();
		connectionDB.startSession();
		request.setAttribute("key", connectionDB.getCliente(Integer.parseInt(keyParam)));
		return "showPedidos";
	}
	
}