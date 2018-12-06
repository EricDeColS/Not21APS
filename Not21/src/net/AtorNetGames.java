package net;

import java.util.List;

import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import controller.Not21Control;
import model.JogadaN21;
import view.InterfaceNot21;

public class AtorNetGames implements OuvidorProxy {
	
	private Proxy proxy;	
	private Not21Control control;
	
	public AtorNetGames(Not21Control control) {
		super();
		this.control = control;
		proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
	}
	

	public void conectar(String nome) {
		try {
			proxy.conectar("localhost", nome);
		} catch (JahConectadoException e) {
			JOptionPane.showMessageDialog(control.getInterface(), e.getMessage());
			e.printStackTrace();
		} catch (NaoPossivelConectarException e) {
			JOptionPane.showMessageDialog(control.getInterface(), e.getMessage());
			e.printStackTrace();
		} catch (ArquivoMultiplayerException e) {
			JOptionPane.showMessageDialog(control.getInterface(), e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void iniciarPartidaRede() {
		try {
			proxy.iniciarPartida(2);
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(control.getInterface(), e.getMessage());
			e.printStackTrace();
		}

	}
	
	@Override
	public void iniciarNovaPartida(Integer posicao) {
		control.iniciarNovaPartida(posicao == 1);
	}	
	
	
	public void enviarJogada(Estado estado){		
		try {
			proxy.enviaJogada(estado);
			JOptionPane.showMessageDialog(control.getInterface(), "Jogada Enviada!");
			
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(control.getInterface(), "ERRO: " + e.getMessage());
			e.printStackTrace();
		}
		
//		if(jogada instanceof JogadaN21){
//			JogadaN21 jbj = (JogadaN21)jogada;
//			if(jbj.equals(JogadaN21.PARAR)){
//				JOptionPane.showMessageDialog(null, "Jogada Enviada!");
//				this.control.habilitaDesabilitaBotoes();
//			}
//			if(jbj.equals(JogadaN21.PEDIR)){
//				JOptionPane.showMessageDialog(null, "Jogada Enviada!");
//				this.control.habilitaDesabilitaBotoes();
//			}
//		}
	}
	
//	public void enviarJogada(String mensagem) {
//		
//		Mensagem msg = new Mensagem(mensagem);
//		try {
//			proxy.enviaJogada(msg);
//			ehMinhaVez = false;
//			JOptionPane.showMessageDialog(null, "Jogada Enviada!");
//		} catch (NaoJogandoException e) {
//			JOptionPane.showMessageDialog(atorJogador, e.getMessage());
//			e.printStackTrace();
//		}
//	}
	


	@Override
	public void receberJogada(Jogada jogada) {
		Estado estado = (Estado)jogada;
		control.receberJogada(estado);
		
//		if(jogada instanceof Estado){
//			Estado estado = (Estado)jogada;
//			this.control.setMesa(estado.getMesa());
//			this.control.sincronizaMesa();
//		}else if(jogada instanceof JogadaN21){
//			JogadaN21 jog = (JogadaN21)jogada;
//			this.control.procederJogada(jog);
//			if(jog.equals(JogadaN21.PARAR)){
//				if(nickJogador.equals(this.control.getMesa().getJogadorAtual().getNome())){
//					
//					ehMinhaVez = false;
//					JOptionPane.showMessageDialog(null, "Jogada Recebida!");
//				}
//				if(jog.equals(JogadaN21.PEDIR)){
//					
//					ehMinhaVez = true;
//					JOptionPane.showMessageDialog(null, "Jogada Recebida!");
//					
//				}	
//				
//			}
//		}else if(jogada instanceof Mensagem){
//			Mensagem msg = (Mensagem)jogada;
//			this.control.mostraMensagem(msg.getMensagem());
//		}
		
	}
	
	public void desconectar() {
		try {
	        if (JOptionPane.showConfirmDialog(null, "Deseja desconectar da partida?") == JOptionPane.YES_OPTION) {
	        	proxy.desconectar();
	        }			
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(control.getInterface(), e.getMessage());
			e.printStackTrace();
		}
	}
	
    public String obterNomeAdversario(String idUsuario) {
		String aux1 = proxy.obterNomeAdversario(1);
		return aux1.equals(idUsuario) ? proxy.obterNomeAdversario(2) : aux1;
    }
	

	@Override
	public void finalizarPartidaComErro(String message) {
		JOptionPane.showMessageDialog(control.getInterface(), message);

	}

	@Override
	public void receberMensagem(String msg) {}


	@Override
	public void tratarConexaoPerdida() {
		JOptionPane.showMessageDialog(control.getInterface(), "A conex�o com o servidor foi perdida!");

	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		JOptionPane.showMessageDialog(control.getInterface(), "N�o foi poss�vel iniciar a partida");

	}
	
//	public String obterNomeAdversario() {
//		return proxy.obterNomeAdversario(2);
//	}
//
//	public boolean ehMinhaVez() {
//		return ehMinhaVez;
//	}
//
//	public void enviaMensagem(String msg) {
//		Mensagem mensagem = new Mensagem(nickJogador+" diz: "+msg);
//		enviarJogada(mensagem);
//	}
//	
//	public void sincronizaMesa(){
//		if(ehMinhaVez){
//			Estado estado = new Estado(control.getMesa());
//			try {
//				proxy.enviaJogada(estado);
//			} catch (NaoJogandoException e) {
//				JOptionPane.showMessageDialog(control.getInterface(), e.getMessage());
//				e.printStackTrace();
//			}
//		}
//	}
}
