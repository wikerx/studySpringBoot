### SpringBoot study_03：玩转数据库配置
	注意最好不要使用默认的mysql，jar自己引入MySQL的jar

 - 1.数据库使用MySQL作为模板，其他数据也是一样的
 - 2.数据连接方式使用JDBCTemplate（SpringBoot的标准配置），如果想使用阿里数据源主从数据库配置的可以下载我的demo，<a href="https://download.csdn.net/download/qq_16393511/10962594">csdn下载</a>或者关注我的Git,因为很多项目不开源，请先加好友<a href="https://github.com/18772101110?tab=repositories">查看</a>
 - 3.测试案例，暂不考虑安全性能。
 - 4.接口调试：（接口中均有固定方法调用，如不习惯可直接使用POST或GET即可，传参方式不习惯也可以随意修改）
	 - 查询所有信息：http://localhost:8080/dp/selectAllOrders		GTE
	 - 根据id查询数据信息：http://localhost:8080/dp/selectById/1	GET
	 - 添加订单信息：http://localhost:8080/dp/addOrder     			必须POST
	 - 修改订单信息：http://localhost:8080/dp/updateOrdedr/6?name=%E6%B5%8B%E8%AF%95%E4%BA%A7%E5%93%816&no=2019012717243025006&remark=remark6             必须PUT
	 - 删除订单信息;http://localhost:8080/dp/deleteOrder/6			必须DELETE

### 数据库在：DB文件下

### 注:浅谈HTTP中Get、Post、Put与Delete的区别

1、GET请求会向数据库发索取数据的请求，从而来获取信息，该请求就像数据库的select操作一样，只是用来查询一下数据，不会修改、增加数据，不会影响资源的内容，即该请求不会产生副作用。无论进行多少次操作，结果都是一样的。

2、与GET不同的是，PUT请求是向服务器端发送数据的，从而改变信息，该请求就像数据库的update操作一样，用来修改数据的内容，但是不会增加数据的种类等，也就是说无论进行多少次PUT操作，其结果并没有不同。

3、POST请求同PUT请求类似，都是向服务器端发送数据的，但是该请求会改变数据的种类等资源，就像数据库的insert操作一样，会创建新的内容。几乎目前所有的提交操作都是用POST请求的。

4、DELETE请求顾名思义，就是用来删除某一个资源的，该请求就像数据库的delete操作。

就像前面所讲的一样，既然PUT和POST操作都是向服务器端发送数据的，那么两者有什么区别呢。。。POST主要作用在一个集合资源之上的（url），而PUT主要作用在一个具体资源之上的（url/xxx），通俗一下讲就是，如URL可以在客户端确定，那么可使用PUT，否则用POST。

综上所述，我们可理解为以下：

1、POST /url 创建  
2、DELETE /url/xxx 删除 
3、PUT /url/xxx 更新
4、GET /url/xxx 查看
 
 Http定义了与服务器交互的不同方法，最基本的方法有4种，分别是GET，POST，PUT，DELETE。URL全称是统一资源定位符，我们可以这样认为：一个URL地址，它用于描述一个网络上的资源，而HTTP中的GET，POST，PUT，DELETE就对应着对这个资源的查，改，增，删4个操作。到这里，大家应该有个大概的了解了，GET一般用于获取/查询资源信息，而POST一般用于更新资源信息。

1.根据HTTP规范，GET用于信息获取，而且应该是安全的和幂等的。

(1).所谓安全的意味着该操作用于获取信息而非修改信息。换句话说，GET 请求一般不应产生副作用。就是说，它仅仅是获取资源信息，就像数据库查询一样，不会修改，增加数据，不会影响资源的状态。

* 注意：这里安全的含义仅仅是指是非修改信息。

(2).幂等的意味着对同一URL的多个请求应该返回同样的结果。这里我再解释一下幂等这个概念：

幂等（idempotent、idempotence）是一个数学或计算机学概念，常见于抽象代数中。
　　幂等有一下几种定义：
　　对于单目运算，如果一个运算对于在范围内的所有的一个数多次进行该运算所得的结果和进行一次该运算所得的结果是一样的，那么我们就称该运算是幂等的。比如绝对值运算就是一个例子，在实数集中，有abs(a)=abs(abs(a))。
　　对于双目运算，则要求当参与运算的两个值是等值的情况下，如果满足运算结果与参与运算的两个值相等，则称该运算幂等，如求两个数的最大值的函数，有在在实数集中幂等，即max(x,x) = x。

看完上述解释后，应该可以理解GET幂等的含义了。

