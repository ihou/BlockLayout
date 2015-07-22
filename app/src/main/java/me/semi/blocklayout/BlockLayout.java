package me.semi.blocklayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author houwenchang
 *         <p/>
 *         2015/7/20.
 */
public class BlockLayout extends ViewGroup {

    private int rowCount;
    private int colCount;
    private int gapSize;

    public BlockLayout(Context context) {
        super(context);
    }

    public BlockLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BlockLayoutChild);

        rowCount = a.getInt(R.styleable.BlockLayoutChild_rowCount, 0);
        colCount = a.getInt(R.styleable.BlockLayoutChild_colCount, 0);
        gapSize = a.getDimensionPixelSize(R.styleable.BlockLayoutChild_gapSize, 0);
        if (rowCount == 0 || colCount == 0) {
            throw new IllegalStateException("no rowCount or colCount found!");
        }

        a.recycle();
    }

    public BlockLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int blockW = (int) ((getWidth() - gapSize * (colCount - 1)) * 1.0 / colCount);
        int blockH = (int) ((getHeight() - gapSize * (rowCount - 1)) * 1.0 / rowCount);

        Log.e("", "blockW:" + blockW + "  blockH:" + blockH);
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            LayoutParams params = (LayoutParams) child.getLayoutParams();
            String[] str = params.block.split(",");
            int x = Integer.valueOf(str[0]);
            int y = Integer.valueOf(str[1]);
            int xSpan = Integer.valueOf(str[2]);
            int ySpan = Integer.valueOf(str[3]);
//            x = 2;
//            y = 0;
//            xSpan = 1;
//            ySpan = 1;

            int left = x * (blockW + gapSize);
            int top = y * (blockH + gapSize);
            int right = left + blockW * xSpan + gapSize * (xSpan - 1);
            int bottom = top + blockH * ySpan + gapSize * (ySpan - 1);
            Log.e("", "left:" + left + "  top:" + top + "  right:" + right + "  bottom:" + bottom);
            child.layout(left, top, right, bottom);
        }

    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new BlockLayout.LayoutParams(getContext(), attrs);
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public String block;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.BlockLayoutChild);
            block = a.getString(R.styleable.BlockLayoutChild_block);
            a.recycle();
        }

    }
}
