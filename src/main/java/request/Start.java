package request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Start {
	@RequestMapping
	public String getStart() {
		return "showClients";
	}	
}