　　但在实际应用中，以上2条规定并没有这么严格。引用别人文章的例子：比如，新闻站点的头版不断更新。虽然第二次请求会返回不同的一批新闻，该操作仍然被认为是安全的和幂等的，因为它总是返回当前的新闻。从根本上说，如果目标是当用户打开一个链接时，他可以确信从自身的角度来看没有改变资源即可。

2.根据HTTP规范，POST表示可能修改变服务器上的资源的请求。继续引用上面的例子：还是新闻以网站为例，读者对新闻发表自己的评论应该通过POST实现，因为在评论提交后站点的资源已经不同了，或者说资源被修改了。

 

　　上面大概说了一下HTTP规范中GET和POST的一些原理性的问题。但在实际的做的时候，很多人却没有按照HTTP规范去做，导致这个问题的原因有很多，比如说：

1.很多人贪方便，更新资源时用了GET，因为用POST必须要到FORM（表单），这样会麻烦一点。

2.对资源的增，删，改，查操作，其实都可以通过GET/POST完成，不需要用到PUT和DELETE。

3.另外一个是，早期的Web MVC框架设计者们并没有有意识地将URL当作抽象的资源来看待和设计，所以导致一个比较严重的问题是传统的Web MVC框架基本上都只支持GET和POST两种HTTP方法，而不支持PUT和DELETE方法。

 　　* 简单解释一下MVC：MVC本来是存在于Desktop程序中的，M是指数据模型，V是指用户界面，C则是控制器。使用MVC的目的是将M和V的实现代码分离，从而使同一个程序可以使用不同的表现形式。

　　以上3点典型地描述了老一套的风格（没有严格遵守HTTP规范），随着架构的发展，现在出现REST(Representational State Transfer)，一套支持HTTP规范的新风格，这里不多说了，可以参考《RESTful Web Services》。

 

　　说完原理性的问题，我们再从表面现像上面看看GET和POST的区别：

1.GET请求的数据会附在URL之后（就是把数据放置在HTTP协议头中），以?分割URL和传输数据，参数之间以&相连，如：login.action?name=hyddd&password=idontknow&verify=%E4%BD%A0%E5%A5%BD。如果数据是英文字母/数字，原样发送，如果是空格，转换为+，如果是中文/其他字符，则直接把字符串用BASE64加密，得出如：%E4%BD%A0%E5%A5%BD，其中％XX中的XX为该符号以16进制表示的ASCII。

POST把提交的数据则放置在是HTTP包的包体中。

2."GET方式提交的数据最多只能是1024字节，理论上POST没有限制，可传较大量的数据，IIS4中最大为80KB，IIS5中为100KB"？？！

　　以上这句是我从其他文章转过来的，其实这样说是错误的，不准确的：

(1).首先是"GET方式提交的数据最多只能是1024字节"，因为GET是通过URL提交数据，那么GET可提交的数据量就跟URL的长度有直接关系了。而实际上，URL不存在参数上限的问题，HTTP协议规范没有对URL长度进行限制。这个限制是特定的浏览器及服务器对它的限制。IE对URL长度的限制是2083字节(2K+35)。对于其他浏览器，如Netscape、FireFox等，理论上没有长度限制，其限制取决于操作系统的支持。

　　注意这是限制是整个URL长度，而不仅仅是你的参数值数据长度。[见参考资料5]

(2).理论上讲，POST是没有大小限制的，HTTP协议规范也没有进行大小限制，说“POST数据量存在80K/100K的大小限制”是不准确的，POST数据是没有限制的，起限制作用的是服务器的处理程序的处理能力。

　　对于ASP程序，Request对象处理每个表单域时存在100K的数据长度限制。但如果使用Request.BinaryRead则没有这个限制。

　　由这个延伸出去，对于IIS 6.0，微软出于安全考虑，加大了限制。我们还需要注意：

1).IIS 6.0默认ASP POST数据量最大为200KB，每个表单域限制是100KB。
2).IIS 6.0默认上传文件的最大大小是4MB。
3).IIS 6.0默认最大请求头是16KB。
IIS 6.0之前没有这些限制。[见参考资料5]

　　所以上面的80K，100K可能只是默认值而已(注：关于IIS4和IIS5的参数，我还没有确认)，但肯定是可以自己设置的。由于每个版本的IIS对这些参数的默认值都不一样，具体请参考相关的IIS配置文档。

