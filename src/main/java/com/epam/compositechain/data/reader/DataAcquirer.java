package com.epam.compositechain.data.reader;

public interface DataAcquirer {
    String getText(String fileName) throws DataException;
}
