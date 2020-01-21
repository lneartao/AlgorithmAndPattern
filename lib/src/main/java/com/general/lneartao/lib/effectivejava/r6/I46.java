package com.general.lneartao.lib.effectivejava.r6;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 优先选择Stream中无副作用的函数
 * <p>
 * 静态导入Collectors的所有成员是惯例也是明智的，因为这样可以提升Stream Pipeline的可读性
 *
 * @author lneartao
 * @date 2020/1/21.
 */
public class I46 {

    private void fun(File file) {
        Map<String, Long> freq = new HashMap<>();
        List<String> topTen = freq.keySet().stream()
                                  .sorted(Comparator.comparing(freq::get).reversed())
                                  .limit(10)
                                  .collect(Collectors.toList());
    }

}
