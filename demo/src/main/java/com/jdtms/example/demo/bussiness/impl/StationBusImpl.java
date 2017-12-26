package com.jdtms.example.demo.bussiness.impl;

import com.jdtms.example.demo.bussiness.StationBus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: nyh
 * \* Date: 17-10-31
 * \* Time: 下午5:08
 * \* Description:
 * \
 */
@Service
public class StationBusImpl implements StationBus{

    @Override
    public String[][] compute(String... sts) {
        String[][] result = new String[sts.length / 2][];
        for(int i = 0; i <sts.length; i++) {
            String[] tmp = new String[2];
            tmp[0] = sts[i];
            tmp[1] = sts[i + 1];
            result[i / 2] = tmp;
            i++;
        }
        return result;
    }
}
