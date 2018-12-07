package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Not21Control;
import model.Carta;

public class InterfaceNot21 extends JFrame {


	public InterfaceNot21(Not21Control control) {
		initComponents();
		
		lbConectar.addMouseListener(new ConexaoListener(control));
		lbDesconectar.addMouseListener(new DesconexaoListener(control));
		lbReiniciar.addMouseListener(new ReiniciarListener(control));
		lbIiciar.addMouseListener(new NovoJogoListener(control));
	}
	
    public class ConexaoListener implements MouseListener {
        private Not21Control control;
        
        public ConexaoListener(Not21Control control) {
            this.control = control;
        }

		@Override
		public void mouseClicked(MouseEvent arg0) {
	    	control.conectar();			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
    }
    
    public class DesconexaoListener implements MouseListener {
    	private Not21Control control;
        
        public DesconexaoListener(Not21Control control) {
            this.control = control;
        }

		@Override
		public void mouseClicked(MouseEvent arg0) {	
	    	control.desconectar();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
    }
    
    public class NovoJogoListener implements MouseListener {
    	private Not21Control control;
        
        public NovoJogoListener(Not21Control control) {
            this.control = control;
        }

		public void mouseClicked(MouseEvent arg0) {	
	       	control.iniciarPartida();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
     }
    
    public class ReiniciarListener implements MouseListener {
    	private Not21Control control;
        
        public ReiniciarListener(Not21Control control) {
            this.control = control;
        }
        
		public void mouseClicked(MouseEvent arg0) {	
	    	control.reiniciar();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
    }
	
	//private CardLayout thisLayout;
	private JPanel contentPane;
	private JLabel lblC1J1;
	private JLabel lblC2J1;
	private JLabel lblC3J1;
	private JLabel lblC1J2;
	private JLabel lblC2J2;
	private JLabel lblC3J2;
	private JLabel lblJogador;
	private JLabel lblJogador_1;
	private JLabel lbReiniciar;
	private JLabel lbDesconectar;
	private JLabel lbConectar;
	private JLabel lbIiciar;
	private JButton btnRegas;
	private JButton btnNovaMao;
	private JButton btnParar;
	private JLabel lblValorDaMo; 
	private JLabel lblDistanciaDoMultiplo;
	private JLabel lblValMaoJ1; //valor da mão de jogador 1
	private JLabel lblValMaoJ2; //valor da mão do jogador 2
	private JLabel distMultiJ2; //distancia do multiplo do jogador 2
	private JLabel distMultiJ1; //distancia do multiplo do jogador 1
	
	
	private void initComponents() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 25, 1118, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 100, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbReiniciar = new JLabel("Reiniciar");	
		lbReiniciar.setHorizontalAlignment(SwingConstants.CENTER);
		lbReiniciar.setForeground(Color.WHITE);
		lbReiniciar.setFont(new Font("Agency FB", Font.PLAIN, 15));
		lbReiniciar.setBounds(559, 555, 63, 84);
		contentPane.add(lbReiniciar);

		lbDesconectar = new JLabel("Desconectar");		
		lbDesconectar.setHorizontalAlignment(SwingConstants.CENTER);
		lbDesconectar.setForeground(Color.WHITE);
		lbDesconectar.setFont(new Font("Agency FB", Font.PLAIN, 12));
		lbDesconectar.setBounds(648, 541, 74, 98);
		contentPane.add(lbDesconectar);

		lbConectar = new JLabel("Conectar");
		lbConectar.setHorizontalAlignment(SwingConstants.CENTER);
		lbConectar.setForeground(Color.WHITE);
		lbConectar.setFont(new Font("Agency FB", Font.PLAIN, 15));
		lbConectar.setBounds(391, 555, 74, 84);
		contentPane.add(lbConectar);

		lbIiciar = new JLabel("    Iniciar");		
		lbIiciar.setForeground(Color.WHITE);
		lbIiciar.setFont(new Font("Agency FB", Font.PLAIN, 15));
		lbIiciar.setBounds(475, 551, 74, 92);
		contentPane.add(lbIiciar);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.BLACK);

		label.setBounds(549, 541, 183, 109);
		contentPane.add(label);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 139, 34));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 431, 360);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnC = new JButton("C1");
		btnC.setEnabled(false);
		btnC.setBorder(null);
		btnC.setBounds(10, 93, 114, 24);
		panel.add(btnC);
		btnC.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnC.setBackground(Color.WHITE);

		JButton btnC_1 = new JButton("C2");
		btnC_1.setEnabled(false);
		btnC_1.setBorder(null);
		btnC_1.setBounds(152, 93, 114, 23);
		panel.add(btnC_1);
		btnC_1.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnC_1.setBackground(Color.WHITE);

		JButton btnCounter = new JButton("COUNTER");
		btnCounter.setEnabled(false);
		btnCounter.setBorder(null);
		btnCounter.setBounds(295, 93, 114, 23);
		panel.add(btnCounter);
		btnCounter.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnCounter.setBackground(Color.WHITE);

