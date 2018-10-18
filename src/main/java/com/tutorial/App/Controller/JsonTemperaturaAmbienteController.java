package com.tutorial.App.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tutorial.App.Container.Container;
import com.tutorial.App.EstruturaDeDados.Fila;

@RestController
@RequestMapping ("json1")
public class JsonTemperaturaAmbienteController {
	
Container c2;
	
	//@Autowired
	Double tamanhoDaFila2;
	
	
	Fila filaVindoDoMqttDaConexao2;
	

	public Fila getFilaVindoDoMqttDaConexao2() {
		return filaVindoDoMqttDaConexao2;
	}

	public void setFilaVindoDoMqttDaConexao2(Fila filaVindoDoMqttDaConexao2) {
		this.filaVindoDoMqttDaConexao2 = filaVindoDoMqttDaConexao2;
	}
	
		
	public Double getTamanhoDaFila2() {
		return tamanhoDaFila2;
	}

	public void setTamanhoDaFila2(Double tamanhoDaFila2) {
		this.tamanhoDaFila2 = tamanhoDaFila2;
	}

	

	public Container getC2() {
		return c2;
	}

	public void setC2(Container c2) {
		this.c2 = c2;
	}

	

	public void conectartda(String subscribeDaConexao) {
		Container c2 = new Container();
		this.c2 = c2;
		c2.conexao(subscribeDaConexao);
		if (c2.getConn().isConnected()) {
			System.out.println("Estamos conectados temperaturaAmbiente");
		}
		while (c2.getValorRecebidoDoCallback2() == null) {
			
		}
		System.out.println("Nao sou mais null");
		setTamanhoDaFila2(c2.getValorRecebidoDoCallback2()); 
		
	}	
	
	/*@RequestMapping(value = "/temperaturaambiente", method = RequestMethod.GET)
	public List<Double> graficoTemperaturadaagua() {
			
		if (!validarConexao()) {
			conectartda("pi/sng/tempAm");
		}
			
		//setTamanhoDaFila(c.getValorRecebidoDoCallback()); 
		System.out.println("Vamos ver se eh null " + getTamanhoDaFila2());		
		//model.addAttribute("message", getTamanhoDaFila());
		
		//return c2.getFilaDeValoresDoCallBack2().mostrarFila();
		return c2.getFilaDeValoresDoCallBack2().mostrarFila();
		
	}*/
	
	@RequestMapping(value = "/temperaturaambiente", method = RequestMethod.GET)
	public Double graficoTemperaturadaagua() {
			
		if (!validarConexao()) {
			conectartda("pi/sng/tempAm");
		}
			
		//setTamanhoDaFila(c.getValorRecebidoDoCallback()); 
		System.out.println("Vamos ver se eh null " + getTamanhoDaFila2());		
		//model.addAttribute("message", getTamanhoDaFila());
		
		//return c2.getFilaDeValoresDoCallBack2().mostrarFila();
		return c2.getValorRecebidoDoCallback2();
		
	}
	
	
	/*@RequestMapping(value = "/temperaturaagua", method = RequestMethod.GET)
	public List<Double> graficoTemperaturambiente() {
			
		if (!validarConexao()) {
			conectartda("pi/sng/tempAm");
		}
			
		//setTamanhoDaFila(c.getValorRecebidoDoCallback()); 
		System.out.println("Vamos ver se eh null " + getTamanhoDaFila2());		
		//model.addAttribute("message", getTamanhoDaFila());
		
		return c2.getFilaDeValoresDoCallBack1().mostrarFila();
		
	}*/
	
	@RequestMapping(value = "/temperaturaagua", method = RequestMethod.GET)
	public List<Double> graficoTemperaturambiente() {
		
		List<Double> lista = new ArrayList<>();
		
		if (!validarConexao()) {
			conectartda("pi/sng/tempAg");
		}
			
		//setTamanhoDaFila(c.getValorRecebidoDoCallback()); 
		System.out.println("Vamos ver se eh null " + getTamanhoDaFila2());		
		//model.addAttribute("message", getTamanhoDaFila());
		lista.add(c2.getValorRecebidoDoCallback1());
		
		return  lista;
		
	}
	
	@RequestMapping(value = "/humidade", method = RequestMethod.GET)
	public List<Double> graficoHumidade() {
		
		List<Double> lista = new ArrayList<>();
		
		if (!validarConexao()) {
			conectartda("pi/sng/hmd");
		}
			
		//setTamanhoDaFila(c.getValorRecebidoDoCallback()); 
		System.out.println("Vamos ver se eh null " + getTamanhoDaFila2());		
		//model.addAttribute("message", getTamanhoDaFila());
		lista.add(c2.getValorRecebidoDoCallback3());
		
		return  lista;
		
	}
	
	@RequestMapping(value = "/luminosidade", method = RequestMethod.GET)
	public List<Double> graficoLuminosidade() {
		
		List<Double> lista = new ArrayList<>();
		
		if (!validarConexao()) {
			conectartda("pi/sng/lumin");
		}
			
		//setTamanhoDaFila(c.getValorRecebidoDoCallback()); 
		System.out.println("Vamos ver se eh null " + getTamanhoDaFila2());		
		//model.addAttribute("message", getTamanhoDaFila());
		lista.add(c2.getValorRecebidoDoCallback4());
		
		return  lista;
		
	}
	
	public boolean validarConexao() {
		if (this.c2 != null) {
			return true;
		}
		
		return false;
	}
	
	/*@RequestMapping ("/temperaturadaagua")
	public List<Integer> arquivoJsonTemperaturaDaAgua(){
		return asList(1);
	}*/
	

}
