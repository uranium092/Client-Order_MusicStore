package request;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Forms.*;
import hibernate.*;

@Controller
public class Update {
	
	@RequestMapping("/formUpdateClient")
	public String updateClient(Model model, @RequestParam("key")String keyClient){
		model.addAttribute("formMapping",new ClienteFormUpdate());
		CRUD connectionDB=new CRUD();
		connectionDB.startSession();
		model.addAttribute("dataClient",connectionDB.getCliente(Integer.parseInt(keyClient)));
		model.addAttribute("dataClientView",connectionDB.getCliente(Integer.parseInt(keyClient)));
		return "updateClient"; 
	} 
	
	@RequestMapping("/updC")
	public String getDataClient(@Valid @ModelAttribute("formMapping") ClienteFormUpdate client, BindingResult result, Model model){
		CRUD connectionDB =new CRUD();
		connectionDB.startSession();
		if(result.hasErrors()) {
			model.addAttribute("dataClientView",connectionDB.getCliente(Integer.parseInt(client.getId()))); //Exception
			return "updateClient";
		}
		connectionDB.updateClient(client);
		return "showClients"; 
	}
	
	@RequestMapping("/formUpdateOrder")
	public String updateOrder(@RequestParam("key")String keyOrder, Model model){
		model.addAttribute("formMapping", new PedidoFormUpdate());
		CRUD connectionDB=new CRUD();
		connectionDB.startSession();
		model.addAttribute("dataOrder",connectionDB.getPedido(Integer.parseInt(keyOrder)));
		model.addAttribute("dataOrderView", connectionDB.getPedido(Integer.parseInt(keyOrder)));
		return "formUpdateOrder";
	}
	
	@RequestMapping("/updP")
	public String getDataOrder(@Valid @ModelAttribute("formMapping") PedidoFormUpdate order, BindingResult result, Model model){
		CRUD connectionDB=new CRUD();
		connectionDB.startSession();
		if(result.hasErrors()) {
			model.addAttribute("dataOrderView", connectionDB.getPedido(Integer.parseInt(order.getIdPedido())));
			return "formUpdateOrder";
		}
		Pedido pedidoActualizado=connectionDB.updateOrder(order);
		Cliente client=pedidoActualizado.getClientePedido();
		model.addAttribute("key",client);
		return "showPedidos";
	}
}
