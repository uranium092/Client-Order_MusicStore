package hibernate;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;
import Forms.*;

public class CRUD {
	
	private SessionFactory sessionFactory;
	private Session session;
	
	public CRUD() {
		sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).addAnnotatedClass(Pedido.class).buildSessionFactory();
	}
	
	public void startSession(){
		session=sessionFactory.openSession();
	}
	
	public List<Cliente> getAllClients(){
		return session.createQuery("from Cliente", Cliente.class).getResultList();
	}
	
	public void insertClient(ClienteForm client){
		session.save(new Cliente(client.getName(), client.getLastName(), client.getBand()));
		session.beginTransaction().commit();
	}
	
	public Cliente getCliente(int id){ //getCliente
		return session.get(Cliente.class, id);
	}
	
	public void insertOrder(PedidoForm order){
		session.beginTransaction();
		Cliente client=session.get(Cliente.class, Integer.parseInt(order.getIdCliente()));
		Pedido p=new Pedido(order.getArticulo(), order.getPrecio());
		client.addOrder(p);
		session.getTransaction().commit();
	}
	 
	public Pedido deleteOrder(int id){ 
		Pedido p=session.get(Pedido.class, id);
		session.delete(p); //eliminar
		session.beginTransaction().commit();
		return p;
	}
	
	public void deleteClient(int id){
		session.delete(session.get(Cliente.class, id));
		session.beginTransaction().commit();
	}
	
	public void updateClient(ClienteFormUpdate client){
		session.beginTransaction();
		Cliente cl=session.get(Cliente.class, Integer.parseInt(client.getId()));
		cl.setNombreCliente(client.getName());
		cl.setApellidoCliente(client.getLastName());
		cl.setBandaCliente(client.getBand());
		session.getTransaction().commit();
	}
	
	public Pedido getPedido(int id){
		return session.get(Pedido.class, id);
	}
	
	public Pedido updateOrder(PedidoFormUpdate order){
		session.beginTransaction();
		Pedido p=session.get(Pedido.class, Integer.parseInt(order.getIdPedido()));
		p.setArticuloCliente(order.getNombreArticulo());
		p.setPrecioArticulo(order.getPrecio());
		session.getTransaction().commit();
		return p;
	}
	
}