package cn.accp.pigcar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.accp.pigcar.pojo.Menus;
import cn.accp.pigcar.pojo.Renttable;
import cn.accp.pigcar.pojo.Roles;
import cn.accp.pigcar.pojo.Users;
import cn.accp.pigcar.service.RentalTableService;
import cn.accp.pigcar.service.UserService;
import cn.accp.pigcar.util.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
@CrossOrigin(allowCredentials = "true")
@ResponseBody()
public class UserController{
    @Resource
    UserService userService;
    @RequestMapping(value="login")
    public Object login(String userpwd, String username,HttpServletRequest request,  HttpSession session){
        try {

            Users user = new Users();
            user.setUsername(username);
            user.setUserpwd(userpwd);
            Users user1 = userService.findUserByUNameAndPwd(user);
            if (null == user1) {
                //表示登录失败,返回到登录界面
                return false;
            }

            List<Menus> menu = userService.findAllMenus(user1);
            System.out.println(menu);

            session.setAttribute("menus", menu);
            //登录成功,将user1对象信息设置到session
            session.setAttribute("user", user1);

            return  true;
        } catch (Exception e) {

            e.printStackTrace();
        }
        //如果发生异常，跳转到错误页面
        return  false;
    }

    @RequestMapping("getUserlogin")
    @ResponseBody
    public Map<String, Object> getLoginUser(HttpSession session){

        Map<String,Object> ld=new HashMap<>();
        ld.put("menu",session.getAttribute("menus"));
        ld.put("user",session.getAttribute("user"));
        return ld;
    }
    /**
     * 用户退出系统，注销session，返回登录界面
     *
     * */
    @RequestMapping("logout")
    public Object logout(HttpServletRequest req){
        //注销session
        req.getSession().invalidate();
        return true;
    }
    /**
     * 查询所有角色信息，为查询用户信息做准备
     */
    @RequestMapping("findAllUsers")
    public Object findAllRoles(HttpSession session){
        List<Roles> roles = userService.findAllRoles();
        session.setAttribute("roles", roles);
        return roles;
    }

    @RequestMapping("addUsers")
    public Boolean addUsers(Users user,HttpServletRequest req){
        boolean flag = userService.addUsers(user);
         //"forward:/car/user/findUserByPage";     "exception";
        //之后我们需要查询所有用户信息
        //List<Users> userList = userService.finAllUser();
        //req.setAttribute("userList", userList);
        //跳转到分页查询
        return flag;
    }


    @RequestMapping("nameExist")
    public Boolean nameExist(String name){
        Users user1 = userService.findUserInfoByUName(name);
        return user1!=null;
    }
    /**
     * 分页查询
     */
    @RequestMapping("findUserByPage")
    public Object findUserByPage(HttpSession session ,String currentPage){
        //获得当前页号
        String index =currentPage;

        PageBean<Users> page = new PageBean<Users>();
        //查询所有用户，获得总记录数量
        List<Users> list = userService.finAllUser();
        page.setTotalCount(list.size());
        int currentIndex=1;
        if (null != index && !"".equals(index) ) {
            currentIndex = Integer.parseInt(index);
        }

        //设置当前页
        System.out.println("当前页："+currentIndex);
        page.setIndex(currentIndex);
        List<Users> userList = userService.findUserByPage(page);
        Map<String,Object> h=new HashMap<>();
        h.put("pageIndex", currentIndex);
        h.put("page", page);
        h.put("userList", userList);
        return h;
    }

    /**
     * 查询所有角色信息，为条件查询用户信息做准备
     */
    @RequestMapping("findAllRoles")
    public Object findAllRoles1(HttpSession session){
        List<Roles> roles = userService.findAllRoles();
        session.setAttribute("roles", roles);
        return  roles;
    }


    @RequestMapping("saveUser")
    public void saveUser(Users user , HttpSession session){
        session.setAttribute("findUser",user);
    }
    @RequestMapping("getsaveUser")
    public Users getsaveUser( HttpSession session){
        return (Users)session.getAttribute("findUser");
    }
    /**
     * 多条件分页查询用户信息
     */
    @RequestMapping("findUserByIf")
    public Map<String,Object> findUserByIf(HttpSession session,String currentPage,Users user){
        //获得当前页号
        String index = currentPage;
        PageBean<Users> page = new PageBean<Users>();
        //多条件查询的所有结果
        List<Users> byIfList = userService.findUserByIf(user);
        page.setTotalCount(byIfList.size());
        int currentIndex = 1;

        if (null != index && !"".equals(index) ) {
            currentIndex = Integer.parseInt(index);
        }
        //设置当前页
        System.out.println("当前页："+currentIndex);
        page.setIndex(currentIndex);
        //多条件的分页查询
        List<Users> list = userService.findUserByIf(user, page);
        //System.out.println(list.get(1).getRoles().getRolename());
        session.setAttribute("pageIndex", currentIndex);
        session.setAttribute("page", page);
        //req.setAttribute("userList", list);
        session.setAttribute("userList", list);
        Map<String,Object> h=new HashMap<>();
        h.put("pageIndex", currentIndex);
        h.put("page", page);
        h.put("userList", list);
        return h;
    }
    /**
     * 跟新用户信息之前先要通过用户主键查询信息，将信息显示在更新界面
     */
    @RequestMapping("preUpdate")
    public Boolean preUpdate(String username,HttpSession session){
        //跟新之前也得做几件事，得先查询role表和用户表
        //需要查出角色的集合
        List<Roles> roles = userService.findAllRoles();
        Users user = userService.findUserInfoByUName(username);
        session.setAttribute("roles", roles);
        session.setAttribute("obj", user);
        return true;
    }

    @RequestMapping("updateget")
    public Object updateget(HttpSession session){
        Map<String,Object> h=new HashMap<>();
       h.put("roles",session.getAttribute("roles"));
        h.put("obj",session.getAttribute("obj"));
        return h;
    }
    /**
     * 更新用户信息
     */
    @RequestMapping("updateUser")
    public Boolean updateUser(Users user){
        boolean flag = userService.updateUsers(user);
        if (flag) {
            //修改成功
            return true;
        }
        return false;
    }
    /**
     * 删除用户信息
     */
    @RequestMapping("deleteUser")
    public boolean deleteMapper(String username){
        boolean flag = userService.deleteUserByUsername(username);
        if (flag) {
            //删除成功
           return true;
        }
        return false;
    }

    /**
     * 批量删除
     */
    @RequestMapping("deleteUsers")
    public boolean deleteUsers(String name[]){

        for(String x:name) {
            userService.deleteUserByUsername(x);
        }
        return true;
    }

    /**
     * 更新密码之前先查询数据
     */
    @RequestMapping("preUpdatePwd")
    public Boolean preUpdatePwd(String username,HttpSession session){
        //更新之前先查询数据，然后，将数据显示到界面
        Users user = userService.findUserInfoByUName(username);
        session.setAttribute("user1", user);
        return true;
    }
    @RequestMapping("preUpdatePwdget")
    public Object preUpdatePwdget(HttpSession session){

        return session.getAttribute("user1");
    }
    /**
     * 更新密码
     */
    @RequestMapping("updatePwd")
    public Boolean updatePwd(String okNewPwd,String userName){
        Users user = new Users();
        user.setUsername(userName);
        user.setUserpwd(okNewPwd);
        boolean flag = userService.updateUsers(user);
        if (flag) {
            //修改成功
            return true;
        }
        return false;
    }

}