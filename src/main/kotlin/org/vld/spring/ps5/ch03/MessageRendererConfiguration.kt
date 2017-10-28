package org.vld.spring.ps5.ch03

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource // ktlint-disable no-unused-imports

@Configuration
// scan packages for @Component bean declarations and @Autowired dependency declarations
@ComponentScan(basePackages = arrayOf("org.vld.spring.ps5.ch03"))
// import XML configuration <bean id=""> into Java configuration class
//@ImportResource(locations = arrayOf("classpath:config/spring/ch03-message-renderer-app-context.xml"))
open class MessageRendererConfiguration
