package com.univates.tcc.abacate.application.launch;

import java.io.Serializable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.univates.tcc.abacate.application.setup.SetupConstants;

@EnableAutoConfiguration
@ComponentScan(basePackages= {
		SetupConstants.Packages.APPLICATION,
		SetupConstants.Packages.DOMAIN,
		SetupConstants.Packages.INTEGRATION}, 
    lazyInit=true)
@SpringBootApplication
public class Launcher implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
    
}