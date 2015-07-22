# BlockLayout

## What is BlockLayout?
**BlockLayout** is a subclass of ViewGroup just like LinearLayout and RelativeLayout and FrameLayout.

With BlockLayout you can arrange chid views with grid which has certain rows and cols.

The blow image show how BlockLayout works.

##Showcase1
![image](https://raw.githubusercontent.com/ihou/BlockLayout/master/showcase/showcase1.jpg)

##Showcase2
![image](https://raw.githubusercontent.com/ihou/BlockLayout/master/showcase/showcase2.jpg)

##Showcase3
![image](https://raw.githubusercontent.com/ihou/BlockLayout/master/showcase/showcase3.jpg)

##Showcase4
![image](https://raw.githubusercontent.com/ihou/BlockLayout/master/showcase/showcase4.jpg)


Usage
-----
```xml

  <me.semi.blocklayout.BlockLayout
        android:layout_width="fill_parent"
        android:layout_height="360dp"
        android:background="#33ff0000"
        app:colCount="3"
        app:rowCount="3"
        app:gapSize="3dp">

        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/li"
            app:block="0,0,1,1"/>

        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/li"
            app:block="1,0,2,2"/>


        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/li"
            app:block="0,1,1,1"/>

        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/li"
            app:block="0,2,1,1"/>

        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/li"
            app:block="1,2,1,1"/>

        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@drawable/li"
            app:block="2,2,1,1"/>
    </me.semi.blocklayout.BlockLayout>
    
```

Arrtibute
----

    There are 4 custom arrtibutes.
    
    For BlockLayout
        app:colCount="3"
        app:rowCount="3"
        app:gapSize="3dp"
        
    For child View
        app:block="0,2,1,1"  # x,y,span in horizomal direction ,span in vertival direction
        
        
        
