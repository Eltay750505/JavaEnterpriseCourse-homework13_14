package ru.mail.romanov1234567890987.repository.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.mail.romanov1234567890987.repository.FileRepository;
import ru.mail.romanov1234567890987.util.PropertyUtil;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileRepositoryImpl implements FileRepository {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private PropertyUtil propertyUtil = new PropertyUtil();

    @Override
    public List<String> getStringCollectionFromFile(String fileName) {
        List<String> stringList = new ArrayList<>();
        String fullPathName = propertyUtil.getProperty("filePathName") + fileName;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fullPathName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringList.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return stringList;
    }
}
