# MVP-Demo
MVP demo
本文适用读者：已经熟练掌握Android编程但没学过MVP模式的程序员。

新需求来临时，看着Activity里面一千多行的代码，你是否很抵触呢？MVP模式可以改变这种情况。

说起MVP模式，我也看过好多相关文章了。可是看完之后，甚至照着例子敲了一遍代码之后，还是没看懂。之懵懂的记得有Model，View，Presenter，Presenter和Model交互数据，然后Presenter控制Activity里面的View显示。在一番努力之后，我终于自认为学会了MVP模式。网上竟然没有一篇通俗易懂的文章。可能那些大神们觉得已经写得很浅显了，可是我们小白看起来还是困难。所以我决定写一篇适合初级Android程序员看的说明，让大家学起来更容易。

先来看下面的图获得一个整体印象。Presenter与View和Model交互，Model和View之间不直接联系。


模型层（Model）处理业务逻辑和数据，视图层（View）负责显示数据以及和用户交互。Activity和Fragment属于View层。

中间的主持人层（Presenter）作为View和Model之间的桥梁。

有了大体了解之后来看这个登录的例子。



登录页面
下面是做完之后的项目结构：


项目结构


这个视图上可以看出以下功能需求：

1.输入用户名2，输入密码。3.登录成功跳转。4.登录失败。5.清除用户名密码

MVP模式下，View是通过接口和Presenter交互的。先写一个LoginView接口对应上面的需求。




LoginView
新建 LoginActivity，implements 上面LoginView接口。还要初始化各个控件，写好findviewbyId。



然后，我们来写Model。同样是先写一个接口，ModelUser，只有一个方法，两种情况，所以这个接口还要有一个接口listener。


ModelUser
public interface OnLoginListener {

void success();

void failure();

}

只有接口是没法app实现的。所以要写接口的实现类，给这个接口新建一个class叫 ModelUserImpl 。




ModelUserImpl
登录成功需要一个Userbean，代码如下




Userbean
OnLoginListener 中success方法要传一个userBean，所以修改一下参数

public interface OnLoginListener {

void success(Userbean userbean);

void failure();

}

最后终于要写Presenter了。还是先写一个接口叫LoginPresenter

presenter是view和Model交互的中介，内部要既要含有Model，又要持有View。

然后有登录和清除两个方法，只要让loginView去做就好了。




LoginPresenter
最后修改loginactivity，new 一个presenter，就




loginactivity
loginDemo就写完了，最后梳理一下思路




具体实现
loginActivity是接口loginView的实现类。ModelUserImpl是ModelUser的实现类。presenter可以写接口，也可以直接写实现类。写接口的好处是可以一目了然看清presenter的方法，像本类只有一个方法，就没有必要写接口了。
