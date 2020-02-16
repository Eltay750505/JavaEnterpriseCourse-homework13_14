package ru.mail.romanov1234567890987;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mail.romanov1234567890987.config.ServiceConfig;
import ru.mail.romanov1234567890987.service.FileService;

import java.lang.invoke.MethodHandles;

public class App
{
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    public static void main( String[] args )
    {
        String fileName = "output.txt";
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ServiceConfig.class);
        context.refresh();
        FileService fileService = context.getBean(FileService.class);
        int sum = fileService.getSum(fileName);
        logger.info("Total sum = " + sum);
    }
}
