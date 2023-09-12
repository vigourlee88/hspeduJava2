package com.itheima.a09;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.itheima.a09")
public class A09 {
	
	private static final Logger log = LoggerFactory.getLogger(A09.class);
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				   new AnnotationConfigApplicationContext(A09.class);
	    E e =context.getBean(E.class);
	    log.debug("{}",e.getF1().getClass());
	    log.debug("{}",e.getF1());
	    log.debug("{}",e.getF1());
	    log.debug("{}",e.getF1());
	    
	    log.debug("{}",
	    		e.getF2().getClass());
	    log.debug("{}",e.getF2());
	    log.debug("{}",e.getF2());
	    log.debug("{}",e.getF2());
	    
	    log.debug("{}",e.getF3());
	    log.debug("{}",e.getF3());
	    
	    log.debug("{}",e.getF4());
	    log.debug("{}",e.getF4());
	    context.close();
		
		
	}

}
