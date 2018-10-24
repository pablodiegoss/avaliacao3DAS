package Cadastros;

public class Viagem {

	private int horaInicio;
	private int minutosInicio;
	private int horaTermino;
	private int minutosTermino;

	private Viagem(int hora, int minutos) {
		this.horaInicio = hora;
		this.minutosInicio = minutos;
	}

	protected static Viagem obterViagem(int hora, int minutos) {
		Viagem v = new Viagem (hora, minutos);
		return v;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public int getMinutoInicio() {
		return minutosInicio;
	}

	public void encerrarViagem(int horaTermino, int minutosTermino) {
		this.horaTermino = horaTermino;
		this.minutosTermino = minutosTermino;
	}

	public int getHoraTermino() {
		return horaTermino;
	}

	public int getMinutosTermino() {
		return minutosTermino;
	}

	public int getDuracaoHoras() {
		return new CalculadoraViagem(this).calcularHoras();
	}

	public int getDuracaoMinutos() {
		return new CalculadoraViagem(this).calcularMinutos();
	}

	public int getDuracaoTotalMinutos() {
		return new CalculadoraViagem(this).calcularTotal();
	}

}
