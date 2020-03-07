package modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {

	private boolean aberto = false;
	private boolean contemNavio = false;

	// Observadores
	// https://pt.stackoverflow.com/questions/236123/o-que-%C3%A9-e-como-implementar-um-listener-em-java
	private final List<ObservadorCampo> observadores = new ArrayList<>();

	private void notificarObservadores(boolean resultado) {
		for (ObservadorCampo observador : observadores) {
			observador.notificar(this, resultado);
		}
	}

	public void adicionarObservador(ObservadorCampo obs) {
		observadores.add(obs);
	}

	// Fim Observadores

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public boolean isContemNavio() {
		return contemNavio;
	}

	public void setContemNavio(boolean contemNavio) {
		this.contemNavio = contemNavio;
	}

	public int abrirCampo() {
		if (!aberto) {
			setAberto(true);

			if (contemNavio == true) {
				contemNavio = false;
				System.out.println("Acertou um navio!");
				notificarObservadores(true);
				return 1;
			} else {
				System.out.println("Errou o tiro!");
			}

			notificarObservadores(false);
		} else {
			return 2;
		}

		return 0;
	}

}