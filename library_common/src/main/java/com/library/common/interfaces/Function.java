package com.library.common.interfaces;

public abstract class Function {

    public String mFuntionName;

    public void setmFuntionName(String mFuntionName) {
        this.mFuntionName = mFuntionName;
    }

    public String getmFuntionName() {
        return mFuntionName;
    }

    public Function(String mFuntionName) {
        this.mFuntionName = mFuntionName;
    }
}
