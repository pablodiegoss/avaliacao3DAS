package Cadastros;

public class CalculadoraViagem {

	public int horaInicio;
	public int minutosInicio;
	public int horaTermino;
	public int minutosTermino;

	public int duracaoHoras;

	public CalculadoraViagem(Viagem v) {

		horaInicio = v.getHoraInicio();
		minutosInicio = v.getMinutoInicio();
		horaTermino = v.getHoraTermino();
		minutosTermino = v.getMinutosTermino();

	}

	public int calcularHoras() {

		final int diferencaHora = horaTermino - horaInicio;
		if (diferencaHora < 0)
			return -1; // para casos em que a hora de termino nao foi registrada
		else if (diferencaHora == 0)
			return 0;
		else {
			if (calcularMinutos() > 0)
				return diferencaHora - 1;
			else
				return diferencaHora;
		}
	}

	public int calcularMinutos() {
		final int diferencaMinutos = minutosTermino - minutosInicio;
		if (diferencaMinutos < 0)
			return 60 + diferencaMinutos;
		else if (diferencaMinutos == 0) {
			return 0;
		} else {
			return diferencaMinutos;
		}
	}

	public int calcularTotal() {
		return calcularHoras() * 60 + calcularMinutos();
	}
}