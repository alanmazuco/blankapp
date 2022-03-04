package br.eti.mazu.infra.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.eti.amazu.infra.util.DateUtil;

public class DateUtilTest {
	
	@Test
	@DisplayName("Verifica se uma data é valida")
	void isValidDate() {		
		Assert.assertTrue(DateUtil.isValidDate("01/02/2022"));
	}
	
	@Test
	@DisplayName("Transforma uma LocalDate em uma string")
	void getStringDate() {
		LocalDate localDate = getLocalDate("01/02/2022");		
		Assert.assertEquals("01/02/2022", DateUtil.getStringDate(localDate));
	}
	
	@Test
	@DisplayName("Verifica se uma data é maior que outra")
	void isDataUmMaiorDataDois() {
		LocalDate localDate1 = getLocalDate("01/02/2022");
		LocalDate localDate2 = getLocalDate("01/02/2020");		
		Assert.assertTrue(DateUtil.isDataUmMaiorDataDois(localDate1,localDate2));
	}
	
	@Test
	@DisplayName("Verifica se uma data é menor que outra")
	void isDataUmMenorDataDois() {		
		LocalDate localDate1 = getLocalDate("01/02/2022");
		LocalDate localDate2 = getLocalDate("08/02/2022");		
		Assert.assertTrue(DateUtil.isDataUmMenorDataDois(localDate1,localDate2));
	}
	
	@Test
	@DisplayName("Verifica se a data informada é menor que a data atual")
	void isDataInformadaMenorDataAtual() {				
		LocalDate localDate = getLocalDate("01/02/2022");
		Assert.assertTrue(DateUtil.isDataInformadaMenorDataAtual(localDate));
	}
	
	@Test
	@DisplayName("Verifica se a data informada é maior que a data atual")
	void isDataInformadaMaiorDataAtual() {		
		LocalDate localDate = getLocalDate("01/02/5022");
		Assert.assertTrue(DateUtil.isDataInformadaMaiorDataAtual(localDate));
	}
	
	@Test
	@DisplayName("Verifica se uma data está interpolada entre duas datas")
	void isDataInterpolada() {		
		LocalDate dataAnterior = getLocalDate("01/02/2021");
		LocalDate data = getLocalDate("25/03/2021");
		LocalDate dataPosterior = getLocalDate("28/10/5020");				
		Assert.assertTrue(DateUtil.isDataInterpolada(dataAnterior, data, dataPosterior));
	}
	
	@Test
	@DisplayName("Transforma uma string em um LocalDate")
	void getLocalDate() {
		LocalDate data = getLocalDate("25/03/2021");				
		Assert.assertEquals(data, DateUtil.getLocalDate("25/03/2021"));
	}
	
	@Test
	@DisplayName("Transforma uma LocalData em data por extenso")
	void getDataPorExtenso() {
		LocalDate data = getLocalDate("25/03/2021");				
		Assert.assertEquals("25 de março de 2021", DateUtil.getDataPorExtenso(data));
	}
	
	@Test
	@DisplayName("Obtém a data atual por extenso")
	void getDataAtualPorExtenso() {		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
		String str =  LocalDate.now().format(formatter);		
		Assert.assertEquals(str, DateUtil.getDataAtualPorExtenso());
	}
	
	@Test
	@DisplayName("Retorna a diferença em dias entre duas datas")
	void getDiferencaEntreDatas() {		
		LocalDate localDate1 = getLocalDate("01/02/2022");
		LocalDate localDate2 = getLocalDate("08/02/2022");		
		Assert.assertEquals(7, DateUtil.getDiferencaEntreDatas(localDate1,localDate2));
	}
	
	@Test
	@DisplayName("Retorna a diferença entre duas datas no formato 0d 0m 0a")
	void getDiferencaEntreDatasEmTempo() {		
		LocalDate localDate1 = getLocalDate("01/02/2022");
		LocalDate localDate2 = getLocalDate("08/02/2022");	
		Assert.assertEquals("7d 0m 0a", DateUtil.getDiferencaEntreDatasEmTempo(localDate1,localDate2));
	}
	
	@Test
	@DisplayName("Retorna a diferença entre duas datas em anos")
	void getDiferencaEntreDatasAno() {		
		LocalDate localDate1 = getLocalDate("01/02/2021");
		LocalDate localDate2 = getLocalDate("08/02/2022");
		Assert.assertEquals(1L, DateUtil.getDiferencaEntreDatasAno(localDate1,localDate2).longValue());
	}
	
	@Test
	@DisplayName("Soma dias a uma data")
	void addDia() {		
		LocalDate localDate = getLocalDate("01/02/2021");
		Assert.assertEquals(getLocalDate("09/03/2021"), DateUtil.addDia(localDate,36L));
	}
	
	@Test
	@DisplayName("Transforma uma String (yyyy-mm-dd) em LocalDate")
	void getLocalDateWithFormat() {		
		LocalDate localDate = getLocalDate("28/02/2021");
		Assert.assertEquals(localDate, DateUtil.getLocalDateWithFormat("2021-02-28"));
	}
	
	@Test
	@DisplayName("Retorna uma string da hora atual no formato HH:MM")
	void getStringNowTime() {		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:MM");
		String str = LocalDateTime.now().format(formatter);
		Assert.assertEquals(str, DateUtil.getStringNowTime());
	}
	
	@Test
	@DisplayName("Retorna uma string do ano atual no formato yyyy")
	void getStringAnoAtual() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
		String str = LocalDate.now().format(formatter);		
		Assert.assertEquals(str, DateUtil.getStringAnoAtual());
	}	
		
	/*
	 * metodo de apoio
	 */
	LocalDate getLocalDate(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");		
		return LocalDate.parse(str, formatter);
	}

}
