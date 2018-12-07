package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Mesa implements Jogada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5437858920975211579L;
	private Jogador jogador1;
	private Jogador jogador2;
	private Baralho baralho;
	private boolean partidaEmAndamento;
	private Jogador vencedor = null;

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
		for(int i=0; i<3; i++) {
		Carta carta = getBaralho().getCartaTopo(); 
		jogador.mao.adicionaCarta(carta);
		}
	}
	
	
	
	public void setBaralho(Baralho baralho) {
		this.baralho = baralho;
	}





	public void distribuiCartas() {

			getCartaDoBaralho(jogador1);
			getCartaDoBaralho(jogador2);
	}

	
	public void maximoCincoJogadas(Jogador jogador) {
		if (jogador.getnRodads() > 4) {
			jogador.setParado();
		}
	}
	public Jogador passaVez() {
		if (this.jogadorAtual == jogador1) {
			jogadorAtual = jogador2;
			
		}
		else if (this.jogadorAtual == jogador2) {
			jogadorAtual = jogador1;
		}
		return jogadorAtual;
	}
	public Jogador getJogadorAtual() {
		return this.jogadorAtual;
	}


	public void avaliaVencedor() {
		int j1 = jogador1.distanciaMult();
		int j2 = jogador2.distanciaMult();

		if (j1 != 0 && j2 != 0) {

			if (j1 < j2) {
				setVencedor(jogador1);
				JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogador1.getNome()));
			} else if (j1 == j2) {
				if (jogador1.getValorDaMao() > jogador2.getValorDaMao()) {
					setVencedor(jogador1);
					JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogador1.getNome()));
				} else {
					setVencedor(jogador2);
					JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogador2.getNome()));
				}
			} else {
				setVencedor(jogador2);
				JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogador2.getNome()));
			}

		} else if (j1 == 0 && j2 != 0) {
			setVencedor(jogador2);
			JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogador2.getNome()));
		} else if (j1 != 0 && j2 == 0) {
			setVencedor(jogador1);
			JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogador1.getNome()));

		} else {
			JOptionPane.showMessageDialog(null, "Algo deu errado");
		}
	}

	private void setVencedor(Jogador jogador) {
		this.vencedor = jogador;
	}

	private Jogador jogadorVencedor() {
		return this.vencedor;
	}
	
	
	public boolean condicaoVitoria() {
		int pJ1 = jogador1.getPediu();
		boolean j1Parado = jogador1.isParado();
		int pJ2 = jogador2.getPediu();
		boolean j2Parado = jogador2.isParado();
		
		if (pJ1 >= 5 && pJ2 >= 5 || pJ1 >= 5 && j2Parado == true || j1Parado == true && pJ2 >= 5
				|| j1Parado == true && j2Parado == true) {
			avaliaVencedor();
			return true;
		} else {
			return false;
		}
	}


	public String getNomeGanhador() {
		return jogadorVencedor().getNome();
	}

	public void setEmAndamento(boolean b) {
		partidaEmAndamento = b;
	}
	
//	public Jogador setPrimeiroJogadorAtual() {
//	if (this.jogadorAtual == null)
//		this.jogadorAtual = jogador1;
//	return this.jogadorAtual;
//}	
//	public Carta[] getMaoj1() {
//		Carta[] maoJ1= new Carta[3];
//		jogador1.mao.getManeta();
//		return maoJ1;
//	}
//	
//	public Carta[] getMaoj2() {
//		Carta[] maoJ1= new Carta[3];
//		jogador2.mao.getManeta();
//		return maoJ1;
//	}
//	public int getNumeroJogadoresAtivos() {
//	int cont = 0;
//	for (Jogador player : jogadores) {
//		if (!player.isParado())
//			cont++;
//	}
//	return cont;
//}
//
//public void setTodosJogadoresAtivos() {
//
//	for (Jogador j : this.jogadores) {
//		j.setAtivo();
//	}
//}
}
