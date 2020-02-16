package ru.mail.romanov1234567890987.service.impl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import ru.mail.romanov1234567890987.config.ServiceConfig;
import ru.mail.romanov1234567890987.repository.FileRepository;
import ru.mail.romanov1234567890987.repository.impl.FileRepositoryImpl;
import ru.mail.romanov1234567890987.service.AddService;
import ru.mail.romanov1234567890987.service.FileService;
import ru.mail.romanov1234567890987.config.RepositoryConfig;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public int getSum(String fileName) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(RepositoryConfig.class);
        context.register(ServiceConfig.class);
        context.refresh();

        AddService addService = context.getBean(AddServiceImpl.class);
        FileRepository repository = context.getBean(FileRepositoryImpl.class);

        List<String> stringCollection = repository.getStringCollectionFromFile(fileName);

        int totalSum = 0;
        for (String element : stringCollection) {
            totalSum += addService.add(element);
        }
        return totalSum;
    }
}
