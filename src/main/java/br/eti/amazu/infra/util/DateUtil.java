package br.eti.amazu.infra.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *  Realiza o tratamento de datas para quase todas as situacoes,
 *  na  obtencao de varios objetos de consulta a banco de dados, 
 *  nas transformacoes e nos calculos que realiza, de
 *  forma mais desacoplada
 *
 *  @author		alan
 *  @version	%I%, %G%
 *  @since 		1.0
 */
public class DateUtil {
	
	private static final String PT_BR_PATTERN = "dd/MM/yyyy";
	
	/**
	 * Construtor default privado.
	 */
	private DateUtil() {
		//NOP
	}
	
	/**
	 *  Verifica se uma data eh valida, recebendo uma string.
	 *  
	 *  @param String
	 *  @return boolean
	 */
	public static boolean isValidDate(String strDate) {	
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PT_BR_PATTERN);		
		formatter.parse(strDate);

		try {
	        LocalDate.parse(strDate, formatter);
	        return true;
	        
		} catch (Exception e) { 
	    	return false;
		} 
	}
	
	/**
	 * Retorna uma string "dd/MM/yyyy", recebendo um LocalDate.
	 *
	 * @param localDate
	 * @return String
	 */
	public static String getStringDate(LocalDate localDate) {
		return DateTimeFormatter.ofPattern(PT_BR_PATTERN).format(localDate);
	}
	
	/**
	 * Verifica se uma data A eh maior que uma data B.
	 *
	 * @param dataUm
	 * @param dataDois
	 * @return boolean
	 */
	public static boolean isDataUmMaiorDataDois(LocalDate dataUm, LocalDate dataDois) {			
		return dataUm.isAfter(dataDois);
	}
	
	/**
	 * Verifica se uma data A eh menor que uma data B.
	 *
	 * @param dataUm
	 * @param dataDois
	 * @return boolean
	 */
	public static boolean isDataUmMenorDataDois(LocalDate dataUm, LocalDate dataDois) {
		return dataUm.isBefore(dataDois);
	}	
	
	/**
	 * Verifica se a data informada eh menor que a data atual.
	 * 
	 * @param LocalDate
	 * @return boolean
	 */
	public static boolean isDataInformadaMenorDataAtual(LocalDate localDate) {
		return localDate.isBefore(LocalDate.now());
	}
	
	/**
	 * Verifica se a data informada eh maior que a data atual.
	 * @param localDate
	 * @return boolean
	 */
	public static boolean isDataInformadaMaiorDataAtual(LocalDate localDate) {
		return localDate.isAfter(LocalDate.now());
	}	
	
	/**
	 * Verifica se uma data estah contida entre duas datas informadas. <p/>
	 * (interpolacao de datas).
	 * 
	 * @param dataAnterior
	 * @param data
	 * @param dataPosterior
	 * @return
	 */
	public static boolean isDataInterpolada(LocalDate dataAnterior, LocalDate data,
			LocalDate dataPosterior) {		
		return  (data.equals(dataAnterior) || data.equals(dataPosterior)) || 
				(data.isAfter(dataAnterior) && data.isBefore(dataPosterior));
	}
	
	/**
	 * Transforma uma String (dd/MM/yyyy) em LocalDate.
	 * @param strDate
	 * @return LocalDate
	 */
	public static LocalDate getLocalDate(String strDate) {		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PT_BR_PATTERN);
		return LocalDate.parse(strDate, formatter);
	}	
	
	/**
	 * Devolve a data por extenso em pt_BR.
	 * 
	 * @param localDate
	 * @return String
	 */
	public static String getDataPorExtenso(LocalDate localDate) {				
		DateTimeFormatter dia = DateTimeFormatter.ofPattern("dd");
		DateTimeFormatter mes = DateTimeFormatter.ofPattern("MMMM");
		DateTimeFormatter ano = DateTimeFormatter.ofPattern("yyyy");
		return  dia.format(localDate) + " de " + mes.format(localDate) + " de " + ano.format(localDate);
	}
	
	/**
	 * Retorna uma string da data atual no formato "dd de MES de yyyy"
	 * 
	 * @return String
     */
	public static String getDataAtualPorExtenso() {		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
		return LocalDate.now().format(formatter);
	}	
	
	/**
	 * Verifica a diferenca em dias, entre duas datas.
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return long
	 */
	public static long getDiferencaEntreDatas(LocalDate dataInicial, LocalDate dataFinal) {
		return ChronoUnit.DAYS.between(dataInicial, dataFinal);
	}	
	
	/**
	 * retorna a diferença entre duas datas 
	 * no formato "0d 0m 0a"
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return String
	 */
	public static String getDiferencaEntreDatasEmTempo(LocalDate dataInicial, LocalDate dataFinal){
				
		Period period = Period.between(dataInicial, dataFinal);
		
		return  new StringBuilder()
				.append(period.getDays())
				.append("d ")
				.append(period.getMonths())
				.append("m ")
				.append(period.getYears())
				.append("a")
				.toString();		
	}
	
	/**
	 * Verifica a diferenca entre duas datas, 
	 * retornando no formato de quantidade de anos.
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return int
	 */
	public static Long getDiferencaEntreDatasAno(LocalDate dataInicial, LocalDate dataFinal){
		return ChronoUnit.YEARS.between(dataInicial, dataFinal);
	}	
	
	/**
	 * Soma dias a uma data.
	 * 
	 * @param localDate
	 * @param dias
	 * @return LocalDate
	 */
	public static LocalDate addDia(LocalDate localDate, Long dias) {
		return localDate.plusDays(dias);
	}	
	
	/**
	 * Transforma uma String (yyyy-mm-dd) em LocalDate.
	 * 
	 * @param strDate (format "yyyy-MM-dd")
	 * @return LocalDate (format "dd/MM/yyyy")
	 */
	public static LocalDate getLocalDateWithFormat(String strDate) {		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(strDate, formatter);
	}
	
	/**
	 * Retorna uma string da hora atual no formato "HH:MM"
	 * 
	 * @return String
	 */
	public static String getStringNowTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:MM");
		return LocalDateTime.now().format(formatter);
	}
	
	/**
	 *  Retorna uma string do ano atual no formato "yyyy"
	 *  
	 *  @return String
     */
	public static String getStringAnoAtual() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
		return LocalDate.now().format(formatter);
	}

}
