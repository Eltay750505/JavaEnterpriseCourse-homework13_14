package ru.mail.romanov1234567890987.service.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.mail.romanov1234567890987.service.AddService;

import java.lang.invoke.MethodHandles;


@Service
public class AddServiceImpl implements AddService {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final int MAX_AMOUNT_OF_NUMS = 2;
    private static final int MIN_AMOUNT_OF_NUMS = 0;

    @Override
    public int add(String numbers) {
        if (numbers == null) {
            return 0;
        }
        String[] splitNums = numbers.split("\\W");
        if (splitNums.length > MAX_AMOUNT_OF_NUMS || splitNums.length < MIN_AMOUNT_OF_NUMS) {
            logger.error("Invalid amount of numbers, the method returns 0 instead");
            return 0;
        }
        int totalSum = getSum(splitNums);
        return totalSum;
    }

    private int getSum(String[] splitNums) {
        int sum = 0;
        for (int i = 0; i < splitNums.length; i++) {
            sum += Integer.parseInt(splitNums[i]);
        }
        return sum;
    }
}
