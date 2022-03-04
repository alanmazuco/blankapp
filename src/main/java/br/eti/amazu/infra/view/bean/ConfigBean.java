package br.eti.amazu.infra.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;
import br.eti.amazu.infra.util.Banner;
import br.eti.amazu.infra.util.FacesUtil;
import br.eti.amazu.infra.util.log.Ansi;

import br.eti.amazu.infra.view.vo.Config;
import br.eti.amazu.infra.view.vo.Theme;

import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
@Getter
@Setter
public class ConfigBean implements Serializable {
	
	private static final long serialVersionUID = -6663659948453061860L;
	
	private final transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	//O objeto config contem as variaveis de configuracoes do sistema.
	private transient Config config;
	
	private String skinTheme;
	
	//Armazena uma lista de idiomas suportados.
	private List<String> locales = new ArrayList<>();
	
	//-------themes--------------------
	private Theme theme;
	private List<Theme> themes;
	
	transient FacesUtil facesUtil = new FacesUtil();

	@PostConstruct
	public void initLocales() {
		
		//Utliza a classe FacesUtil para obter a lista de idiomas suportados.
		locales = new FacesUtil().getLocales();
		
		//realiza apenas um log
		StringBuilder strb = new StringBuilder();
		strb.append("Linguagens suportadas: ");
		int i = 1;
		for (String str : locales) {
			if (i == locales.size()) {
				strb.append(str);
			} else {
				strb.append(str + ", ");
			}
			i++;
		}
		
		Banner.printBanner();
		
		log.info("{}{}{}", Ansi.GREEN, strb, Ansi.RESET);
	}
	
	//-------------------------------------
	public void setConfiguracoes() {
		/*
		 * Aqui carregando parametros defalt, a titulo de demonstracao. Esses dados
		 * serao obtidos de um arquivo de configuracoes.
		 */
		config = new Config();
		/*
		 * TIPOS DE MENU: - menuBar ----------HORIZONTAL (default) - tiered ----------
		 * VERTICAL - slide ----------- VERTICAL - panelMenu ------- VERTICAL
		 */
		config.setMenuType("menuBar"); // O menu default eh menuBar (horizontal).
		
		//Setando os diversos parametros de skin para o aplicativo.
		config.setSkinAnimatedTop("F"); // ........................Topo default "nao-animado".
		config.setSkinBackground("vetruvian"); // ............Skin default - vetruvian.
		config.setSkinImageLogo("amazuLogo.gif"); // ......Imagem logotipo da empresa.
		config.setSkinLogo("T"); // .....................................Topo - logotipo da empresa.
		config.setSkinTextLogo("Tecnologia Java"); // .......Texto abaixo do logotipo.
		config.setSkinColorTextLogo("13f02d"); // ............A cor do texto do logotipo
		config.setSkinAnimatedHtml("blankapp_topo_anime.xhtml"); // .O Html5 anim
		
		//Isto eh o que serah escrito no rodapeh da pagina.
		config.setSkinFooter("Privacy Policy | Amazu Technology | Copyright \u00A9 2018 -" + " All rights reserved");
		
		/*
		 * ======================================== 
		 * MODERNIZACAO DOS TEMAS DO PRIMEFACES
		 * O tema default agora serah o saga.
		 * ========================================
		 */
		theme = new Theme(8L, "saga");
		themes = theme.getThemes();
		skinTheme = theme.getValue();
		config.setSkinTheme(skinTheme);
		/* ========================================= */
		
		//logs
		String strTheme = config.getSkinTheme().equals("saga") ? "saga (default)" : config.getSkinTheme();
		log.info("{}Rodando o tema: {}{}", Ansi.GREEN, strTheme, Ansi.RESET);
		log.info("{}Rodando o skin: {}{}", Ansi.GREEN, config.getSkinBackground(), Ansi.RESET);
		log.info("{}Rodando o menu: {}{}", Ansi.GREEN, config.getMenuType(), Ansi.RESET);
	}

	public void saveTheme(ValueChangeEvent e) {
		theme = (Theme) e.getNewValue();
		theme.setThemes(themes);
		skinTheme = theme.getValue();
		config.setSkinTheme(skinTheme);
	}

	/*---------
	* get/set
	---------*/
	public Config getConfig() {
		if (config == null) {
			this.setConfiguracoes();
		}
		return config;
	}
	
}