package com.library.common.interfaces;

import android.text.TextUtils;

import java.util.HashMap;

/** 
 * @author： zh浩
 * 
 * @创建时间:19-10-18 上午11:13
 * 
 * @描述： Title(页面标题)  
 * 
 * @更新时间： 19-10-18 上午11:13
 * 
 * @更新说明： 无
 * 
 * @版本号 1.0
 */
public class FunctionsManager {

    private static FunctionsManager functionsManager;

    /**
     * 接口存储池
     */
    private HashMap<String, FunctionImp> funCache = null;

    /**
     * 单例模式 获取
     *
     * @return
     */
    public static FunctionsManager getIntance() {
        if (functionsManager == null) {
            functionsManager = new FunctionsManager();
        }
        return functionsManager;
    }

    /**
     * 私有构造方法
     */
    private FunctionsManager() {
        funCache = new HashMap<>();
    }

    /**
     * 添加一个接口
     *
     * @param function
     * @return
     */
    public FunctionsManager addFunction(FunctionImp function) {
        funCache.put(function.getmFuntionName(), function);
        return this;
    }

    /**
     * 调用一个 有参数，有返回值 的接口
     *
     * @param funcName
     * @param param
     * @param resultClass
     * @param <Param>
     * @param <Result>
     * @return
     */
    public <Param, Result> Result invokeFunc(String funcName, Param param, Class<Result> resultClass) {
        if (TextUtils.isEmpty(funcName)) {
            return null;
        }
        FunctionImp f = funCache.get(funcName);
        if (f == null) {
            return null;
        }

        if (resultClass != null) {
            return resultClass.cast(f.function(param));
        } else {
            return (Result) f.function(param);
        }
    }

    /**
     * 调用一个有参数 无返回值的接口
     *
     * @param funcName
     * @param param
     * @param <Param>
     */
    public <Param> void invokeFunc(String funcName, Param param) {
        invokeFunc(funcName, param,Object.class);
    }

    /**
     * 调用一个无参数 无返回值的接口
     *
     * @param funcName
     */
    public void invokeFunc(String funcName) {
        invokeFunc(funcName, new Object(), Object.class);
    }


}
