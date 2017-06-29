readme

【注意事项】
    1.了解框架前，请将所有的TODO看完，里面有需要注意的事项 or 实现原理 or 源码地址.
    2.软件工程师要有改变原有的开发习惯的勇气，请坚持使用框架两个月后再回头考虑合理性.
    n.请遵守以上规范,THS！

【开发规范】
    1.禁止天文数字／天文字符串!
    2.常量全部大写.
    3.变量不要用缩写，除非是行业内已经确认，例如：prop／takeSee ...
    4.单词禁止拼音，禁止错误单词.
    5.码农和工程师的区别是：代码艺术！
    6.类设计，请注意category，特别是Util工具类.
    7.公用的，且完全不与业务耦合,单独纯粹的 工具／ widget / custom view 等等，请放置到核心Library中.
    8.请项目参与者所有人保持一周一次 code review !

【Android平台规范】
    1.安装CheckStyle插件，提交代码前，请用CheckStyle检查，并解决不规范的代码.
    2.xml中不可包含静态字符串，请抽出到string资源文件.（请合理分类，项目中有示例）
    3./**
       * Created by ${USER} on ${DATE}.
       * <p>
       * 描述:待描述
       */
    4.注释掉的代码请删除
    5.【Layout布局文件命名规范】
        1)	Activity的布局：act_+页面名称。
        2)	Adapter的布局：item_，+列表名称。（楼盘列表：item_est_list）
        3)	普通布局：layout_+用途。
        4)	灵活运用<include>、<merge>、<ViewStub> 标签

    6.【Layout布局文件id命名规范】
    	控件缩写+页面+功能
        1)	LinearLayout :ll_
        2)	RelativeLayout:rl_
        3)	FrameLayout:fl_
        4)	TextView:tv_
        5)	ImageView:img_
        6)	ImageButton:imgb_
        7)	Button:btn_
    7.string.xml内部命名规范
        act_页面模块_功能
        fm_页面模块_功能
        公共部分 public_
        多次出现的名称也可以列进公共
