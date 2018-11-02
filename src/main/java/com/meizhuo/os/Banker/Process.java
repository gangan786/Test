package com.meizhuo.os.Banker;

import lombok.Data;

import java.util.ArrayList;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.os.Banker
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/27 13:55
 * @UpdateUser:
 * @UpdateDate: 2018/10/27 13:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Data
public class Process implements Cloneable {

    public String processName;

    public ArrayList<Resource> resourceList = new ArrayList<>();

    public boolean isDone = false;

    public Process(String processName) {
        this.processName = processName;
    }

    public void addResource(Resource resource) {
        resourceList.add(resource);
    }

    @Override
    protected Process clone() throws CloneNotSupportedException {
        Process cloneProcess = new Process(processName);
        cloneProcess.resourceList= (ArrayList<Resource>) this.resourceList.clone();
        cloneProcess.isDone=this.isDone;
        return cloneProcess;
    }
}
