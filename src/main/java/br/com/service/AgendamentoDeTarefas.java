package br.com.service;

import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class AgendamentoDeTarefas {
	
	@Scheduled(fixedRate = 2000)
	public void seraExecutadoACada2Segundos() throws InterruptedException {
		System.out.println(new Date());
		
		Thread.sleep(2000);
	}
	
	@Scheduled(cron = "0 0 21")
	public void todosDosDias21horas() {
		System.out.println(new Date());
		
		
	}
}
