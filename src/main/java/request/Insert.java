package request;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import Forms.*;
import hibernate.*;

@Controller
public class Insert {

	@RequestMapping("/formInsertClient")
	public String setClient(Model model){
		model.addAttribute("formMapping",new ClienteForm());
		return "insertNewClient"; 
	}
	
	@RequestMapping(name="/saveClient", method = RequestMethod.POST)
	public String getDataClient(@Valid @ModelAttribute("formMapping") ClienteForm cliente, BindingResult validResult){
		if(validResult.hasErrors()) {
			return "insertNewClient";
		}
		CRUD connectionDB=new CRUD();
		connectionDB.startSession();
		connectionDB.insertClient(cliente);
		return "showClients";
	}
	
	@RequestMapping("/formInsertOrders")
	public String setOrder(Model model, @RequestParam("key")String key, HttpServletRequest request){
		request.setAttribute("key", key);
		model.addAttribute("formMapping",new PedidoForm());
		return "insertNewOrder";
	}
	
	@RequestMapping("/saveOrder")
	public String getDataOrder(@Valid @ModelAttribute("formMapping")PedidoForm pedido, BindingResult result, HttpServletRequest request){
		if(result.hasErrors()) {
			return "insertNewOrder";
		}
		CRUD connectionDB=new CRUD();
		connectionDB.startSession();
		connectionDB.insertOrder(pedido);
		request.setAttribute("key", connectionDB.getCliente(Integer.parseInt(pedido.getIdCliente())));
		return "showPedidos"; 
	}
}