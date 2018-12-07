package model;

import java.io.Serializable;
import java.util.List;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Jogador implements Jogada {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8368929923312617274L;

	protected String nome;

	protected int numero;

	protected Mao mao;

	protected int nRodads;

	protected int pediu;

	protected boolean parado = false;

	protected boolean comeca = false;

	public int getnRodads() {
		return nRodads;
	}

	public void setnRodads(int nRodads) {
		this.nRodads = nRodads;
	}

	public Jogador(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
		this.mao = new Mao();
		this.nRodads = 0;
		this.pediu = 0;
	}

	public Carta[] getMan() {
		return mao.getManeta();
	}

	public void limparMao() {
		this.mao.limpar();
	}

	public String toString() {
		return String.format("Jogador %s", this.nome);
	}

	public void setParado() {
		this.parado = true;
	}

	public void setAtivo() {
		this.parado = false;
	}

	public boolean isParado() {
		return this.parado;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public void addNRodads() {
		int nRodads = getnRodads();
		nRodads++;
		setnRodads(nRodads);
	}

	public int distanciaMult() {

		int pontos = this.getValorDaMao();
		int aux = pontos % 21;
		int temp = pontos % 21;
		int result =0;
		aux = 21-aux;
		
		if (pontos > 21) {
			if (aux != 0) {
				if (aux < temp) {
					result= aux;
				} else {
					result= temp;
				}
			} else {
				result= 0;
			}
		} else {
			result = aux;
		}
		if (result == 21) return 0;
		return result;
	}

	public void jogadorPediu() {
		pediu++;
		if (pediu > 4) {
			setParado();
		}

	}

	public int getPediu() {
		return pediu;
	}

	public int getValorDaMao() {
		int i = 0;
		int diminui = 0;
		int soma = 0;
		int valor = 0;
		for (Carta carta : this.mao.getCartas()) {
			i++;
			if (i % 3 == 0) {
				diminui = diminui + carta.getValor();
				System.out.println("uma carta para diminuir");
			} else {
				soma = soma + carta.getValor();
				System.out.println("uma carta para somar");
			}

		}
		valor = soma - diminui;
		if (valor < 0) {
			valor = 0;
		}

		return valor;
	}

}
