# Log4J
Log4J是Apache的一个开源项目，通过使用Log4J，我们可以控制日志信息输送的目的地
是控制台、文件、GUI组件，甚至是套接口服务器、NT的事件记录器、UNIX Syslog守护
进程等；我们也可以控制每一条日志的输出格式；通过定义每一条日志信息的级别，我
们能够更加细致地控制日志的生成过程。最令人感兴趣的就是，这些可以通过一个配置
文件来灵活地进行配置，而不需要修改应用的代码。

### 导入架包
Jar架包：<a href="https://down.laomo.io/03_jar/00_jar/log4j-1.2.17.jar">老莫雅居</a><br/>
如果是使用maven项目，需要增加部署选择在pom.xml中新增依赖：
```html<!-- 加入log4j支持 -->
<dependency>
 <groupId>log4j</groupId>
 <artifactId>log4j</artifactId>
 <version>1.2.17</version>
</dependency>
```
### 日志输出
使用Log4J来进行日志输出。 采用如下代码，可以看到输出结果有几个改观：
- 知道是Log4J.TestLog4j这个类里的日志
- 是在[main]线程里的日志
- 日志级别可观察，一共有6个级别 `TRACE/DEBUG/INFO/WARN/ERROR/FATAL`
```A：off   最高等级，用于关闭所有日志记录
B：fatal 指出每个严重的错误事件将会导致应用程序的退出
C：error 指出虽然发生错误事件，但仍然不影响系统的继续运行
D：warm  表明会出现潜在的错误情形
E：info  一般和在粗粒度级别上，强调应用程序的运行全程
F：debug 一般用于细粒度级别上，对调试应用程序非常有帮助
G：all   最低等级，用于打开所有日志记录
```
- 日志输出级别范围可控制， 如代码所示，只输出高于DEBUG级别的，那么TRACE级别的日志自动不输出
- 每句日志消耗的毫秒数(最前面的数字)，可观察，这样就可以进行性能计算

```package log4j;
 
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
 
public class TestLog4j {
 static Logger logger = Logger.getLogger(TestLog4j.class);
 public static void main(String[] args) throws InterruptedException {
 BasicConfigurator.configure();
 logger.setLevel(Level.DEBUG);
 logger.trace("跟踪信息");
 logger.debug("调试信息");
 logger.info("输出信息");
 Thread.sleep(1000);
 logger.warn("警告信息");
 logger.error("错误信息");
 logger.fatal("致命信息");
 }
}
```
### 流程讲解
- 基于类的名称获取日志对象</br>
```
static Logger logger = Logger.getLogger(TestLog4j.class);
```
- 进行默认配置
```
BasicConfigurator.configure();
```
- 设置日志输出级别
```
logger.setLevel(Level.DEBUG);
```
- 进行不同级别的日志输出
```logger.trace("跟踪信息");
logger.debug("调试信息");
logger.info("输出信息");
Thread.sleep(1000);
logger.warn("警告信息");
logger.error("错误信息");
logger.fatal("致命信息");
```










