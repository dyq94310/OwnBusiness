package com.deng.demo.interfaces.fallback;

import com.deng.demo.interfaces.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author DengYongQi
 * @date 2019-07-24
 **/
@Component
public class SchedualServiceHiFallBack implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