		lblC3J1 = new JLabel("");
		lblC3J1.setBounds(295, 117, 114, 156);
		panel.add(lblC3J1);

		lblJogador = new JLabel("Jogador 1");
		lblJogador.setBounds(10, 11, 114, 56);
		panel.add(lblJogador);
		lblJogador.setForeground(Color.WHITE);
		lblJogador.setFont(new Font("Agency FB", Font.PLAIN, 20));

		lblC2J1 = new JLabel("");
		lblC2J1.setBounds(152, 117, 114, 156);
		panel.add(lblC2J1);

		lblC1J1 = new JLabel("");
		lblC1J1.setBounds(10, 117, 114, 156);
		panel.add(lblC1J1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(34, 139, 34));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(660, 11, 431, 360);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblJogador_1 = new JLabel("Jogador 2");
		lblJogador_1.setBounds(295, 11, 115, 46);
		panel_1.add(lblJogador_1);
		lblJogador_1.setForeground(Color.WHITE);
		lblJogador_1.setFont(new Font("Agency FB", Font.PLAIN, 20));

		JButton btnCounter_1 = new JButton("COUNTER");
		btnCounter_1.setEnabled(false);
		btnCounter_1.setBorder(null);
		btnCounter_1.setBounds(295, 91, 114, 23);
		panel_1.add(btnCounter_1);
		btnCounter_1.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnCounter_1.setBackground(Color.WHITE);

		JButton button_1 = new JButton("C2");
		button_1.setEnabled(false);
		button_1.setBorder(null);
		button_1.setBounds(152, 91, 114, 23);
		panel_1.add(button_1);
		button_1.setFont(new Font("Agency FB", Font.PLAIN, 18));
		button_1.setBackground(Color.WHITE);

		JButton button = new JButton("C1");
		button.setEnabled(false);
		button.setBorder(null);
		button.setBounds(10, 91, 114, 24);
		panel_1.add(button);
		button.setFont(new Font("Agency FB", Font.PLAIN, 18));
		button.setBackground(Color.WHITE);

		lblC1J2 = new JLabel("");
		lblC1J2.setBounds(10, 115, 114, 156);
		panel_1.add(lblC1J2);

		lblC2J2 = new JLabel("");
		lblC2J2.setBounds(152, 115, 114, 156);
		panel_1.add(lblC2J2);

		lblC3J2 = new JLabel("");
		lblC3J2.setBounds(295, 115, 114, 156);
		panel_1.add(lblC3J2);

		JLabel label_1 = new JLabel("");

		label_1.setForeground(Color.BLACK);
		label_1.setBounds(383, 541, 183, 109);
		contentPane.add(label_1);

		JLabel lblDeckJogador = new JLabel("");
		lblDeckJogador.setBounds(451, 11, 199, 290);
		contentPane.add(lblDeckJogador);

		
		
		/**** PEDE NOVA MAO ****/
		
		
		btnNovaMao = new JButton("Nova M\u00E3o");
		btnNovaMao.setBorder(null);
		btnNovaMao.setBounds(451, 312, 199, 23);
		contentPane.add(btnNovaMao);
		btnNovaMao.setBackground(SystemColor.text);
		btnNovaMao.setFont(new Font("Agency FB", Font.PLAIN, 18));

		
		
		/**** PARA DE JOGAR ****/
		
		
		
		btnParar = new JButton("Parar");
		btnParar.setBorder(null);
		btnParar.setBounds(451, 348, 199, 23);
		contentPane.add(btnParar);
		btnParar.setBackground(SystemColor.text);
		btnParar.setFont(new Font("Agency FB", Font.PLAIN, 18));

		lblValorDaMo = new JLabel("Valor da M\u00E3o");
		lblValorDaMo.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblValorDaMo.setForeground(Color.WHITE);
		lblValorDaMo.setBounds(10, 382, 113, 40);
		contentPane.add(lblValorDaMo);

		lblDistanciaDoMultiplo = new JLabel("Distancia do Multiplo");
		lblDistanciaDoMultiplo.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblDistanciaDoMultiplo.setForeground(Color.WHITE);
		lblDistanciaDoMultiplo.setBounds(10, 416, 157, 40);
		contentPane.add(lblDistanciaDoMultiplo);

