package visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.ObservadorTabuleiro;
import modelo.Tabuleiro;

@SuppressWarnings("serial")
public class Cena2 extends JPanel implements ObservadorTabuleiro {
	JLabel resultadoDoTiro = new JLabel("Resultado: ");
	JLabel bombasDisponiveis = new JLabel("Numero de bombas: ");

	public Cena2(Tabuleiro tabuleiro) {
		// setLayout(new GridLayout(1,0));

		tabuleiro.adicionarObservador(this);

		resultadoDoTiro.setFont(new Font("Tahoma", 1, 20));

		bombasDisponiveis.setFont(new Font("Tahoma", 1, 20));
		bombasDisponiveis.setForeground(new Color(255, 102, 144));

		add(bombasDisponiveis);
		add(resultadoDoTiro);

	}

	@Override
	public void notificarMisseis(Tabuleiro tabuleiro, int misseis, boolean statusTiro) {
		if (statusTiro) {
			resultadoDoTiro.setText("ACERTOU O TIRO!");
			resultadoDoTiro.setForeground(Color.green);
		} else {
			resultadoDoTiro.setText("ERROU O TIRO!");
			resultadoDoTiro.setForeground(Color.red);
		}

		bombasDisponiveis.setText("Numero de bombas: " + Integer.toString(misseis) + "   ");

	}

}