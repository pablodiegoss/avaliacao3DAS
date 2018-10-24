package Cadastros;

public class CalculaMinutos {

	private int minutosTermino;
	private int minutosInicio;
	
	private int duracaoMinutos;
	private Viagem viagem;
	public CalculaMinutos(Viagem v) {
		minutosTermino = v.getMinutosTermino();
		minutosInicio = v.getMinutoInicio();
		viagem = v;
	}

	public int calcular() {
		if (minutosTermino > minutosInicio)
			duracaoMinutos = minutosTermino - minutosInicio;
		else {
			duracaoMinutos = 60 - minutosInicio + minutosTermino;
			if (duracaoMinutos == 60) // caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}

	public int calcularTotal() {
		final int horas = new CalculaHoras(viagem).calcular();
		return horas * 60 + calcular();
	}
}
