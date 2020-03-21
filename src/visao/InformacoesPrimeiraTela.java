package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class InformacoesPrimeiraTela extends JPanel implements MouseListener {

	JLabel dificuldadeDoJogo = new JLabel();

	// https://www.javaprogressivo.net/2014/04/Tutorial-JCheckBox-Java-Como-Usar-Botoes-Checagem-CheckBox.html
	ButtonGroup botoes = new ButtonGroup();
	JRadioButton facil;
	JRadioButton medio;
	JRadioButton dificil;

	JButton botaoIniciar = new JButton(new ImageIcon(getClass().getResource("/visao/recursos/start.png")));
	
	// Observadores
	// https://pt.stackoverflow.com/questions/236123/o-que-%C3%A9-e-como-implementar-um-listener-em-java
	private final List<ObservadorTela1> observadores = new ArrayList<>();

		private void notificarObservadores() {
			for (ObservadorTela1 observador : observadores) {
				observador.notificar(this);
			}
		}

	public void adicionarObservador(ObservadorTela1 obs) {
		observadores.add(obs);
	}

	// Fim Observadores

	public InformacoesPrimeiraTela() {
		setLayout(new BorderLayout(10, 10));
		
		JLabel imgMissel = new JLabel();
		imgMissel.setIcon(new ImageIcon(getClass().getResource("/visao/recursos/m.png"))); //Imagem do bot�o do missel 
		
		JPanel titulo = new JPanel();
		titulo.setLayout(new BorderLayout());
		titulo.add(dificuldadeDoJogo, BorderLayout.NORTH);

		
		JPanel opcoes = new JPanel(new GridLayout(3,1));
		facil = new JRadioButton("Facil", false);
		medio = new JRadioButton("Medio", false);
		dificil = new JRadioButton("Dificil", false);
		botoes.add(facil);
		botoes.add(medio);
		botoes.add(dificil);
		
		facil.setFont(new Font("Impact",Font.PLAIN,15));
		medio.setFont(new Font("Impact",Font.PLAIN,15));
		dificil.setFont(new Font("Impact",Font.PLAIN,15));
		
		
		facil.setForeground(new Color(0,255,0));
		medio.setForeground(new Color(255,215,0));
		dificil.setForeground(new Color(255,0,0));
		
		opcoes.add(facil);
		opcoes.add(medio);
		opcoes.add(dificil);
		
		dificuldadeDoJogo.setText("Dificuldade do jogo:	");
		dificuldadeDoJogo.setFont(new Font("Impact",Font.PLAIN,20));
		dificuldadeDoJogo.setForeground(new Color(51,153,255));
		dificuldadeDoJogo.setHorizontalAlignment(SwingConstants.CENTER);
		
		botaoIniciar.addMouseListener(this);
		botaoIniciar.setContentAreaFilled(false);
		
		add(titulo, BorderLayout.NORTH);
		add(opcoes, BorderLayout.CENTER);
		add(botaoIniciar, BorderLayout.WEST);
		add(imgMissel, BorderLayout.AFTER_LINE_ENDS);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (facil.isSelected()) {
			new BatalhaNaval(80);
			notificarObservadores();
		}else if(medio.isSelected()) {
			new BatalhaNaval(50);
			notificarObservadores();
		}else if(dificil.isSelected()) {
			new BatalhaNaval(25);
			notificarObservadores();
		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

}
