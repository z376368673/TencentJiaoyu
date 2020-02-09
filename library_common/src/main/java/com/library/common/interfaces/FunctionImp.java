package com.library.common.interfaces;
/**
 * @author： zh浩
 *
 * @创建时间:19-10-18 上午10:57
 *
 * @描述： Title(页面标题)
 *
 * @更新时间： 19-10-18 上午10:57
 *
 * @更新说明： 无
 *
 * @版本号 1.0
 */
public abstract class FunctionImp<Param, Result> extends Function {

    /**
     * 接口构造方法
     *
     * @param funcName 接口名称
     */
    public FunctionImp(String funcName) {
        super(funcName);
    }

    /**
     * 接口抽象类
     *
     * @param data
     * @return
     */
    public abstract Result function(Param data);

}