		JLabel label_2 = new JLabel("Valor da M\u00E3o");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Agency FB", Font.PLAIN, 22));
		label_2.setBounds(898, 394, 113, 40);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Distancia do Multiplo");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Agency FB", Font.PLAIN, 22));
		label_3.setBounds(898, 428, 171, 40);
		contentPane.add(label_3);

		lblValMaoJ1 = new JLabel("");
		lblValMaoJ1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblValMaoJ1.setForeground(Color.WHITE);
		lblValMaoJ1.setBounds(117, 394, 46, 23);
		contentPane.add(lblValMaoJ1);

		lblValMaoJ2 = new JLabel("");
		lblValMaoJ2.setForeground(Color.WHITE);
		lblValMaoJ2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblValMaoJ2.setBounds(1009, 404, 46, 23);
		contentPane.add(lblValMaoJ2);

		distMultiJ2 = new JLabel("");
		distMultiJ2.setForeground(Color.WHITE);
		distMultiJ2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		distMultiJ2.setBounds(1057, 441, 46, 23);
		contentPane.add(distMultiJ2);

		distMultiJ1 = new JLabel("");
		distMultiJ1.setForeground(Color.WHITE);
		distMultiJ1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		distMultiJ1.setBounds(160, 428, 46, 23);
		contentPane.add(distMultiJ1);

		lblC1J1.setIcon(new ImageIcon("imagens/Default.jpg"));
		lblC2J1.setIcon(new ImageIcon("imagens/Default.jpg"));
		lblC3J1.setIcon(new ImageIcon("imagens/Default.jpg"));
		lblC1J2.setIcon(new ImageIcon("imagens/Default.jpg"));
		lblC2J2.setIcon(new ImageIcon("imagens/Default.jpg"));
		lblC3J2.setIcon(new ImageIcon("imagens/Default.jpg"));
		lblDeckJogador.setIcon(new ImageIcon("imagens/DefaultM.jpg"));

		label.setIcon(new ImageIcon("imagens/principal1.png"));
		label_1.setIcon(new ImageIcon("imagens/principal.png"));

		btnRegas = new JButton("Regas");
		btnRegas.setBorder(null);
		btnRegas.setForeground(Color.WHITE);
		btnRegas.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnRegas.setBackground(new Color(34, 139, 34));
		btnRegas.setBounds(10, 602, 74, 48);
		contentPane.add(btnRegas);
		
	}

	public void setNomeJogador1(String nome) {
		lblJogador.setText("Jogador " + nome);
	}

	public void setNomeJogador2(String nome) {
		lblJogador_1.setText("Jogador " + nome);
	}
	
	public void setValorMaoJ1(int valor) {
		lblValMaoJ1.setText(valor+"");
	}
	public void setValorMaoJ2(int valor) {
		lblValMaoJ2.setText(valor+"");
	}
	
	public void setDistMultiploJ1(int valor) {
		distMultiJ1.setText(valor+"");
	}
	public void setDistMultiploJ2(int valor) {
		distMultiJ2.setText(valor+"");
	}
	
	public void setMaoJ1Panel(String[] mao) {
		String[] temp = mao;
		
		lblC1J1.setIcon(new ImageIcon("imagens/"+temp[0]+".jpg"));
		lblC2J1.setIcon(new ImageIcon("imagens/"+temp[1]+".jpg"));
		lblC3J1.setIcon(new ImageIcon("imagens/"+temp[2]+".jpg"));
		repaint();
	}
	public void setMaoJ2Panel(String[] cartas) {
		String[] temp = cartas;
		lblC1J2.setIcon(new ImageIcon("imagens/"+temp[0]+".jpg"));
		lblC2J2.setIcon(new ImageIcon("imagens/"+temp[1]+".jpg"));
		lblC3J2.setIcon(new ImageIcon("imagens/"+temp[2]+".jpg"));
		repaint();
	}
	
//	public void habilitaDesabilitaBotoes() {
//		boolean minhaVez = this.controle.ehMinhaVez();
//		btnNovaMao.setEnabled(minhaVez);
//		btnParar.setEnabled(minhaVez);
//	}
//


//	public void sincronizaMesa(Mesa mesa) {
//		contentPane.removeAll();
//		thisLayout.show(getContentPane(), PAINEL_JOGO);
//		for (Jogador jogador : mesa.getJogadores()) {
//			criar(jogador);
//		}
//		contentPane.repaint();
//		System.gc();
//		habilitaDesabilitaBotoes();
//		
//	}
//


	public void mostraRegras() {

		String regras = ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::Not 21:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
				+ "� um jogo de cartas onde vencedor � definido quando aquele de entre\n"
				+ "2 jogadores,mais se aproximarem de um m�ltiplo de 21 sem atingir o\n"
				+ "n�mero e em at� 5 compras de cartas.\n"
				+ "Um baralho de 4 naipes contendo 52 cartas, tendo cada carta do naipe\n"
				+ "um valor de 1 a 13 � embaralhado e 3 cartas s�o distribu�das para cada\n"
				+ "jogador. As duas primeiras cartas sacadas somar�o seus valores,\n"
				+ "enquanto a terceira diminuir� seu valor. Se o valor resultante desta\n"
				+ "equa��o for satisfat�rio o jogador poder� n�o efetuar mais saques mas\n"
				+ "seu oponente sim, respeitando o limite m�ximo de 5 saques. Quando todos\n"
				+ "os jogadores param � determinado um vencedor\n"
				+ "No caso de um empate o resultado ser� decidido verificando quem possui\n" + "a m�o de maior valor.";
	}

}
