package org.vld.spring.ps5.ch03

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
// scan packages for @Component, @Repository, @Service, @Controller bean declarations
// and @Autowired/@Qualifier, @Resource dependency declarations
@ComponentScan(basePackages = arrayOf("org.vld.spring.ps5.ch03"))
open class MessageRendererConfig
