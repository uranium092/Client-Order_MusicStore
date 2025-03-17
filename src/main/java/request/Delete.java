package request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hibernate.*;

@Controller
public class Delete {
	
	@RequestMapping("del")
	public String deleteOrder(@RequestParam("key")String keyOrder, Model model){
		CRUD connectionDB=new CRUD();
		connectionDB.startSession();	
		Pedido p=connectionDB.deleteOrder(Integer.parseInt(keyOrder));
		model.addAttribute("key", p.getClientePedido());
		return "showPedidos"; 
	}
	
	@RequestMapping("delC")
	public String deleteClient(@RequestParam("key")String keyClient){
		CRUD connectionDB=new CRUD();
		connectionDB.startSession();
		connectionDB.deleteClient(Integer.parseInt(keyClient));
		return "showClients"; 
	}
	
}