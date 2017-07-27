# EasyRefreshLayout
Inherited This library allows you to easily achieve the drop-down refresh and upload more 

## Recommended 
* Recommended in conjunction with [BaseRecyclerViewAdapterHelper](http://www.recyclerview.org)


# How to use

## Step 1
* You need to add jitpack repository infomaition to build.gradle in your project.

``` 
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.0'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }

    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

```
## step 2


* You need to add library dependencies infomation to build.gradle in your module. 

- [![](https://jitpack.io/v/anzaizai/EasyRefreshLayout.svg)](https://jitpack.io/#anzaizai/EasyRefreshLayout)

``` 
 compile 'com.github.anzaizai:EasyRefreshLayout:1.3.1'
```
* last releases version is 1.3.1 can be use

## step 3

* Use EasyRefreshLayout as the top-level root layout the needs to be added pull-down refresh or pull-up loading more the funcation views.

###such as:

```

    <com.ajguan.library.EasyRefreshLayout
        android:id="@+id/easylayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <android.support.v7.widget.RecyclerView
            android:id="@+id/recyclerview"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
    </com.ajguan.library.EasyRefreshLayout>
    
```
* add EasyEvenr listener

```
  easyRefreshLayout.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final List<String> list = new ArrayList<>();
                        for (int j = 0; j < 5; j++) {
                            list.add("this is  new load data >>>>" + new Date().toLocaleString());
                        }

                        //adapter.addData(list);

                        easyRefreshLayout.loadMoreComplete(new EasyRefreshLayout.Event() {
                            @Override
                            public void complete() {
                                adapter.getData().addAll(list);
                                adapter.notifyDataSetChanged();

                            }
                        }, 500);

                    }
                }, 2000);
                

            }

            @Override
            public void onRefreshing() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> list = new ArrayList<>();
                        for (int i = 0; i < 20; i++) {
                            list.add("this is refresh data >>>" + new Date().toLocaleString());
                        }
                        adapter.setNewData(list);
                        easyRefreshLayout.refreshComplete();
                        Toast.makeText(getApplicationContext(), "refresh success", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);

            }
        });
        
```


* if you need only pull-down refresh funcation

```
  easyRefreshLayout.setLoadMoreModel(LoadModel.NONE);

```

* if you need only pull-up loading funcation

```
    // 普通加载
  easyRefreshLayout.setLoadMoreModel(LoadModel.COMMON_MODEL);
    or
    //预加载 advanceCount为剩余数据为advanceCount时触发预加载事件
  easyRefreshLayout.setLoadMoreModel(LoadModel.ADVANCE_MODEL,advanceCount);

```
## step 4 

### Customizable pull-down refresh head view 

* You only need to create a view to implement the RefreshVIew interface
* Set the custom view to Easy RefreshLayout

```
easyRefreshLayout.setRefreshHeadView(customizabaleView);

```

### Customizable pull-up load footer view 

* You only need to create a view to implement the ILoadMoreView interface
* Set the custom view to Easy RefreshLayout

```
easyRefreshLayout.setLoadMoreView(customizabaleView);

```

for more information on how to use it，see demo on github [https://github.com/anzaizai/EasyRefreshLayout](https://github.com/anzaizai/EasyRefreshLayout)

# References

* Part of the content from the blog [http://www.2cto.com/kf/201606/518620.html](http://www.2cto.com/kf/201606/518620.html)

## Very grateful to the contribution of bloggers

# Portal
- [更多分享](http://www.cherylgood.cn/)
- 个人博客：[http://www.cherylgood.cn](http://www.cherylgood.cn/)，欢迎交流学习
