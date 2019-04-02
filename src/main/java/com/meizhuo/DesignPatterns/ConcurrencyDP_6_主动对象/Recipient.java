package com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/4/2 11:25
 * @UpdateUser:
 * @UpdateDate: 2019/4/2 11:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Recipient implements Serializable {

    private static final long serialVersionUID = -6189554012682115493L;

    private Set<String> to = new HashSet<String>();

    public void addTo(String msisdn) {
        to.add(msisdn);
    }

    public Set<String> getToList() {
        return (Set<String>) Collections.unmodifiableCollection(to);
    }

}
