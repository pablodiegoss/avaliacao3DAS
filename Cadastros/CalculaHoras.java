package Cadastros;

public class CalculaHoras {
	public int horaInicio;
	public int minutosInicio;
	public int horaTermino;
	public int minutosTermino;
	
	public int duracaoHoras;
	
	public CalculaHoras(Viagem v) {
		
		horaInicio = v.getHoraInicio();
		minutosInicio = v.getMinutoInicio();
		horaTermino = v.getHoraTermino();
		minutosTermino = v.getMinutosTermino();
	
	}

	public int calcular() {
		if (horaTermino == horaInicio)
			duracaoHoras = 0;
		if (horaTermino > horaInicio) //varias possibilidades... 
			if (horaTermino == horaInicio + 1) {  
				if (minutosTermino < minutosInicio)  //nao chegou a uma hora
					duracaoHoras = 0;
				else //durou pelo menos uma hora
					duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (horaTermino - horaInicio > 2) //
					duracaoHoras = horaTermino - horaInicio;
				else if (horaTermino - horaInicio == 2 &&   //certamente menos de duas horas  
						 minutosTermino < minutosInicio)    //e mais de uma hora
					duracaoHoras = 1;
				else //duracao de duas horas, certamente
					duracaoHoras = 2;
			}
		if (horaTermino < horaInicio) 
			duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return duracaoHoras;
	}
}