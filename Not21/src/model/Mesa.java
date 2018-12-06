package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Mesa implements Jogada {

	private Jogador jogador1;
	private Jogador jogador2;
	private Baralho baralho;
	private boolean partidaEmAndamento;

	private Jogador jogadorAtual;

	public Mesa() {		
		this.baralho = new Baralho();
		this.baralho.embaralhar();
		this.jogador1 = this.jogador2 = null;

	}

	public Jogador getJogador1() {
		return jogador1;
	}
	
	public Jogador getJogador2() {
		return jogador2;
	}
	
	public Jogador getJogador(String nome) {
		return jogador1.getNome().equals(nome) ? jogador1 : jogador2;
	}


	public void criaJogador1(String nome) {
		this.jogador1 = new Jogador(nome, 1);
		this.jogadorAtual = jogador1;
	}
	
	public void criaJogador2(String nome) {
		this.jogador2 = new Jogador(nome, 2);
	}
	
	
	
	

	public Baralho getBaralho() {
		return this.baralho;
	}
	
	//	teste para pegar carta do baralho
	public void getCartaDoBaralho(Jogador jogador) {
		Carta carta = getBaralho().getCartaTopo(); 
		jogador.mao.adicionaCarta(carta);
	}
	
	
	
	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}





//	public void distribuiCartas() {
//
//		for (Jogador j : this.jogadores) {
//			j.limparMao();
//			getCartaDoBaralho();
//			getCartaDoBaralho();
//			getCartaDoBaralho();
//			
//			passaIndependente();
//		}
//
//	}

	public void maximoCincoJogadas(Jogador jogador) {
		if (jogador.getnRodads() > 4) {
			jogador.setParado();
		}
	}
//	public Jogador passaIndependente() {
//		if (this.jogadorAtual == jogadores.get(0)) {
//			jogadorAtual = jogadores.get(1);
//			
//		}
//		else if (this.jogadorAtual == jogadores.get(1)) {
//			jogadorAtual = jogadores.get(0);
//		}
//		return jogadorAtual;
//	}
//	public Jogador getJogadorAtual() {
//		return this.jogadorAtual;
//	}
//	public Jogador setPrimeiroJogadorAtual() {
//		if (this.jogadorAtual == null)
//			this.jogadorAtual = jogadores.get(0);
//		return this.jogadorAtual;
//	}

//	public void avaliaVencedor(List<Jogador> jogadores) {
//		int j1 = jogadores.get(0).distanciaMult();
//		int j2 = jogadores.get(1).distanciaMult();
//
//		if (j1 != 0 && j2 != 0) {
//
//			if (j1 < j2) {
//				setVencedor(jogadores.get(0));
//				JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogadores.get(0).getNome()));
//			} else if (j1 == j2) {
//				if (jogadores.get(0).getValorDaMao() > jogadores.get(1).getValorDaMao()) {
//					setVencedor(jogadores.get(0));
//					JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogadores.get(0).getNome()));
//				} else {
//					setVencedor(jogadores.get(1));
//					JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogadores.get(1).getNome()));
//				}
//			} else {
//				setVencedor(jogadores.get(1));
//				JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogadores.get(1).getNome()));
//			}
//
//		} else if (j1 == 0 && j2 != 0) {
//			setVencedor(jogadores.get(1));
//			JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogadores.get(1).getNome()));
//		} else if (j1 != 0 && j2 == 0) {
//			setVencedor(jogadores.get(0));
//			JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogadores.get(0).getNome()));
//
//		} else {
//			JOptionPane.showMessageDialog(null, "Algo deu errado");
//		}
//	}

//	public boolean condicaoVitoria() {
//		int pJ1 = jogadores.get(0).getPediu();
//		boolean j1Parado = jogadores.get(0).isParado();
//		int pJ2 = jogadores.get(1).getPediu();
//		boolean j2Parado = jogadores.get(1).isParado();
//		if (pJ1 >= 5 && pJ2 >= 5 || pJ1 >= 5 && j2Parado == true || j1Parado == true && pJ2 >= 5
//				|| j1Parado == true && j2Parado == true) {
//			avaliaVencedor(jogadores);
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	public int getNumeroJogadoresAtivos() {
//		int cont = 0;
//		for (Jogador player : jogadores) {
//			if (!player.isParado())
//				cont++;
//		}
//		return cont;
//	}
//
//	public void setTodosJogadoresAtivos() {
//
//		for (Jogador j : this.jogadores) {
//			j.setAtivo();
//		}
//	}
//
//	public void limpaJogadores() {
//		this.jogadores.clear();
//	}

//	public String mostraGanhador() {
//		return getVencedor().getNome();
//	}

	public void setEmAndamento(boolean b) {
		// TODO Auto-generated method stub

	}
	
	/*public void passaVez(Jogador jogador) {
		if (jogadores.get(0) == jogador) {
			jogadorAtual = jogadores.get(1);
		}
		else if (jogadores.get(1) == jogador) {
			jogadorAtual = jogadores.get(0);
		}
	}*/
	
//	public Carta[] getMaoj1() {
//		Carta[] maoJ1= new Carta[3];
//		jogadores.get(0).mao.getManeta();
//		return maoJ1;
//	}
//	
//	public Carta[] getMaoj2() {
//		Carta[] maoJ1= new Carta[3];
//		jogadores.get(1).mao.getManeta();
//		return maoJ1;
//	}
}
