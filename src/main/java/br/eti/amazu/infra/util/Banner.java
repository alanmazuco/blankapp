package br.eti.amazu.infra.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.eti.amazu.infra.util.log.Ansi;

public class Banner {

	private Banner() {}

	private static final Logger log = LoggerFactory.getLogger(Banner.class);
	private static final String INIT_PARAM = "{}{}{}";
	
	public static void printBanner() {
		
		log.info(INIT_PARAM, Ansi.RED, "  )     )       )        (   ", Ansi.RESET);
		log.info(INIT_PARAM, Ansi.RED, " ( /(    (     ( /(  (    ))\\  ", Ansi.RESET);
		log.info(INIT_PARAM, Ansi.RED, " )(_))   )\\  ' )(_)) )\\  /((_) ", Ansi.RESET);
		log.info(INIT_PARAM, Ansi.RED, "((_)_  _((_)) ((_)_ ((_)(_))(  ", Ansi.RESET);
		log.info(INIT_PARAM, Ansi.BLACK_YELLOWBG, "/ _` || '  \\  / _` ||_ /| || | ", Ansi.RESET);
		log.info(INIT_PARAM, Ansi.BLACK_YELLOWBG, "\\__,_||_|_|_| \\__,_|/__| \\_,_|", Ansi.RESET);
		log.info("++++++++++++++++++++++++++++++");
		log.info("Amazu Technology  © Copyrights");
		log.info("++++++++++++++++++++++++++++++");
		
	}
	
}
