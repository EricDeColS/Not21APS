package controller;

import java.awt.Component;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Carta;
import model.JogadaN21;
import model.Jogador;
import model.Mesa;
import net.AtorNetGames;
import net.Estado;
import view.InterfaceNot21;

public class Not21Control {
	
	private String idJogador;
	private Mesa mesa;
	private AtorNetGames atorRede;
	private InterfaceNot21 interfaceNot21;

	public Not21Control() {

		this.atorRede = new AtorNetGames(this);
		this.mesa = new Mesa();
	}
	
	public InterfaceNot21 getInterface() {
		return interfaceNot21;
	}
	
	public void iniciarNovaPartida(boolean comecoJogando) {
		String nomeAdversario = atorRede.obterNomeAdversario(idJogador);
		
		if (comecoJogando) {
			mesa.criaJogador1(idJogador);
			mesa.criaJogador2(nomeAdversario);
			
			interfaceNot21.setNomeJogador1(idJogador);
			interfaceNot21.setNomeJogador2(nomeAdversario);
			
			JOptionPane.showMessageDialog(interfaceNot21, "Voc� come�a jogando.");
		} else {
			mesa.criaJogador1(nomeAdversario);
			mesa.criaJogador2(idJogador);
			
			interfaceNot21.setNomeJogador1(nomeAdversario);
			interfaceNot21.setNomeJogador2(idJogador);
			
			JOptionPane.showMessageDialog(interfaceNot21, "O advers�rio come�a jogando.");
		}
		
		mesa.setEmAndamento(true);		
	}
	
	public void receberJogada(Estado estado) {
		System.out.println("Recebendo jogada");		
	}
	
	public static void main(String[] args) {
		new Not21Control().go();
	}
	
    private void go() {
		this.interfaceNot21 = new InterfaceNot21(this);
		this.idJogador = JOptionPane.showInputDialog(interfaceNot21, "Escolha o nome do participante:");
		
		interfaceNot21.setVisible(true);
	}
    
	public void conectar() {
		atorRede.conectar(idJogador);	
		JOptionPane.showMessageDialog(interfaceNot21, "Voc� est� conectado");
	}

	public void desconectar() {
		atorRede.desconectar();
	}

	public void iniciarPartida() {
		atorRede.iniciarPartidaRede();		
	}

	public void reiniciar() {
		// TODO Auto-generated method stub
		
	}

	public void sincronizaMesa(Mesa mesa) {
		
		
	}

	public void atualizaMaoJ1() {
		Carta[] aux =  mesa.getJogador1().getMan();
		String[] mao = new String[3];
		mao[0]=aux[0].toString();
		mao[1]=aux[1].toString();
		mao[2]=aux[2].toString();
		
	interfaceNot21.setMaoJ1Panel(mao);
		
	}
	public void atualizaMaoJ2() {

		Carta[] aux =  mesa.getJogador2().getMan();
		String[] mao = new String[3];
		mao[0]=aux[0].toString();
		mao[1]=aux[1].toString();
		mao[2]=aux[2].toString();
		
		interfaceNot21.setMaoJ2Panel(mao);
			
		}

	public void atualizaPontosJ1() {
		interfaceNot21.setValorMaoJ1(mesa.getJogador1().getValorDaMao());
		interfaceNot21.setDistMultiploJ1(mesa.getJogador1().distanciaMult());
	}
	
	public void atualizaPontosJ2() {
		interfaceNot21.setValorMaoJ2(mesa.getJogador2().getValorDaMao());
		interfaceNot21.setDistMultiploJ2(mesa.getJogador2().distanciaMult());
	}
	
	
	
	
	
	public void sair() {
		System.exit(0);
	}







}
