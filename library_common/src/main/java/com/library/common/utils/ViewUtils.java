package com.library.common.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author： zh浩
 * @创建时间:19-10-18 下午4:37
 * @描述： view 工具类
 * @更新时间： 19-10-18 下午4:37
 * @更新说明： 无
 * @版本号 1.0
 */
public class ViewUtils {

    public static ViewUtils newInstance() {
        return new ViewUtils();
    }

    /**
     * 得到View的值
     *
     * @param supView
     * @param tag
     *
     * @return
     */
    public Object getViewVal(ViewGroup supView, String tag) {
        View view = supView.findViewWithTag(tag);
        if (EmptyUtils.isEmpty(view)) {
            return null;
        }
        Object result = null;
        if (view instanceof TextView) {
            result = ((TextView) view).getText().toString();
        } else if (view instanceof WebView) {
            result = ((WebView) view).getUrl();
        }
        return result;
    }

    /**
     * 设置值
     *
     * @param view
     * @param val
     */
    public void setValue(View view, Object val) {
        try {
            if (view != null && val != null) {
                if (view instanceof ImageView) {
                    if (val instanceof Drawable) {
                        ((ImageView) view).setImageDrawable((Drawable) val);
                    }
                    //setImage(view, val.toString());
                } else if (view instanceof TextView) {
                    ((TextView) view).setText(val.toString());
                } else if (view instanceof WebView) {
                    ((WebView) view).loadUrl(val.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 得到所有View的Tag
     *
     * @param viewGroup
     *
     * @return
     */
    public static List<Object> getViewTags(ViewGroup viewGroup) {
        List<Object> allTag = new ArrayList<>();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View view = viewGroup.getChildAt(i);
            Object tag = view.getTag();
            if (tag != null) {
                allTag.add(tag);
            }
        }
        return allTag;
    }


    /**
     * 自动复制文书对象
     *
     * @param docBean
     *
     * @return
     */
    protected Object AutoValueByTag(Object docBean, ViewGroup viewGroup) {
        try {
            Field[] fields = docBean.getClass().getDeclaredFields();
            if (EmptyUtils.isNotEmpty(fields)) {
                for (Field field : fields) {
                    Class<?> type = field.getType();
                    Object value = getViewVal(viewGroup, field.getName());
                    if (value != null) {
                        if (type == Integer.class || type == int.class) {
                            value = Integer.parseInt(String.valueOf(value));
                        } else if (type == Double.class || type == double.class) {
                            value = Double.parseDouble(String.valueOf(value));
                        } else if (type == Boolean.class || type == boolean.class) {
                            value = Boolean.parseBoolean(String.valueOf(value));
                        }
                        field.setAccessible(true);
                        field.set(docBean, value);
                    }
                }
            }
        } catch (Exception e) {

        }
        return docBean;
    }

    public void inJectViewByTag(Object obj, View view) {
        try {
            if (obj instanceof JSONObject) {
                Iterator<String> keys = ((JSONObject) obj).keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    setValue(view.findViewWithTag(key), ((JSONObject) obj).get(key));
                }
            } else {
                Field[] fields = obj.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    Object val = field.get(obj);
                    setValue(view.findViewWithTag(field.getName()), val);
                }
            }
        } catch (Exception e) {
            new Throwable("inJectViewByTag失败啦:");
        }
    }


}
