package com.library.common.interfaces;

public class InterfaceHelper {
    private static InterfaceHelper interfaceHelper;
    private static FunctionsManager manager;


    public static InterfaceHelper getInstance() {
        if (interfaceHelper == null) {
            interfaceHelper = new InterfaceHelper();
        }
        return interfaceHelper;
    }

    private InterfaceHelper() {
        manager = FunctionsManager.getIntance();
    }

    public InterfaceHelper addActionLinstener(String action) {
        manager.addFunction(new FunctionImp(action) {
            @Override
            public Object function(Object data) {
                return null;
            }
        });
        return this;
    }

}
