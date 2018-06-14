package com.luren.verticalviewpager;

import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator 可爱的路人 on 2018/6/14.
 * Email:513421345@qq.com
 * TODO
 */
public abstract class VerticalPagerAdapter extends PagerAdapter {

    public void setViewPagerObserver(DataSetObserver observer) {
        try {
            Method setViewPagerObserver = getClass().getDeclaredMethod("setViewPagerObserver", DataSetObserver.class);
            setViewPagerObserver.setAccessible(true);
            setViewPagerObserver.invoke(this, observer);
            setViewPagerObserver.setAccessible(false);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the proportional width of a given page as a percentage of the
     * ViewPager's measured width from (0.f-1.f]
     *
     * @param position The position of the page requested
     * @return Proportional width for the given page position
     */
    public float getPageHeight(int position) {
        return 1.f;
    }
}
