package net;

import br.ufsc.inf.leobr.cliente.Jogada;
import model.Mesa;

public class Estado implements Jogada{

	
	private Mesa mesa;
	
	public Estado(Mesa mesa) {
		this.mesa = mesa;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	

}
