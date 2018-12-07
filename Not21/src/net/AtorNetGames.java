package net;


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
			System.out.println("conectado");
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
			
			
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(control.getInterface(), "ERRO: " + e.getMessage());
			e.printStackTrace();
		}
	}	


	@Override
	public void receberJogada(Jogada jogada) {
		Estado estado = (Estado)jogada;
		control.receberJogada(estado);		
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
		JOptionPane.showMessageDialog(control.getInterface(), "A conexão com o servidor foi perdida!");

	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		JOptionPane.showMessageDialog(control.getInterface(), "Não foi possível iniciar a partida");

	}
}
