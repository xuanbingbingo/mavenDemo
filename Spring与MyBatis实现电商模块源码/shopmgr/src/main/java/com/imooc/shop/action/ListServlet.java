package com.imooc.shop.action;

import com.imooc.shop.bean.Article;
import com.imooc.shop.bean.ArticleType;
import com.imooc.shop.service.ShopService;
import com.imooc.shop.utils.Pager;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@MultipartConfig // 申明这个Servlet是要接收大文件对象的
@WebServlet("/list")
public class ListServlet extends HttpServlet {

    // 定义业务层对象
    private ShopService shopService;

    private HttpServletRequest request;
    private HttpServletResponse response ;

    @Override
    public void init() throws ServletException {
        super.init();
        // 获取sping的容器。然后从容器中得到业务层对象
        ServletContext servletContext = this.getServletContext() ;
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        shopService = (ShopService) context.getBean("shopService");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            this.request = req ;
            this.response = resp ;
            request.setCharacterEncoding("UTF-8");
            String method = request.getParameter("method");
            switch (method){
                case "getAll":
                    getAll();
                    break;
                case "deleteById":
                    deleteById();
                    break;
                case "preArticle":
                    preArticle();
                    break;
                case "showUpdate":
                    showUpdate();
                    break;
                case "updateArticle":
                    updateArticle();
                    break;
                case "addArticle":
                    addArticle();
                    break;

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addArticle() throws ServletException, IOException, ParseException {
        // 接收界面提交的参数
        // 获取请求参数 ----普通表单元素
        String code = request.getParameter("code");
        String title = request.getParameter("titleStr");
        String supplier = request.getParameter("supplier");
        String locality = request.getParameter("locality");
        String price = request.getParameter("price");
        String putawayDate = request.getParameter("putawayDate");
        String storage = request.getParameter("storage");
        String description = request.getParameter("description");
        // 定义一个商品对象封装界面提交的参数
        Article article = new Article();
        // 发布时间 ： 2018-04-25 21:34:40
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        article.setPutawayDate(sdf.parse(putawayDate));

        // 接收用户可能上传的封面
        String imageUrl = receiveImage();
        article.setImage(imageUrl);
        ArticleType type = new ArticleType();
        type.setCode(code);
        article.setArticleType(type);
        article.setTitle(title);
        article.setSupplier(supplier);
        article.setLocality(locality);
        article.setPrice(Double.parseDouble(price));
        article.setStorage(Integer.parseInt(storage));
        article.setDescription(description);
        shopService.saveArticle(article);
        request.setAttribute("tip","添加商品成功");
        getAll();
    }

    private String receiveImage() {
        try{
            // 如果用户上传了这里代码是不会出现异常 了
            // 如果没有上传这里出现异常
            Part part = request.getPart("image");
            // 保存到项目的路径中去
            String sysPath = request.getSession().getServletContext().getRealPath("/resources/images/article");
            // 定义一个新的图片名称
            String fileName = UUID.randomUUID().toString() ;
            //  提取图片的类型
            // 上传文件的内容性质
            String contentDispostion = part.getHeader("content-disposition");
            // 获取上传文件的后缀名
            String suffix = contentDispostion.substring(contentDispostion.lastIndexOf("."), contentDispostion.length() - 1);
            fileName+=suffix ;
            // 把图片保存到路径中去
            part.write(sysPath+"/"+fileName);
            return fileName ;
        }catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }

    public void updateArticle(){
        // 接收界面提交的参数
        // 获取请求参数 ----普通表单元素
        String code = request.getParameter("code");
        String title = request.getParameter("titleStr");
        String supplier = request.getParameter("supplier");
        String locality = request.getParameter("locality");
        String price = request.getParameter("price");
        String storage = request.getParameter("storage");
        String description = request.getParameter("description");
        String id = request.getParameter("id"); // 物品编号
        String picUrl = request.getParameter("picUrl"); // 物品旧封面
        // 定义一个商品对象封装界面提交的参数
        Article article = new Article();

        // 接收用户可能上传的封面
        String newUrl = receiveImage();
        picUrl = newUrl!=null ?newUrl:picUrl ;

        article.setId(Integer.valueOf(id));
        article.setImage(picUrl);
        ArticleType type = new ArticleType();
        type.setCode(code);
        article.setArticleType(type);
        article.setTitle(title);
        article.setSupplier(supplier);
        article.setLocality(locality);
        article.setPrice(Double.parseDouble(price));
        article.setStorage(Integer.parseInt(storage));
        article.setDescription(description);
        shopService.updateArticle(article);
        request.setAttribute("tip","修改商品成功");
        showUpdate();
    }

    private void showUpdate() {
        try {
            String id = request.getParameter("id");
            Article article = shopService.getArticleById(id);
            // 查询出所有的商品类型
            List<ArticleType> types = shopService.getArticleTypes();
            request.setAttribute("article" ,article);
            request.setAttribute("types" ,types);
            request.getRequestDispatcher("/WEB-INF/jsp/updateArticle.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void preArticle() {

        try {
            String id = request.getParameter("id");
            Article article = shopService.getArticleById(id);
            request.setAttribute("article" ,article);
            request.getRequestDispatcher("/WEB-INF/jsp/preArticle.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void deleteById() throws ServletException, IOException {
        try{
            String id = request.getParameter("id");
            shopService.deleteById(id);
            request.setAttribute("tip","删除成功");
        }catch (Exception e){
            request.setAttribute("tip","删除失败");
            e.printStackTrace();
        }
        request.getRequestDispatcher("/list?method=getAll").forward(request,response);
    }

    private void getAll() throws ServletException, IOException {

        // 考虑分页查询
        Pager pager = new Pager();
        // 看是否传入了分页参数的页码
        String pageIndex = request.getParameter("pageIndex");
        if(!StringUtils.isEmpty(pageIndex)){
                int pSize = Integer.valueOf(pageIndex);
                pager.setPageIndex(pSize);
        }

        String secondType = request.getParameter("secondType");
        String title = request.getParameter("title");
        request.setAttribute("title",title);
        request.setAttribute("secondType",secondType);
       // 接收一级类型编号查询
        String typeCode = request.getParameter("typeCode");
        // 根据一级类型查询对应的二级类型
        if(!StringUtils.isEmpty(typeCode)){

            List<ArticleType> secondTypes = shopService.loadSecondTypes(typeCode);
            request.setAttribute("typeCode",typeCode);
            request.setAttribute("secondTypes",secondTypes);
        }

        // 1.查询所有的一级类型数据
        List<ArticleType> firstArticleTypes = shopService.loadFirstArticleTypes();
        // 2.查询所有的商品信息
        List<Article> articles = shopService.searchArticles(typeCode , secondType , title , pager);
        request.setAttribute("articleTypes" ,shopService.getArticleTypes());
        request.setAttribute("firstArticleTypes" ,firstArticleTypes);
        request.setAttribute("pager" ,pager);
        request.setAttribute("articles" ,articles);
        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request,response);
    }
}