3.在ASP中，服务端获取GET请求参数用Request.QueryString，获取POST请求参数用Request.Form。在JSP中，用request.getParameter(\"XXXX\")来获取，虽然jsp中也有request.getQueryString()方法，但使用起来比较麻烦，比如：传一个test.jsp?name=hyddd&password=hyddd，用request.getQueryString()得到的是：name=hyddd&password=hyddd。在PHP中，可以用$_GET和$_POST分别获取GET和POST中的数据，而$_REQUEST则可以获取GET和POST两种请求中的数据。值得注意的是，JSP中使用request和PHP中使用$_REQUEST都会有隐患，这个下次再写个文章总结。

4.POST的安全性要比GET的安全性高。注意：这里所说的安全性和上面GET提到的“安全”不是同个概念。上面“安全”的含义仅仅是不作数据修改，而这里安全的含义是真正的Security的含义，比如：通过GET提交数据，用户名和密码将明文出现在URL上，因为(1)登录页面有可能被浏览器缓存，(2)其他人查看浏览器的历史纪录，那么别人就可以拿到你的账号和密码了，除此之外，使用GET提交数据还可能会造成Cross-site request forgery攻击。

　　总结一下，Get是向服务器发索取数据的一种请求，而Post是向服务器提交数据的一种请求，在FORM（表单）中，Method默认为"GET"，实质上，GET和POST只是发送机制不同，并不是一个取一个发！


### @PathVariable和@RequestParam的区别
1、 @PathVariable 

当使用@RequestMapping URI template 样式映射时， 即 someUrl/{paramId}, 这时的paramId可通过 @Pathvariable注解绑定它传过来的值到方法的参数上。
示例代码：

@Controller  
@RequestMapping("/owners/{ownerId}")  
public class RelativePathUriTemplateController {  
  
  @RequestMapping("/pets/{petId}")  
  public void findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {      
    // implementation omitted   
  }  
}  
上面代码把URI template 中变量 ownerId的值和petId的值，绑定到方法的参数上。若方法参数名称和需要绑定的uri template中变量名称不一致，需要在@PathVariable("name")指定uri template中的名称。

2、 @RequestHeader、@CookieValue

@RequestHeader 注解，可以把Request请求header部分的值绑定到方法的参数上。

示例代码：

这是一个Request 的header部分：

Host                    localhost:8080  
Accept                  text/html,application/xhtml+xml,application/xml;q=0.9  
Accept-Language         fr,en-gb;q=0.7,en;q=0.3  
Accept-Encoding         gzip,deflate  
Accept-Charset          ISO-8859-1,utf-8;q=0.7,*;q=0.7  
Keep-Alive              300  
@RequestMapping("/displayHeaderInfo.do")  
public void displayHeaderInfo(@RequestHeader("Accept-Encoding") String encoding,  
                              @RequestHeader("Keep-Alive") long keepAlive)  {  
}  
上面的代码，把request header部分的 Accept-Encoding的值，绑定到参数encoding上了， Keep-Alive header的值绑定到参数keepAlive上。

@CookieValue 可以把Request header中关于cookie的值绑定到方法的参数上。

例如有如下Cookie值：

JSESSIONID=415A4AC178C59DACE0B2C9CA727CDD84 
参数绑定的代码：

@RequestMapping("/displayHeaderInfo.do")  
public void displayHeaderInfo(@CookieValue("JSESSIONID") String cookie)  {  
}  
即把JSESSIONID的值绑定到参数cookie上。

3、@RequestParam, @RequestBody

@RequestParam 
A） 常用来处理简单类型的绑定，通过Request.getParameter() 获取的String可直接转换为简单类型的情况（ String--> 简单类型的转换操作由ConversionService配置的转换器来完成）；因为使用request.getParameter()方式获取参数，所以可以处理get 方式中queryString的值，也可以处理post方式中 body data的值；
B）用来处理Content-Type: 为 application/x-www-form-urlencoded编码的内容，提交方式GET、POST；

C) 该注解有两个属性： value、required； value用来指定要传入值的id名称，required用来指示参数是否必须绑定；
示例代码：

@Controller  
@RequestMapping("/pets")  
@SessionAttributes("pet")  
public class EditPetForm {  
    @RequestMapping(method = RequestMethod.GET)  
 public String setupForm(@RequestParam("petId") int petId, ModelMap model) {  
       Pet pet = this.clinic.loadPet(petId);  
   model.addAttribute("pet", pet);  
   return "petForm";  
   }  
@RequestBody

该注解常用来处理Content-Type: 不是application/x-www-form-urlencoded编码的内容，例如application/json, application/xml等；

它是通过使用HandlerAdapter 配置的HttpMessageConverters来解析post data body，然后绑定到相应的bean上的。

因为配置有FormHttpMessageConverter，所以也可以用来处理 application/x-www-form-urlencoded的内容，处理完的结果放在一个MultiValueMap<String, String>里，这种情况在某些特殊需求下使用，详情查看FormHttpMessageConverter api;