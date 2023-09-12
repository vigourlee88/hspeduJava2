package com.itheima.a05;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Component;

import com.alibaba.druid.sql.visitor.functions.If;

public class ComponentScanPostProcessor implements BeanFactoryPostProcessor{

	@Override //context.refresh时调用
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        
		try {
			ComponentScan componentScan = AnnotationUtils.findAnnotation(Config.class, ComponentScan.class);
	        if(componentScan != null) {
	        	for(String p : componentScan.basePackages()) {
	        		System.out.println(p);
	        		//com.itheima.a05.component -> classpath*:com/ithaima/a05/somponent/**/*.class
	        		String path = "classpath*:" + p.replace(".", "/") + "/**/*.class";
	        		System.out.println(path);
	        		CachingMetadataReaderFactory factory = new CachingMetadataReaderFactory();
	        		Resource[] resources = new PathMatchingResourcePatternResolver().getResources(path);
	        		AnnotationBeanNameGenerator generator = new AnnotationBeanNameGenerator();
	        		for (Resource resource : resources) {
	//					System.out.println(resource);
						MetadataReader reader = factory.getMetadataReader(resource);
	//					System.out.println("类名: " + reader.getClassMetadata().getClassName());
						AnnotationMetadata annotationMetadata = reader.getAnnotationMetadata();
	//					System.out.println("是否加了 @Component: " + annotationMetadata.hasAnnotation(Component.class.getName()));
	//					System.out.println("是否加了 派生@Component: " + annotationMetadata.hasMetaAnnotation(Component.class.getName()));
						
						if(annotationMetadata.hasAnnotation(Component.class.getName())
								|| annotationMetadata.hasMetaAnnotation(Component.class.getName())) {
							AbstractBeanDefinition bd = BeanDefinitionBuilder
									.genericBeanDefinition(reader.getClassMetadata().getClassName())
							        .getBeanDefinition();

							if(configurableListableBeanFactory instanceof DefaultListableBeanFactory beanFactory) {
								String name = generator.generateBeanName(bd, beanFactory);
							    beanFactory.registerBeanDefinition(name, bd);
							}
							
						}
					}
	        	}
	        	
	        }
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
