package ru.mail.romanov1234567890987.repository;


import java.util.List;

public interface FileRepository {
    List<String> getStringCollectionFromFile(String fileName);
}
