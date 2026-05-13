package co.edu.unicauca.asae.cleanarquitecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asae.cleanarquitecture.service.DocenteService;
import co.edu.unicauca.asae.cleanarquitecture.service.EvaluacionService;
import co.edu.unicauca.asae.cleanarquitecture.service.FormatoAService;
import co.edu.unicauca.asae.cleanarquitecture.service.FormatoPPService;
import co.edu.unicauca.asae.cleanarquitecture.service.FormatoTIService;
import co.edu.unicauca.asae.cleanarquitecture.service.ObservacionService;

@SpringBootApplication
public class TallerjpaApplication implements CommandLineRunner {

	@Autowired
    private FormatoPPService serviceFormatoPP;
	
	@Autowired
    private FormatoTIService serviceFormatoTi;

	@Autowired
	private DocenteService serviceDocente;

	@Autowired
	private ObservacionService serviceObservacion;

	@Autowired
	private FormatoAService formatoAService;

	@Autowired
	private EvaluacionService evaluacionService;

	public static void main(String[] args) {
		SpringApplication.run(TallerjpaApplication.class, args);
	}
	@Override
    public void run(String... args) {
        //serviceFormatoPP.crearFormatoPP("prueba5","obj general 5","javier 5","sebastian 5",2);
		//serviceFormatoTi.crearFormatoTi("pruebaTi 8", "obj 8", "Martha 8", "pepe 8", "pablo 8", 2);
		//serviceDocente.crear("Jose","Muñoz","jose@gmail.com");
		//serviceObservacion.crear(8,6,"Prueba ob");
		//serviceObservacion.listar(6);
		//serviceDocente.listarMiembrosComite();
		//serviceDocente.consultarFormatosPorDocente(6);


		//serviceDocente.listarDocentes("gico", "pe");
		//formatoAService.listarFormatos("daniel");
		//evaluacionService.evaluacionesFecha("01/03/2026","21/05/2026","jul");
		//formatoAService.formatoADeatils("PP prueba5");
		//formatoAService.formatoAexist("PP prueba5");
		//formatoAService.agregarEstado(9, "rechazado");
		serviceDocente.docenteExist("daniel@gmail.com");
	}

}
